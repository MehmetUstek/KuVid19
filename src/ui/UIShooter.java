package ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class UIShooter extends UIGameObject implements ImageObserver{
	
	String type;
	public int diameter;
	BufferedImage bimage;
	Image image;
	double width,height;
	AffineTransform at = new AffineTransform();
	double rotationAngle;
	



	public UIShooter(String type,int width, int height) {
		// TODO Auto-generated constructor stub
		super();
		this.type=type;
		this.width=width;
		this.height=height;
	}



	public double getHeight() {
		return height;
	}



	@Override
	public void render(Graphics2D g) {
		String file= "src/assets/shooter.png";
		ImageIcon icon = new ImageIcon(file);
		image = icon.getImage();
		at.setToIdentity();
		double rotation = getRotationAngle() /180;
		at.rotate(rotation,x,y+getHeight());
		at.translate(x, y);
		
		g.drawImage(image, at, null);
		
	}

	public String getAtomType() {
		return type;
	}

	public void setAtomType(String type) {
		this.type = type;
	}
	
	public void paintComponent(Graphics2D g) {
		render(g);
	}

	@Override
	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		// TODO Auto-generated method stub
		return false;
	}
	public double getRotationAngle() {
		return rotationAngle;
	}



	public void setRotationAngle(double rotationAngle) {
		this.rotationAngle = rotationAngle;
	}
}
