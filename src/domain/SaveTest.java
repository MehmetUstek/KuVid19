package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import domain.atom.Atom;
import ui.Renderer;
import ui.UIAtom;

class SaveTest {
	Renderer renderer= new Renderer();
	Controller controller = new Controller(renderer, null);
	Save save= new Save(controller);
	@Test
	void mustBeTrue() {
		// I will use savetest.txt file for this test classes.
		// The initializing process below is a must to initialize a save object.
		renderer.addObject(new UIAtom("alpha"));
		controller.setUsername("savetest");
		controller.addObject(new Atom("alpha"));
		save.loadGame();
		
		
		assertTrue(controller.getShootingObject().getType().equals("alpha"));
		
		//The set alpha count for saved file "savetest" contains 20 alpha atoms.
		assertTrue(controller.getAlphaCount()==20);
		
		//Test shield count
		assertTrue(controller.getEtaCount()==20);
		
		// Test powerup count
		assertTrue(controller.getAlphaPUCount()==20);
		
		//Test time
		assertTrue(controller.getTime()==600);
		
		//Test difficulty / speed of the game TODO
		assertTrue(controller.getSpeed()==10);
		
		//Test username
		assertTrue(controller.getUsername().equals("savetest"));
	}
	
	@Test
	void mustBeFalse() {
		renderer.addObject(new UIAtom("alpha"));
		controller.setUsername("savetest");
		controller.addObject(new Atom("alpha"));
		save.loadGame();
		
		assertFalse(controller.getAlphaCount()!=20);
	}

}
