package domain.molecule;

public abstract class BetaMolecule {
	
	String moleculeType;
	String shape;
	int x,y;
	public BetaMolecule(String moleculeType,String shape) {
		this.moleculeType= moleculeType;
		this.shape=shape;
	}
	public abstract void move();
	public abstract void collectMolecule();
	
}
