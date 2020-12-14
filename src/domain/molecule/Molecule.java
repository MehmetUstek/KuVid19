package domain.molecule;

import domain.GameObject;
import domain.atom.Atom;


public abstract class Molecule extends GameObject implements MovementStrategy{
	
	public static double L=100;

	public double width;
	public double height;
	
	public Molecule() {
	}
	
	public double getWidth() {
		return width;
	}


	public void setWidth(double width) {
		this.width = width;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public abstract void collectMolecule();
	public abstract boolean isInDanger();
	public abstract boolean isIntersecting(Atom bullet);
}
