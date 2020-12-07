package domain;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import domain.atom.AlphaAtom;
import domain.atom.Atom;
import domain.utility.Point;

public class Controller {
	//This class will handle all the UI actions.
	// It will handle every user actions such that,
	// shooting of atom, using blender etc. This class may also contain the handling of the collisions using collision handler class.
	Object object;
	KeyEvent event;
	public Controller() {
		// TODO Auto-generated constructor stub
//		this.object=object;
//		this.event=event;
		// if shooted atom, then call atom's move function.
		
	
		
	}
	public Point shootAtom(Atom object) {
		return object.move(object.getP(), object.getSpeed(), object.getMovementAngle());
	}
	
}
