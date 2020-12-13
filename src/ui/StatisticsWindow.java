package ui;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatisticsWindow extends JPanel{
	JLabel statisticAlpha = new JLabel();
	JLabel statisticBeta = new JLabel();
	JLabel statisticSigma = new JLabel();
	JLabel statisticGamma = new JLabel();
	String alpha= "src/assets/atoms/alpha.png";
	String beta= "src/assets/atoms/beta.png";
	String sigma= "src/assets/atoms/sigma.png";
	String gamma= "src/assets/atoms/gamma.png";
	
	JLabel puAlpha = new JLabel();
	JLabel puBeta = new JLabel();
	JLabel puSigma = new JLabel();
	JLabel puGamma = new JLabel();
	
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
		add(puAlpha);
		add(puBeta);
		add(puSigma);
		add(puGamma);
	}

}
