package ui;

import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatisticsWindow extends JPanel{
	static StatisticsWindow instance;
	JButton statisticAlpha = new JButton();
	JButton statisticBeta = new JButton();
	JButton statisticSigma = new JButton();
	JButton statisticGamma = new JButton();
	Font myFont = new Font("Times New Roman", Font.BOLD, 20);
	Font secondFont = new Font("Times New Roman", Font.BOLD, 15);
	

	String alpha= "src/assets/atoms/alpha.png";
	String beta= "src/assets/atoms/beta.png";
	String sigma= "src/assets/atoms/sigma.png";
	String gamma= "src/assets/atoms/gamma.png";
	
	JButton puAlpha = new JButton();
	JButton puBeta = new JButton();
	JButton puSigma = new JButton();
	JButton puGamma = new JButton();
	
	String alphaP= "src/assets/powerups/+alpha-b.png";
	String betaP= "src/assets/powerups/+beta-b.png";
	String sigmaP= "src/assets/powerups/+sigma-b.png";
	String gammaP= "src/assets/powerups/+gamma-b.png";
	
	
	
	ImageIcon icona = new ImageIcon(alpha);
	ImageIcon iconb = new ImageIcon(beta);
	ImageIcon icons = new ImageIcon(sigma);
	ImageIcon icong = new ImageIcon(gamma);
	
	ImageIcon alphaPU = new ImageIcon(alphaP);
	ImageIcon betaPU = new ImageIcon(betaP);
	ImageIcon sigmaPU = new ImageIcon(sigmaP);
	ImageIcon gammaPU = new ImageIcon(gammaP);
	
	
	JLabel alphaLabel = new JLabel("1");
	JLabel betaLabel = new JLabel("1");
	JLabel sigmaLabel = new JLabel("1");
	JLabel gammaLabel = new JLabel("1");
	
	JLabel alphaPULabel = new JLabel("1");
	JLabel betaPULabel = new JLabel("1");
	JLabel sigmaPULabel = new JLabel("1");
	JLabel gammaPULabel = new JLabel("1");
	JLabel scoreText = new JLabel("Score");
	JLabel score= new JLabel();
	JLabel timeShape = new JLabel("Time");
	JLabel time = new JLabel("0");
	//Shields
	JButton etaLabel = new JButton("Eta");
	JLabel eta= new JLabel("0");
	JButton lotaLabel = new JButton("Lota");
	JLabel lota= new JLabel("0");
	JButton thetaLabel = new JButton("Theta");
	JLabel theta= new JLabel("0");
	JButton zetaLabel = new JButton("Zeta");
	JLabel zeta= new JLabel("0");
	
	public StatisticsWindow() {
		statisticAlpha.setIcon(icona);
		statisticBeta.setIcon(iconb);
		statisticSigma.setIcon(icons);
		statisticGamma.setIcon(icong);
		alphaLabel.setFont(myFont);
		betaLabel.setFont(myFont);
		sigmaLabel.setFont(myFont);
		gammaLabel.setFont(myFont);
		alphaPULabel.setFont(myFont);
		betaPULabel.setFont(myFont);
		sigmaPULabel.setFont(myFont);
		gammaPULabel.setFont(myFont);
		scoreText.setFont(secondFont);
		score.setFont(myFont);
		timeShape.setFont(secondFont);
		time.setFont(myFont);
		etaLabel.setFont(secondFont);
		lotaLabel.setFont(secondFont);
		thetaLabel.setFont(secondFont);
		zetaLabel.setFont(secondFont);
		eta.setFont(myFont);
		lota.setFont(myFont);
		theta.setFont(myFont);
		zeta.setFont(myFont);
		
		add(scoreText);
		add(score);
		add(timeShape);
		add(time);
		
		add(alphaLabel);
		add(statisticAlpha);
		add(betaLabel);
		add(statisticBeta);
		add(sigmaLabel);
		add(statisticSigma);
		add(gammaLabel);
		add(statisticGamma);
		
		
		
		puAlpha.setIcon(alphaPU);
		puBeta.setIcon(betaPU);
		puSigma.setIcon(sigmaPU);
		puGamma.setIcon(gammaPU);
		puAlpha.setName("puAlpha");
		
		puAlpha.setBorder(BorderFactory.createEmptyBorder());
		puAlpha.setContentAreaFilled(false);
		
		puBeta.setBorder(BorderFactory.createEmptyBorder());
		puBeta.setContentAreaFilled(false);
		
		puSigma.setBorder(BorderFactory.createEmptyBorder());
		puSigma.setContentAreaFilled(false);
		
		puGamma.setBorder(BorderFactory.createEmptyBorder());
		puGamma.setContentAreaFilled(false);
		
		statisticAlpha.setBorder(BorderFactory.createEmptyBorder());
		statisticAlpha.setContentAreaFilled(false);
		
		statisticBeta.setBorder(BorderFactory.createEmptyBorder());
		statisticBeta.setContentAreaFilled(false);
		
		statisticSigma.setBorder(BorderFactory.createEmptyBorder());
		statisticSigma.setContentAreaFilled(false);
		
		statisticGamma.setBorder(BorderFactory.createEmptyBorder());
		statisticGamma.setContentAreaFilled(false);
		
		//Shields
		etaLabel.setBorder(BorderFactory.createEmptyBorder());
		etaLabel.setContentAreaFilled(false);
		lotaLabel.setBorder(BorderFactory.createEmptyBorder());
		lotaLabel.setContentAreaFilled(false);
		thetaLabel.setBorder(BorderFactory.createEmptyBorder());
		thetaLabel.setContentAreaFilled(false);
		zetaLabel.setBorder(BorderFactory.createEmptyBorder());
		zetaLabel.setContentAreaFilled(false);
		
		
		
		//Shields Add
		add(etaLabel);
		add(eta);
		add(lotaLabel);
		add(lota);
		add(thetaLabel);
		add(theta);
		add(zetaLabel);
		add(zeta);
				
		add(alphaPULabel);
		add(puAlpha);
		add(betaPULabel);
		add(puBeta);
		add(sigmaPULabel);
		add(puSigma);
		add(gammaPULabel);
		add(puGamma);
		
		
	}

	public JLabel getScore() {
		return score;
	}


	public void setScore(JLabel score) {
		this.score = score;
	}


	public JLabel getTime() {
		return time;
	}


	public void setTime(JLabel time) {
		this.time = time;
	}


	public JLabel getAlphaPULabel() {
		return alphaPULabel;
	}


	public void setAlphaPULabel(JLabel alphaPULabel) {
		this.alphaPULabel = alphaPULabel;
	}


	public JLabel getBetaPULabel() {
		return betaPULabel;
	}


	public void setBetaPULabel(JLabel betaPULabel) {
		this.betaPULabel = betaPULabel;
	}


	public JLabel getSigmaPULabel() {
		return sigmaPULabel;
	}


	public void setSigmaPULabel(JLabel sigmaPULabel) {
		this.sigmaPULabel = sigmaPULabel;
	}


	public JLabel getGammaPULabel() {
		return gammaPULabel;
	}


	public void setGammaPULabel(JLabel gammaPULabel) {
		this.gammaPULabel = gammaPULabel;
	}


	public JLabel getAlphaLabel() {
		return alphaLabel;
	}


	public void setAlphaLabel(JLabel alphaLabel) {
		this.alphaLabel = alphaLabel;
	}


	public JLabel getBetaLabel() {
		return betaLabel;
	}


	public void setBetaLabel(JLabel betaLabel) {
		this.betaLabel = betaLabel;
	}


	public JLabel getSigmaLabel() {
		return sigmaLabel;
	}


	public void setSigmaLabel(JLabel sigmaLabel) {
		this.sigmaLabel = sigmaLabel;
	}


	public JLabel getGammaLabel() {
		return gammaLabel;
	}


	public void setGammaLabel(JLabel gammaLabel) {
		this.gammaLabel = gammaLabel;
	}


	public JButton getStatisticAlpha() {
		return statisticAlpha;
	}


	public void setStatisticAlpha(JButton statisticAlpha) {
		this.statisticAlpha = statisticAlpha;
	}


	public JButton getStatisticBeta() {
		return statisticBeta;
	}


	public void setStatisticBeta(JButton statisticBeta) {
		this.statisticBeta = statisticBeta;
	}


	public JButton getStatisticSigma() {
		return statisticSigma;
	}


	public void setStatisticSigma(JButton statisticSigma) {
		this.statisticSigma = statisticSigma;
	}


	public JButton getStatisticGamma() {
		return statisticGamma;
	}


	public void setStatisticGamma(JButton statisticGamma) {
		this.statisticGamma = statisticGamma;
	}


	public JButton getPuAlpha() {
		return puAlpha;
	}


	public void setPuAlpha(JButton puAlpha) {
		this.puAlpha = puAlpha;
	}


	public JButton getPuBeta() {
		return puBeta;
	}


	public void setPuBeta(JButton puBeta) {
		this.puBeta = puBeta;
	}


	public JButton getPuSigma() {
		return puSigma;
	}


	public void setPuSigma(JButton puSigma) {
		this.puSigma = puSigma;
	}


	public JButton getPuGamma() {
		return puGamma;
	}


	public void setPuGamma(JButton puGamma) {
		this.puGamma = puGamma;
	}

	public static StatisticsWindow getInstance() {
		if(instance==null) {
			instance= new StatisticsWindow();
		}
		return instance;
	}
	
	public JButton getEtaLabel() {
		return etaLabel;
	}

	public void setEtaLabel(JButton etaLabel) {
		this.etaLabel = etaLabel;
	}

	public JButton getLotaLabel() {
		return lotaLabel;
	}

	public void setLotaLabel(JButton lotaLabel) {
		this.lotaLabel = lotaLabel;
	}

	public JButton getThetaLabel() {
		return thetaLabel;
	}

	public void setThetaLabel(JButton thetaLabel) {
		this.thetaLabel = thetaLabel;
	}

	public JButton getZetaLabel() {
		return zetaLabel;
	}

	public void setZetaLabel(JButton zetaLabel) {
		this.zetaLabel = zetaLabel;
	}

	public JLabel getEta() {
		return eta;
	}

	public void setEta(JLabel eta) {
		this.eta = eta;
	}

	public JLabel getLota() {
		return lota;
	}

	public void setLota(JLabel lota) {
		this.lota = lota;
	}

	public JLabel getTheta() {
		return theta;
	}

	public void setTheta(JLabel theta) {
		this.theta = theta;
	}

	public JLabel getZeta() {
		return zeta;
	}

	public void setZeta(JLabel zeta) {
		this.zeta = zeta;
	}

}
