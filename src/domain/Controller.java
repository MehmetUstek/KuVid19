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
import ui.UIPowerup;
import ui.Renderer;
import ui.UIShooter;
import ui.molecule.UIMolecule;

public class Controller {
	
	private Renderer renderer;
	private ArrayList<Powerup> collectedPowerups = new ArrayList<Powerup>();
	private int score = 0, time = 0, counter = 0, lives = 3, initialMoleculeCount;
	private int alphaCount=0,betaCount=0,sigmaCount=0,gammaCount=0;
	private int alphaPUCount=0,betaPUCount=0,sigmaPUCount=0,gammaPUCount=0;
	private boolean atomFalled;
	public ArrayList<GameObject> objects = new ArrayList<GameObject>();
	Frame frame;
	
	public Controller(Renderer UI, Frame frame) {
		this.renderer = UI;
		this.frame = frame;
	}
	
	// Set the shooted object to be 0th in list.
	
	public void update() {
		// TODO Auto-generated method stub

		renderer.setScore(score);
		renderer.setLives(lives);
		
		for (int i = 0; i < objects.size(); i++) {
			GameObject tempobject = (GameObject) objects.get(i);
			renderer.objects.get(i).setX((int) tempobject.getX());
			renderer.objects.get(i).setY((int) tempobject.getY());
//			if(tempobject.getType()== "alpha" || tempobject.getType()== "beta" ...
			if (i==0) {
				if(tempobject.getType()=="alpha"|| tempobject.getType()=="beta"|| tempobject.getType()=="sigma"||
						tempobject.getType()=="gamma") {
					setAtomPositionsAndCheckCollision(tempobject);
				}else {
					setPowerupPositionsAndCheckCollision(tempobject);
				}
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
				UIShooter shooter = (UIShooter) renderer.objects.get(i);
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
	
	private void setAtomPositionsAndCheckCollision(GameObject tempobject) {
		Atom tempobject1 = (Atom) tempobject;
		UIAtom atom = (UIAtom) renderer.objects.get(0);
		double x = tempobject1.getX();
		double y =  tempobject1.getY();
		double x1= x + tempobject1.getDiameter();
		double y1= y+ tempobject1.getDiameter();
		if(tempobject1.isShooted()) {
			atom.setX(x);
			atom.setY(y);
		}else {
			// TODO this will change. Will be added, when atom is destroyed put new atom from existing ones.
			x=objects.get(1).getX();
			y=objects.get(1).getY();
			tempobject.setX(x);
			tempobject.setY(y);
			atom.setX(x);
			atom.setY(y);
		}
		
		if(tempobject1.getY()> Toolkit.getDefaultToolkit().getScreenSize().getHeight()+ tempobject1.getWidth()/2) {
//    		tempobject1.setX(x);
//    		tempobject1.setY(y);
//    		tempobject1.setShooted(false);
//    		atomFalled=true;
    	}
		
		tempobject = tempobject1;
		Rectangle2D r= new Rectangle2D.Double(x,y,tempobject1.getDiameter(),tempobject1.getDiameter());
		// Collision with alpha molecule and alpha atom.
		for (int j = 0; j < objects.size(); j++) {
			if(objects.size()==0) {
				break;
			}
			GameObject collisionObject = (GameObject) objects.get(j);
			renderer.objects.get(j).setX((int) collisionObject.getX());
			renderer.objects.get(j).setY((int) collisionObject.getY());
			if ((collisionObject.getId()== ID.AlphaMolecule && tempobject.getType()=="alpha") ||
					(collisionObject.getId()== ID.BetaMolecule && tempobject.getType()=="beta") ||
					(collisionObject.getId()== ID.SigmaMolecule && tempobject.getType()=="sigma") ||
					(collisionObject.getId()== ID.GammaMolecule && tempobject.getType()=="gamma")
					) {
				Molecule collisionObject1 = (Molecule) collisionObject;
				UIMolecule molecule = (UIMolecule) renderer.objects.get(j);
				double a = collisionObject1.getX();
				double b = collisionObject1.getY();
				Rectangle2D r1= new Rectangle2D.Double(a,b,collisionObject1.getHeight(),collisionObject1.getWidth());
				if(r1.intersects(r) || r.intersects(r1)) {
					System.out.println("Collision");
					objects.remove(collisionObject);
//					tempobject.setX(objects.get(1).getX());
//					tempobject.setY(objects.get(1).getY());
//					objects.remove(tempobject);
					
					renderer.removeObject(molecule);
//					uicontroller.removeObject(atom);
					
					tempobject.setX(objects.get(1).getX());
					tempobject.setY(objects.get(1).getY());
					((Atom) tempobject).setShooted(false);
					
//					uicontroller.addObject(atom);
				}
			}
			}
	}
	
	private void setPowerupPositionsAndCheckCollision(GameObject tempobject) {
		Powerup tempobject1 = (Powerup) tempobject;
		UIPowerup pu = (UIPowerup) renderer.objects.get(0);
		double x = tempobject1.getX();
		double y =  tempobject1.getY();
		double x1= x + tempobject1.getDiameter();
		double y1= y+ tempobject1.getDiameter();
		if(tempobject1.isShooted()) {
			pu.setX(x);
			pu.setY(y);
		}else {
			tempobject.setX(objects.get(1).getX());
			tempobject.setY(objects.get(1).getY());
			
		}
		//TODO There is problem after atom lands.
		if(tempobject1.getY()> Toolkit.getDefaultToolkit().getScreenSize().getHeight()+ tempobject1.getWidth()/2) {
//    		tempobject1.setX(x);
//    		tempobject1.setY(y);
//    		tempobject1.setShooted(false);
//    		atomFalled=true;
    	}
		
		tempobject = tempobject1;
		Rectangle2D r= new Rectangle2D.Double(x,y,tempobject1.getDiameter(),tempobject1.getDiameter());
		// Collision with alpha molecule and alpha atom.
		for (int j = 0; j < objects.size(); j++) {
			if(objects.size()==0) {
				break;
			}
			GameObject collisionObject = (GameObject) objects.get(j);
			renderer.objects.get(j).setX((int) collisionObject.getX());
			renderer.objects.get(j).setY((int) collisionObject.getY());
			if ((collisionObject.getId()== ID.AlphaMolecule && tempobject.getType()=="alpha") ||
					(collisionObject.getId()== ID.BetaMolecule && tempobject.getType()=="beta") ||
					(collisionObject.getId()== ID.SigmaMolecule && tempobject.getType()=="sigma") ||
					(collisionObject.getId()== ID.GammaMolecule && tempobject.getType()=="gamma")
					) {
				Molecule collisionObject1 = (Molecule) collisionObject;
				UIMolecule molecule = (UIMolecule) renderer.objects.get(j);
				double a = collisionObject1.getX();
				double b = collisionObject1.getY();
				Rectangle2D r1= new Rectangle2D.Double(a,b,collisionObject1.getHeight(),collisionObject1.getWidth());
				if(r1.intersects(r) || r.intersects(r1)) {
					System.out.println("Collision");
					objects.remove(collisionObject);
//					tempobject.setX(objects.get(1).getX());
//					tempobject.setY(objects.get(1).getY());
//					objects.remove(tempobject);
					
					renderer.removeObject(molecule);
//					uicontroller.removeObject(atom);
					
					tempobject.setX(objects.get(1).getX());
					tempobject.setY(objects.get(1).getY());
					((Powerup) tempobject).setShooted(false);
//					uicontroller.addObject(atom);
				}
			}
			}
	}
}
