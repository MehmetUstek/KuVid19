package domain.blender;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import domain.GameObject;
import domain.atom.Atom;
import domain.powerup.Powerup;
import ui.KuVid;

public class Blender extends GameObject{
	String atomType;
	String targetAtomType;
	BufferedImage bimage;
	Image image;
	int width;
	int height;
	private static final int FRAME_WIDTH = 600;
	final static int atomNumber= 100;
	final static int L=200;
	final static int diameter= L/10;


	public Blender() {
		this.width=L;
		this.height=L;

	}
	public void BlendAtom(int atomRank, int targetAtomRank) {
		if(atomRank == 1 && targetAtomRank == 2) {
			if(KuVid.alphaList.size() >= 2) {
				KuVid.alphaList.remove(KuVid.alphaList.size() - 1);
				KuVid.alphaList.remove(KuVid.alphaList.size() - 1);

				KuVid.betaList.add(new Atom("beta"));
				System.out.println("You have blended 2 alpha atoms to get a beta atom");
			} else {

			}
		}
		if(atomRank == 1 && targetAtomRank == 3) {
			if(KuVid.alphaList.size() >= 3) {
				KuVid.alphaList.remove(KuVid.alphaList.size() - 1);
				KuVid.alphaList.remove(KuVid.alphaList.size() - 1);
				KuVid.alphaList.remove(KuVid.alphaList.size() - 1);

				KuVid.gammaList.add(new Atom("gamma"));
				System.out.println("You have blended 3 alpha atoms to get a gamma atom");
			} else {

			}
		}	
		if(atomRank == 1 && targetAtomRank == 4) {
			if(KuVid.alphaList.size() >= 4) {
				KuVid.alphaList.remove(KuVid.alphaList.size() - 1);
				KuVid.alphaList.remove(KuVid.alphaList.size() - 1);
				KuVid.alphaList.remove(KuVid.alphaList.size() - 1);
				KuVid.alphaList.remove(KuVid.alphaList.size() - 1);

				KuVid.sigmaList.add(new Atom("sigma"));
				System.out.println("You have blended 4 alpha atoms to get a sigma atom");
			} else {

			}
		}
		if(atomRank == 2 && targetAtomRank == 3) {
			if(KuVid.betaList.size() >= 2) {
				KuVid.betaList.remove(KuVid.betaList.size() - 1);
				KuVid.betaList.remove(KuVid.betaList.size() - 1);

				KuVid.gammaList.add(new Atom("gamma"));
				System.out.println("You have blended 2 beta atoms to get a gamma atom");
			} else {

			}
		}
		if(atomRank == 2 && targetAtomRank == 4) {
			if(KuVid.betaList.size() >= 3) {
				KuVid.betaList.remove(KuVid.betaList.size() - 1);
				KuVid.betaList.remove(KuVid.betaList.size() - 1);
				KuVid.betaList.remove(KuVid.betaList.size() - 1);

				KuVid.sigmaList.add(new Atom("sigma"));
				System.out.println("You have blended 3 beta atoms to get a sigma atom");
			} else {

			}
		}
		if(atomRank == 3 && targetAtomRank == 4) {
			if(KuVid.gammaList.size() >= 2) {
				KuVid.gammaList.remove(KuVid.gammaList.size() - 1);
				KuVid.gammaList.remove(KuVid.gammaList.size() - 1);

				KuVid.sigmaList.add(new Atom("sigma"));
				System.out.println("You have blended 2 gamma atoms to get a sigma atom");
			} else {

			}
		}

		if(atomRank == 2 && targetAtomRank == 1) {
			if(KuVid.betaList.size() >= 1) {
				KuVid.betaList.remove(KuVid.betaList.size() - 1);

				KuVid.alphaList.add(new Atom("alpha"));
				KuVid.alphaList.add(new Atom("alpha"));
				System.out.println("You have broken a beta atom to get 2 alpha atoms");
			} else {

			}
		}
		if(atomRank == 3 && targetAtomRank == 1) {
			if(KuVid.gammaList.size() >= 1) {
				KuVid.gammaList.remove(KuVid.gammaList.size() - 1);

				KuVid.alphaList.add(new Atom("alpha"));
				KuVid.alphaList.add(new Atom("alpha"));
				KuVid.alphaList.add(new Atom("alpha"));
				System.out.println("You have broken a gamma atom to get 3 alpha atoms");
			} else {

			}
		}	
		if(atomRank == 4 && targetAtomRank == 1) {
			if(KuVid.sigmaList.size() >= 1) {
				KuVid.sigmaList.remove(KuVid.sigmaList.size() - 1);

				KuVid.alphaList.add(new Atom("alpha"));
				KuVid.alphaList.add(new Atom("alpha"));
				KuVid.alphaList.add(new Atom("alpha"));
				KuVid.alphaList.add(new Atom("alpha"));
				System.out.println("You have broken a sigma atom to get 4 alpha atoms");
			} else {

			}
		}
		if(atomRank == 3 && targetAtomRank == 2) {
			if(KuVid.gammaList.size() >= 1) {
				KuVid.gammaList.remove(KuVid.gammaList.size() - 1);

				KuVid.betaList.add(new Atom("beta"));
				KuVid.betaList.add(new Atom("beta"));
				System.out.println("You have broken a gamma atom to get 2 beta atoms");
			} else {

			}
		}
		if(atomRank == 4 && targetAtomRank == 2) {
			if(KuVid.sigmaList.size() >= 1) {
				KuVid.sigmaList.remove(KuVid.sigmaList.size() - 1);

				KuVid.betaList.add(new Atom("beta"));
				KuVid.betaList.add(new Atom("beta"));
				KuVid.betaList.add(new Atom("beta"));
				System.out.println("You have broken a sigma atom to get 3 beta atoms");
			} else {

			}
		}
		if(atomRank == 4 && targetAtomRank == 3) {
			if(KuVid.sigmaList.size() >= 1) {
				KuVid.sigmaList.remove(KuVid.sigmaList.size() - 1);

				KuVid.gammaList.add(new Atom("gamma"));
				KuVid.gammaList.add(new Atom("gamma"));
				System.out.println("You have broken a sigma atom to get 2 gamma atoms");
			} else {

			}
		}
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}


}
