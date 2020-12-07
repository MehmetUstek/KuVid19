package ui;

import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JLayeredPane;

import domain.atom.*;
import domain.shooter.AtomShooter;

public class KuVidGameplay extends JLayeredPane {
	// This class will handle creating the all the frame instances including background, atoms, molecules etc.
	// This class will be a persistent storage.
	
	final int health=100;
	final int speed=20;
	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 800;
	final static int L=FRAME_HEIGHT/10;
	final static int diameter= L;
	Background background= new Background(FRAME_WIDTH,FRAME_HEIGHT);
	SigmaAtom sigma=new SigmaAtom(0,0,100, 100, diameter, "name");
	AlphaAtom alpha = new AlphaAtom(0,0,100,100,diameter,"name");
	BetaAtom beta = new BetaAtom(0,0,100,100,diameter,"name");
	GammaAtom gamma = new GammaAtom(0,0,100,100,diameter,"name");
	AtomShooter shooter= new AtomShooter(0,0,health,speed,0.0,L/2,L*2,new Object());
	public KuVidGameplay() throws FileNotFoundException, IOException {
		
		createObjects();
		// TODO Auto-generated constructor stub
	}
	public void createObjects() throws FileNotFoundException, IOException {
		
		background.setBounds(0, 0, background.getWidth(), background.getHeight());
		//sigma.setBounds(0,0,60,60); // has to change
		sigma.setSize(diameter,diameter);
		alpha.setSize(diameter,diameter);
		gamma.setSize(diameter,diameter);
		beta.setSize(diameter,diameter);
		shooter.setSize(shooter.getWidth(),shooter.getHeight());
		sigma.setLocation(0,0);
		beta.setLocation(100,0);
		alpha.setLocation(200,0);
		gamma.setLocation(300,0);
		shooter.setLocation(background.getWidth()/2-shooter.getWidth()/2, background.getHeight()-shooter.getHeight());
		System.out.println(shooter.getLocation());
		System.out.println(shooter.getHeight());
		System.out.println(shooter.getWidth());
		add(background, new Integer(0));
		add(sigma, new Integer(1));
		add(beta, new Integer(1));
		add(gamma, new Integer(1));
		add(alpha, new Integer(1));
		add(shooter,new Integer(1));
		
		
	}
}
