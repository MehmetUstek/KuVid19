package ui.molecule;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class SigmaMoleculeUI extends UIMolecule{
	
	Image img;
	AffineTransform at = new AffineTransform();
	
	public SigmaMoleculeUI(){
		super();
		
	}
	
	public void paintComponent(Graphics2D g) {
		super.paintComponent(g);
		g.drawImage(img, (int)x,(int)y, (ImageObserver) this);
	}

	@Override
	public void render(Graphics2D g){
		
		ImageIcon icon = new ImageIcon("src/assets/molecules/sigma-.png");
		img = icon.getImage();
		image= icon.getImage();
		image= image.getScaledInstance((int)getWidth(), (int)getHeight(), Image.SCALE_SMOOTH);
		icon = new ImageIcon(image);
		image = icon.getImage();
		Rectangle2D r= new Rectangle2D.Double(x,y,getWidth(),getHeight());
        double cx= r.getCenterX();
        double cy= r.getCenterY();
        at.setToIdentity();
		at.translate(x,y);
		g.drawImage(img, at, new Canvas());
	}
}


