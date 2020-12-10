package domain.molecule;
import java.awt.Point;
import java.awt.Shape;

import domain.atom.Atom;

public class AlphaMolecule extends Molecule{
	
	public AlphaMolecule(String movementType, int width, int height, Point location){
		super(movementType, width, height, location);
	}

	@Override
	public void collectMolecule() {
		// TODO Auto-generated method stub	
	}
	
	@Override
	public boolean isInDanger() {
		return false;
	}

	@Override
	public boolean isIntersecting(Atom bullet) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String toString() {
		return "AlphaMolecule [movementType=" + movementType + ", width=" + width + ", height=" + height + ", location="
				+ location + "]";
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
