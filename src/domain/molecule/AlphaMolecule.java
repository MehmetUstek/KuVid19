package domain.molecule;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

import domain.ID;
import domain.atom.Atom;
import ui.KuVid;

public class AlphaMolecule extends Molecule{
	
	private boolean rotationFlag = true;
	private final double rightRotation = 45;
	private final double leftRotation = -45;
	

	public AlphaMolecule(){
		this.setId(ID.AlphaMolecule);
		this.setWidth((int) (Molecule.L/4));
		this.setHeight((int) (Molecule.L/4));
	}

	@Override
	public void collectMolecule() {
		// TODO Auto-generated method stub	
	}
	
	@Override
	public boolean isInDanger() {
		return false;
	}

	@Override
	public boolean isIntersecting(Atom bullet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update() {
		move(KuVid.L/50);
	}
	
	@Override
	public String toString() {
		return "AlphaMolecule [width=" + width + ", height=" + height + ", x=" + x + ", y=" + y + ", id=" + id + "]";
	}

	@Override
	public void move(double speed) {
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
