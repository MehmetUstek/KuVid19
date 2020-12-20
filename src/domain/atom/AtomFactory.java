package domain.atom;

import java.util.Random;


public class AtomFactory {
	static Random random = new Random();
	public static Atom getAtom(Atom atom,String type) {
		if(type== "") {
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
		else {
			atom.setType(type);
			return atom;
		}
		
	}
}
