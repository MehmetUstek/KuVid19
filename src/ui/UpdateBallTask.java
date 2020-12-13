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
    double velX;
	double velY;
    public UpdateBallTask(Atom atom,Dimension d,AtomShooter shooter) {
    	 this.atom= atom;
    	 this.d = d;
    	 this.shooter= shooter;
    	 velX= atom.getSpeed() * Math.sin(Math.toRadians(shooter.getRotationAngle()));
     	velY= atom.getSpeed() * Math.cos(Math.toRadians(180-shooter.getRotationAngle()));
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
    	if(atom.getY() <atom.getDiameter()/2 ) {
    		if(atom.getRotationAngle()==0) {
//	    		atom.setRotationAngle(atom.getRotationAngle()-180);
	    		velY = -velY;
	    		atom.move(atom.getX(),atom.getY(),velX,velY);
	    		System.out.println(velY);
    		}
    		else {
//    			atom.setRotationAngle(atom.getRotationAngle()+90);
    			velY= -velY;
        		atom.move(atom.getX(),atom.getY(),velX,velY);
    		}
        	System.out.println(atom.getRotationAngle());
    	}
    	else if(atom.getX() > 0 && atom.getY() > 0 && atom.getX()< d.getWidth() - atom.getDiameter() ) {
    		
    		atom.move(atom.getX(),atom.getY(),velX,velY);
//    	System.out.println(atom.getMovementAngle());
    	}
    	else if(atom.getX() < atom.getDiameter()/2) {
//    		atom.setRotationAngle(atom.getRotationAngle()+90);
    		velX = -velX;
    		atom.move(atom.getX(),atom.getY(),velX,velY);
    		System.out.println(velX);
    	}
    	else if( atom.getX() >= d.getWidth() - atom.getDiameter()) {
    		velX = -velX;
    		atom.move(atom.getX(),atom.getY(),velX,velY);
    		System.out.println(velX);
    	}
    	else {
//    		atom.setRotationAngle(atom.getRotationAngle()+90);
    		atom.move(atom.getX(),atom.getY(),velX,velY);

    	}
    }

}
 