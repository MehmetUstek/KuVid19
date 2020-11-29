package domain.powerup;

public abstract class Powerup {
	String powerupType;
	double speed;
	double diameter;
	public Powerup(String powerupType,double speed, double diameter) {
		this.powerupType=powerupType;
	}
	
	public abstract void move();
	public abstract void shoot(double angle);
	public abstract void bounceFromWall();
}
