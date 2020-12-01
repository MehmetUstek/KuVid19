package ui;

import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JLayeredPane;

import domain.atom.*;

public class MainMenu extends JLayeredPane {
	final static int L=600;
	final static int diameter= L/10;
	private static final int FRAME_WIDTH = 600;
	Background background= new Background();
	SigmaAtom sigma=new SigmaAtom(100, 100, diameter, "name");
	AlphaAtom alpha = new AlphaAtom(100,100,diameter,"name");
	BetaAtom beta = new BetaAtom(100,100,diameter,"name");
	GammaAtom gamma = new GammaAtom(100,100,diameter,"name");
	public MainMenu() throws FileNotFoundException, IOException {
		
		addObjects();
		// TODO Auto-generated constructor stub
	}
	public void addObjects() throws FileNotFoundException, IOException {
		
		background.setBounds(0, 0, FRAME_WIDTH, 800);
		//sigma.setBounds(0,0,60,60); // has to change
		sigma.setSize(diameter,diameter);
		alpha.setSize(diameter,diameter);
		gamma.setSize(diameter,diameter);
		beta.setSize(diameter,diameter);
		sigma.setLocation(0,0);
		beta.setLocation(100,0);
		alpha.setLocation(200,0);
		gamma.setLocation(300,0);
		
		add(background, new Integer(0));
		add(sigma, new Integer(1));
		add(beta, new Integer(1));
		add(gamma, new Integer(1));
		add(alpha, new Integer(1));
		
		
	}
}
