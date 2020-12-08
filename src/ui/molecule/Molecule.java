package ui.molecule;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import domain.molecule.EnumMovement;

public abstract class Molecule extends JPanel{
	BufferedImage bimage;
	Image image;
	public double L; 
	public EnumMovement movementType;
	public int width;
	public int height;
	Point location;
	
	public Molecule(EnumMovement movementType, int width, int height, Point location) throws IOException {
		this.movementType = movementType;
		this.width = width;
		this.height = height;
		this.location = location;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
	public abstract void move();
	
	
}
