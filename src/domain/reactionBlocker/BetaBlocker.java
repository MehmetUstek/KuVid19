package domain.reactionBlocker;

public abstract class BetaBlocker {
	String blockerType;
	double damage;
	double radius;
	
	public BetaBlocker(String blockerType) {
		this.blockerType=blockerType;
	}
	
	public abstract void move();
	public abstract void destroyMolecule();
	public abstract void hitThePlayer();

}
