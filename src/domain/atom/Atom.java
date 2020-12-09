package domain.atom;

import java.awt.Graphics;
import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.IOException;

import domain.GameObject;

public abstract class Atom extends GameObject{
	String atomType;
	double movementAngle;
	double speed;
	int diameter;
	public Atom(int x,int y,double movementAngle, int speed, int diameter,String atomType){
		super();
		this.x=x;
		this.y=y;
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
	
	public void move(int x,int y,double d, double movementangle) {
		double radian = Math.toRadians(movementangle);
		int newX= (int) (x+   Math.ceil(d * Math.sin(radian)));
		int newY= (int) (y + Math.ceil(d * Math.cos(radian)));
		this.x=newX;
		this.y= newY;
	}
	public void bounceBack(int x,int y, int speed, double movementAngle) {
		move(x,y,speed,-movementAngle);
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
