package domain.molecule;

import java.awt.Point;
import java.awt.Shape;

import domain.atom.Atom;


public class SigmaMolecule extends Molecule{
	
	public SigmaMolecule(EnumMovement movementType, int width, int height, Point point){
		super(movementType, width, height, point);
	}

	@Override
	public void collectMolecule() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isInDanger() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isIntersecting(Atom bullet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Shape getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
	
}