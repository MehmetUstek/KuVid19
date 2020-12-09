package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;



public class UIAtom extends UIGameObject{
	
	
	public String atomType;
	public int diameter;
	BufferedImage bimage;
	Image image;
	int x,y,length;
	
	public UIAtom(String atomType, int diameter, int x, int y) {
		// TODO Auto-generated constructor stub
		super();
		this.atomType=atomType;
		this.diameter= diameter;
		this.x=x;
		this.y=y;
		this.length=diameter;
		
	}

	
	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getLength() {
		return length;
	}



	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public void render(Graphics g) {
		String file= "src/assets/atoms/"+ getAtomType() +".png";
		
		ImageIcon icon = new ImageIcon(file);
		image = icon.getImage();
		g.drawImage(image,0,0, this);
		
	}
	public void move(int x, int y,double speed, double movementangle) {
		double radian = Math.toRadians(movementangle);
		int newX= (int) (x+   Math.ceil(speed * Math.sin(radian)));
		int newY= (int) (y + Math.ceil(speed * Math.cos(radian)));

		setX(newX);
		setY(newY);
		setLocation(x,y);
		 
	}

	public String getAtomType() {
		return atomType;
	}

	public void setAtomType(String atomType) {
		this.atomType = atomType;
	}
	
	public void paintComponent(Graphics g) {
		render(g);
	}

}
