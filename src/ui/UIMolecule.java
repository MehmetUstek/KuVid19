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

import domain.molecule.MoleculeType;



public class UIMolecule extends UIGameObject{
	
	
	Image image;
	int x,y;
	String moleculeType;
	int width,height;
	
	public UIMolecule(String moleculeType, int width, int height, int x, int y) {
		// TODO Auto-generated constructor stub
		super();
		this.moleculeType = moleculeType;
		this.width = width;
		this.height = height;
		this.x=x;
		this.y=y;
		
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



	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	@Override
	public void render(Graphics g) {
		String file= "src/assets/molecules/"+getMoleculeType()+".png";
		
		ImageIcon icon = new ImageIcon(file);
		image = icon.getImage();
		g.drawImage(image,0,0, this);
		
	}
	public void move(int x, int y,double speed, double movementangle) {
		 movementangle=0;
		if(getMoleculeType() == "alpha-1") {
			movementangle=0;
			double radian = Math.toRadians(movementangle);
			int newX= (int) (x+   Math.ceil(speed * Math.sin(radian)));
			int newY= (int) (y + Math.ceil(speed * Math.cos(radian)));

			setX(newX);
			setY(newY);
			setLocation(x,y);
		}
		
		 
	}

	public String getMoleculeType() {
		return moleculeType;
	}

	public void setMoleculeType(String moleculeType) {
		this.moleculeType = moleculeType;
	}
	
	public void paintComponent(Graphics g) {
		render(g);
	}

}
