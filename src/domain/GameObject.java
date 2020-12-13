package domain;

import java.awt.Shape;
import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class GameObject implements Serializable {

	protected double x, y, velX, velY, rotationAngle,width,height;
	

	protected ID id;
	String type;
	

	public GameObject() {
		this.x = getX();
		this.y = getY();
	}

	public abstract void update();
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public double getRotationAngle() {
		return rotationAngle;
	}

	public void setRotationAngle(double rotationAngle) {
		this.rotationAngle = rotationAngle;
	}

	public void setY(double y) {
		this.y = y;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public double getVelX() {
		return velX;
	}

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public double getVelY() {
		return velY;
	}

	public void setVelY(double vely) {
		this.velY = vely;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

}
