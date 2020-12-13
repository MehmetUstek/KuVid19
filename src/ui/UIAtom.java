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



public class UIAtom extends UIGameObject implements ImageObserver{
	
	
	public String atomType;
	public double diameter;
	BufferedImage bimage;
	Image image;
	double width,height;
	AffineTransform at = new AffineTransform();
	public UIAtom(String atomType, double diameter) {
		// TODO Auto-generated constructor stub
		super();
		this.atomType=atomType;
		this.diameter= diameter;
		this.width=diameter;
		this.height=diameter;
	}

//	
//	public int getWidth() {
//		return width;
//	}
//
//
//	public void setWidth(int width) {
//		this.width = width;
//	}
//
//
//	public int getHeight() {
//		return height;
//	}
//
//
//	public void setHeight(int height) {
//		this.height = height;
//	}


	@Override
	public void render(Graphics2D g) {
		String file= "src/assets/atoms/"+ getAtomType() +".png";
		ImageIcon icon = new ImageIcon(file);
		image = icon.getImage();
		
//		try {
//			bimage = ImageIO.read(new File(file));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		image = bimage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		Canvas canvas= new Canvas();
//		canvas.setBackground(Color.BLACK);
		JLabel label = new JLabel();
//		canvas.setVisible(true);
//		canvas.prepareImage(image, canvas);
		// IF THIS DOES NOT WORK, USE CANVAS.
		at.setToIdentity();
		at.translate(x, y);
		g.drawImage(image,at, this);
		
	}
	public String getAtomType() {
		return atomType;
	}

	public void setAtomType(String atomType) {
		this.atomType = atomType;
	}
	
	public void paintComponent(Graphics2D g) {
		render(g);
	}

	@Override
	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		// TODO Auto-generated method stub
		return false;
	}

}