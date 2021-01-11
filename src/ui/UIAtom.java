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
//	AffineTransform at = new AffineTransform();
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
		return diameter*2;
	}


	public void setWidth(double width) {
		this.width = width;
	}


	public double getHeight() {
		return diameter*2;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	@Override
	public void render(Graphics2D g) {
		String file= "src/assets/atoms/"+ getAtomType() +".png";
		icon = new ImageIcon(file);
//		try {
//			BufferedImage bimage= ImageIO.read(new File(file));
//			System.out.println(getDiameter());
//			image= bimage.getScaledInstance((int) getDiameter(), (int) getDiameter(), Image.SCALE_AREA_AVERAGING); 
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		image = icon.getImage();
//		image= image.getScaledInstance((int)getDiameter()*2,(int)getDiameter()*2, Image.SCALE_SMOOTH);
//		icon= new ImageIcon(image);
		image= icon.getImage();
		image= image.getScaledInstance((int)getWidth(), (int)getHeight(), Image.SCALE_SMOOTH);
		icon = new ImageIcon(image);
		image = icon.getImage();
		Rectangle2D r= new Rectangle2D.Double(x,y,getWidth(),getHeight());
        double cx= r.getCenterX();
        double cy= r.getCenterY();
//        at.setToIdentity();
//		at.translate(cx,cy);
//		Rectangle2D r= new Rectangle2D.Double(x,y,getDiameter(),getDiameter());
//		g.drawImage(image,(int) x,(int) y, new Canvas());
		g.drawImage(image,(int) cx,(int) cy,new Canvas());
		
		
	}
	public String getAtomType() {
		return atomType;
	}

	public void setAtomType(String atomType) {
		this.atomType = atomType;
	}
	

	@Override
	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		// TODO Auto-generated method stub
		return false;
	}

}
