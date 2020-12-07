package ui;
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import domain.Saver;
import domain.atom.AlphaAtom;
import domain.atom.Atom;
import domain.atom.BetaAtom;
import domain.atom.GammaAtom;
import domain.atom.SigmaAtom;
import domain.gameState.Statistics;
import domain.utility.Point;

public class KuVid {
	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 800;
	final static int atomNumber= 100;
	final static int L=FRAME_HEIGHT/10;
	final static int diameter= L/10;
	Saver player;
	Statistics statistics;
	static Atom alpha;
	static Atom beta;
	static Atom sigma;
	static Atom gamma;
	static ArrayList<Atom> alphaList= new ArrayList<Atom>();
	static ArrayList<Atom> betaList= new ArrayList<Atom>();
	static ArrayList<Atom> sigmaList= new ArrayList<Atom>();
	static ArrayList<Atom> gammaList= new ArrayList<Atom>();
	static JFrame frame;
	
	
	
	public static void main(String []args ) throws IOException {
		KuVidGameplay gameplay= new KuVidGameplay();
		frame= new JFrame("KuVid");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setResizable(false);
		frame.setLayeredPane(gameplay);
		frame.setVisible(true);
		
		
		for(int i=0;i<atomNumber;i++) {
			alphaList.add(new AlphaAtom( 0,0,15.02, L, diameter,"alpha"));
		}
		for(int i=0;i<atomNumber;i++) {
			betaList.add(new BetaAtom(0,0, 15.02, L, diameter,"beta"));
		}
		for(int i=0;i<atomNumber;i++) {
			sigmaList.add(new SigmaAtom(0,0, 15.02, L, diameter,"sigma"));
		}
		for(int i=0;i<atomNumber;i++) {
			gammaList.add(new GammaAtom(0,0, 15.02, L, diameter,"gamma"));
		}
		System.out.println("The game has started");
		
		System.out.println("100 Alpha is created"+alphaList.get(0).toString());
		System.out.println("100 Beta is created"+betaList.get(0).toString());
		System.out.println("100 Sigma is created"+sigmaList.get(0).toString());
		System.out.println("100 Gamma is created"+gammaList.get(0).toString());
		
	}
	
	
	public boolean isIn(Point p) {
		return (p.x <= frame.getWidth() && p.x >= 0 && p.y <= frame.getHeight() && p.y >= 0);
}
	
	
}
