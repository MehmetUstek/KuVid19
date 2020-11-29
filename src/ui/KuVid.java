package ui;
import java.util.ArrayList;

import domain.Saver;
import domain.atom.AlphaAtom;
import domain.atom.Atom;
import domain.atom.BetaAtom;
import domain.atom.GammaAtom;
import domain.atom.SigmaAtom;
import domain.gameState.Statistics;

public class KuVid {
	final static int atomNumber= 100;
	final static int L=2;
	final static double diameter= L/10;
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
	
	public static void main(String []args ) {
		for(int i=0;i<atomNumber;i++) {
			alphaList.add(new AlphaAtom( 15.02, L, diameter,"alpha"));
		}
		for(int i=0;i<atomNumber;i++) {
			betaList.add(new BetaAtom( 15.02, L, diameter,"beta"));
		}
		for(int i=0;i<atomNumber;i++) {
			sigmaList.add(new SigmaAtom( 15.02, L, diameter,"sigma"));
		}
		for(int i=0;i<atomNumber;i++) {
			gammaList.add(new GammaAtom( 15.02, L, diameter,"gamma"));
		}
		System.out.println("The game has started");
		
		System.out.println("100 Alpha is created"+alphaList.get(0).toString());
		System.out.println("100 Beta is created"+betaList.get(0).toString());
		System.out.println("100 Sigma is created"+sigmaList.get(0).toString());
		System.out.println("100 Gamma is created"+gammaList.get(0).toString());
		
	}
}
