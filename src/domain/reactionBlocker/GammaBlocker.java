package domain.reactionBlocker;

public abstract class GammaBlocker {
	String blockerType;
	double damage;
	double radius;
	
	public GammaBlocker(String blockerType) {
		this.blockerType=blockerType;
	}
	
	public abstract void move();
	public abstract void destroyMolecule();
	public abstract void hitThePlayer();

}
