package domain.reactionBlocker;

public abstract class SigmaBlocker {
	String blockerType;
	double damage;
	double radius;
	
	public SigmaBlocker(String blockerType) {
		this.blockerType=blockerType;
	}
	
	public abstract void move();
	public abstract void destroyMolecule();
	public abstract void hitThePlayer();

}
