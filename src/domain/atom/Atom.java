package domain.atom;

import domain.GameObject;

public class Atom extends GameObject{
	String atomType;
	double rotationAngle;
	double speed;
	double diameter;
	double x,y;
	boolean isShooted;
	
	public Atom(String atomType){
		super();
		this.x=getX();
		this.y=getY();
		this.rotationAngle= getRotationAngle();
		this.speed= getSpeed();
		this.diameter= getDiameter();
		this.atomType= atomType;
	}

	public boolean isShooted() {
		return isShooted;
	}
	public void setShooted(boolean isShooted) {
		this.isShooted = isShooted;
	}
	@Override
	public String toString() {
		return "Atom [atomType=" + atomType + ", movementAngle=" + rotationAngle + "speed="
				+ speed + ", diameter=" + diameter + "]";
	}

	public double getDiameter() {
		return diameter;
	}
	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}
	
	
	public String getType() {
		return atomType;
	}
	public void setType(String atomType) {
		this.atomType = atomType;
	}
	public double getRotationAngle() {
		return rotationAngle;
	}
	public void setRotationAngle(double rotationAngle) {
		this.rotationAngle = rotationAngle;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public void move(double x, double y,double velX, double velY) {
//		double radian = Math.toRadians(getRotationAngle());
//		System.out.println(getRotationAngle());
//		double newX=  x+ (speed * Math.sin(radian));
//		double newY=  y +(speed * -Math.cos(radian));
		double newX=  x+velX;
		double newY=  y +velY;
		setX(newX);
		setY(newY);
		
		 
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
//	public void bounceBack(int x, int y,double speed, double movementangle) {
//		move(x,y,speed);
//	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
