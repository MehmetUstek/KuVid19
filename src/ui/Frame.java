package ui;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import domain.Controller;
import domain.atom.Atom;



public class Frame extends Canvas {

	private static final long serialVersionUID = 1L;
	public static int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
			HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private JPanel sidebar = new JPanel();
	private JButton saveButton = new JButton("Save");
	private JButton loadButton = new JButton("Load");
	private JButton pauseButton = new JButton("Pause");
	private JButton quitButton = new JButton("Quit");
	private JButton loginButton = new JButton("Login");
	private JButton logoutButton = new JButton("Logout");
	private JTextField moleculeType = new JTextField();
	private JTextField moleculeCount = new JTextField(10);
	private JTextField betaType = new JTextField();
	private JTextField betaCount = new JTextField(10);
	private boolean canAddBricks = false;
	private JFrame frame;
	private JPanel gui = new JPanel(new GridLayout(0,1));
	private JLayeredPane maingui = new JLayeredPane();
	private JPanel simpleGui = new JPanel(new FlowLayout());  
	private JPanel gamePanel = new JPanel(new FlowLayout());
	private JButton Game = new JButton ("Play Game");
	private JButton buildMode = new JButton("Build Mode");
	private JButton restartButton = new JButton("Restart");
	
	public UIController controller= new UIController();
	public Controller GC= new Controller(controller, this);
	//TODO: Change game type in here.
	public Frame(Dimension d, String title, KuVid game) {
		frame = new JFrame(title);
		frame.setMaximumSize(d);
		frame.setMinimumSize(new Dimension(1, 1));
		frame.setSize(frame.getMaximumSize());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setBackground(Color.WHITE);
		frame.setLocationRelativeTo(null);
		sidebar.add(quitButton);
		sidebar.add(restartButton);
		sidebar.setBackground(Color.white);
		sidebar.setBounds(10, 10, 200, 40);
		
		
		frame.add(sidebar);
		
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}
	
	public Frame(Dimension d, String title, BuildMode buildmode) {
		
		frame = new JFrame(title);
		
		frame.setMaximumSize(d);
		frame.setMinimumSize(new Dimension(1, 1));
		frame.setSize(frame.getMaximumSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		sidebar.add(quitButton);
		sidebar.setBackground(Color.white);
		sidebar.setBounds(10, HEIGHT - 90, 500, 40);
		
		frame.add(sidebar);
		moleculeType.setText("Alpha Molecules");
		moleculeType.setEditable(false);
		betaType.setText("Beta Molecules");
		betaType.setEditable(false);
		moleculeCount.setEditable(true);
		moleculeCount.setText("6");
		betaCount.setEditable(true);
		betaCount.setText("6");
		
		simpleGui.add( moleculeType );
		simpleGui.add( moleculeCount );
		simpleGui.add( betaType );
		simpleGui.add( betaCount );
		
		// frame.add();
		gui.add(simpleGui);
		gui.setBounds(WIDTH- gui.getWidth() - 370, HEIGHT - 200 , 350, 150);
		
		frame.add(gui);
		
		JLabel label = new JLabel("EDITING AREA FOR THE PLAYER", SwingConstants.CENTER);
		label.setBounds(WIDTH/2 - 100, HEIGHT/2+100, 200, 100);
		frame.add(label);
		

		
		frame.add(buildmode);

		frame.setVisible(true);
		buildmode.start();
		
		
	}
	
	public JTextField getMoleculeType() {
		return moleculeType;
	}

	public void setMoleculeType(JTextField moleculeType) {
		this.moleculeType = moleculeType;
	}

	public JTextField getMoleculeCount() {
		return moleculeCount;
	}

	public void setMoleculeCount(JTextField moleculeCount) {
		this.moleculeCount = moleculeCount;
	}
	public JTextField getBetaCount() {
		return betaCount;
	}

	public void setBetaCount(JTextField betaCount) {
		this.betaCount = betaCount;
	}

	public Frame() {}

	public Frame(Dimension screenSize, String title, Main mainGame) {
		frame = new JFrame(title);
		frame.setVisible(true);
		frame.setSize(WIDTH, HEIGHT);
		frame.setBackground(Color.BLACK);
		frame.setLocationRelativeTo(null);
//		UIAtom atom = new UIAtom("alpha",60);
//		controller.addObject(atom);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		atom.setBounds(0,0,60,60);
		
//		frame.add(atom);
		gamePanel.setBackground(Color.WHITE);
		gamePanel.add(Game);
		gamePanel.add(buildMode);
//		gamePanel.add(atom);
//		String file = "/src/assets/kuvid_bc.png";
//		ImageIcon icon= new ImageIcon(file);
//		Image image= icon.getImage();
//		background.add(image);
		// UIAtom(String atomType, int diameter, int x, int y) 
//		int diameter= 40;
//		int speed= diameter;
//		int x= frame.getWidth()/2+diameter;
//		int y = frame.getHeight() - 3*diameter;
////		UIAtom atomui = new UIAtom("alpha",diameter,x,y);
////		UIAtom beta = new UIAtom("beta",diameter,x+40,y);
////		UIAtom gamma = new UIAtom("gamma",diameter,x-50,y);
//		UIMolecule molecule = new UIMolecule("alpha-1",diameter*2,diameter*2,x-100,10);
//		Atom atom = new AlphaAtom("alpha",diameter,x,y,speed,135);
//		
//		GC.addObject(atom);
//		
////		controller.addObject(beta);
////		controller.addObject(atomui);
////		controller.addObject(gamma);
//		controller.addObject(molecule);
//		
////		
////		for(UIGameObject object:controller.objects) {
//////			object.setBounds(object.getX(),object.getY(),object.getX()+object.getWidth(),object.getY()+object.getHeight());
//////			maingui.add(object,new Integer(1));
////			System.out.println("refresh");
////		}
////		maingui.setBounds(0 , 0  , frame.getWidth(), frame.getHeight());
////		
////		frame.add(maingui);
		
		
////		TimerTask timertask= new TimerTask() {
////
////			@Override
////			public void run() {
////				// TODO Auto-generated method stub
////				for(UIGameObject object: controller.objects ) {
////					System.out.println("task Running");
////				while ( object.getX()< WIDTH && object.getY() <HEIGHT && object.getX()>0 && object.getY()>0) {
////						object.move(object.getX(),object.getY(),speed, 180);
////			}
////			}
////			}
////		};
////		Timer timer = new Timer(true);
////        timer.scheduleAtFixedRate(timertask, 0, 10000);
////        try {
////            Thread.sleep(100000);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
////        timer.cancel();
//    
//		Thread t1 = new Thread() {
//			public void run() {
//				UIGameObject object= controller.objects.get(0);
//				while (true) {
//				for(int i=0;i<controller.objects.size();i++) {
//					 	if(object.getX()< WIDTH && object.getY() <HEIGHT && object.getX()>0 && object.getY()>0) {
//						object= controller.objects.get(i);
////						object.move(object.getX(),object.getY(),speed, 135);
//						try {
//							sleep(200);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//					 	}
//					 	else{
////					 		object.bounceBack(object.getX(),object.getY(),speed, 180);
//						 	try {
//								sleep(100);
//							} catch (InterruptedException e) {
//								e.printStackTrace();
//							}
//					 	}
//				}
//					
//					
//				}
//				
//			}
//		};
//		t1.start();
		
		frame.add(gamePanel);
		
	}

	

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}


	public boolean isCanAddBricks() {
		return canAddBricks;
	}

	public void setCanAddBricks(boolean canAddBricks) {
		this.canAddBricks = canAddBricks;
	}


	public JButton getQuitButton() {
		return quitButton;
	}

	public void setQuitButton(JButton quitButton) {
		this.quitButton = quitButton;
	}

	
	public JButton getGame() {
		return Game;
	}

	public void setGame(JButton game) {
		Game = game;
	}

	public JButton getBuildMode() {
		return buildMode;
	}

	public void setBuildMode(JButton buildMode) {
		this.buildMode = buildMode;
	}

	public void dispose() {
		frame.dispose();
	}
	
	
	
}