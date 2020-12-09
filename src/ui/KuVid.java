package ui;
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import domain.atom.AlphaAtom;
import domain.atom.Atom;
import domain.atom.BetaAtom;
import domain.atom.GammaAtom;
import domain.atom.SigmaAtom;
import domain.gameState.Statistics;

public class KuVid {
	static final int FRAME_WIDTH = 600;
	final static int atomNumber= 100;
	final static int L=200;
	final static int diameter= L/10;
	public static final int HEIGHT = 200;
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
	
	
	
	public static void main(String []args) throws IOException {
		KuVidGameplay gameplay= new KuVidGameplay();
		frame= new JFrame("KuVid");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(FRAME_WIDTH, 800);
		frame.setResizable(false);
		frame.setLayeredPane(gameplay);
		frame.setVisible(true);
		
		
		
		
		
	}
	
	
	public boolean isIn(int x, int y) {
		return (x <= frame.getWidth() && x >= 0 && y <= frame.getHeight() && y >= 0);
}
	
	
}
