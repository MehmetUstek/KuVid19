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
    	if(atom.getX()> d.getWidth()-atom.getDiameter()*2 && atom.getY()> d.getHeight()-atom.getDiameter()*2) {
    		this.cancel();
    	}
    	if(atom.getX() > 0 && atom.getY() > 0) {
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
 