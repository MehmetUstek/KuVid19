package domain;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;

import domain.atom.Atom;
import domain.molecule.Molecule;
import domain.powerup.Powerup;
import ui.Frame;
import ui.UIAtom;
import ui.UIController;
import ui.UIShooter;

public class Controller {
	
	private UIController uicontroller;
	private ArrayList<Powerup> collectedPowerups = new ArrayList<Powerup>();
	private int score = 0, time = 0, counter = 0, lives = 3, initialMoleculeCount;
	private boolean atomFalled;
	public LinkedList<GameObject> objects = new LinkedList<GameObject>();
	Frame frame;
	
	public Controller(UIController UI, Frame frame) {
		this.uicontroller = UI;
		this.frame = frame;
	}
	
	public void update() {
		// TODO Auto-generated method stub
//		if(atomFalled) {
//			--lives;
//			atomFalled=false;
//		}
		uicontroller.setScore(score);
		uicontroller.setLives(lives);
		
		for (int i = 0; i < objects.size(); i++) {
			GameObject tempobject = (GameObject) objects.get(i);
			uicontroller.objects.get(i).setX((int) tempobject.getX());
			uicontroller.objects.get(i).setY((int) tempobject.getY());
			
			if (tempobject.getType() == "alpha") {
				Atom tempobject1 = (Atom) tempobject;
				UIAtom atom = (UIAtom) uicontroller.objects.get(i);
				int x = (int) tempobject1.getX();
				int y = (int) tempobject1.getY();
				atom.setX(x);
				atom.setY(y);
				if(tempobject1.getY()> Toolkit.getDefaultToolkit().getScreenSize().getHeight()+ tempobject1.getWidth()/2) {
		    		tempobject1.setX(x);
		    		tempobject1.setY(y);
		    		tempobject1.setShooted(false);
		    		atomFalled=true;
		    	}
				
//				tempobject = tempobject1;
//				ball.setBounds(ball.getX(),ball.getY(),ball.getX()+ball.getWidth(),ball.getY()+ball.getHeight());
//				ball.setLocation(x, y);
//				System.out.println(ball.getX());
//				System.out.println("Y:");
//				System.out.println(ball.getY());
				
//				Atom atom =  (Atom) tempobject;
				}
			if (tempobject.getType() == "beta") {
				UIAtom atom = (UIAtom) uicontroller.objects.get(i);
				int x = (int) tempobject.getX();
				int y = (int) tempobject.getY();
				atom.setX(x);
				atom.setY(y);
				}
			if (tempobject.getType() == "sigma") {
				UIAtom atom = (UIAtom) uicontroller.objects.get(i);
				int x = (int) tempobject.getX();
				int y = (int) tempobject.getY();
				atom.setX(x);
				atom.setY(y);
				}
			if (tempobject.getType() == "gamma") {
				UIAtom atom = (UIAtom) uicontroller.objects.get(i);
				int x = (int) tempobject.getX();
				int y = (int) tempobject.getY();
				atom.setX(x);
				atom.setY(y);
				}
			if (tempobject.getType() == "shooter") {
				UIShooter shooter = (UIShooter) uicontroller.objects.get(i);
				int x = (int) tempobject.getX();
				int y = (int) tempobject.getY();
				double rotation = tempobject.getRotationAngle();
				shooter.setX(x);
				shooter.setY(y);
				shooter.setRotationAngle(rotation);
				
				}
//			if (tempobject.getType() == "alphaMol") {
//				UIShooter shooter = (UIShooter) uicontroller.objects.get(i);
//				int x = (int) tempobject.getX();
//				int y = (int) tempobject.getY();
//				double rotation = tempobject.getRotationAngle();
//				shooter.setX(x);
//				shooter.setY(y);
//				shooter.setRotationAngle(rotation);
//				
//				}
		
			tempobject.update();
		}
		
	}
	public Frame getFrame() {
		return frame;
	}
	public void setFrame(Frame frame) {
		this.frame = frame;
	}
	public LinkedList<Molecule> getMolecules() {
		LinkedList<Molecule> allMolecules = new LinkedList<Molecule>();
//		for (int i = 0; i < objects.size(); i++) {
//			GameObject tempobject = (GameObject) objects.get(i);
//			if (tempobject.getId() == ID.AlphaMolecule || tempobject.getId() == ID.BetaMolecule
//					|| tempobject.getId() == ID.SigmaMolecule || tempobject.getId() == ID.GammaMolecule) {
//
//				allMolecules.add((Molecule) tempobject);
//			}
//		}
		return allMolecules;
	}
	public int getInitialMoleculeCount() {
		return initialMoleculeCount;
	}
	public void setInitialMoleculeCount(int initialMoleculeCount) {
		this.initialMoleculeCount = initialMoleculeCount;
	}
	public void addObject(GameObject obj) {
		this.objects.add(obj);
	}

	public void removeObject(GameObject obj) {
		this.objects.remove(obj);
	}
	
	public GameObject getObject(String obj) {
		int i=0;
		for(GameObject tempObject: this.objects) {
			i++;
			if(tempObject.getType()== obj) {
				return tempObject;
			}
		}
		return null;
	}
	public void updateLives() {
		lives--;
	}
	
}
