package domain.shield;

import domain.GameObject;
import domain.atom.Atom;

public abstract class ShieldDecorator extends Atom{
	
	public ShieldDecorator(String atomType) {
		super(atomType);
		// TODO Auto-generated constructor stub
	}
	public abstract void changeSpeed();
	public abstract double getEfficiency();
}
