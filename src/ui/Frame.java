package ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import domain.gameState.Statistics;



public class Frame extends Canvas {

	private static final long serialVersionUID = 1L;
	public static int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
			HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private JPanel sidebar = new JPanel();
	private JButton quitButton = new JButton("Quit");
	private JTextField moleculeType = new JTextField("AlphaMolecule");
	private JTextField moleculeCount = new JTextField(10);
	private JTextField betaType = new JTextField("BetaMolecule");
	private JTextField betaCount = new JTextField(10);
	private JTextField sigmaCount = new JTextField(10);
	private JTextField gammaCount = new JTextField(10);
	private JFrame frame;
	private JPanel gui = new JPanel(new GridLayout(0,1));
	private JPanel simpleGui = new JPanel(new FlowLayout());  
	private JPanel gamePanel = new JPanel(new FlowLayout());
	private JButton Game = new JButton ("Play Game");
	private JButton buildMode = new JButton("Build Mode");
	StatisticsWindow statsWindow= new StatisticsWindow();
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
		statsWindow.setBounds(1800,10,90, 630);
		statsWindow.setLayout(new BoxLayout(statsWindow, BoxLayout.Y_AXIS));
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
		sidebar.setBounds(10, 10, 100, 40);
		
		frame.add(sidebar);
		moleculeType.setEditable(false);
		betaType.setEditable(false);
		moleculeCount.setEditable(true);
		moleculeCount.setText("6");
		betaCount.setEditable(true);
		betaCount.setText("6");
		sigmaCount.setEditable(true);
		sigmaCount.setText("6");
		gammaCount.setEditable(true);
		gammaCount.setText("6");
		
		simpleGui.add( moleculeType );
		simpleGui.add( moleculeCount );
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
	
	public JTextField getBetaType() {
		return betaType;
	}



	public void setBetaType(JTextField betaType) {
		this.betaType = betaType;
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
	
}