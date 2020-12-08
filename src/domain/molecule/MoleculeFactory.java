package domain.molecule;

import java.awt.Point;
import java.util.Random;

public class MoleculeFactory {
	private static int border = 530;
	
	private static Random random = new Random();
	
	public static Molecule getMolecule(String molecule) {
		int height = 50;
		int width = 50;
		Point location = null;
		Molecule mol = null;
		
		if(molecule.equals("Alpha")){
			mol = new AlphaMolecule(EnumMovement.Alpha, height, width, location);
			location.setLocation(random.nextInt(border), 0);
			return mol;
		}
		
		if(molecule.equals("Beta")){
			mol = new AlphaMolecule(EnumMovement.Beta, height, width, location);
			location.setLocation(random.nextInt(border), 0);
			return mol;
		}
		
		if(molecule.equals("Gamma")){
			mol = new AlphaMolecule(EnumMovement.Gamma, height, width, location);
			location.setLocation(random.nextInt(border), 0);
			return mol;
		}
		
		if(molecule.equals("Sigma")){
			mol = new AlphaMolecule(EnumMovement.Sigma, height, width, location);
			location.setLocation(random.nextInt(border), 0);
			return mol;
		}
		return null;
	}

}
