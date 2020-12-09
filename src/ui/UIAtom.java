package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;



public class UIAtom extends UIGameObject{
	
	public String atomType;
	public int diameter;
	BufferedImage bimage;
	Image image;
	int x,y;
	
	public UIAtom(String atomType, int diameter, int x, int y) {
		// TODO Auto-generated constructor stub
		super();
		this.atomType=atomType;
		this.diameter= diameter;
		this.x=x;
		this.y=y;
		String file= "src/assets/atoms/"+ getAtomType() +".png";
		try {
			bimage = ImageIO.read(new File(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		image = bimage.getScaledInstance(diameter, diameter, Image.SCALE_DEFAULT);
		
	}

	

	@Override
	public void render(Graphics g) {
		String file= "src/assets/atoms/"+ getAtomType() +".png";
		try {
			bimage = ImageIO.read(new File(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		image = bimage.getScaledInstance(diameter, diameter, Image.SCALE_DEFAULT);
		g.drawImage(image,0,0, this);
		
	}
	public void move(Point p,double speed, double movementangle) {
		double radian = Math.toRadians(movementangle);
		int newX= (int) (p.getX()+   Math.ceil(speed * Math.sin(radian)));
		int newY= (int) (p.getY() + Math.ceil(speed * Math.cos(radian)));
		p.setLocation(newX,newY);
		this.setLocation(p);
		 
	}

	public String getAtomType() {
		return atomType;
	}

	public void setAtomType(String atomType) {
		this.atomType = atomType;
	}
//	public void repaint(Graphics g) {
//		render(g);
//	}
	
	public void paintComponent(Graphics g) {
		render(g);
	}

}
