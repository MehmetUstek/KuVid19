package Shooter;

import Domain.Atom;
import Domain.Powerup;

public abstract class AtomShooter {

	Object shootingObjectType;

	int health;

	double angle;

	Atom currentAtom;
	Powerup currenPU;

	public abstract double getTheAngle();

	public abstract void getSelectedObject();
	
	public AtomShooter(int health, double angle, Object shootingObjectType) {
		this.angle=angle;
		this.health= health;
		this.shootingObjectType= shootingObjectType;
	}
}
