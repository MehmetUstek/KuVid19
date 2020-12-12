package ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
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
	int width,height;
	
	public UIShooter(String type,int width, int height) {
		// TODO Auto-generated constructor stub
		super();
		this.type=type;
		this.width=width;
		this.height=height;
	}



	@Override
	public void render(Graphics g) {
		String file= "src/assets/shooter.png";
		ImageIcon icon = new ImageIcon(file);
		image = icon.getImage();
		g.drawImage(image,(int) getX(),(int) getY(), this);
		
	}

	public String getAtomType() {
		return type;
	}

	public void setAtomType(String type) {
		this.type = type;
	}
	
	public void paintComponent(Graphics g) {
		render(g);
	}

	@Override
	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		// TODO Auto-generated method stub
		return false;
	}

}
