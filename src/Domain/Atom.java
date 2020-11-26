package Domain;

public abstract class Atom {
	String atomType;
	double movementAngle;
	int x,y;
	double speed;
	double diameter;
	
	public Atom(double movementAngle, double speed, double diameter,String atomType) {
		this.movementAngle= movementAngle;
		this.speed= speed;
		this.diameter= diameter;
		this.atomType= atomType;
	}
	public void move() {
		
	}
	public void shoot(double angle) {
		
	}
	public void bounceFromWall() {
		
	}
	
}
