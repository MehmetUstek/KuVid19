package ui;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;


import domain.Controller;
import domain.atom.AlphaAtom;
import domain.atom.Atom;

import domain.gameState.Statistics;

public class KuVid extends Canvas implements Runnable {
	private boolean running = false;
	public static int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
			HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private Thread thread;
	Controller controller;
	UIController uicontroller;
	Statistics statistics;
	private Frame window = new Frame(Toolkit.getDefaultToolkit().getScreenSize(), "KuVid", this);
	private static KuVid game;
	int diameter= 40;
	int speed= diameter;
	int x= 500;
	int y =100;
	private boolean pause = false;
	
	Atom atom = new AlphaAtom("alpha",diameter,x,y,20,215);
	UIAtom atomui = new UIAtom("alpha",diameter);
	
	
	
	
	
	

	public KuVid() {
			
			uicontroller =new UIController();
			controller = new Controller(uicontroller, window);
			this.requestFocus();
			System.out.println(atom.getX());
			uicontroller.addObject(atomui);
			controller.addObject(atom);
			System.out.println(atom.getX());
			
//			for(UIGameObject object:uicontroller.objects) {
//				object.setBounds(object.getX(),object.getY(),object.getX()+object.getLength(),getY()+object.getLength());
//				maingui.add(object,new Integer(1));
//				System.out.println("refresh");
//			}
//			maingui.setBounds(0 , 0  , WIDTH, HEIGHT);
			this.addKeyListener(new KeyListener() {
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					if(e.getKeyCode() == KeyEvent.VK_L) {
						System.out.println("LOADED");
					}
					if(e.getKeyCode() == KeyEvent.VK_S) {
						System.out.println("SAVED");
					}
					if(e.getKeyCode() == KeyEvent.VK_UP) {
						System.out.println("Shoot Atom");
					}
					if(e.getKeyCode() == KeyEvent.VK_LEFT) {
						System.out.println("Move Shooter left");
					}
					if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
						System.out.println("Move Shooter right");
					}
					if(e.getKeyCode() == KeyEvent.VK_P) {
						System.out.println("PAUSED");
							thread.stop();
							running = false;
							pause = true;
					}
					if(e.getKeyCode() == KeyEvent.VK_R) {
						System.out.println("RESUME");
						start();
						pause= false;
					}
					if(e.getKeyCode() == KeyEvent.VK_C) {
						System.out.println("Switch Atom");
					}
					
				}

				@Override
				public void keyReleased(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyTyped(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
			});
			window.getLoadButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("LOADED");


				}
			});
			
			window.getRestartButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					window.dispose();
					thread.stop();
					running=false;
					game = new KuVid();

				}
			});
			
			window.getQuitButton().addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				@Override
				public void actionPerformed(ActionEvent e) {
					// are you sure to go back sorucak
					window.dispose();
					thread.stop();
					running=false;
					new Main();
				}
			});
			window.getPauseButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(pause == false) {
					thread.stop();
					running = false;
					pause = true;
					window.getPauseButton().setText("Resume");
					} else {
						start();
						pause= false;
						window.getPauseButton().setText("Pause");
					}
				}
			});
		
	}
	
	public boolean isIn(int x, int y) {
		return (x <= WIDTH && x >= 0 && y <= HEIGHT && y >= 0);
}

	public synchronized void start() {
		System.out.println("Started");
		thread = new Thread(this);
		running = true;
		thread.start();
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("lolzie");
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				delta--;
			}
			if (running)
				render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void render() {
		// TODO Auto-generated method stub
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.cyan);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		uicontroller.render(g);
		g.dispose();
		bs.show();
	}


	public void update() {     
		controller.update();
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static KuVid getGame() {
		return game;
	}
	public static void setGame(KuVid game) {
		KuVid.game = game;
	}
	public static void main(String[] args) {
		game = new KuVid();
	}
	
}
