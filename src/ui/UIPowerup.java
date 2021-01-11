package ui;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;



/**
 * @author MehmetUstek
 *
 */
public class UIPowerup extends UIGameObject implements ImageObserver{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String puType;
	ImageIcon icon;
	Image image;
	double width,height;
	AffineTransform at = new AffineTransform();
	public UIPowerup(String puType) {
		// TODO Auto-generated constructor stub
		super();
		this.puType=puType;
		this.width=getWidth();
		this.height=getHeight();
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
		String file= "src/assets/powerups/"+ getPUType() +"-b.png";
		icon = new ImageIcon(file);
		image = icon.getImage();
		image= image.getScaledInstance((int)getWidth(), (int)getHeight(), Image.SCALE_SMOOTH);
		icon = new ImageIcon(image);
		image = icon.getImage();
		Rectangle2D r= new Rectangle2D.Double(x,y,getWidth(),getHeight());
        double cx= r.getCenterX();
        double cy= r.getCenterY();
//        at.setToIdentity();
//		at.translate(cx,cy);
		g.drawImage(image, (int) cx,(int) cy, new Canvas());
		
	}
	public String getPUType() {
		return puType;
	}

	public void setPUType(String atomType) {
		this.puType = atomType;
	}
	

	@Override
	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		// TODO Auto-generated method stub
		return false;
	}

}
