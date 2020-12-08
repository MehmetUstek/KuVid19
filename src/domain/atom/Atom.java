package domain.atom;

import java.awt.Graphics;

import domain.GameObject;
import domain.utility.Point;

public abstract class Atom extends GameObject{
	Point p;
	String atomType;
	double movementAngle;
	double speed;
	int diameter;
	
	public Atom(Point p,double movementAngle, int speed, int diameter,String atomType) {
		this.p=p;
		this.movementAngle= movementAngle;
		this.speed= speed;
		this.diameter= diameter;
		this.atomType= atomType;
	}
	public abstract void move(); // Move the atom in its class given x,y locations and speed and diameter, such that it will return new values of x,y.
	public abstract void shoot(double angle); //
	public abstract void bounceBack(double angle); //Change the direction 90 degrees.
	public abstract void destroy(); //Delete the atom's instance.
	@Override
	public String toString() {
		return "Atom [atomType=" + atomType + ", movementAngle=" + movementAngle + "speed="
				+ speed + ", diameter=" + diameter + "]";
	}
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	public int getDiameter() {
		return diameter;
	}
	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}
	
	public Point move(Point p,double d, double movementangle) {
		double radian = Math.toRadians(movementangle);
		int newX= (int) (p.getX()+   Math.ceil(d * Math.sin(radian)));
		int newY= (int) (p.getY() + Math.ceil(d * Math.cos(radian)));
		p.setX(newX);
		p.setY(newY);
		return p;
	}
	public Point bounceBack(Point p, int speed, double movementAngle) {
		return move(p,speed,-movementAngle);
	}
	public Point getP() {
		return p;
	}
	public void setP(Point p) {
		this.p = p;
	}
	public String getAtomType() {
		return atomType;
	}
	public void setAtomType(String atomType) {
		this.atomType = atomType;
	}
	public double getMovementAngle() {
		return movementAngle;
	}
	public void setMovementAngle(double movementAngle) {
		this.movementAngle = movementAngle;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
}
