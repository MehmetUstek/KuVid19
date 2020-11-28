package domain.powerup;

public abstract class GammaPowrerup {
	String powerupType;
	public GammaPowrerup(String powerupType) {
		this.powerupType=powerupType;
	}
	
	public abstract void move();
	public abstract void shoot(double angle);
	public abstract void bounceFromWall();
}
