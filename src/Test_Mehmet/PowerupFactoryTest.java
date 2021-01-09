package Test_Mehmet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import domain.Controller;
import domain.powerup.Powerup;
import domain.powerup.PowerupFactory;

class PowerupFactoryTest {

	@Test
	void mustBeTrue() {
		Powerup pu= new Powerup("alpha");
		//AtomFactory with unspecified type. This has to return random type of atom.
		Powerup testPU= PowerupFactory.getPU(pu, "+alpha");
		assertTrue(Controller.isPowerup(testPU)); //returns an atom with valid type.
		
		testPU = PowerupFactory.getPU(pu, "+alpha");
		assertTrue(testPU.getType().equals("+alpha")); //returns an alpha atom.
		
		testPU = PowerupFactory.getPU(pu, "+beta");
		assertTrue(testPU.getType().equals("+beta")); //returns an beta atom.
		
		testPU = PowerupFactory.getPU(pu, "+sigma");
		assertTrue(testPU.getType().equals("+sigma")); //returns an sigma atom.
		
		testPU = PowerupFactory.getPU(pu, "+gamma");
		assertTrue(testPU.getType().equals("+gamma")); //returns an gamma atom.
	}

}
