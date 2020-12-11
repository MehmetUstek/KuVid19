package ui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;



public class UIAtom extends UIGameObject{
	
	
	public String atomType;
	public int diameter;
	BufferedImage bimage;
	Image image;
	int width,height;
	
	public UIAtom(String atomType, int diameter) {
		// TODO Auto-generated constructor stub
		super();
		this.atomType=atomType;
		this.diameter= diameter;
		this.width=diameter;
		this.height=diameter;
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
		String file= "src/assets/atoms/"+ getAtomType() +".png";
//		ImageIcon icon = new ImageIcon(file);
//		image = icon.getImage();
		try {
			bimage = ImageIO.read(new File(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		image = bimage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		g.drawImage(image,(int) getX(),(int) getY(), new Canvas());
		
	}
	public void move(int x, int y,double speed, double movementangle) {
		double radian = Math.toRadians(movementangle);
		int newX= (int) (x+   Math.ceil(speed * Math.sin(radian)));
		int newY= (int) (y + Math.ceil(speed * Math.cos(radian)));

		setX(newX);
		setY(newY);
//		setLocation(x,y);
		 
	}
	public void bounceBack(int x, int y,double speed, double movementangle) {
		move(x,y,speed,-movementangle);
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
