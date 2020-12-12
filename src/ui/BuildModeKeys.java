package ui;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

import domain.Controller;
import domain.molecule.Molecule;


public class BuildModeKeys implements KeyListener, MouseListener, MouseMotionListener {
	private boolean isBuild = false;
	private boolean isMove = false;
	private boolean deleteMode = false;
	
	private static Molecule a;

	public boolean isMove() {
		return isMove;
	}

	public void setMove(boolean isMove) {
		this.isMove = isMove;
	}

	private Controller GC;
	private UIController UIC;

	public BuildModeKeys(Controller GC, UIController UIC) {
		this.GC = GC;
		this.UIC = UIC;

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			setBuild(true);

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public boolean isBuild() {
		return isBuild;
	}

	public void setBuild(boolean isBuild) {
		this.isBuild = isBuild;
	}

//	public void mouseDragged(MouseEvent event) {
//		deleteMode =  GC.getFrame().getDeleteBox().isSelected();
//		if (isMove && !deleteMode) {
//			if (event.getY() < KuVid.HEIGHT / 2 + 80 && event.getX() < KuVid.WIDTH - 20 && event.getY() > 0) {
//				int x = event.getX();
//				int y = event.getY();
//				a.setLocation(new Point(x,y));
//			}
//		}
//
//	}


	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

		int x = e.getX();
		int y = e.getY();

		LinkedList<Molecule> molecules = GC.getMolecules();
		double maxX = x + KuVid.WIDTH / 50;
		double minX = x - KuVid.WIDTH / 50;
		int minY = y - 20;
		int maxY = y + 20;
		
//		deleteMode =  GC.getFrame().getDeleteBox().isSelected();

		for (int i = 0; i < molecules.size(); i++) {
			if (minX < molecules.get(i).getX() && molecules.get(i).getX() < maxX
					&& minY < molecules.get(i).getY() && maxY > molecules.get(i).getY()) {
				if(!deleteMode) {
					a = molecules.get(i);
					isMove = true;
				} else {
					GC.objects.remove(i);
					UIC.objects.remove(i);
				}

			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
//		deleteMode =  GC.getFrame().getDeleteBox().isSelected();
//		if (isMove && !deleteMode) {
//			if (e.getY() < KuVid.HEIGHT / 2 + 80 && e.getX() < KuVid.WIDTH - 20 && e.getY() > 0) {
//				int x = e.getX();
//				int y = e.getY();
//				a.setX(x);
//				a.setY(y);
//				isMove = false;
//			}
//		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}