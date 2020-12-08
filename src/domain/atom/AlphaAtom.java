package domain.atom;


import java.io.FileNotFoundException;
import java.io.IOException;

import domain.utility.Point;

public class AlphaAtom extends Atom {
	Point p;
	public AlphaAtom(Point p,double movementAngle, int speed, int diameter,String atomType) throws FileNotFoundException, IOException {
		super(p,movementAngle, speed, diameter,atomType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shoot(double angle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bounceBack(double angle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
