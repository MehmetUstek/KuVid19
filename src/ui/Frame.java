package ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



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
	private JTextField brickType1 = new JTextField();
	private JTextField brickCount1 = new JTextField(10); 
	private JTextField brickType2 = new JTextField(); 
	private JTextField brickCount2 = new JTextField(10); 
	private JTextField brickType3 = new JTextField(); 
	private JTextField brickCount3 = new JTextField(10);
	private JTextField brickType4 = new JTextField();
	private JTextField brickCount4 = new JTextField(10);
	private JCheckBox deleteBox = new JCheckBox("delete?", false);
	private boolean canAddBricks = false;
	private JFrame frame;
	private JPanel gamePanel = new JPanel(new FlowLayout());
	private JButton Game = new JButton ("Play Game");
	private JButton buildMode = new JButton("Build Mode");
	private JButton restartButton = new JButton("Restart");
	
	UIController controller= new UIController();
	
	//TODO: Change game type in here.
	public Frame(Dimension d, String title, KuVid game) {
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
		sidebar.add(restartButton);
		sidebar.add(loginButton);
		sidebar.add(logoutButton);
		sidebar.setBackground(Color.white);
		sidebar.setBounds(10, 10, 550, 40);
		
		frame.add(sidebar);
		
		////
		UIAtom atom = new UIAtom("alpha",60 );
		frame.add(atom);
		
		////
		
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
		


		
		// frame.add();
		
		JLabel label = new JLabel("EDITING AREA FOR THE PLAYER", SwingConstants.CENTER);
		label.setBounds(WIDTH/2 - 100, HEIGHT/2+100, 200, 100);
		frame.add(label);
		

		
		frame.add(buildmode);

		frame.setVisible(true);
		buildmode.start();
		
		
	}
	
	public Frame() {}

	public Frame(Dimension screenSize, String title, Main mainGame) {
		frame = new JFrame(title);
		frame.setVisible(true);
		frame.setSize(900, 900);
		frame.setLocationRelativeTo(null);
		UIAtom atom = new UIAtom("alpha",600 );
		controller.addObject(atom);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamePanel.add(atom);
		gamePanel.add(Game);
		gamePanel.add(buildMode);
		frame.add(gamePanel);
		
	}

	public JTextField getBrickCount1() {
		return brickCount1;
	}

	public void setBrickCount1(JTextField brickCount1) {
		this.brickCount1 = brickCount1;
	}

	public JTextField getBrickCount2() {
		return brickCount2;
	}

	public void setBrickCount2(JTextField brickCount2) {
		this.brickCount2 = brickCount2;
	}

	public JTextField getBrickCount3() {
		return brickCount3;
	}

	public void setBrickCount3(JTextField brickCount3) {
		this.brickCount3 = brickCount3;
	}

	public JTextField getBrickCount4() {
		return brickCount4;
	}

	public void setBrickCount4(JTextField brickCount4) {
		this.brickCount4 = brickCount4;
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