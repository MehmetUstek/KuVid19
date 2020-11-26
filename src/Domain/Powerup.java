package Domain;

public abstract class Powerup {
	String powerupType;
	public Powerup(String powerupType) {
		this.powerupType=powerupType;
	}
	
	public abstract void move();
	public abstract void shoot(double angle);
	public abstract void bounceFromWall();
}
