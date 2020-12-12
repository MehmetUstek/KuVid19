package domain.atom;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;

import domain.GameObject;

public class Atom extends GameObject{
	String atomType;
	double movementAngle;
	double speed;
	int diameter;
	double x,y;
	public Atom(String atomType, int diameter, double x, double y,double speed,double movementAngle){
		super();
		this.x=x;
		this.y=y;
		this.movementAngle= movementAngle;
		this.speed= speed;
		this.diameter= diameter;
		this.atomType= atomType;
	}
	public void move() {
		move(getX(),getY(),40,90);
	}
 // Move the atom in its class given x,y locations and speed and diameter, such that it will return new values of x,y.
	public void bounceBack(double angle) {
		
	}
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
	
	
	public String getType() {
		return atomType;
	}
	public void setType(String atomType) {
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
	public void move(double x, double y,double speed, double movementangle) {
		double radian = Math.toRadians(movementangle);
		double newX=  (x+   Math.ceil(speed * Math.sin(radian)));
		double newY=  (y + Math.ceil(speed * Math.cos(radian)));

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
	public void bounceBack(int x, int y,double speed, double movementangle) {
		move(x,y,speed,-movementangle);
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Shape getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
