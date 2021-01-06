package domain.atom;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import domain.Controller;

class AtomFactoryTest {

	@Test
	void mustBeTrue() {
		Atom atom= new Atom("alpha");
		//AtomFactory with unspecified type. This has to return random type of atom.
		Atom testAtom= AtomFactory.getAtom(atom, "");
		assertTrue(Controller.isAtom(testAtom)); //returns an atom with valid type.
		
		testAtom = AtomFactory.getAtom(atom, "alpha");
		assertTrue(testAtom.getType().equals("alpha")); //returns an alpha atom.
		
		testAtom = AtomFactory.getAtom(atom, "beta");
		assertTrue(testAtom.getType().equals("beta")); //returns an beta atom.
		
		testAtom = AtomFactory.getAtom(atom, "sigma");
		assertTrue(testAtom.getType().equals("sigma")); //returns an sigma atom.
		
		testAtom = AtomFactory.getAtom(atom, "gamma");
		assertTrue(testAtom.getType().equals("gamma")); //returns an gamma atom.
	}
	
	@Test
	void mustBeFalse() {
		Atom atom= new Atom("alpha");
		//AtomFactory with unspecified type. This has to return random type of atom.
		Atom testAtom= AtomFactory.getAtom(atom, "");
		
		testAtom = AtomFactory.getAtom(atom, "beta");
		assertFalse(testAtom.getType().equals("alpha")); //must return the specified atom not other types of atoms.
		
	}

}