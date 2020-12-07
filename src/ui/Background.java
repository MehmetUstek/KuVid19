package ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Background extends JPanel{
	//This class will form the background of the Frame. It will be the first layer where game events happen.
	// Atoms, molecules etc. will be in the second layer of the frame at top of this panel.
	int width;
	int height;
	public Background(int width, int height) {
		this.width=width;
		this.height=height;
		// TODO Auto-generated constructor stub
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

	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
	}
}
