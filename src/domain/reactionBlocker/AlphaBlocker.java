package domain.reactionBlocker;

public abstract class AlphaBlocker {
	String blockerType;
	double damage;
	double radius;
	
	public AlphaBlocker(String blockerType) {
		this.blockerType=blockerType;
	}
	
	public abstract void move();
	public abstract void destroyMolecule();
	public abstract void hitThePlayer();

}
