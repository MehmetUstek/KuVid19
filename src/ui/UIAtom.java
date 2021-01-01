package ui;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;



public class UIAtom extends UIGameObject implements ImageObserver{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String atomType;
	public double diameter;
	ImageIcon icon;
	Image image;
	double width,height;
	AffineTransform at = new AffineTransform();
	public UIAtom(String atomType) {
		// TODO Auto-generated constructor stub
		super();
		this.atomType=atomType;
		this.diameter= getDiameter();
		this.width=diameter;
		this.height=diameter;
	}

	
	public double getDiameter() {
		return diameter;
	}


	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}


	public double getWidth() {
		return width;
	}


	public void setWidth(double width) {
		this.width = width;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	@Override
	public void render(Graphics2D g) {
		String file= "src/assets/atoms/"+ getAtomType() +".png";
		icon = new ImageIcon(file);
		image = icon.getImage();
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
