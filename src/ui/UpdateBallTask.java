package ui;

import java.awt.Dimension;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import domain.atom.Atom;

public class UpdateBallTask extends TimerTask {
    Atom atom;
    Dimension d;
    
    
    public UpdateBallTask(Atom atom,Dimension d) {
    	 this.atom= atom;
    	 this.d = d;
    }
    @Override
    public void run() {
        // update ball position
    	double x= d.getWidth()/2;
    	double y =d.getHeight() - 160;
    	
    	if(atom.getY()> d.getHeight()+atom.getDiameter()/2) {
    		this.cancel();
    		atom.setX(x);
    		atom.setY(y);
    	}
    	if(atom.getX() > 0 && atom.getY() > 0 && atom.getX()< d.getWidth() ) {
    	atom.move(atom.getX(),atom.getY(),atom.getSpeed(),atom.getMovementAngle());
//    	System.out.println(atom.getMovementAngle());
    	}
    	else {
    		atom.setMovementAngle(atom.getMovementAngle()+90);
    		atom.move(atom.getX(),atom.getY(),atom.getSpeed(),atom.getMovementAngle());
        	System.out.println(atom.getMovementAngle());

    	}
    }

}
 