package Domain;

public abstract class Atom {
	String atomType;
	double movementAngle;
	double speed;
	double diameter;
	
	public Atom(double movementAngle, double speed, double diameter,String atomType) {
		this.movementAngle= movementAngle;
		this.speed= speed;
		this.diameter= diameter;
		this.atomType= atomType;
	}
	public abstract void move();
	public abstract void shoot(double angle); //
	public abstract void bounceFromWall(double angle); //Change the direction 90 degrees.
	public abstract void destroy(); //Delete the atom's instance.
	@Override
	public String toString() {
		return "Atom [atomType=" + atomType + ", movementAngle=" + movementAngle + "speed="
				+ speed + ", diameter=" + diameter + "]";
	}
}
