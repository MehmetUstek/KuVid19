package ui;

import java.awt.Dimension;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import domain.atom.Atom;
import domain.shooter.AtomShooter;

public class UpdateBallTask extends TimerTask {
    Atom atom;
    Dimension d;
    AtomShooter shooter;
    
    public UpdateBallTask(Atom atom,Dimension d,AtomShooter shooter) {
    	 this.atom= atom;
    	 this.d = d;
    	 this.shooter= shooter;
    }
    @Override
    public void run() {
        // update ball position
    	double x= shooter.getX();
    	double y = shooter.getY() -shooter.getHeight()/2;
    	
    	if(atom.getY()> d.getHeight()+atom.getDiameter()/2) {
    		this.cancel();
    		atom.setX(x);
    		atom.setY(y);
    	}
    	if(atom.getX() > 0 && atom.getY() > 0 && atom.getX()< d.getWidth() ) {
    	atom.move(atom.getX(),atom.getY(),atom.getSpeed());
//    	System.out.println(atom.getMovementAngle());
    	}
    	else {
    		atom.setRotationAngle(atom.getRotationAngle()+90);
    		atom.move(atom.getX(),atom.getY(),atom.getSpeed());
        	System.out.println(atom.getRotationAngle());

    	}
    }

}
 