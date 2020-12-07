package domain.atom;

import java.awt.Graphics;

import javax.swing.JPanel;

public abstract class Atom extends JPanel {
	int x,y;
	String atomType;
	double movementAngle;
	double speed;
	int diameter;
	
	public Atom(int x,int y,double movementAngle, double speed, int diameter,String atomType) {
		this.x= x;
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
	
}
