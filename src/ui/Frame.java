package ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame extends Canvas {

	private static final long serialVersionUID = 1L;
	public static int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
			HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private JPanel sidebar = new JPanel();
	private JButton quitButton = new JButton("Quit");
	private JTextField alphaType = new JTextField("AlphaMolecule");
	private JTextField alphaCount = new JTextField(10);
	private JTextField betaType = new JTextField("BetaMolecule");
	private JTextField sigmaType = new JTextField("SigmaMolecule");
	private JTextField gammaType = new JTextField("GammaMolecule");
	private JTextField betaCount = new JTextField(10);
	private JTextField sigmaCount = new JTextField(10);
	private JTextField gammaCount = new JTextField(10);
	private JFrame frame;
	private JPanel gui = new JPanel(new GridLayout(0,1));
	private JPanel simpleGui = new JPanel(new FlowLayout());  
	private JPanel gamePanel = new JPanel(new FlowLayout());
	private JButton Game = new JButton ("Play Game");
	private JButton buildMode = new JButton("Build Mode");
	StatisticsWindow statsWindow;
	private JButton applyButton = new JButton("Apply");
	
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
		sidebar.setBackground(Color.white);
		sidebar.setBounds(10, 10, 100, 40);
		statsWindow = StatisticsWindow.getInstance();
		statsWindow.setBounds(1750,10,150, 800);
		statsWindow.setLayout(new GridLayout(9,2));
		frame.add(sidebar);
		frame.add(statsWindow);
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
		sidebar.add(applyButton);
		sidebar.setBackground(Color.white);
		sidebar.setBounds(10, 10, 200, 40);
		
		frame.add(sidebar);
		alphaType.setEditable(false);
		betaType.setEditable(false);
		alphaCount.setEditable(true);
		alphaCount.setText("100");
		betaCount.setEditable(true);
		betaCount.setText("100");
		sigmaCount.setEditable(true);
		sigmaCount.setText("100");
		gammaCount.setEditable(true);
		gammaCount.setText("100");
		
		simpleGui.add( alphaType );
		simpleGui.add( alphaCount );
		simpleGui.add( betaType );
		simpleGui.add( betaCount );
		simpleGui.add( sigmaCount );
		simpleGui.add( gammaCount );
		
		// frame.add();
		gui.add(simpleGui);
		gui.setBounds(WIDTH- gui.getWidth() - 370, HEIGHT - 200 , 350, 150);
		
		frame.add(gui);
		frame.add(buildmode);

		frame.setVisible(true);
		buildmode.start();
		
		
	}
	
	

	public Frame() {}

	public Frame(Dimension screenSize, String title, Main mainGame) {
		frame = new JFrame(title);
		frame.setVisible(true);
		frame.setSize(WIDTH, HEIGHT);
		frame.setBackground(Color.BLACK);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamePanel.setBackground(Color.WHITE);
		gamePanel.add(Game);
		gamePanel.add(buildMode);
		frame.add(gamePanel);
		
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
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
	
	public StatisticsWindow getStatsWindow() {
		return statsWindow;
	}

	public void setStatsWindow(StatisticsWindow statsWindow) {
		this.statsWindow = statsWindow;
	}

	public JButton getApplyButton() {
		return applyButton;
	}

	public void setApplyButton(JButton applyButton) {
		this.applyButton = applyButton;
	}
	public JTextField getSigmaCount() {
		return sigmaCount;
	}
	public void setSigmaCount(JTextField sigmaCount) {
		this.sigmaCount = sigmaCount;
	}
	public JTextField getGammaCount() {
		return gammaCount;
	}
	public void setGammaCount(JTextField gammaCount) {
		this.gammaCount = gammaCount;
	}
	
	public JTextField getAlphaType() {
		return alphaType;
	}
	public void setAlphaType(JTextField alphaType) {
		this.alphaType = alphaType;
	}
	public JTextField getSigmaType() {
		return sigmaType;
	}
	public void setSigmaType(JTextField sigmaType) {
		this.sigmaType = sigmaType;
	}
	public JTextField getGammaType() {
		return gammaType;
	}
	public void setGammaType(JTextField gammaType) {
		this.gammaType = gammaType;
	}

	public JTextField getAlphaCount() {
		return alphaCount;
	}
	public void setAlphaCount(JTextField alphaCount) {
		this.alphaCount = alphaCount;
	}
	public JTextField getBetaType() {
		return betaType;
	}
	public void setBetaType(JTextField betaType) {
		this.betaType = betaType;
	}
	public JTextField getBetaCount() {
		return betaCount;
	}

	public void setBetaCount(JTextField betaCount) {
		this.betaCount = betaCount;
	}
}