package domain;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import domain.atom.Atom;
import domain.atom.AtomFactory;
import domain.molecule.MoleculeFactory;
import domain.powerup.Powerup;
import domain.powerup.PowerupFactory;
import ui.UIAtom;
import ui.UIGameObject;
import ui.UIMoleculeFactory;
import ui.UIPowerup;
import ui.molecule.UIMolecule;

/**
 * @author MehmetUstek
 *
 */
public class Save implements ISaveLoad {
	/**
	 * OVERVIEW: This class is saver and loader class which uses JSON file to save and load the game.
	 */
	String username="",currentShootingObject="";
	double objectMovementAngle=0,objectX=0,objectY=0, score=0;
	int remainingTime=0, alphaAtomCount=0, betaAtomCount=0,sigmaAtomCount=0,gammaAtomCount=0, 
	alphaPUCount=0,betaPUCount=0,sigmaPUCount=0,gammaPUCount=0,
	etaCount= 0, lotaCount= 0, thetaCount = 0, zetaCount =0;
	ArrayList<GameObject> list;
	Controller controller;
	boolean isShooted;
	Save instance;
	double speed;
	double diameter= Controller.L/10;
	public Save(Controller controller)
	{
		
		this.controller= controller;
		this.username=controller.getUsername();
		this.score=controller.getScore();
		this.remainingTime= controller.getTime();
		this.speed= controller.getSpeed();
		this.etaCount=controller.getEtaCount();
		this.lotaCount=controller.getLotaCount();
		this.thetaCount= controller.getThetaCount();
		this.zetaCount= controller.getZetaCount();
		this.alphaAtomCount= controller.getAlphaCount();
		this.betaAtomCount= controller.getBetaCount();
		this.sigmaAtomCount= controller.getSigmaCount();
		this.gammaAtomCount= controller.getGammaCount();
		this.alphaPUCount= controller.getAlphaPUCount();
		this.betaPUCount= controller.getBetaPUCount();
		this.sigmaPUCount= controller.getSigmaPUCount();
		this.gammaPUCount= controller.getGammaPUCount();
		
		
	}
	public Save(String username,Controller controller) {
		this.username= username;
		this.controller= controller;
	}
	public Save(String username,Controller controller, ArrayList<GameObject> list,int remainingTime) {
		this.controller= controller;
		this.username= username;
		this.list= list;
		this.speed= controller.getSpeed();
		this.remainingTime= remainingTime;
		this.alphaAtomCount=controller.getAlphaCount();
		this.betaAtomCount= controller.getBetaCount();
		this.sigmaAtomCount= controller.getSigmaCount();
		this.gammaAtomCount= controller.getGammaCount();
		this.etaCount= controller.getEtaCount();
		this.lotaCount= controller.getLotaCount();
		this.thetaCount= controller.getThetaCount();
		this.zetaCount= controller.getZetaCount();
	}
	public void saveGame() {
		/**
		 * @requires the game's must-save objects which are username, score, time, shooting object's position, angle etc.
		 * @modifies the JSON file which the game is saved.
		 * @effects write the specified keys to the JSON file. The structure will be i.e "username":"mehmet".
		 * The saved file is "username"_saves.txt i.e mehmet_saves.txt
		 */
		JsonObject obj= new JsonObject();
		Gson gson = new GsonBuilder().create();
		JsonArray array = new JsonArray();
		
		obj.addProperty("username", username);
		obj.addProperty("score", score);
		obj.addProperty("speed", speed);
		//Remaining time as seconds.
		obj.addProperty("remainingTime", remainingTime);
		
		//Shooting Object
		currentShootingObject= controller.getShootingObject().getType();
		isShooted= controller.getShootingObject().isShooted();
		objectX = controller.getShootingObject().getX();
		objectY = controller.getShootingObject().getY();
		objectMovementAngle= controller.getShootingObject().getRotationAngle();
		obj.addProperty("currentShootingObject", currentShootingObject);
		obj.addProperty("objectX", objectX);
		obj.addProperty("objectY", objectY);
		obj.addProperty("isShooted", isShooted);
		
		//Movement angle double.
		obj.addProperty("objectMovementAngle", objectMovementAngle);
		
		
		//Atoms
		obj.addProperty("alphaAtom", alphaAtomCount);
		obj.addProperty("betaAtom", betaAtomCount);
		obj.addProperty("sigmaAtom", sigmaAtomCount);
		obj.addProperty("gammaAtom", gammaAtomCount);
		
		//Powerups
		obj.addProperty("alphaPU", alphaPUCount);
		obj.addProperty("betaPU", betaPUCount);
		obj.addProperty("sigmaPU", sigmaPUCount);
		obj.addProperty("gammaPU", gammaPUCount);
		
		//Shields
		obj.addProperty("eta", etaCount);
		obj.addProperty("lota", lotaCount);
		obj.addProperty("theta", thetaCount);
		obj.addProperty("zeta", zetaCount);
		
		
		//molecule and its position (position as string, must do split.)
		
		array.add(obj);
		// The first element of the array is the areas indicated above.
		// The next element is the atom location.
		// The very next element may be shooter location.
		// And the rest is molecule location.
		
		// Atom Location
		
		// Molecule locations.
//		for(int i=0;i<list.size();i++) {
//			JsonObject moleculePositions= new JsonObject();
//			moleculePositions.addProperty("type", list.get(i).getId().toString());
//			moleculePositions.addProperty("x", list.get(i).getX());
//			moleculePositions.addProperty("y", list.get(i).getY());
//			array.add(moleculePositions);
//		}
		for(int i=2;i<controller.objects.size();i++) {
			list.add(controller.objects.get(i));
		}
		// Molecule and Powerup & Reaction Blockers
		for(int i=0;i<list.size();i++) {
			JsonObject puPositions= new JsonObject();
			puPositions.addProperty("type", list.get(i).getType());
			puPositions.addProperty("x", list.get(i).getX());
			puPositions.addProperty("y", list.get(i).getY());
			puPositions.addProperty("speed", list.get(i).getSpeed());
			array.add(puPositions);
		}
		
		FileWriter writer;
		try {
			writer = new FileWriter(username+"_saves.txt");
//			gson.toJson(obj,writer);
//			gson.toJson(moleculePositions,writer);
//			gson.toJson(atom,writer);
			gson.toJson(array,writer);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("done");
		
		
//		System.out.println(obj);
	}
	public void loadGame() {
		/**
		 * @requires the game has to be saved at least once for that username. 
		 * @effects brings the values from JSON file and assigns them into controller object's corresponding values.
		 * The file that will be load has a structure such "username"_saves.txt.
		 */
		
		Gson gson = new Gson();
		JsonReader reader;
		JsonArray obj = new JsonArray();
		try {
			System.out.println("username is:"+username);
			reader = new JsonReader(new FileReader(username+"_saves.txt"));
			obj= gson.fromJson(reader, JsonArray.class);
//			System.out.println(obj);
			username= obj.get(0).getAsJsonObject().get("username").getAsString();
			score= obj.get(0).getAsJsonObject().get("score").getAsInt();
			speed= obj.get(0).getAsJsonObject().get("speed").getAsDouble();
			alphaAtomCount= obj.get(0).getAsJsonObject().get("alphaAtom").getAsInt();
			betaAtomCount= obj.get(0).getAsJsonObject().get("betaAtom").getAsInt();
			sigmaAtomCount= obj.get(0).getAsJsonObject().get("sigmaAtom").getAsInt();
			gammaAtomCount= obj.get(0).getAsJsonObject().get("gammaAtom").getAsInt();
			
			//Shields
			etaCount= obj.get(0).getAsJsonObject().get("eta").getAsInt();
			lotaCount= obj.get(0).getAsJsonObject().get("lota").getAsInt();
			thetaCount= obj.get(0).getAsJsonObject().get("theta").getAsInt();
			zetaCount= obj.get(0).getAsJsonObject().get("zeta").getAsInt();
			
			int remainingTime= obj.get(0).getAsJsonObject().get("remainingTime").getAsInt();
			String currentShootingObject= obj.get(0).getAsJsonObject().get("currentShootingObject").getAsString();
//			System.out.println(currentShootingObject);
			double objectMovementAngle= obj.get(0).getAsJsonObject().get("objectMovementAngle").getAsDouble();
			double objectX= obj.get(0).getAsJsonObject().get("objectX").getAsDouble();
			double objectY= obj.get(0).getAsJsonObject().get("objectY").getAsDouble();
			boolean isShooted = obj.get(0).getAsJsonObject().get("isShooted").getAsBoolean();
			GameObject shootingObject= controller.getShootingObject();
			UIGameObject uiobject= controller.getUIShootingObject();
//			System.out.println(currentShootingObject);
			
			//Shields
			controller.setEtaCount(etaCount);
			controller.setLotaCount(lotaCount);
			controller.setThetaCount(thetaCount);
			controller.setZetaCount(zetaCount);
			
			//Time
			controller.setTime(remainingTime);
			controller.setSpeed(speed);
			
			//Shooting Object load
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
				Atom atom1= AtomFactory.getAtom((Atom) shootingObject,currentShootingObject);
				((UIAtom) uiobject).setAtomType(atom1.getType());
			}else if(currentShootingObject.equals("+alpha") || currentShootingObject.equals("+beta") || currentShootingObject.equals("+sigma") || currentShootingObject.equals("+gamma")) {
	
	//			shootingObject= new Powerup(currentShootingObject);
	//			uiobject = new UIPowerup(currentShootingObject);
	//			uiobject.setHeight(diameter*2);
	//			uiobject.setWidth(diameter*2);
	//			shootingObject.setHeight(diameter*2);
	//			shootingObject.setWidth(diameter*2);
				Powerup pu1= PowerupFactory.getPU((Powerup) shootingObject,currentShootingObject);
				((UIPowerup) uiobject).setPUType(pu1.getType());
			}
			controller.getShootingObject().setShooted(isShooted);
			controller.getShootingObject().setX(objectX);
			controller.getShootingObject().setY(objectY);
			controller.getShootingObject().setRotationAngle(objectMovementAngle);
			
			
			//Molecules Load
			for(int i=1;i<obj.size();i++) {
				String s= obj.get(i).getAsJsonObject().get("type").getAsString();
				if(isMolecule(s)) {
					GameObject molecule = MoleculeFactory.getMolecule(obj.get(i).getAsJsonObject().get("type").getAsString());
					molecule.setX(obj.get(i).getAsJsonObject().get("x").getAsDouble());
					molecule.setY(obj.get(i).getAsJsonObject().get("y").getAsDouble());
					controller.objects.add(molecule);
					
					//TODO Change UIMolecule with UIMoleculeFactory
					UIMolecule uimolecule = UIMoleculeFactory.getMolecule(obj.get(i).getAsJsonObject().get("type").getAsString());
					
					uimolecule.setX(molecule.getX());
					uimolecule.setY(molecule.getY());
					controller.getRenderer().objects.add(uimolecule);
				}
				else if(isPowerup(s)){
					Powerup pu = PowerupFactory.getPU(s);
					pu.setX(obj.get(i).getAsJsonObject().get("x").getAsDouble());
					pu.setY(obj.get(i).getAsJsonObject().get("y").getAsDouble());
					pu.setWidth(diameter*2);
					pu.setHeight(diameter*2);
//					pu.setRotationAngle(0);
					pu.setSpeed(obj.get(i).getAsJsonObject().get("speed").getAsDouble());
//					System.out.println(pu.getSpeed());
					controller.addObject(pu);
					UIPowerup uiPu = new UIPowerup(pu.getType());
					controller.renderer.objects.add(uiPu);
				}
			}
			
			
			// Loading the Atom counts on the game.
			controller.setAlphaCount(alphaAtomCount);
			controller.setBetaCount(betaAtomCount);
			controller.setSigmaCount(sigmaAtomCount);
			controller.setGammaCount(gammaAtomCount);
			
		
			reader.close();
			
//			return obj;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
//	public Save getInstance() {
//		if(instance==null) {
//			return new Save(username,controller);
//		}
//		return instance;
//	}

	private boolean isMolecule(String s) {
		if(s.equals("AlphaMolecule") || s.equals("BetaMolecule") || s.equals("SigmaMolecule") || s.equals("GammaMolecule")) {
			return true;
		}
		return false;
	}
	private boolean isPowerup(String s) {
		if(s.equals("+alpha") || s.equals("+beta") || s.equals("+sigma") || s.equals("+gamma")) {
			return true;
		}
		return false;
	}
}
