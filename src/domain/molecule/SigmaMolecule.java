package domain.molecule;

public abstract class SigmaMolecule {
	
	String moleculeType;
	String shape;
	int x,y;
	public SigmaMolecule(String moleculeType,String shape) {
		this.moleculeType= moleculeType;
		this.shape=shape;
	}
	public abstract void move();
	public abstract void collectMolecule();
	
}
