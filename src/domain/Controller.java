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
import domain.shield.*;
import domain.shooter.AtomShooter;
import ui.Frame;
import ui.KuVid;
import ui.UIAtom;
import ui.UIGameObject;
import ui.UIMoleculeFactory;
import ui.UIPowerup;
import ui.Renderer;
import ui.StatisticsWindow;
import ui.UIShooter;
import ui.UpdateAtomTask;
import ui.molecule.AlphaMoleculeUI;
import ui.molecule.UIMolecule;

public class Controller {
	public static double WIDTH =  Toolkit.getDefaultToolkit().getScreenSize().getWidth()-200,
			HEIGHT =  Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	Renderer renderer;
	private ArrayList<Powerup> collectedPowerups = new ArrayList<Powerup>();
	private int score = 0, time, counter = 0, lives = 3, initialMoleculeCount;
	private int alphaCount=100,betaCount=100,sigmaCount=100,gammaCount=100;
	private int alphaPUCount=20,betaPUCount=20,sigmaPUCount=20,gammaPUCount=20;
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
	double speed= 20;
	double shooterX= WIDTH/2;
	double shooterY =HEIGHT - shooterHeight*2;
	double atomX = shooterX+ diameter/2;
	double atomY = shooterY -diameter*2;
	double rotationConstant = 10;
	double atomSpeed=L/5;
	double shooterMoveConstant = 15;
	private boolean isPaused = false;
	private boolean isLoaded = false;
	public double fallingSpeed = atomSpeed;
	TimerTask timerTask ;
	Timer timer;
	SaveLoadAdapter save;
	Random random = new Random();
	StatisticsWindow statsWindow = StatisticsWindow.getInstance();
	String username="mehmet";
	private static KuVid game;
	public Controller(Renderer UI, Frame frame) {
		this.renderer = UI;
		this.frame = frame;
	}
	
	// Set the shooted object to be 0th in list.
	
	public void update() {
		// TODO Auto-generated method stub
		statsWindow.getAlphaLabel().setText(Integer.toString(alphaCount));
		statsWindow.getBetaLabel().setText(Integer.toString(betaCount));
		statsWindow.getSigmaLabel().setText(Integer.toString(sigmaCount));
		statsWindow.getGammaLabel().setText(Integer.toString(gammaCount));
		statsWindow.getAlphaPULabel().setText(Integer.toString(alphaPUCount));
		statsWindow.getBetaPULabel().setText(Integer.toString(betaPUCount));
		statsWindow.getSigmaPULabel().setText(Integer.toString(sigmaPUCount));
		statsWindow.getGammaPULabel().setText(Integer.toString(gammaPUCount));
		renderer.setScore(score);
		renderer.setLives(lives);
		statsWindow.getScore().setText(Integer.toString(score));
		// Remaining timer
		int timeAsSecond= time;
		String minute=Integer.toString(timeAsSecond/60);
		String second= Integer.toString(timeAsSecond%60);
		if(timeAsSecond%60 ==0) {
			second += "0";
		}
		statsWindow.getTime().setText(minute+":"+second);
		if(time==0 && !frame.isBuildMode()) {
			System.out.println("Time is Up! Game Over");
			
		}
		
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
				}
//			if (tempobject.getType() == "shooter") {
			if (i==1) {
				AtomShooter tempobject1= (AtomShooter) tempobject;
				UIShooter shooter = (UIShooter) renderer.objects.get(i);
				int x = (int) tempobject.getX();
				int y = (int) tempobject.getY();
				double rotation = tempobject.getRotationAngle();
				shooter.setX(x);
				shooter.setY(y);
				shooter.setRotationAngle(rotation);
				shooterCollision(tempobject1);
				}
//			System.out.println(tempobject.getType());
			if(tempobject.getType()!=null) {
				if (i!=0 && (tempobject.getType().equals("+alpha") ||
						tempobject.getType().equals("+beta") || 
						tempobject.getType().equals("+sigma") ||
						tempobject.getType().equals("+gamma"))) {
					Powerup tempobject1=(Powerup) tempobject;
					if(!frame.isBuildMode()) {
						tempobject1.setSpeed(fallingSpeed);
					}
					tempobject1.fallInStraightLine(tempobject1.getX(), tempobject1.getY());
	//				UIPowerup uipowerup = (UIPowerup) renderer.objects.get(i);
	//				uipowerup.setX(tempobject1.getX());
	//				uipowerup.setY(tempobject1.getY());
				}
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
		if(!tempobject1.isShooted()) {
			// TODO this will change. Will be added, when atom is destroyed put new atom from existing ones.
			x=objects.get(1).getX()+tempobject1.getDiameter()/3;
			y=objects.get(1).getY()-tempobject1.getDiameter()*3;
			tempobject.setX(x);
			tempobject.setY(y);
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
					if(timerTask !=null) {
						timerTask.cancel();
					}
					renderer.removeObject(molecule);
//					uicontroller.removeObject(atom);
					
					tempobject.setX(objects.get(1).getX());
					tempobject.setY(objects.get(1).getY());
					tempobject.setRotationAngle(getShooter().getRotationAngle());
					((Atom) tempobject).setShooted(false);
					score++;
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
			x=objects.get(1).getX()-tempobject1.getWidth();
			y=objects.get(1).getY()-tempobject1.getHeight()*4;
			tempobject.setX(x);
			tempobject.setY(y);
			
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
		for (int j = 0; j < objects.size(); j++) {
			if(objects.size()==0) {
				break;
			}
			GameObject collisionObject = (GameObject) objects.get(j);
			renderer.objects.get(j).setX((int) collisionObject.getX());
			renderer.objects.get(j).setY((int) collisionObject.getY());
			
			//Powerup and Reaction Blocker collision
			if ((collisionObject.getId()== ID.AlphaBlocker && tempobject.getType()=="+alpha") ||
					(collisionObject.getId()== ID.BetaBlocker && tempobject.getType()=="+beta") ||
					(collisionObject.getId()== ID.SigmaBlocker && tempobject.getType()=="+sigma") ||
					(collisionObject.getId()== ID.GammaBlocker && tempobject.getType()=="+gamma")
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
					
					// TODO Add when blocker is completed.
					if(timerTask !=null) {
						timerTask.cancel();
					}
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
	
	public void shootObject(GameObject shootingObject,AtomShooter shooter) {
		double shooterRotationAngle=0;
		if(!shootingObject.isShooted() && checkObjectScore(shootingObject.getType())>0) {
			shootingObject.setShooted(true);
			System.out.println("Shoot");
			shooterRotationAngle = shooter.getRotationAngle();
			shootingObject.setRotationAngle(shooterRotationAngle);
//			System.out.println(shootingObject.getRotationAngle());
			timerTask = new UpdateAtomTask(shootingObject,Toolkit.getDefaultToolkit().getScreenSize(),shooter);
			timer = new Timer(true);
	        timer.scheduleAtFixedRate(timerTask, 0, 40);
	        updateObjectScore(shootingObject.getType());
//	        if(atom.getX()> WIDTH-atom.getDiameter()*2 && atom.getY()> HEIGHT-atom.getDiameter()*2) {
//	    		timer.cancel();
//	    	}
	        atomX = shooter.getX();
	        shootingObject.setX(atomX);
	        System.out.println(Thread.currentThread().getName()+" TimerTask started");
			
		}
		else {
			System.out.println("The object is already shooted or there is not enough of object:"+ shootingObject.getType());
		}
	}
	
	public void moveShooter(AtomShooter shooter,GameObject shootingObject, String direction) {
		if(direction == "left") {
			if (shooter.getX() > 0)
				shooterX -=shooterMoveConstant;
				
			shooter.setX(shooterX);
			if(!shootingObject.isShooted()) {
				atomX = shooterX+shootingObject.getWidth();
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
				atomX = shooterX+shootingObject.getWidth();
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
		ArrayList<GameObject> moleculeList= new ArrayList<GameObject>();
		for(int i=2;i<objects.size();i++) {
			moleculeList.add(objects.get(i));
		}
		GameObject shootingObject= getShootingObject();
		save= new SaveLoadAdapter(new Save(username,score,time,shootingObject.getType(),shootingObject.isShooted(),shootingObject.getX(),shootingObject.getY(),shootingObject.getRotationAngle(),
				alphaCount,betaCount,sigmaCount,gammaCount,alphaPUCount,betaPUCount,sigmaPUCount,gammaPUCount,moleculeList,this,speed));
		save.saveGame();
	}
	public void loadGame() {
		
		if(!isLoaded) {
			isLoaded= true;
			if(save==null) {
				save = new SaveLoadAdapter(new Save(username,this));
				System.out.println("new save");
			}
			save.loadGame();
		}
		
	}
	public GameObject getShootingObject() {
		return this.objects.get(0);
	}
	public GameObject setShootingObject(GameObject obj) {
		return this.objects.set(0,obj);
	}
	public UIGameObject getUIShootingObject() {
		return this.renderer.objects.get(0);
	}
	public Renderer getRenderer() {
		return this.renderer;
	}
	public static KuVid getGame() {
		return game;
	}

	public void addObject(int i, GameObject obj) {
		// TODO Auto-generated method stub
			this.objects.add(i,obj);
		
	}
	public GameObject getShooter() {
		return this.objects.get(1);
	}
	
	private void updateObjectScore(String type) {
		if(type.equals("alpha")) {
			alphaCount--;
			System.out.println(alphaCount);
		}
		else if(type.equals("beta")) {
			betaCount--;
		}
		else if(type.equals("sigma")) {
			sigmaCount--;
		}
		else if(type.equals("gamma")) {
			gammaCount--;
		}
		else if(type.equals("+alpha")) {
			alphaPUCount--;
		}
		else if(type.equals("+beta")) {
			betaPUCount--;
		}
		else if(type.equals("+sigma")) {
			sigmaPUCount--;
		}
		else {
			gammaPUCount--;
		}
	}
	private void increasePUScore(String type) {
		
		if(type.equals("+alpha")) {
			alphaPUCount++;
		}
		else if(type.equals("+beta")) {
			betaPUCount++;
		}
		else if(type.equals("+sigma")) {
			sigmaPUCount++;
		}
		else {
			gammaPUCount++;
		}
	}
	private int checkObjectScore(String type) {
		if(type.equals("alpha")) {
			return alphaCount;
		}
		else if(type.equals("beta")) {
			return betaCount;
		}
		else if(type.equals("sigma")) {
			return sigmaCount;
		}
		else if(type.equals("gamma")) {
			return gammaCount;
		}
		else if(type.equals("+alpha")) {
			return alphaPUCount;
		}
		else if(type.equals("+beta")) {
			return betaPUCount;
		}
		else if(type.equals("+sigma")) {
			return sigmaPUCount;
		}
		else {
			return gammaPUCount;
		}
	}
	private void shooterCollision(AtomShooter shooter) {
		UIShooter uishooter = (UIShooter) renderer.objects.get(1);
		int x = (int) shooter.getX();
		int y = (int) shooter.getY();
		Rectangle2D r= new Rectangle2D.Double(x,y,shooter.getWidth(),shooter.getHeight());
		// Collision with alpha molecule and alpha atom.
		for (int j = 2; j < objects.size(); j++) {
			if(objects.size()==0) {
				break;
			}
			GameObject collisionObject = (GameObject) objects.get(j);
			if(collisionObject.getType()!=null) {
				if (collisionObject.getType().equals("+alpha") || collisionObject.getType().equals("+beta") ||
						collisionObject.getType().equals("+sigma") || collisionObject.getType().equals("+gamma")) {
					Powerup collisionObject1 = (Powerup) collisionObject;
					UIPowerup pu = (UIPowerup) renderer.objects.get(j);
					double a = collisionObject1.getX();
					double b = collisionObject1.getY();
					Rectangle2D r1= new Rectangle2D.Double(a,b,collisionObject1.getHeight(),collisionObject1.getWidth());
					if(r1.intersects(r) || r.intersects(r1)) {
						System.out.println("Collision");
						objects.remove(collisionObject);
						renderer.removeObject(pu);
						increasePUScore(collisionObject.getType());
						
					}
				}
			}
		}
	}

	public void setAlphaCount(int alphaCount) {
		this.alphaCount = alphaCount;
	}

	public void setBetaCount(int betaCount) {
		this.betaCount = betaCount;
	}

	public void setSigmaCount(int sigmaCount) {
		this.sigmaCount = sigmaCount;
	}

	public void setGammaCount(int gammaCount) {
		this.gammaCount = gammaCount;
	}

	public void setBetaPUCount(int betaPUCount) {
		this.betaPUCount = betaPUCount;
	}

	public int getAlphaCount() {
		return alphaCount;
	}

	public int getBetaCount() {
		return betaCount;
	}

	public int getSigmaCount() {
		return sigmaCount;
	}

	public int getGammaCount() {
		return gammaCount;
	}

	public int getAlphaPUCount() {
		return alphaPUCount;
	}

	public void setAlphaPUCount(int alphaPUCount) {
		this.alphaPUCount = alphaPUCount;
	}

	public int getSigmaPUCount() {
		return sigmaPUCount;
	}

	public void setSigmaPUCount(int sigmaPUCount) {
		this.sigmaPUCount = sigmaPUCount;
	}

	public int getGammaPUCount() {
		return gammaPUCount;
	}

	public void setGammaPUCount(int gammaPUCount) {
		this.gammaPUCount = gammaPUCount;
	}

	public int getBetaPUCount() {
		return betaPUCount;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void shieldClicked(String type) {
		// TODO Auto-generated method stub
	if(isAtom(getShootingObject())) {
		Atom shootingObject= (Atom) getShootingObject();
		if(type.equals("eta")) {
			setShootingObject(new Eta(shootingObject));
			
		}
		else if(type.equals("lota")) {
			setShootingObject(new Lota(shootingObject));
		}
		else if(type.equals("theta")) {
			setShootingObject(new Theta(shootingObject));
		}
		else {
			setShootingObject(new Zeta(shootingObject));
		}
	}
	System.out.println(((Atom)getShootingObject()).getEfficiency());
	}
	
	
	
}
