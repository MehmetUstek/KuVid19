package ui;

import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatisticsWindow extends JPanel{
	JButton statisticAlpha = new JButton();
	JButton statisticBeta = new JButton();
	JButton statisticSigma = new JButton();
	JButton statisticGamma = new JButton();
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
	
	
	public StatisticsWindow() {
		
		statisticAlpha.setIcon(icona);
		statisticBeta.setIcon(iconb);
		statisticSigma.setIcon(icons);
		statisticGamma.setIcon(icong);
		add(statisticAlpha);
		add(statisticBeta);
		add(statisticSigma);
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
		
		
		add(puAlpha);
		add(puBeta);
		add(puSigma);
		add(puGamma);
		
		
		
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


	
	

}
