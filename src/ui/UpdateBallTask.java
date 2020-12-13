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
	double x;
	double y;
    public UpdateBallTask(Atom atom,Dimension d,AtomShooter shooter) {
    	 this.atom= atom;
    	 this.d = d;
    	 this.shooter= shooter;
    	 velX= atom.getSpeed() * Math.sin(Math.toRadians(atom.getRotationAngle()));
    	 velY= atom.getSpeed() * Math.cos(Math.toRadians(180-atom.getRotationAngle()));
    	 x = shooter.getX();
    	 y = shooter.getY() -shooter.getHeight()/2;
    }
    @Override
    public void run() {
    	
    	if(atom.getY()> d.getHeight()+atom.getDiameter()/2) {
    		atom.setX(x);
    		atom.setY(y);
    		atom.setShooted(false);
    		
    		this.cancel();
    		
    	}
    	else if(atom.getY() <atom.getDiameter()/2 ) {
    		if(atom.getRotationAngle()==0) {
	    		atom.setRotationAngle(atom.getRotationAngle()-180);
	    		velY = -velY;
	    		atom.move(atom.getX(),atom.getY(),velX,velY);
	    		System.out.println(velY);
    		}
    		else if(atom.getRotationAngle()<0) {
    			atom.setRotationAngle(180+atom.getRotationAngle());
    			velY= -velY;
        		atom.move(atom.getX(),atom.getY(),velX,velY);
    		}
    		else {
    			atom.setRotationAngle(180-atom.getRotationAngle());
    			velY= -velY;
        		atom.move(atom.getX(),atom.getY(),velX,velY);
    		}
    	}
    	else if(atom.getX() > 0 && atom.getY() > 0 && atom.getX()< d.getWidth() - atom.getDiameter() ) {
    		
    		atom.move(atom.getX(),atom.getY(),velX,velY);
    	}
    	else if(atom.getX() < atom.getDiameter()/2) {
//    		atom.setRotationAngle(atom.getRotationAngle()+90);
    		atom.setRotationAngle(-atom.getRotationAngle());
    		velX = -velX;
    		atom.move(atom.getX(),atom.getY(),velX,velY);
    		System.out.println(velX);
    	}
    	else if( atom.getX() >= d.getWidth() - atom.getDiameter()) {
    		velX = -velX;
    		atom.setRotationAngle(-atom.getRotationAngle());
    		atom.move(atom.getX(),atom.getY(),velX,velY);
    		System.out.println(velX);
    	}
    	else {
    		atom.move(atom.getX(),atom.getY(),velX,velY);

    	}
    }

}
 