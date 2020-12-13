package domain.molecule;

public class MoleculeFactory {
	
	public static Molecule getMolecule(String molecule) {
		Molecule mol = null;
		
		if(molecule.equals("Alpha")){
			mol = new AlphaMolecule();
			return mol;
		}
		
		if(molecule.equals("Beta")){
			mol = new AlphaMolecule();
			return mol;
		}
		
		if(molecule.equals("Gamma")){
			mol = new AlphaMolecule();
			return mol;
		}
		
		if(molecule.equals("Sigma")){
			mol = new AlphaMolecule();
			return mol;
		}
		return null;
	}

}
