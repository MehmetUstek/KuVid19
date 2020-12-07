package domain.shooter;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import domain.atom.Atom;
import domain.powerup.Powerup;
import domain.utility.Point;

public class AtomShooter extends JPanel{
	
	BufferedImage bimage;
	Image image;

	Object shootingObjectType;
	Point p;
	int health;
	int width;
	int height;
	double angle;
	double speed;
	Atom currentAtom;
	Powerup currentPU;
	
	public AtomShooter(Point p,int health, double speed, double rotationAngle,int width,int height, Object shootingObjectType) throws FileNotFoundException, IOException {
		this.p=p;
		this.angle=rotationAngle;
		this.speed= speed;
		this.health= health;
		this.width=width;
		this.height=height;
		this.shootingObjectType= shootingObjectType;
		bimage = ImageIO.read(new File("./src/assets/shooter.png"));
		image = bimage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
	}

	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}

	public Object getShootingObjectType() {
		return shootingObjectType;
	}

	public void setShootingObjectType(Object shootingObjectType) {
		this.shootingObjectType = shootingObjectType;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
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
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image,0,0, this);
		
	}
	
}
