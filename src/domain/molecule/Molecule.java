package domain.molecule;

import domain.GameObject;
import domain.atom.Atom;


public abstract class Molecule extends GameObject implements MovementStrategy{
	
	@Override
	public void move(double speed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getSpeed() {
		// TODO Auto-generated method stub
		return super.getSpeed();
	}
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


	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return super.getType();
	}

	public abstract void collectMolecule();
	public abstract boolean isInDanger();
	public abstract boolean isIntersecting(Atom bullet);
}
