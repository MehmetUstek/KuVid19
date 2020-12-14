package domain;

import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.LinkedList;

import domain.atom.Atom;
import domain.molecule.AlphaMolecule;
import domain.molecule.Molecule;
import domain.powerup.Powerup;
import ui.Frame;
import ui.UIAtom;
import ui.Renderer;
import ui.UIShooter;
import ui.molecule.UIMolecule;

public class Controller {
	
	private Renderer uicontroller;
	private ArrayList<Powerup> collectedPowerups = new ArrayList<Powerup>();
	private int score = 0, time = 0, counter = 0, lives = 3, initialMoleculeCount;
	private boolean atomFalled;
	public LinkedList<GameObject> objects = new LinkedList<GameObject>();
	Frame frame;
	
	public Controller(Renderer UI, Frame frame) {
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
			
			if (tempobject.getType() == "alpha" || tempobject.getType() == "beta" ||
					tempobject.getType() == "sigma" || tempobject.getType() == "gamma") {
				setAtomPositionsAndCheckCollision(tempobject,i);
//				Atom tempobject1 = (Atom) tempobject;
//				UIAtom atom = (UIAtom) uicontroller.objects.get(i);
//				double x = tempobject1.getX();
//				double y =  tempobject1.getY();
//				double x1= x + tempobject1.getDiameter();
//				double y1= y+ tempobject1.getDiameter();
//				atom.setX(x);
//				atom.setY(y);
//				
//				if(tempobject1.getY()> Toolkit.getDefaultToolkit().getScreenSize().getHeight()+ tempobject1.getWidth()/2) {
//		    		tempobject1.setX(x);
//		    		tempobject1.setY(y);
//		    		tempobject1.setShooted(false);
//		    		atomFalled=true;
//		    	}
//				
//				tempobject = tempobject1;
//				Rectangle2D r= new Rectangle2D.Double(x,y,tempobject1.getDiameter(),tempobject1.getDiameter());
//				// Collision with alpha molecule and alpha atom.
//				for (int j = 0; j < objects.size(); j++) {
//					GameObject collisionObject = (GameObject) objects.get(j);
//					uicontroller.objects.get(j).setX((int) collisionObject.getX());
//					uicontroller.objects.get(j).setY((int) collisionObject.getY());
////					System.out.println(collisionObject);
//					if (collisionObject.getId()== ID.AlphaMolecule) {
//						AlphaMolecule collisionObject1 = (AlphaMolecule) collisionObject;
//						UIMolecule molecule = (UIMolecule) uicontroller.objects.get(j);
//						double a = collisionObject1.getX();
//						double b = collisionObject1.getY();
////						double a1 =a+ collisionObject.getWidth();
////						double b1 =b+ collisionObject.getHeight();
//						Rectangle2D r1= new Rectangle2D.Double(a,b,collisionObject1.getHeight(),collisionObject1.getWidth());
//						if(r1.intersects(r) || r.intersects(r1)) {
//							System.out.println("Collision");
//							objects.remove(collisionObject);
//							objects.remove(tempobject);
//							uicontroller.removeObject(molecule);
//							uicontroller.removeObject(atom);
//							
//						}
//					}
//					}
				}
//			if (tempobject.getType() == "beta") {
//				UIAtom atom = (UIAtom) uicontroller.objects.get(i);
//				int x = (int) tempobject.getX();
//				int y = (int) tempobject.getY();
//				atom.setX(x);
//				atom.setY(y);
//				}
//			if (tempobject.getType() == "sigma") {
//				UIAtom atom = (UIAtom) uicontroller.objects.get(i);
//				int x = (int) tempobject.getX();
//				int y = (int) tempobject.getY();
//				atom.setX(x);
//				atom.setY(y);
//				}
//			if (tempobject.getType() == "gamma") {
//				UIAtom atom = (UIAtom) uicontroller.objects.get(i);
//				int x = (int) tempobject.getX();
//				int y = (int) tempobject.getY();
//				atom.setX(x);
//				atom.setY(y);
//				}
			if (tempobject.getType() == "shooter") {
				UIShooter shooter = (UIShooter) uicontroller.objects.get(i);
				int x = (int) tempobject.getX();
				int y = (int) tempobject.getY();
				double rotation = tempobject.getRotationAngle();
				shooter.setX(x);
				shooter.setY(y);
				shooter.setRotationAngle(rotation);
				
				}
			if (tempobject.getId()==ID.AlphaMolecule) {
				
				}
		
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
	public boolean intersects(Rectangle2D r, Rectangle2D r1) {
		if(r.intersects(r1)) {
			return true;
		}
		return false;
	}
	
	private void setAtomPositionsAndCheckCollision(GameObject tempobject,int i) {
		Atom tempobject1 = (Atom) tempobject;
		UIAtom atom = (UIAtom) uicontroller.objects.get(i);
		double x = tempobject1.getX();
		double y =  tempobject1.getY();
		double x1= x + tempobject1.getDiameter();
		double y1= y+ tempobject1.getDiameter();
		atom.setX(x);
		atom.setY(y);
		
		if(tempobject1.getY()> Toolkit.getDefaultToolkit().getScreenSize().getHeight()+ tempobject1.getWidth()/2) {
    		tempobject1.setX(x);
    		tempobject1.setY(y);
    		tempobject1.setShooted(false);
    		atomFalled=true;
    	}
		
		tempobject = tempobject1;
		Rectangle2D r= new Rectangle2D.Double(x,y,tempobject1.getDiameter(),tempobject1.getDiameter());
		// Collision with alpha molecule and alpha atom.
		for (int j = 0; j < objects.size(); j++) {
			GameObject collisionObject = (GameObject) objects.get(j);
			uicontroller.objects.get(j).setX((int) collisionObject.getX());
			uicontroller.objects.get(j).setY((int) collisionObject.getY());
			if ((collisionObject.getId()== ID.AlphaMolecule && tempobject.getType()=="alpha") ||
					(collisionObject.getId()== ID.BetaMolecule && tempobject.getType()=="beta") ||
					(collisionObject.getId()== ID.SigmaMolecule && tempobject.getType()=="sigma") ||
					(collisionObject.getId()== ID.GammaMolecule && tempobject.getType()=="gamma")
					) {
				Molecule collisionObject1 = (Molecule) collisionObject;
				UIMolecule molecule = (UIMolecule) uicontroller.objects.get(j);
				double a = collisionObject1.getX();
				double b = collisionObject1.getY();
				Rectangle2D r1= new Rectangle2D.Double(a,b,collisionObject1.getHeight(),collisionObject1.getWidth());
				if(r1.intersects(r) || r.intersects(r1)) {
					System.out.println("Collision");
					objects.remove(collisionObject);
					objects.remove(tempobject);
					uicontroller.removeObject(molecule);
					uicontroller.removeObject(atom);
					
				}
			}
			}
	}
}
