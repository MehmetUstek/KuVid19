package domain.shooter;

import domain.GameObject;

public class AtomShooter extends GameObject{
	String type;
	double rotationAngle;
	double speed;
	int width,height;
	double x,y;
	public AtomShooter(String type,int width, int height){
		super();
		this.type=type;
		this.width=width;
		this.height=height;
	}
	public void move() {
		move(getX(),getY(),40,90);
	}
	
	
	
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public String getType() {
		return type;
	}
	public void setType(String atomType) {
		this.type = atomType;
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
	
}
