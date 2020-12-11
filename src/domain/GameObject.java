package domain;

import java.awt.Shape;
import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class GameObject implements Serializable {

	protected double x, y, velX, velY;
	protected ID id;
	String type;
	

	public GameObject() {
		this.x = getX();
		this.y = getY();
	}

	public abstract void update();
	public abstract Shape getBounds();
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

	

}
