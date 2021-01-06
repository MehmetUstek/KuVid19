package domain.molecule;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

import domain.ID;
import domain.atom.Atom;
import ui.KuVid;


public class BetaMolecule extends Molecule{
	
	

	public static boolean hasReached = false;
	private boolean rotationFlag = true;

	public BetaMolecule(){
		this.setId(ID.BetaMolecule);
		this.setWidth((int) (Molecule.L/4));
		this.setHeight((int) (Molecule.L/4));
	}

	@Override
	public void collectMolecule() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isInDanger() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "BetaMolecule";
	}


	@Override
	public boolean isIntersecting(Atom bullet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update() {
		move(getSpeed()/50);
	}
	
	@Override
	public String toString() {
		return "BetaMolecule [width=" + width + ", height=" + height + ", x=" + x + ", y=" + y + ", id=" + id + "]";
	}

	@Override
	public void move(double speed) {
		if(!hasReached) {
			this.setY(this.getY() + speed);
			
		} else if(hasReached) {
			if(rotationFlag) {
				//rotate it 45 degree
				double locX = this.getX() / 2;
				double locY = this.getY() / 2;
				AffineTransform at = AffineTransform.getRotateInstance(45, locX, locY);
				AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
				this.setY(this.getY() + speed);
				
			}else if(!rotationFlag) {
				//rotate it -45 degree
				double locX = this.getX() / 2;
				double locY = this.getY() / 2;
				AffineTransform at = AffineTransform.getRotateInstance(-45, locX, locY);
				AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
				this.setY(this.getY() + speed);
			}
		}
		
	}

	@Override
	public void move(double x, double y, double velX, double velY) {
		// TODO Auto-generated method stub
		
	}
	
}