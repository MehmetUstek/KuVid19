package Test_Mehmet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.jupiter.api.Test;

import domain.Controller;
import domain.Save;
import domain.atom.Atom;
import ui.Renderer;
import ui.UIAtom;

class SaveLoadTest {
	/*
	 * Black-box: Test of the specified initial settings of the game.
	 * Glass-box: New iteration through the controller and saving the game again.
	 */
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
		controller.loadGame();
		
		
		assertTrue(controller.getShootingObject().getType().equals("alpha")); //Black-box return the initial settings.
		
		//The set alpha count for saved file "savetest" contains 20 alpha atoms.
		assertTrue(controller.getAlphaCount()==20);//Black-box return the initial settings.
		
		//Test shield count
		assertTrue(controller.getEtaCount()==20);//Black-box return the initial settings.
		
		// Test powerup count
		assertTrue(controller.getAlphaPUCount()==20);//Black-box return the initial settings.
		
		//Test time
		assertTrue(controller.getTime()==600);//Black-box return the initial settings.
		
		//Test difficulty / speed of the game TODO
		assertTrue(controller.getSpeed()==10);//Black-box return the initial settings.
		
		//Test username
		assertTrue(controller.getUsername().equals("savetest"));//Black-box return the initial settings.
	}
	
	

}
