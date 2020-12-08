package ui.molecule;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import domain.molecule.EnumMovement;

public class AlphaMoleculeUI extends Molecule{
	
	ImageIcon bImage;
	Image img;
	
	public AlphaMoleculeUI(EnumMovement movementType, int width, int height, Point location) throws IOException {
		super(movementType, width, height, location);
		bimage = ImageIO.read(new File("src/assets/molecules/alpha-1.png"));
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
}
