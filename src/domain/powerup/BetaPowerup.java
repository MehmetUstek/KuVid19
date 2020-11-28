package domain.powerup;

public abstract class BetaPowerup {
	String powerupType;
	public BetaPowerup(String powerupType) {
		this.powerupType=powerupType;
	}
	
	public abstract void move();
	public abstract void shoot(double angle);
	public abstract void bounceFromWall();
}
