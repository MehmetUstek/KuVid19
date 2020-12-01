package ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Background extends JPanel{

	public Background() {
		// TODO Auto-generated constructor stub
	}
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 600, 800);
	}
}
