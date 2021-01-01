package ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Frame extends Canvas {

	private static final long serialVersionUID = 1L;
	public static int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
			HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private JPanel sidebar = new JPanel();
	private JButton quitButton = new JButton("Quit");
	private JTextField alphaMoleculeType = new JTextField("AlphaMolecule");
	private JTextField alphaMoleculeCount = new JTextField(10);
	private JTextField betaMoleculeType = new JTextField("BetaMolecule");
	private JTextField sigmaMoleculeType = new JTextField("SigmaMolecule");
	private JTextField gammaMoleculeType = new JTextField("GammaMolecule");
	private JTextField puText = new JTextField("Powerups");
	private JTextField betaMoleculeCount = new JTextField(10);
	private JTextField sigmaMoleculeCount = new JTextField(10);
	private JTextField gammaMoleculeCount = new JTextField(10);
	private JTextField puCount = new JTextField(10);
	
	private JTextField alphaAtomType = new JTextField("AlphaAtom");
	private JTextField betaAtomType = new JTextField("BetaAtom");
	private JTextField sigmaAtomType = new JTextField("SigmaAtom");
	private JTextField gammaAtomType = new JTextField("GammaAtom");
	
	private JTextField alphaAtomCount = new JTextField(10);
	private JTextField betaAtomCount = new JTextField(10);
	private JTextField sigmaAtomCount = new JTextField(10);
	private JTextField gammaAtomCount = new JTextField(10);
	
	//Shields
	private JTextField etaType = new JTextField("Eta");
	private JTextField lotaType = new JTextField("Lota");
	private JTextField thetaType = new JTextField("Theta");
	private JTextField zetaType = new JTextField("Zeta");
	private JTextField etaCount = new JTextField(10);
	private JTextField lotaCount = new JTextField(10);
	private JTextField thetaCount = new JTextField(10);
	private JTextField zetaCount = new JTextField(10);
	
	
	private JFrame frame;
	private JPanel gui = new JPanel(new GridLayout(0,1));
	private JPanel simpleGui = new JPanel(new FlowLayout());  
	private JPanel gamePanel = new JPanel(new FlowLayout());
	private JButton Game = new JButton ("Play Game");
	private JButton buildMode = new JButton("Build Mode");
	StatisticsWindow statsWindow;
	private JButton applyButton = new JButton("Apply");
	private boolean isBuildMode= false;
	JTextField username= new JTextField("Enter username:");
	JButton login = new JButton("login");
	// Time
	JLabel time= new JLabel("Time(As Seconds)");
	JTextField gameTime = new JTextField("600");
	
	
	
	//Hardness of the game
	private JPanel hardnessGui = new JPanel(new FlowLayout());  
	JLabel hardness= new JLabel("Difficulty");
	JRadioButton easyBox= new JRadioButton("Easy");
	JRadioButton mediumBox= new JRadioButton("Medium");
	JRadioButton hardBox= new JRadioButton("Hard");
	ButtonGroup bGroup = new ButtonGroup();
	
	public Frame(Dimension d, String title, KuVid game) {
		frame = new JFrame(title);
		isBuildMode= false;
		frame.setMaximumSize(d);
		frame.setMinimumSize(new Dimension(1, 1));
		frame.setSize(frame.getMaximumSize());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setBackground(Color.WHITE);
		frame.setLocationRelativeTo(null);
		sidebar.add(quitButton);
		sidebar.add(username);
		sidebar.add(login);
		sidebar.setBackground(Color.white);
		sidebar.setBounds(10, 10, 300, 40);
		statsWindow = StatisticsWindow.getInstance();
		statsWindow.setBounds(1750,10,150, 1000);
		statsWindow.setLayout(new GridLayout(0,2));
		frame.add(sidebar);
		frame.add(statsWindow);
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}
	
	
	public Frame(Dimension d, String title, BuildMode buildmode) {
		
		frame = new JFrame(title);
		isBuildMode= true;
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
		alphaMoleculeType.setEditable(false);
		betaMoleculeType.setEditable(false);
		sigmaMoleculeType.setEditable(false);
		gammaMoleculeType.setEditable(false);
		alphaAtomType.setEditable(false);
		betaAtomType.setEditable(false);
		sigmaAtomType.setEditable(false);
		gammaAtomType.setEditable(false);
		puText.setEditable(false);
		etaType.setEditable(false);
		lotaType.setEditable(false);
		thetaType.setEditable(false);
		zetaType.setEditable(false);
		
		alphaAtomCount.setEditable(true);
		alphaAtomCount.setText("20");
		betaAtomCount.setEditable(true);
		betaAtomCount.setText("20");
		sigmaAtomCount.setEditable(true);
		sigmaAtomCount.setText("20");
		gammaAtomCount.setEditable(true);
		gammaAtomCount.setText("20");
		alphaMoleculeCount.setEditable(true);
		alphaMoleculeCount.setText("100");
		betaMoleculeCount.setEditable(true);
		betaMoleculeCount.setText("100");
		sigmaMoleculeCount.setEditable(true);
		sigmaMoleculeCount.setText("100");
		gammaMoleculeCount.setEditable(true);
		gammaMoleculeCount.setText("100");
		
		//Shields
		etaCount.setEditable(true);
		etaCount.setText("20");
		lotaCount.setEditable(true);
		lotaCount.setText("20");
		thetaCount.setEditable(true);
		thetaCount.setText("20");
		zetaCount.setEditable(true);
		zetaCount.setText("20");
		
		puCount.setEditable(true);
		puCount.setText("20");
		gameTime.setEditable(true);
		simpleGui.add(new JLabel("Username"));
		simpleGui.add(username);
		simpleGui.add(time);
		simpleGui.add(gameTime);
		simpleGui.add( alphaAtomType );
		simpleGui.add( alphaAtomCount );
		simpleGui.add( betaAtomType );
		simpleGui.add( betaAtomCount );
		simpleGui.add( sigmaAtomType );
		simpleGui.add( sigmaAtomCount );
		simpleGui.add( gammaAtomType );
		simpleGui.add( gammaAtomCount );
		
		simpleGui.add( alphaMoleculeType );
		simpleGui.add( alphaMoleculeCount );
		simpleGui.add( betaMoleculeType );
		simpleGui.add( betaMoleculeCount );
		simpleGui.add( sigmaMoleculeType );
		simpleGui.add( sigmaMoleculeCount );
		simpleGui.add( gammaMoleculeType );
		simpleGui.add( gammaMoleculeCount );
		simpleGui.add( puText);
		simpleGui.add( puCount );
		simpleGui.add(etaType);
		simpleGui.add(etaCount);
		simpleGui.add(lotaType);
		simpleGui.add(lotaCount);
		simpleGui.add(thetaType);
		simpleGui.add(thetaCount);
		simpleGui.add(zetaType);
		simpleGui.add(zetaCount);
		simpleGui.setLayout(new GridLayout(0,2));
		
		gui.add(simpleGui);
		
		//Hardness
		easyBox.setActionCommand("easy");
		mediumBox.setActionCommand("medium");
		hardBox.setActionCommand("hard");
		hardnessGui.add(hardness);
		hardnessGui.add(easyBox);
		hardnessGui.add(mediumBox);
		hardnessGui.add(hardBox);
		bGroup.add(easyBox);
		bGroup.add(mediumBox);
		bGroup.add(hardBox);
		bGroup.setSelected(easyBox.getModel(), true);
		hardnessGui.setLayout(new GridLayout(0,1));
		hardnessGui.setBounds(WIDTH- gui.getWidth() - 700, HEIGHT - 100 , 100, 100);
		frame.add(hardnessGui);
		
		
		gui.setBounds(WIDTH- gui.getWidth() - 370, HEIGHT - 300 , 350, 300);
		
		frame.add(gui);
		frame.add(buildmode);

		frame.setVisible(true);
		buildmode.start();
		
		
	}
	
	public Frame() {}

	public Frame(Dimension screenSize, String title, Main mainGame) {
		isBuildMode= false;
		
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
	
	public JTextField getAlphaMoleculeType() {
		return alphaMoleculeType;
	}


	public void setAlphaMoleculeType(JTextField alphaMoleculeType) {
		this.alphaMoleculeType = alphaMoleculeType;
	}


	public JTextField getAlphaMoleculeCount() {
		return alphaMoleculeCount;
	}


	public void setAlphaMoleculeCount(JTextField alphaMoleculeCount) {
		this.alphaMoleculeCount = alphaMoleculeCount;
	}


	public JTextField getBetaMoleculeType() {
		return betaMoleculeType;
	}


	public void setBetaMoleculeType(JTextField betaMoleculeType) {
		this.betaMoleculeType = betaMoleculeType;
	}


	public JTextField getSigmaMoleculeType() {
		return sigmaMoleculeType;
	}


	public void setSigmaMoleculeType(JTextField sigmaMoleculeType) {
		this.sigmaMoleculeType = sigmaMoleculeType;
	}


	public JTextField getGammaMoleculeType() {
		return gammaMoleculeType;
	}


	public void setGammaMoleculeType(JTextField gammaMoleculeType) {
		this.gammaMoleculeType = gammaMoleculeType;
	}


	public JTextField getBetaMoleculeCount() {
		return betaMoleculeCount;
	}


	public void setBetaMoleculeCount(JTextField betaMoleculeCount) {
		this.betaMoleculeCount = betaMoleculeCount;
	}


	public JTextField getSigmaMoleculeCount() {
		return sigmaMoleculeCount;
	}


	public void setSigmaMoleculeCount(JTextField sigmaMoleculeCount) {
		this.sigmaMoleculeCount = sigmaMoleculeCount;
	}


	public JTextField getGammaMoleculeCount() {
		return gammaMoleculeCount;
	}


	public void setGammaMoleculeCount(JTextField gammaMoleculeCount) {
		this.gammaMoleculeCount = gammaMoleculeCount;
	}


	public JTextField getAlphaAtomCount() {
		return alphaAtomCount;
	}


	public void setAlphaAtomCount(JTextField alphaAtomCount) {
		this.alphaAtomCount = alphaAtomCount;
	}


	public JTextField getBetaAtomCount() {
		return betaAtomCount;
	}


	public void setBetaAtomCount(JTextField betaAtomCount) {
		this.betaAtomCount = betaAtomCount;
	}


	public JTextField getSigmaAtomCount() {
		return sigmaAtomCount;
	}


	public void setSigmaAtomCount(JTextField sigmaAtomCount) {
		this.sigmaAtomCount = sigmaAtomCount;
	}


	public JTextField getGammaAtomCount() {
		return gammaAtomCount;
	}


	public void setGammaAtomCount(JTextField gammaAtomCount) {
		this.gammaAtomCount = gammaAtomCount;
	}


	public JTextField getPuCount() {
		return puCount;
	}
	public void setPuCount(JTextField puCount) {
		this.puCount = puCount;
	}

	public boolean isBuildMode() {
		return isBuildMode;
	}


	public ButtonGroup getbGroup() {
		return bGroup;
	}


	public void setbGroup(ButtonGroup bGroup) {
		this.bGroup = bGroup;
	}


	public JRadioButton getEasyBox() {
		return easyBox;
	}


	public JRadioButton getMediumBox() {
		return mediumBox;
	}


	public JRadioButton getHardBox() {
		return hardBox;
	}


	public JTextField getGameTime() {
		return gameTime;
	}


	public void setGameTime(JTextField gameTime) {
		this.gameTime = gameTime;
	}


	public JTextField getEtaCount() {
		return etaCount;
	}


	public void setEtaCount(JTextField etaCount) {
		this.etaCount = etaCount;
	}


	public JTextField getLotaCount() {
		return lotaCount;
	}


	public void setLotaCount(JTextField lotaCount) {
		this.lotaCount = lotaCount;
	}


	public JTextField getThetaCount() {
		return thetaCount;
	}


	public void setThetaCount(JTextField thetaCount) {
		this.thetaCount = thetaCount;
	}


	public JTextField getZetaCount() {
		return zetaCount;
	}


	public void setZetaCount(JTextField zetaCount) {
		this.zetaCount = zetaCount;
	}


	public JTextField getUsername() {
		return username;
	}


	public void setUsername(JTextField username) {
		this.username = username;
	}


	public JButton getLogin() {
		return login;
	}


	public void setLogin(JButton login) {
		this.login = login;
	}
	
}