package domain;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;

import domain.atom.AlphaAtom;
import domain.atom.Atom;
import domain.molecule.Molecule;
import domain.powerup.Powerup;
import ui.Frame;
import ui.UIAtom;
import ui.UIController;

public class Controller {
	//This class will handle all the UI actions.
	// It will handle every user actions such that,
	// shooting of atom, using blender etc. This class may also contain the handling of the collisions using collision handler class.
	Object object;
	KeyEvent event;
	private UIController uicontroller;
	private ArrayList<Powerup> collectedPowerups = new ArrayList<Powerup>();
	private int score = 0, time = 0, counter = 0, lives = 3, initialMoleculeCount;
	
	public LinkedList<GameObject> objects = new LinkedList<GameObject>();
	Frame frame;
	
	public Controller(UIController UI, Frame frame) {
		this.uicontroller = UI;
		this.frame = frame;
	}
	
	public void update() {
		// TODO Auto-generated method stub
		uicontroller.setScore(score);
		uicontroller.setLives(lives);

		for (int i = 0; i < objects.size(); i++) {
			GameObject tempobject = (GameObject) objects.get(i);
			uicontroller.objects.get(i).setX((int) tempobject.getX());
			uicontroller.objects.get(i).setY((int) tempobject.getY());
			
			if (tempobject.getId() == ID.AlphaAtom) {
				UIAtom ball = (UIAtom) uicontroller.objects.get(i);
				int xs1 = (int) tempobject.getX();
				int ys1 = (int) tempobject.getY();
				ball.setLocation(xs1,ys1);
				AlphaAtom alphaAtom = (AlphaAtom) tempobject;
				uicontroller.addObject(ball);
				
				
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
		LinkedList<Molecule> allBricks = new LinkedList<Molecule>();
		for (int i = 0; i < objects.size(); i++) {
			GameObject tempobject = (GameObject) objects.get(i);
			if (tempobject.getId() == ID.AlphaMolecule || tempobject.getId() == ID.BetaMolecule
					|| tempobject.getId() == ID.SigmaMolecule || tempobject.getId() == ID.GammaMolecule) {

				allBricks.add((Molecule) tempobject);
			}
		}
		return allBricks;
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

	/**
	 * REQUIRES: obj != null, obj should exist in the list. MODIFIES: objects
	 * EFFECTS: Removes a game object from the objects field list.
	 * 
	 * @param obj Game Object (Paddle, Brick, Powerups, etc.)
	 */
	public void removeObject(GameObject obj) {
		this.objects.remove(obj);
	}
	
	
}
