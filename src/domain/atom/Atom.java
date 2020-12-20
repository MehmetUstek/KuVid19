package domain.atom;

import domain.GameObject;

public class Atom extends GameObject{
	String atomType;
	double rotationAngle;
	double speed;
	double diameter;
	double x,y;
	boolean isShooted;
	double stability,efficiency;
	int protons, neutrons;
	double width,height;
	public Atom(String atomType){
		super();
		this.x=getX();
		this.y=getY();
		this.rotationAngle= getRotationAngle();
		this.speed= getSpeed();
		this.diameter= getDiameter();
		this.atomType= atomType;
		this.stability= getStability();
		this.efficiency= getEfficiency();
		this.protons = getProtons();
		this.neutrons= getNeutrons();
		this.width= getDiameter();
		this.height= getDiameter();
	}
	public double getWidth() {
		return diameter;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return diameter;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public int getProtons() {
		return protons;
	}

	public void setProtons(int protons) {
		this.protons = protons;
	}

	public int getNeutrons() {
		return neutrons;
	}

	public void setNeutrons(int neutrons) {
		this.neutrons = neutrons;
	}
	public double getStability() {
		return stability;
	}

	public void setStability(double stability) {
		this.stability = stability;
	}

	public double getEfficiency() {
		return efficiency;
	}

	public void setEfficiency() {
		if(getType().equals("alpha")) {
			this.efficiency = (1- (Math.abs((getNeutrons()-getProtons())) / getProtons()) ) * getStability();
		}
		if(getType().equals("beta")) {
			this.efficiency = getStability() - (0.5 * Math.abs(getNeutrons() - getProtons()) / getProtons());
		}
		if(getType().equals("sigma")) {
			this.efficiency = (1+ getStability()) /2 +  (Math.abs(getNeutrons() - getProtons()) / getProtons());
		}
		if(getType().equals("gamma")) {
			this.efficiency = getStability() + (Math.abs(getNeutrons() - getProtons()) / (2* getProtons()));
		}
	}

	public boolean isShooted() {
		return isShooted;
	}
	public void setShooted(boolean isShooted) {
		this.isShooted = isShooted;
	}
	@Override
	public String toString() {
		return atomType;
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
