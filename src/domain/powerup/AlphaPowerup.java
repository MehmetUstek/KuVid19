package domain.powerup;

public abstract class AlphaPowerup {
	String powerupType;
	public AlphaPowerup(String powerupType) {
		this.powerupType=powerupType;
	}
	
	public abstract void move();
	public abstract void shoot(double angle);
	public abstract void bounceFromWall();
}
