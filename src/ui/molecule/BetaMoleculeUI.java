package ui.molecule;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import domain.molecule.EnumMovement;

public class BetaMoleculeUI extends Molecule{
	
	
	public BetaMoleculeUI(EnumMovement movementType, int width, int height, Point location) {
		super(movementType, width, height, location);
	}
	
	public void paintComponent(Graphics g) {
	}

	@Override
	public void move() {
		this.setLocation(this.getLocation().x, this.getLocation().y += 20);
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
