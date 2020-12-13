package ui.molecule;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ui.UIGameObject;

public class UIMolecule extends UIGameObject implements ImageObserver{
	BufferedImage bimage;
	Image image;
	public double L; 
	public double width;
	public double height;
	
	public UIMolecule(){
		super();
	}
	
	public void paintComponent(Graphics2D g) {
		render(g);
		
	}
	
	public void render(Graphics2D g){
		String file= "src/assets/molecules/alpha-1.png";
		try {
			bimage = ImageIO.read(new File(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		image = bimage.getScaledInstance((int) width, (int)height, Image.SCALE_DEFAULT);
		g.drawImage(image,(int)x,(int)y, this);
		
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
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}

}
