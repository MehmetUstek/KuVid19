package ui.molecule;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class BetaMoleculeUI extends UIMolecule{
	
	Image img;
	AffineTransform at = new AffineTransform();
	
	public BetaMoleculeUI(){
		super();
		
	}
	
	public void paintComponent(Graphics2D g) {
		super.paintComponent(g);
		g.drawImage(img, (int)x,(int)y, (ImageObserver) this);
	}

	@Override
	public void render(Graphics2D g){
		
		ImageIcon icon = new ImageIcon("src/assets/molecules/beta-1.png");
		img = icon.getImage();
		
		at.setToIdentity();
		at.translate(x, y);
		g.drawImage(img, at, this);
	}
}
