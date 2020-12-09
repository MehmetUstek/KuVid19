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
	
	BufferedImage bImage;
	Image img;
	
	public BetaMoleculeUI(EnumMovement movementType, int width, int height, Point location) throws IOException {
		super(movementType, width, height, location);
		bimage = ImageIO.read(new File("src/assets/molecules/beta-1.png"));
		img = bimage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, (ImageObserver) this); 
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
