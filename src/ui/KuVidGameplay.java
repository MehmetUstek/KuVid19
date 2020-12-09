package ui;

import java.awt.Color;
import domain.molecule.MoleculeFactory;
import java.awt.Font;
import java.awt.Point;
import domain.utility.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JLayeredPane;

import domain.atom.*;
import domain.molecule.EnumMovement;
import ui.molecule.*;
import domain.shooter.AtomShooter;

public class KuVidGameplay extends JLayeredPane {
	// This class will handle creating the all the frame instances including background, atoms, molecules etc.
	// This class will be a persistent storage.
	private static Random random = new Random();
	private static List<ui.molecule.Molecule> moleculeList = new ArrayList<ui.molecule.Molecule>();
	final static int L=200;
	final static int diameter= L/10;
	final int health=100;
	final int speed=2;
	private static final int FRAME_WIDTH = 600;
	Background background = new Background(FRAME_WIDTH,FRAME_WIDTH );
	Molecule alphaMol = new AlphaMoleculeUI(EnumMovement.Alpha, L/4, L/4, new Point(300, 0));
	Molecule betaMol = new BetaMoleculeUI(EnumMovement.Beta, L/4, L/4, new Point(340, 0));
	Molecule sigmaMol = new SigmaMoleculeUI(EnumMovement.Sigma, L/4, L/4, new Point(380, 0));
	Molecule gammaMol = new GammaMoleculeUI(EnumMovement.Gamma, L/4, L/4, new Point(420,0));
	UIAtom atom;
	public KuVidGameplay() throws FileNotFoundException, IOException {
		
		createObjects();
//		moveMol(betaMol);
		moveMol(alphaMol);
//		moveMol(sigmaMol);
//		moveMol(gammaMol);
//		moveAtom(atom);
		// TODO Auto-generated constructor stub
	}
	public void createObjects() throws FileNotFoundException, IOException {
		
//		atom = new UIAtom("sigma", diameter,new UtilPoint(200,200));
		background.setBounds(0, 0, FRAME_WIDTH, FRAME_WIDTH);
		//sigma.setBounds(0,0,60,60); // has to change
		
//		atom.setSize(diameter,diameter);
		
		alphaMol.setSize(L/4, L/4);
		betaMol.setSize(L/4, L/4);
		sigmaMol.setSize(L/4, L/4);
		gammaMol.setSize(L/4, L/4);
		
		
//		atom.setLocation(60,100);
		alphaMol.setLocation(200,0);
		betaMol.setLocation(270,0);
		sigmaMol.setLocation(340,0);
		gammaMol.setLocation(530,0);
		
		
		add(background, new Integer(0));
		add(alphaMol, new Integer(1));
		add(betaMol, new Integer(1));
		add(sigmaMol, new Integer(1));
		add(gammaMol, new Integer(1));
		
//		add(atom, new Integer(1));
//		atom.move(new Point(100,200),speed,30);
	}

	public void createMolecules() {
		for (int i = 0; i < 20; i++) {
			int temp = random.nextInt(3);

			switch (temp) {
			case 0:
				MoleculeFactory.getMolecule("Alpha");
			case 1:
				MoleculeFactory.getMolecule("Beta");
			case 2:
				MoleculeFactory.getMolecule("Sigma");
			case 3:
				MoleculeFactory.getMolecule("Gamma");
			}
		}
	}
	public void moveAtom(UIAtom atom) {
//		t1 = new Thread() {
//			public void run() {
//				while (atom.getX() < 700) {
//					atom.move(atom.getLocation(),speed,1);
//					try {
//						sleep(500);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//				atom.setVisible(false);
//			}
//		};
//		t1.start();
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
