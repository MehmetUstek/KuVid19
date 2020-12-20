package domain;

import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import domain.atom.Atom;
import domain.atom.AtomFactory;
import domain.molecule.AlphaMolecule;
import domain.molecule.BetaMolecule;
import domain.molecule.Molecule;
import domain.molecule.MoleculeFactory;
import domain.powerup.Powerup;
import domain.powerup.PowerupFactory;
import domain.shooter.AtomShooter;
import ui.Frame;
import ui.KuVid;
import ui.UIAtom;
import ui.UIGameObject;
import ui.UIMoleculeFactory;
import ui.UIPowerup;
import ui.Renderer;
import ui.UIShooter;
import ui.UpdateAtomTask;
import ui.molecule.AlphaMoleculeUI;
import ui.molecule.UIMolecule;

public class Controller {
	public static double WIDTH =  Toolkit.getDefaultToolkit().getScreenSize().getWidth()-200,
			HEIGHT =  Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private Renderer renderer;
	private ArrayList<Powerup> collectedPowerups = new ArrayList<Powerup>();
	private int score = 0, time = 0, counter = 0, lives = 3, initialMoleculeCount;
	private int alphaCount=0,betaCount=0,sigmaCount=0,gammaCount=0;
	private int alphaPUCount=0,betaPUCount=0,sigmaPUCount=0,gammaPUCount=0;
	private boolean atomFalled;
	public ArrayList<GameObject> objects = new ArrayList<GameObject>();
	Frame frame;
	private Thread thread;
	private boolean running = false;
	public static final double L= HEIGHT/10;
	private static final double ALPHA_STABILITY= 0.85;
	private static final double BETA_STABILITY= 0.9;
	private static final double SIGMA_STABILITY= 0.8;
	private static final double GAMMA_STABILITY= 0.7;
	double shooterHeight = L;
	double diameter= L/10;
	double speed= L;
	double shooterX= WIDTH/2;
	double shooterY =HEIGHT - shooterHeight*2;
	double atomX = shooterX;
	double atomY = shooterY -diameter*2;
	double rotationConstant = 10;
	double atomSpeed=L/5;
	double shooterMoveConstant = 15;
	private boolean isPaused = false;
	
	TimerTask timerTask ;
	Timer timer;
	Save save;
	Random random = new Random();
	String username="mehmet";
	private static KuVid game;
	public Controller(Renderer UI, Frame frame) {
		this.renderer = UI;
		this.frame = frame;
	}
	
	// Set the shooted object to be 0th in list.
	
	public void update() {
		// TODO Auto-generated method stub

		renderer.setScore(score);
		renderer.setLives(lives);
		
		for (int i = 0; i < objects.size(); i++) {
			GameObject tempobject = (GameObject) objects.get(i);
			renderer.objects.get(i).setX((int) tempobject.getX());
			renderer.objects.get(i).setY((int) tempobject.getY());
//			if(tempobject.getType()== "alpha" || tempobject.getType()== "beta" ...
			if (i==0) {
				if(tempobject.getType().equals("alpha")|| tempobject.getType().equals("beta")|| tempobject.getType().equals("sigma")||
						tempobject.getType().equals("gamma")) {
					setAtomPositionsAndCheckCollision(tempobject);
				}else {
					setPowerupPositionsAndCheckCollision(tempobject);
				}
//				Atom tempobject1 = (Atom) tempobject;
//				UIAtom atom = (UIAtom) uicontroller.objects.get(i);
//				double x = tempobject1.getX();
//				double y =  tempobject1.getY();
//				double x1= x + tempobject1.getDiameter();
//				double y1= y+ tempobject1.getDiameter();
//				atom.setX(x);
//				atom.setY(y);
//				
//				if(tempobject1.getY()> Toolkit.getDefaultToolkit().getScreenSize().getHeight()+ tempobject1.getWidth()/2) {
//		    		tempobject1.setX(x);
//		    		tempobject1.setY(y);
//		    		tempobject1.setShooted(false);
//		    		atomFalled=true;
//		    	}
//				
//				tempobject = tempobject1;
//				Rectangle2D r= new Rectangle2D.Double(x,y,tempobject1.getDiameter(),tempobject1.getDiameter());
//				// Collision with alpha molecule and alpha atom.
//				for (int j = 0; j < objects.size(); j++) {
//					GameObject collisionObject = (GameObject) objects.get(j);
//					uicontroller.objects.get(j).setX((int) collisionObject.getX());
//					uicontroller.objects.get(j).setY((int) collisionObject.getY());
////					System.out.println(collisionObject);
//					if (collisionObject.getId()== ID.AlphaMolecule) {
//						AlphaMolecule collisionObject1 = (AlphaMolecule) collisionObject;
//						UIMolecule molecule = (UIMolecule) uicontroller.objects.get(j);
//						double a = collisionObject1.getX();
//						double b = collisionObject1.getY();
////						double a1 =a+ collisionObject.getWidth();
////						double b1 =b+ collisionObject.getHeight();
//						Rectangle2D r1= new Rectangle2D.Double(a,b,collisionObject1.getHeight(),collisionObject1.getWidth());
//						if(r1.intersects(r) || r.intersects(r1)) {
//							System.out.println("Collision");
//							objects.remove(collisionObject);
//							objects.remove(tempobject);
//							uicontroller.removeObject(molecule);
//							uicontroller.removeObject(atom);
//							
//						}
//					}
//					}
				}
//			if (tempobject.getType() == "beta") {
//				UIAtom atom = (UIAtom) uicontroller.objects.get(i);
//				int x = (int) tempobject.getX();
//				int y = (int) tempobject.getY();
//				atom.setX(x);
//				atom.setY(y);
//				}
//			if (tempobject.getType() == "sigma") {
//				UIAtom atom = (UIAtom) uicontroller.objects.get(i);
//				int x = (int) tempobject.getX();
//				int y = (int) tempobject.getY();
//				atom.setX(x);
//				atom.setY(y);
//				}
//			if (tempobject.getType() == "gamma") {
//				UIAtom atom = (UIAtom) uicontroller.objects.get(i);
//				int x = (int) tempobject.getX();
//				int y = (int) tempobject.getY();
//				atom.setX(x);
//				atom.setY(y);
//				}
			if (tempobject.getType() == "shooter") {
				UIShooter shooter = (UIShooter) renderer.objects.get(i);
				int x = (int) tempobject.getX();
				int y = (int) tempobject.getY();
				double rotation = tempobject.getRotationAngle();
				shooter.setX(x);
				shooter.setY(y);
				shooter.setRotationAngle(rotation);
				
				}
			if (tempobject.getId()==ID.AlphaMolecule) {
				
				}
		
			tempobject.update();
		}
		
	}
	public Frame getFrame() {
		return frame;
	}
	public void setFrame(Frame frame) {
		this.frame = frame;
	}
	public LinkedList<Molecule> getMolecules() {
		LinkedList<Molecule> allMolecules = new LinkedList<Molecule>();
//		for (int i = 0; i < objects.size(); i++) {
//			GameObject tempobject = (GameObject) objects.get(i);
//			if (tempobject.getId() == ID.AlphaMolecule || tempobject.getId() == ID.BetaMolecule
//					|| tempobject.getId() == ID.SigmaMolecule || tempobject.getId() == ID.GammaMolecule) {
//
//				allMolecules.add((Molecule) tempobject);
//			}
//		}
		return allMolecules;
	}
	public int getInitialMoleculeCount() {
		return initialMoleculeCount;
	}
	public void setInitialMoleculeCount(int initialMoleculeCount) {
		this.initialMoleculeCount = initialMoleculeCount;
	}
	public void addObject(GameObject obj) {
		this.objects.add(obj);
	}

	public void removeObject(GameObject obj) {
		this.objects.remove(obj);
	}
	
	
	public GameObject getObject(String obj) {
		int i=0;
		for(GameObject tempObject: this.objects) {
			i++;
			if(tempObject.getType()== obj) {
				return tempObject;
			}
		}
		return null;
	}
	public void updateLives() {
		lives--;
	}
	public boolean intersects(Rectangle2D r, Rectangle2D r1) {
		if(r.intersects(r1)) {
			return true;
		}
		return false;
	}
	
	private void setAtomPositionsAndCheckCollision(GameObject tempobject) {
		Atom tempobject1 = (Atom) tempobject;
		UIAtom atom = (UIAtom) renderer.objects.get(0);
		double x = tempobject1.getX();
		double y =  tempobject1.getY();
		double x1= x + tempobject1.getDiameter();
		double y1= y+ tempobject1.getDiameter();
		if(tempobject1.isShooted()) {
			atom.setX(x);
			atom.setY(y);
		}else {
			// TODO this will change. Will be added, when atom is destroyed put new atom from existing ones.
			x=objects.get(1).getX();
			y=objects.get(1).getY();
			tempobject.setX(x);
			tempobject.setY(y);
			atom.setX(x);
			atom.setY(y);
		}
		
		if(tempobject1.getY()> Toolkit.getDefaultToolkit().getScreenSize().getHeight()+ tempobject1.getWidth()/2) {
//    		tempobject1.setX(x);
//    		tempobject1.setY(y);
//    		tempobject1.setShooted(false);
//    		atomFalled=true;
    	}
		
		tempobject = tempobject1;
		Rectangle2D r= new Rectangle2D.Double(x,y,tempobject1.getDiameter(),tempobject1.getDiameter());
		// Collision with alpha molecule and alpha atom.
		for (int j = 0; j < objects.size(); j++) {
			if(objects.size()==0) {
				break;
			}
			GameObject collisionObject = (GameObject) objects.get(j);
			renderer.objects.get(j).setX((int) collisionObject.getX());
			renderer.objects.get(j).setY((int) collisionObject.getY());
			if ((collisionObject.getId()== ID.AlphaMolecule && tempobject.getType()=="alpha") ||
					(collisionObject.getId()== ID.BetaMolecule && tempobject.getType()=="beta") ||
					(collisionObject.getId()== ID.SigmaMolecule && tempobject.getType()=="sigma") ||
					(collisionObject.getId()== ID.GammaMolecule && tempobject.getType()=="gamma")
					) {
				Molecule collisionObject1 = (Molecule) collisionObject;
				UIMolecule molecule = (UIMolecule) renderer.objects.get(j);
				double a = collisionObject1.getX();
				double b = collisionObject1.getY();
				Rectangle2D r1= new Rectangle2D.Double(a,b,collisionObject1.getHeight(),collisionObject1.getWidth());
				if(r1.intersects(r) || r.intersects(r1)) {
					System.out.println("Collision");
					objects.remove(collisionObject);
//					tempobject.setX(objects.get(1).getX());
//					tempobject.setY(objects.get(1).getY());
//					objects.remove(tempobject);
					
					renderer.removeObject(molecule);
//					uicontroller.removeObject(atom);
					
					tempobject.setX(objects.get(1).getX());
					tempobject.setY(objects.get(1).getY());
					((Atom) tempobject).setShooted(false);
					
//					uicontroller.addObject(atom);
				}
			}
			}
	}
	
	private void setPowerupPositionsAndCheckCollision(GameObject tempobject) {
		Powerup tempobject1 = (Powerup) tempobject;
		UIPowerup pu = (UIPowerup) renderer.objects.get(0);
		double x = tempobject1.getX();
		double y =  tempobject1.getY();
		double x1= x + tempobject1.getDiameter();
		double y1= y+ tempobject1.getDiameter();
		if(tempobject1.isShooted()) {
			pu.setX(x);
			pu.setY(y);
		}else {
			tempobject.setX(objects.get(1).getX());
			tempobject.setY(objects.get(1).getY());
			
		}
		//TODO There is problem after atom lands.
		if(tempobject1.getY()> Toolkit.getDefaultToolkit().getScreenSize().getHeight()+ tempobject1.getWidth()/2) {
//    		tempobject1.setX(x);
//    		tempobject1.setY(y);
//    		tempobject1.setShooted(false);
//    		atomFalled=true;
    	}
		
		tempobject = tempobject1;
		Rectangle2D r= new Rectangle2D.Double(x,y,tempobject1.getDiameter(),tempobject1.getDiameter());
		// Collision with alpha molecule and alpha atom.
		for (int j = 0; j < objects.size(); j++) {
			if(objects.size()==0) {
				break;
			}
			GameObject collisionObject = (GameObject) objects.get(j);
			renderer.objects.get(j).setX((int) collisionObject.getX());
			renderer.objects.get(j).setY((int) collisionObject.getY());
			if ((collisionObject.getId()== ID.AlphaMolecule && tempobject.getType()=="alpha") ||
					(collisionObject.getId()== ID.BetaMolecule && tempobject.getType()=="beta") ||
					(collisionObject.getId()== ID.SigmaMolecule && tempobject.getType()=="sigma") ||
					(collisionObject.getId()== ID.GammaMolecule && tempobject.getType()=="gamma")
					) {
				Molecule collisionObject1 = (Molecule) collisionObject;
				UIMolecule molecule = (UIMolecule) renderer.objects.get(j);
				double a = collisionObject1.getX();
				double b = collisionObject1.getY();
				Rectangle2D r1= new Rectangle2D.Double(a,b,collisionObject1.getHeight(),collisionObject1.getWidth());
				if(r1.intersects(r) || r.intersects(r1)) {
					System.out.println("Collision");
					objects.remove(collisionObject);
//					tempobject.setX(objects.get(1).getX());
//					tempobject.setY(objects.get(1).getY());
//					objects.remove(tempobject);
					
					renderer.removeObject(molecule);
//					uicontroller.removeObject(atom);
					
					tempobject.setX(objects.get(1).getX());
					tempobject.setY(objects.get(1).getY());
					((Powerup) tempobject).setShooted(false);
//					uicontroller.addObject(atom);
				}
			}
			}
	}
	
	public void shootObject(GameObject shootingObject,AtomShooter shooter,double atomX) {
		double shooterRotationAngle=0;
		if(!shootingObject.isShooted()) {
			shootingObject.setShooted(true);
			System.out.println("Shoot");
			shooterRotationAngle = shooter.getRotationAngle();
			shootingObject.setRotationAngle(shooterRotationAngle);
			System.out.println(shootingObject.getRotationAngle());
			timerTask = new UpdateAtomTask(shootingObject,Toolkit.getDefaultToolkit().getScreenSize(),shooter);
			timer = new Timer(true);
	        timer.scheduleAtFixedRate(timerTask, 0, 40);
	        
//	        if(atom.getX()> WIDTH-atom.getDiameter()*2 && atom.getY()> HEIGHT-atom.getDiameter()*2) {
//	    		timer.cancel();
//	    	}
	        atomX = shooter.getX();
	        shootingObject.setX(atomX);
	        System.out.println(Thread.currentThread().getName()+" TimerTask started");
			
		}
	}
	
	public void moveShooter(AtomShooter shooter,GameObject shootingObject, String direction) {
		if(direction == "left") {
			if (shooter.getX() > 0)
				shooterX -=shooterMoveConstant;
				
			shooter.setX(shooterX);
			if(!shootingObject.isShooted()) {
				atomX = shooterX;
				shootingObject.setX(atomX);
			}
		}
		else if(direction=="right") {
			System.out.println("Move Shooter right");
			if (shooter.getX() < WIDTH - shooter.getWidth()) {
				shooterX +=shooterMoveConstant;
			}
			shooter.setX(shooterX);
			if(!shootingObject.isShooted()) {
				atomX = shooterX;
				shootingObject.setX(atomX);
				
			}
		}
	}
	
	public void rotateShooter(AtomShooter shooter, GameObject shootingObject, String direction) {
		double shooterRotationAngle= shooter.getRotationAngle();
		if(direction == "left") {
			System.out.println("Rotate shooter left");
			if(shooterRotationAngle > -90 ) {
				shooterRotationAngle -= rotationConstant;
				shooter.setRotationAngle(shooterRotationAngle);
				shootingObject.setRotationAngle(shooterRotationAngle);
				System.out.println(shootingObject.getRotationAngle());
			}
		}
		else if(direction=="right") {
			System.out.println("Rotate shooter right");
			if(shooterRotationAngle < 90) {
				shooterRotationAngle += rotationConstant;
				shooter.setRotationAngle(shooterRotationAngle);
				shootingObject.setRotationAngle(shooterRotationAngle);
			}
		}
	}
	public void pauseGame() {
		if(!isPaused) {
			System.out.println("PAUSED");
			if(timerTask!= null) {
				timerTask.cancel();
			}
			isPaused = true;

		}
	}
	public void resumeGame(AtomShooter shooter,GameObject shootingObject) {
		System.out.println("RESUME");
		if(isPaused) {
			timerTask = new UpdateAtomTask(shootingObject,Toolkit.getDefaultToolkit().getScreenSize(),shooter);
			setTimer(new Timer(true));
			timer.scheduleAtFixedRate(timerTask, 0, 100);
			isPaused= false;
		}
	}
	
	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	
	public void switchAtom() {
		GameObject shootingObject = getShootingObject();
		UIGameObject uiShootingObject = renderer.objects.get(0);
		System.out.println("Switch Atom");
		if(isAtom(shootingObject) && !shootingObject.isShooted()) {
			Atom atom = (Atom) shootingObject;
			Atom atom1= AtomFactory.getAtom(atom,"");
			System.out.println(atom1.getType());
			((UIAtom) uiShootingObject).setAtomType(atom1.getType());
		}
	}
	public boolean isAtom(GameObject tempobject) {
		if(tempobject.getType()=="alpha"|| tempobject.getType()=="beta"|| tempobject.getType()=="sigma"||
				tempobject.getType()=="gamma") {
			return true;
		}
		return false;
	}
	public void saveGame() {
		int score=100;
		int remainingTime=60;
		int atomCount = 8;
		ArrayList<Molecule> list= new ArrayList<Molecule>();
		//TODO add every molecule element into the list with for loop.
		Molecule alphaMol = new AlphaMolecule();
		Molecule betaMol = new BetaMolecule();
		
		//TODO Change all of the molecules which will come from building mode.
		alphaMol.setX(500);
		alphaMol.setY(500);
		list.add(betaMol);
		list.add(alphaMol);
		GameObject shootingObject= getShootingObject();
		save= new Save(username,score,remainingTime,shootingObject.getType(),shootingObject.isShooted(),shootingObject.getX(),shootingObject.getY(),shootingObject.getRotationAngle(),
				atomCount,atomCount,atomCount,atomCount,atomCount,atomCount,atomCount,atomCount,list);
		save.saveGame();
	}
	public void loadGame() {
		
//		System.out.println(save.loadGame(this));
		if(save==null) {
			save = new Save();
			System.out.println("new save");
		}
		JsonArray obj = (JsonArray) save.loadGame();
		System.out.println("object:"+obj);
//		game = new KuVid();
		username= obj.get(0).getAsJsonObject().get("username").getAsString();
		score= obj.get(0).getAsJsonObject().get("score").getAsInt();
		int remainingTime= obj.get(0).getAsJsonObject().get("remainingTime").getAsInt();
		String currentShootingObject= obj.get(0).getAsJsonObject().get("currentShootingObject").getAsString();
		System.out.println(currentShootingObject);
		double objectMovementAngle= obj.get(0).getAsJsonObject().get("objectMovementAngle").getAsDouble();
		double objectX= obj.get(0).getAsJsonObject().get("objectX").getAsDouble();
		double objectY= obj.get(0).getAsJsonObject().get("objectY").getAsDouble();
//		boolean isShooted = obj.get(0).getAsJsonObject().get("isShooted").getAsBoolean();
		GameObject shootingObject= getShootingObject();
		UIGameObject uiobject= renderer.objects.get(0);
		System.out.println(currentShootingObject);
		if(currentShootingObject.equals("alpha") || currentShootingObject.equals("beta") || currentShootingObject.equals("sigma") || currentShootingObject.equals("gamma")) {
//			shootingObject= new Atom(currentShootingObject);
//			uiobject = new UIAtom(shootingObject.getType());
////			uiobject.setHeight(diameter);
////			uiobject.setWidth(diameter);
//			((UIAtom)uiobject).setDiameter(diameter);
//			shootingObject.setHeight(diameter);
//			shootingObject.setWidth(diameter);
//			shootingObject.setSpeed(atomSpeed);
//			shootingObject.setRotationAngle(objectMovementAngle);
			
			//TODO Setting shootingObject does not work precisely.
			Atom atom1= AtomFactory.getAtom((Atom) getShootingObject(),currentShootingObject);
			((UIAtom) uiobject).setAtomType(atom1.getType());
		}else if(currentShootingObject.equals("+alpha") || currentShootingObject.equals("+beta") || currentShootingObject.equals("+sigma") || currentShootingObject.equals("+gamma")) {

//			shootingObject= new Powerup(currentShootingObject);
//			uiobject = new UIPowerup(currentShootingObject);
//			uiobject.setHeight(diameter*2);
//			uiobject.setWidth(diameter*2);
//			shootingObject.setHeight(diameter*2);
//			shootingObject.setWidth(diameter*2);
			Powerup pu1= PowerupFactory.getPU((Powerup) getShootingObject(),currentShootingObject);
			((UIPowerup) uiobject).setPUType(pu1.getType());
		}
		
		getShootingObject().setX(objectX);
		getShootingObject().setY(objectY);
		shootingObject.setRotationAngle(objectMovementAngle);
		
		//Molecules Load
		for(int i=1;i<obj.size();i++) {
			System.out.println(obj.get(i).getAsJsonObject().get("type"));
			Molecule molecule = MoleculeFactory.getMolecule(obj.get(i).getAsJsonObject().get("type").getAsString());
			molecule.setX(obj.get(i).getAsJsonObject().get("x").getAsDouble());
			molecule.setY(obj.get(i).getAsJsonObject().get("y").getAsDouble());
			System.out.println(molecule);
			this.objects.add(molecule);
			
			//TODO Change UIMolecule with UIMoleculeFactory
			UIMolecule uimolecule = UIMoleculeFactory.getMolecule(obj.get(i).getAsJsonObject().get("type").getAsString());
			
			uimolecule.setX(molecule.getX());
			uimolecule.setY(molecule.getY());
			renderer.objects.add(uimolecule);
		}
		
	}
	public GameObject getShootingObject() {
		return this.objects.get(0);
	}
	public static KuVid getGame() {
		return game;
	}

	public void addObject(int i, GameObject obj) {
		// TODO Auto-generated method stub
			this.objects.add(i,obj);
		
	}
}
