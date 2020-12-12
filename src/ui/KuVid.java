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
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

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
	int x= WIDTH/2;
	int y =HEIGHT - 90;
	private boolean pause = false;
	private boolean atomShooted=false;
	String asd= "alpha";
	Atom atom = new Atom("alpha",diameter,x,y,20,215);
	UIAtom atomui = new UIAtom(atom.getType(),diameter);
	Random random = new Random();
	
	
	
	
	

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
					
					
					switch (e.getKeyCode()) {
					case KeyEvent.VK_UP:
						if(atomShooted == false) {
							System.out.println("Shoot Atom");
							atomShooted=true;
							
							Atom atom = (Atom) controller.getObject("alpha");
							TimerTask timerTask = new UpdateBallTask(atom,Toolkit.getDefaultToolkit().getScreenSize());
							Timer timer = new Timer(true);
					        timer.scheduleAtFixedRate(timerTask, 0, 100);
					        System.out.println(Thread.currentThread().getName()+" TimerTask started");
							
						}
						break;
					case  KeyEvent.VK_L:
						System.out.println("LOADED");
						break;
					case  KeyEvent.VK_S:
						System.out.println("SAVED");
						break;
					case  KeyEvent.VK_LEFT:
						System.out.println("Move Shooter left");
						break;
					case  KeyEvent.VK_RIGHT:
						System.out.println("Move Shooter right");
						break;
					case  KeyEvent.VK_P:
						System.out.println("PAUSED");
						thread.stop();
						running = false;
						pause = true;
						break;
					case  KeyEvent.VK_R:
						System.out.println("RESUME");
						start();
						pause= false;
						break;
					case  KeyEvent.VK_C:
						System.out.println("Switch Atom");
						int nextInt = random.nextInt(3);
//						Atom atom = (Atom) controller.getObject(getAtom().getType());
						Atom atom = getAtom();
						switch(nextInt) {
						case 0:
							atom.setType("alpha");
							atomui.setAtomType("alpha");
//							update();
							break;
						case 1:
							atom.setType("beta");
							atomui.setAtomType("beta");
//							update();
							break;
						case 2:
							atom.setType("sigma");
							atomui.setAtomType("sigma");
//							update();
							break;
						case 3:
							atom.setType("gamma");
							atomui.setAtomType("gamma");
//							update();
							break;
						}
						
						break;
						
					default:
						break;
					}
//					if(e.getKeyCode() == KeyEvent.VK_L) {
//						System.out.println("LOADED");
//					}
//					if(e.getKeyCode() == KeyEvent.VK_S) {
//						System.out.println("SAVED");
//					}
//					if(e.getKeyCode() == KeyEvent.VK_UP) {
//						System.out.println("Shoot Atom");
//					}
//					if(e.getKeyCode() == KeyEvent.VK_LEFT) {
//						System.out.println("Move Shooter left");
//					}
//					if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
//						System.out.println("Move Shooter right");
//					}
//					if(e.getKeyCode() == KeyEvent.VK_P) {
//						System.out.println("PAUSED");
//							thread.stop();
//							running = false;
//							pause = true;
//					}
//					if(e.getKeyCode() == KeyEvent.VK_R) {
//						System.out.println("RESUME");
//						start();
//						pause= false;
//					}
//					if(e.getKeyCode() == KeyEvent.VK_C) {
//						System.out.println("Switch Atom");
//					}
					
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
		
			
			window.getQuitButton().addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				@Override
				public void actionPerformed(ActionEvent e) {
					window.dispose();
					thread.stop();
					running=false;
					new Main();
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
	
	public Atom getAtom() {
		return atom;
	}
	
}
