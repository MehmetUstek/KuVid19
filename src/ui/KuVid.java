package ui;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.Controller;
import domain.atom.Atom;

import domain.gameState.Statistics;
import domain.shooter.AtomShooter;

public class KuVid extends Canvas implements Runnable {
	private boolean running = false;
	public static double WIDTH =  Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
			HEIGHT =  Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private Thread thread;
	Controller controller;
	UIController uicontroller;
	Statistics statistics;
	private Frame window = new Frame(Toolkit.getDefaultToolkit().getScreenSize(), "KuVid", this);
	private static KuVid game;
	private static final double L= HEIGHT/10;
	private JTextField blenderGivenAtom = new JTextField(10);
	
	private JPanel simpleGui = new JPanel(new FlowLayout());  
	double shooterHeight = L;
	double diameter= L/10;
	double speed= L;
	double shooterX= WIDTH/2;
	double shooterY =HEIGHT - shooterHeight*2;
	double atomX = shooterX;
	double atomY = shooterY -diameter*2;
	private boolean isPaused = false;
	private boolean atomShooted=false;
	
//	private boolean atomShooted=false;
	Random random = new Random();
	Timer timer;
	TimerTask timerTask;
	double shooterRotationAngle=0;
	double rotationConstant = 10;
	double atomSpeed=L/5;
	double shooterMoveConstant = 15;
	//These instances are only for the KUVID Game class atom. When these instances is used in this class they will be called with their get methods.
	// The atom class will be added to the collisions no matter what.
	Atom atom = new Atom("alpha");
	UIAtom atomui = new UIAtom(atom.getType(),diameter);
	//TODO Get rid of atom x,y,diameter variables. All variables.
	
	//Shooter
	AtomShooter shooter = new AtomShooter("shooter");
	UIShooter shoterui = new UIShooter("shooter",diameter*2,diameter/2);
	
	
	

	public KuVid() {
			uicontroller =new UIController();
			controller = new Controller(uicontroller, window);
			this.requestFocus();
			
			// Atom settings.
			atom.setDiameter(diameter);
			atom.setX(atomX);
			atom.setY(atomY);
			atom.setSpeed(atomSpeed);
			atom.setRotationAngle(shooterRotationAngle);
			
			// Shooter Settings.
			shooter.setWidth(shooterHeight /2 );
			shooter.setHeight(shooterHeight);
			shooter.setX(shooterX);
			shooter.setY(shooterY);
			
			uicontroller.addObject(atomui);
			controller.addObject(atom);
			System.out.println(atom.getX());
			
			shooter.setRotationAngle(shooterRotationAngle);

			uicontroller.addObject(shoterui);
			controller.addObject(shooter);
			
//			for(UIGameObject object:uicontroller.objects) {
//				object.setBounds(object.getX(),object.getY(),object.getX()+object.getLength(),getY()+object.getLength());
//				maingui.add(object,new Integer(1));
//				System.out.println("refresh");
//			}
//			maingui.setBounds(0 , 0  , WIDTH, HEIGHT);
			this.addKeyListener(new KeyListener() {
				public void keyPressed(KeyEvent e) {
					
					switch (e.getKeyCode()) {
					case KeyEvent.VK_UP:
						if(!atom.isShooted()) {
							atom.setShooted(true);
							System.out.println("Shoot Atom");
							shooterRotationAngle = shooter.getRotationAngle();
							atom.setRotationAngle(shooterRotationAngle);
							System.out.println(atom.getRotationAngle());
//							Atom atom = (Atom) controller.getObject("alpha");
							timerTask = new UpdateBallTask(getAtom(),Toolkit.getDefaultToolkit().getScreenSize(),shooter);
							timer = new Timer(true);
					        timer.scheduleAtFixedRate(timerTask, 0, 40);
					        
//					        if(atom.getX()> WIDTH-atom.getDiameter()*2 && atom.getY()> HEIGHT-atom.getDiameter()*2) {
//					    		timer.cancel();
//					    	}
					        atomX = shooter.getX();
					        atom.setX(atomX);
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
						
						if (shooter.getX() > 0)
							shooterX -=shooterMoveConstant;
							
						shooter.setX(shooterX);
						if(!atom.isShooted()) {
							atomX = shooterX;
							atom.setX(atomX);
						}
						break;
					case  KeyEvent.VK_RIGHT:
						System.out.println("Move Shooter right");
						if (shooter.getX() < WIDTH - shooter.getWidth()) {
							shooterX +=shooterMoveConstant;
						}
						shooter.setX(shooterX);
						if(!atom.isShooted()) {
							atomX = shooterX;
							atom.setX(atomX);
							
						}

						
						break;
						
					case  KeyEvent.VK_A:
						System.out.println("Rotate shooter left");
						if(shooterRotationAngle > -90 ) {
							shooterRotationAngle -= rotationConstant;
							shooter.setRotationAngle(shooterRotationAngle);
							atom.setRotationAngle(shooterRotationAngle);
							System.out.println(atom.getRotationAngle());
						}
						
						break;
					case  KeyEvent.VK_D:
						System.out.println("Rotate shooter right");
						if(shooterRotationAngle < 90) {
							shooterRotationAngle += rotationConstant;
							shooter.setRotationAngle(shooterRotationAngle);
							atom.setRotationAngle(shooterRotationAngle);
						}
						break;
					case  KeyEvent.VK_P:
						if(!isPaused) {
							System.out.println("PAUSED");
							thread.stop();
							timerTask.cancel();
							isPaused = true;

//							timer.cancel();
						}
						break;
					case  KeyEvent.VK_R:
						System.out.println("RESUME");
						if(isPaused) {
							start();
//							timerTask.run();
//							atom.setRotationAngle(shooterRotationAngle);
							timerTask = new UpdateBallTask(atom,Toolkit.getDefaultToolkit().getScreenSize(),shooter);
							setTimer(new Timer(true));
							timer.scheduleAtFixedRate(timerTask, 0, 100);
							
							isPaused= false;
						}
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
					case  KeyEvent.VK_B:
						System.out.println("Blender");
						if(!isPaused) {
							thread.stop();
							isPaused = true;
						}
						nextInt = 0;
						Atom atom1 = getAtom();
						switch(nextInt) {
						case 0:
							blenderGivenAtom.setVisible(true);
							simpleGui.setBounds(400,400,800,800);
							simpleGui.setVisible(true);
							break;
						case 1:
							
							break;
						case 2:
							
							break;
						case 3:
							
							break;
						}
						
						break;
						
					default:
						break;
					}
					update();
//					
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
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, (int)WIDTH, (int) HEIGHT);
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
//	public static void main(String[] args) {
//		game = new KuVid();
//	}
	
	public Atom getAtom() {
		return atom;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	
	
}
