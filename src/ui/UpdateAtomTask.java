package ui;

import java.awt.Dimension;
import java.util.TimerTask;

import domain.GameObject;
import domain.shooter.AtomShooter;

public class UpdateAtomTask extends TimerTask {
    GameObject atom;
    Dimension d;
    double width;
    AtomShooter shooter;
    double velX;
	double velY;
	double x;
	double y;
    public UpdateAtomTask(GameObject atom,Dimension d,AtomShooter shooter) {
    	 this.atom= atom;
    	 this.d = d;
    	 this.shooter= shooter;
    	 width= d.getWidth()-200;
    	 velX= atom.getSpeed() * Math.sin(Math.toRadians(atom.getRotationAngle()));
    	 velY= atom.getSpeed() * Math.cos(Math.toRadians(180-atom.getRotationAngle()));
    	 x = shooter.getX()+ atom.getWidth()/2;
    	 y = shooter.getY() -atom.getHeight()*2;
    }
    @Override
    public void run() {
//    	System.out.println(atom.getHeight());
    	if(atom.getY()> d.getHeight()+atom.getHeight()/2) {
    		atom.setX(x);
    		atom.setY(y);
    		atom.setShooted(false);
    		
    		this.cancel();
    		
    	}
    	else if(atom.getY() <atom.getHeight()/2 ) {
    		if(atom.getRotationAngle()==0) {
	    		atom.setRotationAngle(atom.getRotationAngle()-180);
	    		velY = -velY;
	    		atom.move(atom.getX(),atom.getY(),velX,velY);
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
    	else if(atom.getX() > 0 && atom.getY() > 0 && atom.getX()< width - atom.getWidth()*4) {
    		
    		atom.move(atom.getX(),atom.getY(),velX,velY);
    	}
    	else if(atom.getX() < atom.getWidth()/2) {
//    		atom.setRotationAngle(atom.getRotationAngle()+90);
    		atom.setRotationAngle(-atom.getRotationAngle());
    		velX = -velX;
    		atom.move(atom.getX(),atom.getY(),velX,velY);
    	}
    	else if( atom.getX() >= width - atom.getWidth()*4) {
    		velX = -velX;
    		atom.setRotationAngle(-atom.getRotationAngle());
    		atom.move(atom.getX(),atom.getY(),velX,velY);
    	}
    	else {
    		atom.move(atom.getX(),atom.getY(),velX,velY);

    	}
    }

}
 