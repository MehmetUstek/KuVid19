package domain.atom;

import java.util.Random;

import domain.molecule.AlphaMolecule;
import domain.molecule.Molecule;

public class AtomFactory {
	static Random random = new Random();
	static Atom atom;
	public static Atom getAtom(Atom atom) {
		int i = random.nextInt(3);
		switch(i) {
		case 0:
			atom.setType("alpha");
			break;
		case 1:
			atom.setType("beta");
			break;
		case 2:
			atom.setType("sigma");
			break;
		case 3:
			atom.setType("gamma");
			break;
		}
		return atom;
	}
}
