package ui;

import java.awt.Component;
import java.awt.Graphics;
import java.io.Serializable;

import javax.swing.JComponent;
import javax.swing.JPanel;



public abstract class UIGameObject implements Serializable {

	protected double x, y;
	int width,height;

	public UIGameObject() {
		this.x = getX();
		this.y = getY();
		this.width= getWidth();
		this.height= getHeight();
	}



	public int getWidth() {
		return width;
	}



	public void setWidth(int width) {
		this.width = width;
	}



	public int getHeight() {
		return height;
	}



	public void setHeight(int height) {
		this.height = height;
	}



	public abstract void render(Graphics g);

	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}

	public double getX() {
		return  x;
	}

	public double getY() {
		return y;
	}
	public void paintComponent(Graphics g) {
		render(g);
	}

}
