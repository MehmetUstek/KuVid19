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
		frame.setBackground(Color.BLACK);
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

		UIAtom atom = new UIAtom("alpha",60);
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
		frame.setBackground(Color.BLACK);
		frame.setLocationRelativeTo(null);
		UIAtom atom = new UIAtom("alpha",60);
		JButton asdsa = new JButton ("Play asdsa");
		gamePanel.add(asdsa);
		controller.addObject(atom);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		atom.setBounds(0,0,60,60);
		Background bg= new Background(WIDTH,HEIGHT);
		bg.setBounds(0,0,WIDTH,HEIGHT);
		bg.add(atom);
		gamePanel.add(bg,0,0);

		frame.add(atom);
		gamePanel.setBackground(Color.BLACK);
		gamePanel.add(Game);
		gamePanel.add(buildMode);
		gamePanel.add(atom);
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