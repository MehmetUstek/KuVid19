package ui;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import domain.Controller;
import domain.atom.AlphaAtom;
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
	private JCheckBox deleteBox = new JCheckBox("delete?", false);
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
//		UIAtom atom = new UIAtom("alpha",60,100,60);
//		maingui.add(atom);
		sidebar.add(saveButton);
		sidebar.add(loadButton);
		sidebar.add(pauseButton);
		sidebar.add(quitButton);
		sidebar.add(restartButton);
		sidebar.add(loginButton);
		sidebar.add(logoutButton);
		sidebar.setBackground(Color.white);
		sidebar.setBounds(10, 10, 550, 40);
		
		
		frame.add(sidebar);
		
		////

		////
//		maingui.setBounds(100 , 100  , WIDTH, HEIGHT);
		frame.add(game);
//		frame.add(maingui);
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
		
		sidebar.add(saveButton);
		sidebar.add(loadButton);
		sidebar.add(pauseButton);
		sidebar.add(quitButton);
		sidebar.add(loginButton);
		sidebar.add(logoutButton);
		sidebar.add(deleteBox);
		sidebar.setBackground(Color.white);
		sidebar.setBounds(10, HEIGHT - 90, 500, 40);
		
		frame.add(sidebar);
		moleculeType.setText("Simple Bricks");
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
		frame.setBackground(Color.WHITE);
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
		
		// UIAtom(String atomType, int diameter, int x, int y) 
		int diameter= 40;
		int speed= diameter;
		int x= frame.getWidth()/2+diameter;
		int y = frame.getHeight() - 3*diameter;
		UIAtom atom = new UIAtom("alpha",diameter,x,y);
		UIAtom beta = new UIAtom("beta",diameter,x+40,y);
		UIAtom gamma = new UIAtom("gamma",diameter,x-50,y);
		UIMolecule molecule = new UIMolecule("alpha-1",diameter*2,diameter*2,x-100,y-300);
		
//		controller.addObject(beta);
		controller.addObject(atom);
//		controller.addObject(gamma);
		controller.addObject(molecule);
		for(UIGameObject object:controller.objects) {
			object.setBounds(object.getX(),object.getY(),object.getX()+object.getWidth(),object.getY()+object.getHeight());
			maingui.add(object,new Integer(1));
			System.out.println("refresh");
		}
		maingui.setBounds(0 , 0  , frame.getWidth(), frame.getHeight());
		frame.add(maingui);
		Thread t1 = new Thread() {
			public void run() {
				UIGameObject object= controller.objects.get(0);
				while ( object.getX()< WIDTH && object.getY() <HEIGHT && object.getX()>0 && object.getY()>0) {
				for(int i=0;i<controller.objects.size();i++) {
						object= controller.objects.get(i);
						object.move(object.getX(),object.getY(),speed, 180);
						try {
							sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}
					
					
					object.setVisible(true);
				}
			}
		};
		t1.start();
		
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

	public JButton getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(JButton saveButton) {
		this.saveButton = saveButton;
	}

	public JButton getLoadButton() {
		return loadButton;
	}

	public void setLoadButton(JButton loadButton) {
		this.loadButton = loadButton;
	}

	public JButton getQuitButton() {
		return quitButton;
	}

	public void setQuitButton(JButton quitButton) {
		this.quitButton = quitButton;
	}

	public JButton getPauseButton() {
		return pauseButton;
	}

	public void setPauseButton(JButton pauseButton) {
		this.pauseButton = pauseButton;
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
	
	public JCheckBox getDeleteBox() {
		return this.deleteBox;
	}
	
	public JButton getRestartButton() {
		return this.restartButton;
	}
	
	public JButton getLoginButton(){
		return loginButton;
	}

	public JButton getLogoutButton() {
		return logoutButton;
	}
	
	
}