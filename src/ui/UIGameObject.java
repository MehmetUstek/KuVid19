package ui;

import java.awt.Component;
import java.awt.Graphics;
import java.io.Serializable;

import javax.swing.JComponent;
import javax.swing.JPanel;



public abstract class UIGameObject extends JComponent implements Serializable {

	protected int x, y, length;

	public UIGameObject() {
		this.x = getX();
		this.y = getY();
		this.length= getLength();
	}

	public int getLength() {
		return length;
	}

	public void setSize(int length) {
		this.length = length;
	}

	public abstract void render(Graphics g);

	public void setX(int x) {
		this.x = x;
	}
	public abstract void move(int x, int y,double speed, double movementangle);

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public void paintComponent(Graphics g) {
		render(g);
	}

}
