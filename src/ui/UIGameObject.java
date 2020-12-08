package ui;

import java.awt.Component;
import java.awt.Graphics;
import java.io.Serializable;



public abstract class UIGameObject extends Component implements Serializable {

	protected int x, y;

	public UIGameObject() {
		this.x = getX();
		this.y = getY();
	}

	public abstract void render(Graphics g);

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
