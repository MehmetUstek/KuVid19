package domain.molecule;

import java.awt.Point;
import java.awt.Shape;
import java.io.FileNotFoundException;
import java.io.IOException;
import domain.atom.Atom;


public class BetaMolecule extends Molecule{

	public BetaMolecule(String movementType, int width, int height, Point point) throws IOException, FileNotFoundException {
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
	public String toString() {
		return "BetaMolecule [movementType=" + movementType + ", width=" + width + ", height=" + height + ", location="
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