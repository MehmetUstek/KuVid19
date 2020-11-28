package domain.powerup;

public abstract class SigmaPowerup {
	String powerupType;
	public SigmaPowerup(String powerupType) {
		this.powerupType=powerupType;
	}
	
	public abstract void move();
	public abstract void shoot(double angle);
	public abstract void bounceFromWall();
}
