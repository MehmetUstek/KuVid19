package domain;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;

import domain.atom.AlphaAtom;
import domain.atom.Atom;
import domain.powerup.Powerup;
import domain.utility.Point;
import ui.Frame;
import ui.UIController;

public class Controller {
	//This class will handle all the UI actions.
	// It will handle every user actions such that,
	// shooting of atom, using blender etc. This class may also contain the handling of the collisions using collision handler class.
	Object object;
	KeyEvent event;
	private UIController uicontroller;
	private ArrayList<Powerup> collectedPowerups = new ArrayList<Powerup>();
	private int score = 0, time = 0, counter = 0, lives = 3;
	public LinkedList<GameObject> objects = new LinkedList<GameObject>();
	Frame frame;
	public Controller(UIController UI, Frame frame) {
		this.uicontroller = UI;
		this.frame = frame;
	}
	public Point shootAtom(Atom object) {
		return object.move(object.getP(), object.getSpeed(), object.getMovementAngle());
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
				AlphaAtom ball = (AlphaAtom) tempobject;
				
			}
		}
	}
	
}
