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
	private static final int FRAME_WIDTH = 800;
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
		
		frame= new JFrame("KuVid");
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT+L);
		System.out.println(frame.getSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(true);
		KuVidGameplay gameplay= new KuVidGameplay(FRAME_WIDTH,FRAME_HEIGHT);
		frame.setLayeredPane(gameplay);
		frame.setVisible(true);
		
		
		System.out.println("The game has started");
	
	}
	
	
	public boolean isIn(Point p) {
		return (p.x <= frame.getWidth() && p.x >= 0 && p.y <= frame.getHeight() && p.y >= 0);
}
	
	
}
