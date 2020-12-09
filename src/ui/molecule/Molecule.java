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
import ui.UIGameObject;

public abstract class Molecule extends UIGameObject{
	public double L; 
	public EnumMovement movementType;
	public int width;
	public int height;
	Point location;
	
	public Molecule(EnumMovement movementType, int width, int height, Point location)  {
		this.movementType = movementType;
		this.width = width;
		this.height = height;
		this.location = location;
	}
	
	public void paintComponent(Graphics g) {
		render(g);
	}
	public void render(Graphics g) {
		
		
	}
	public abstract void move();
	
	
}
