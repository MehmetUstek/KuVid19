package domain.molecule;

import java.awt.Graphics;
import java.awt.Point;
import java.io.IOException;

import javax.swing.JPanel;

import domain.atom.Atom;


public abstract class Molecule{
	public double L; 
	public EnumMovement movementType;
	public int width;
	public int height;
	Point location;
	
	public Molecule(EnumMovement movementType, int width, int height, Point location) {
		this.movementType = movementType;
		this.width = width;
		this.height = height;
		this.location = location;
	}

	public abstract void collectMolecule();
	public abstract boolean isInDanger();
	public abstract boolean isIntersecting(Atom bullet);
	
	public EnumMovement getMovementType() {
		return movementType;
	}
	
	
}
