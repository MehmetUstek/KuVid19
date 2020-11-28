package domain.shooter;

import domain.atom.Atom;
import domain.powerup.Powerup;

public class AtomShooter {

	Object shootingObjectType;

	int health;
	double width;
	double height;
	double angle;
	double speed;
	Atom currentAtom;
	Powerup currentPU;
	
	public AtomShooter(int health, double speed, double rotationAngle,double width,double height, Object shootingObjectType) {
		this.angle=rotationAngle;
		this.speed= speed;
		this.health= health;
		this.width=width;
		this.height=height;
		this.shootingObjectType= shootingObjectType;
	}

	public Object getShootingObjectType() {
		return shootingObjectType;
	}

	public void setShootingObjectType(Object shootingObjectType) {
		this.shootingObjectType = shootingObjectType;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
}
