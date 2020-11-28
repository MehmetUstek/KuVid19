package domain.molecule;

public abstract class Molecule {
	
	String moleculeType;
	String shape;
	int x,y;
	public Molecule(String moleculeType,String shape) {
		this.moleculeType= moleculeType;
		this.shape=shape;
	}
	public abstract void move();
	public abstract void collectMolecule();
	
}
