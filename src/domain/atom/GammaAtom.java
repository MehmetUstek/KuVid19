package domain.atom;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GammaAtom extends Atom {
	BufferedImage bimage;
	Image image;
	public GammaAtom(int x, int y,double movementAngle, double speed, int diameter,String atomType) throws FileNotFoundException, IOException {
		super(x,y,movementAngle, speed, diameter,atomType);
		bimage = ImageIO.read(new FileInputStream("src/assets/atoms/gamma.png"));
		image = bimage.getScaledInstance(diameter, diameter, Image.SCALE_DEFAULT);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shoot(double angle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bounceBack(double angle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image,0,0, this);
	}
}
