package domain.reactionBlocker;

public abstract class ReactionBlocker {
	String blockerType;
	double damage;
	double radius;
	
	public ReactionBlocker(String blockerType) {
		this.blockerType=blockerType;
	}
	
	public abstract void move();
	public abstract void destroyMolecule();
	public abstract void hitThePlayer();

}
