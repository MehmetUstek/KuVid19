package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import domain.utility.PropertyEvent;
import domain.utility.PropertyListener;

public class UIAtom extends UIGameObject{
	
	public String atomType;
	public int diameter;
	BufferedImage bimage;
	Image image;
	public UIAtom(String atomType, int diameter) {
		// TODO Auto-generated constructor stub
		super();
		this.atomType=atomType;
		this.diameter= diameter;
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

	public String getAtomType() {
		return atomType;
	}

	public void setAtomType(String atomType) {
		this.atomType = atomType;
	}
	

}
