package domain.gameState;

import java.util.ArrayList;

import domain.atom.Atom;
import domain.molecule.Molecule;
import domain.powerup.Powerup;
import domain.reactionBlocker.ReactionBlocker;
import domain.shooter.AtomShooter;

public class GameState {
	GameState savedGame;
	AtomShooter shooter;
	ArrayList<Powerup> powerupList;
	ArrayList<Atom> atomList;
	ArrayList<Molecule> moleculeList;
	ArrayList<ReactionBlocker> blockerList;
	
	public GameState(AtomShooter shooter, ArrayList<Powerup> powerupList, ArrayList<Atom> atomList,
			ArrayList<Molecule> moleculeList, ArrayList<ReactionBlocker> blockerList) {
		this.shooter=shooter;
		this.powerupList =powerupList;
		this.atomList=atomList;
		this.moleculeList=moleculeList;
		this.blockerList=blockerList;
		
	}

}
