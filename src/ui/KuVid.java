package ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JTextField;
import domain.Controller;
import domain.GameObject;
import domain.atom.Atom;
import domain.blender.Blender;
import domain.gameState.Statistics;
import domain.powerup.Powerup;
import domain.shooter.AtomShooter;

public class KuVid extends Canvas implements Runnable {
	private boolean running = false;
	public static double WIDTH =  Toolkit.getDefaultToolkit().getScreenSize().getWidth()-200,
			HEIGHT =  Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private Thread thread;
	Controller controller;
	Renderer renderer;
	Statistics statistics;
	private Frame window = new Frame(Toolkit.getDefaultToolkit().getScreenSize(), "KuVid", this);
	private static KuVid game;
	public static final double L= HEIGHT/10;
	private JTextField blenderGivenAtom = new JTextField(10);
	
	double shooterHeight = L;
	double diameter= L/10;
	double speed= L;
	double shooterX= WIDTH/2;
	double shooterY =HEIGHT - shooterHeight*2;
	double atomX = shooterX + diameter/2;
	double atomY = shooterY/2 - diameter*2;
	private boolean isPaused = false;
	
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
	// Initial shooting object.
	Atom shootingObject = new Atom("alpha");
	UIAtom atomui = new UIAtom(shootingObject.getType());
	//TODO Get rid of atom x,y,diameter variables. All variables.
	
	//Shooter
	AtomShooter shooter = new AtomShooter("shooter");
	UIShooter shoterui = new UIShooter("shooter",diameter*2,diameter/2);
	
	//Blender
	Blender blender = new Blender();
	UIBlender blenderui = new UIBlender(150, 150);
	
	
	
	//Molecule prototype
//		Molecule alphaMol = new AlphaMolecule();
//		Molecule betaMol = new BetaMolecule();
//		Molecule sigmaMol = new SigmaMolecule();
//		Molecule gammaMol = new GammaMolecule();
//		
//		UIMolecule alphaUI = new AlphaMoleculeUI();
//		UIMolecule betaUI = new BetaMoleculeUI();
//		UIMolecule sigmaUI = new SigmaMoleculeUI();
//		UIMolecule gammaUI = new GammaMoleculeUI();
	
	boolean keyB;
	int atomRank;
	int targetAtomRank;
	double blenderX = WIDTH - shooterHeight*2+50;
	double blenderY = HEIGHT - 4* shooterHeight;
	
	public static ArrayList<Atom> alphaList= new ArrayList<Atom>();
	public static ArrayList<Atom> betaList= new ArrayList<Atom>();
	public static ArrayList<Atom> sigmaList= new ArrayList<Atom>();
	public static ArrayList<Atom> gammaList= new ArrayList<Atom>();

	

	public KuVid() {
			renderer =new Renderer();
			controller = new Controller(renderer, window);
			this.requestFocus();
			
			// Atom settings.
			shootingObject.setDiameter(diameter);
			shootingObject.setX(atomX);
			shootingObject.setY(atomY);
			shootingObject.setSpeed(atomSpeed);
			shootingObject.setRotationAngle(shooterRotationAngle);
			atomui.setDiameter(diameter);
			
			renderer.addObject(atomui);
			controller.addObject(shootingObject);
			
			
			// Shooter Settings.
			shooter.setWidth(shooterHeight /2 );
			shooter.setHeight(shooterHeight);
			shooter.setX(shooterX);
			shooter.setY(shooterY);
			shooter.setRotationAngle(shooterRotationAngle);
			
			renderer.addObject(shoterui);
			controller.addObject(shooter);
			
			
			// Blender Settings. Blender is just shown in this demo. It is not fully integrated with controller.
			alphaList.add(shootingObject);
			alphaList.add(shootingObject);
			alphaList.add(shootingObject);
			
			System.out.print("Printed " + alphaList.size() + diameter); 

			blender.setX(blenderX);
			blender.setY(blenderY);
			
//			renderer.addObject(blenderui);
//			controller.addObject(blender);
			
			System.out.println("Number of Alpha atoms: " + alphaList.size());
			System.out.println("Number of Beta atoms: " + betaList.size());
			System.out.println("Number of Sigma atoms: " + sigmaList.size());
			System.out.println("Number of Gamma atoms: " + gammaList.size());
			
			// Molecule settings
//			alphaMol.setX(200);
//			alphaMol.setY(0);
//			betaMol.setX(300);
//			betaMol.setY(0);
//			sigmaMol.setX(400);
//			sigmaMol.setY(0);
//			gammaMol.setX(500);
//			gammaMol.setY(0);
			
//			renderer.addObject(alphaUI);
//			controller.addObject(alphaMol);
//			renderer.addObject(betaUI);
//			controller.addObject(betaMol);
//			renderer.addObject(sigmaUI);
//			controller.addObject(sigmaMol);
//			renderer.addObject(gammaUI);
//			controller.addObject(gammaMol);
			
//			alphaMol.move(atomSpeed);
//			betaMol.move(atomSpeed);
//			sigmaMol.move(atomSpeed);
//			gammaMol.move(atomSpeed);
			
			this.addKeyListener(new KeyListener() {
				public void keyPressed(KeyEvent e) {
					
					if(e.getKeyCode() != KeyEvent.VK_B 
							&& e.getKeyCode() != KeyEvent.VK_1 
							&& e.getKeyCode() != KeyEvent.VK_2 
							&& e.getKeyCode() != KeyEvent.VK_3 
							&& e.getKeyCode() != KeyEvent.VK_4) {
						keyB = false;
						atomRank = 0;
						targetAtomRank = 0;
					}

					switch (e.getKeyCode()) {
					case KeyEvent.VK_UP:
						controller.shootObject(getShootingObject(), shooter);

						break;
					case  KeyEvent.VK_L:
						System.out.println("LOADED");
//						window.dispose();
						controller.loadGame();
						resumeGame();
						//TODO these resume and pauses will change.
						
						break;
					case  KeyEvent.VK_S:
						System.out.println("SAVED");
						controller.saveGame();
						pauseGame();
						break;
					case  KeyEvent.VK_LEFT:
						controller.moveShooter(shooter, shootingObject, "left");
						break;
					case  KeyEvent.VK_RIGHT:
						controller.moveShooter(shooter, shootingObject, "right");
						break;
					case  KeyEvent.VK_A:
						controller.rotateShooter(shooter, shootingObject, "left");
						
						break;
					case  KeyEvent.VK_D:
						controller.rotateShooter(shooter, shootingObject, "right");
						break;
					case  KeyEvent.VK_P:
						pauseGame();
						break;
					case  KeyEvent.VK_R:
						System.out.println("RESUME");
						resumeGame();
						
						break;
					case  KeyEvent.VK_C:
						controller.switchAtom();
						
						break;
					case  KeyEvent.VK_B:
						System.out.println("BLEND");
						keyB = true;
						atomRank = 0;
						targetAtomRank = 0;
						break;
					case  KeyEvent.VK_1:
						if(atomRank == 0 && keyB == true) {
							atomRank = 1;
						} else if(atomRank != 0 && keyB == true) {
							targetAtomRank = 1;
							blender.BlendAtom(atomRank, targetAtomRank);
							keyB = false;
							atomRank = 0;
							targetAtomRank = 0;
						}
						System.out.println("BLENDED");

						System.out.println("Number of Alpha atoms: " + alphaList.size());
						System.out.println("Number of Beta atoms: " + betaList.size());
						System.out.println("Number of Sigma atoms: " + sigmaList.size());
						System.out.println("Number of Gamma atoms: " + gammaList.size());

						break;
					case  KeyEvent.VK_2:
						if(atomRank == 0 && keyB == true) {
							atomRank = 2;
						} else if(atomRank != 0 && keyB == true) {
							targetAtomRank = 2;
							blender.BlendAtom(atomRank, targetAtomRank);
							keyB = false;
							atomRank = 0;
							targetAtomRank = 0;
						}
						System.out.println("BLENDED");

						System.out.println("Number of Alpha atoms: " + alphaList.size());
						System.out.println("Number of Beta atoms: " + betaList.size());
						System.out.println("Number of Sigma atoms: " + sigmaList.size());
						System.out.println("Number of Gamma atoms: " + gammaList.size());
						break;
					case  KeyEvent.VK_3:
						if(atomRank == 0 && keyB == true) {
							atomRank = 3;
						} else if(atomRank != 0 && keyB == true) {
							targetAtomRank = 3;
							blender.BlendAtom(atomRank, targetAtomRank);
							keyB = false;
							atomRank = 0;
							targetAtomRank = 0;
						}
						System.out.println("BLENDED");

						break;
					case  KeyEvent.VK_4:
						if(atomRank == 0 && keyB == true) {
							atomRank = 4;
						} else if(atomRank != 0 && keyB == true) {
							targetAtomRank = 4;
							blender.BlendAtom(atomRank, targetAtomRank);
							keyB = false;
							atomRank = 0;
							targetAtomRank = 0;
						}
						System.out.println("BLENDED");

						break;

						
					default:
						break;
					}
//					update();
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
			window.getStatsWindow().getPuAlpha().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(!getShootingObject().isShooted()) {
						System.out.println("Pu Alpha clicked");
						Powerup pu= new Powerup("+alpha");
						pu.setHeight(diameter*2);
						pu.setWidth(diameter*2);
						pu.setSpeed(atomSpeed);
						pu.setRotationAngle(shooterRotationAngle);
						controller.objects.set(0,pu );
						UIPowerup puUI= new UIPowerup("+alpha");
						puUI.setHeight(diameter*4);
						puUI.setWidth(diameter*4);
						renderer.objects.set(0,puUI );
					}
				}
				
			});
			window.getStatsWindow().getPuBeta().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
					if(!getShootingObject().isShooted()) {
						Powerup pu= new Powerup("+beta");
						System.out.println("Pu Beta clicked");
						pu.setHeight(diameter*2);
						pu.setWidth(diameter*2);
						pu.setSpeed(atomSpeed);
						pu.setRotationAngle(shooterRotationAngle);
						controller.objects.set(0,pu );
						UIPowerup puUI= new UIPowerup("+beta");
						puUI.setHeight(diameter*4);
						puUI.setWidth(diameter*4);
						renderer.objects.set(0,puUI );
					}
				}
				
			});
			window.getStatsWindow().getPuSigma().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(!getShootingObject().isShooted()) {
						Powerup pu= new Powerup("+sigma");
						System.out.println("Pu Sigma clicked");
						pu.setHeight(diameter*2);
						pu.setWidth(diameter*2);
						pu.setSpeed(atomSpeed);
						pu.setRotationAngle(shooterRotationAngle);
						controller.objects.set(0,pu );
						UIPowerup puUI= new UIPowerup("+sigma");
						puUI.setHeight(diameter*4);
						puUI.setWidth(diameter*4);
						renderer.objects.set(0,puUI );
					}
				}
				
			});
			window.getStatsWindow().getPuGamma().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(!getShootingObject().isShooted()) {
						Powerup pu= new Powerup("+gamma");
						System.out.println("Pu Gamma clicked");
						pu.setHeight(diameter*2);
						pu.setWidth(diameter*2);
						pu.setSpeed(atomSpeed);
						pu.setRotationAngle(shooterRotationAngle);
						controller.objects.set(0,pu );
						UIPowerup puUI= new UIPowerup("+gamma");
						puUI.setHeight(diameter*4);
						puUI.setWidth(diameter*4);
						renderer.objects.set(0,puUI );
					}
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
//				System.out.println("FPS: " + frames);
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
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, (int)WIDTH, (int) HEIGHT);
		renderer.render(g);
		g.dispose();
		bs.show();
	}


	public void update() {     
		controller.update();
		//TODO delete this later.
		controller.loadGame();
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
	
	public GameObject getShootingObject() {
		return controller.objects.get(0);
	}
//	public GameObject setShootingObject(GameObject obj) {
//		obj.setType(type);
//	}
	public UIGameObject getUIShootingObject() {
		return renderer.objects.get(0);
	}
	

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	public boolean isAtom(GameObject tempobject) {
		if(tempobject.getType()=="alpha"|| tempobject.getType()=="beta"|| tempobject.getType()=="sigma"||
				tempobject.getType()=="gamma") {
			return true;
		}
		return false;
	}
	
	private void pauseGame() {
		if(!isPaused) {
			System.out.println("PAUSED");
			thread.stop();
//			timerTask.cancel();
			isPaused = true;

//			timer.cancel();
		}
		controller.pauseGame();
	}
	private void resumeGame() {
		if(isPaused) {
			start();
//			timerTask.run();
//			atom.setRotationAngle(shooterRotationAngle);
//			timerTask = new UpdateAtomTask(shootingObject,Toolkit.getDefaultToolkit().getScreenSize(),shooter);
//			setTimer(new Timer(true));
//			timer.scheduleAtFixedRate(timerTask, 0, 100);
			controller.resumeGame(shooter, shootingObject);
			isPaused= false;
		}
	}
}
