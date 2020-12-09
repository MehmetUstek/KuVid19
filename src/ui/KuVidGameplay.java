package ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JLayeredPane;

import domain.Controller;
import domain.atom.*;
import ui.molecule.Molecule;
import domain.shooter.AtomShooter;

public class KuVidGameplay extends Canvas {
	// This class will handle creating the all the frame instances including background, atoms, molecules etc.
	// This class will be a persistent storage.
	int width;
	int height;
	int health;
	int speed;
	int L;
	int diameter;
	Background background;
	SigmaAtom sigma;
	AlphaAtom alpha;
	BetaAtom beta;
	GammaAtom gamma;
	AtomShooter shooter;
	UIController controller;
	AlphaAtom alphatest;
	
	public KuVidGameplay(int width,int height) throws FileNotFoundException, IOException {
		this.width= width;
		this.height= height;
		createObjects();
		
//		moveMol(betaMol);
//		moveMol(alphaMol);
//		moveMol(sigmaMol);
//		moveMol(gammaMol);
		
		// TODO Auto-generated constructor stub
	}
	public void createObjects() throws FileNotFoundException, IOException {
		health=100;
		speed=L;
		L= width/10;
		diameter=L;
		background= new Background(width,height);
		controller = new UIController();
		
		UIAtom atom = new UIAtom("sigma", diameter, 50,60);
		
		controller.addObject(atom);
		
//		
//		background.setBounds(0, 0, background.getWidth(), background.getHeight());
//		sigma.setSize(diameter,diameter);
//		alpha.setSize(diameter,diameter);
//		gamma.setSize(diameter,diameter);
//		beta.setSize(diameter,diameter);
//		System.out.println(shooter.getHeight());
//		shooter.setSize(shooter.getWidth(),shooter.getHeight());
//		sigma.setLocation(0,0);
//		beta.setLocation(100,0);
//		
//		gamma.setLocation(300,0);
//		shooter.setLocation(background.getWidth()/2-shooter.getWidth()/2, background.getHeight()- shooter.getHeight());
//		Point shooterPosition = new Point(background.getWidth()/2-shooter.getWidth()/2, background.getHeight()- shooter.getHeight());
//		shooter.setP(shooterPosition);
//		alpha.setP( new Point(shooter.getP().getX(), shooter.getP().getY()-alpha.getHeight()));
//		alpha.setLocation(alpha.getP().getX(),alpha.getP().getY());
//		add(background, new Integer(0));
//		add(sigma, new Integer(1));
//		add(beta, new Integer(1));
//		add(gamma, new Integer(1));
//		add(alpha, new Integer(1));
//		add(shooter,new Integer(1));
//		
//		//System.out.println(alpha.getLocation());
//		AlphaAtom alpha2 = new AlphaAtom(p,45.0,20,diameter,"name");
//		System.out.println(p.getX());
//		System.out.println(p.getY());
//		System.out.println(alpha2.move(p,20,45));
//		alphatest = new AlphaAtom(p,100,speed,diameter,"name");
//		add(alphatest, new Integer(1));

	}
	public void moveMol(Molecule mol) {
		Thread t1 = new Thread() {
			public void run() {
				while (mol.getLocation().y < 700) {
					mol.move();
					try {
						sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				mol.setVisible(false);
			}
		};
		t1.start();
	}
	
}
