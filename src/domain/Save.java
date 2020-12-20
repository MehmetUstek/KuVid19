package domain;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import domain.atom.Atom;
import domain.molecule.Molecule;
import domain.molecule.MoleculeFactory;
import domain.powerup.Powerup;

public class Save {
	String username="",currentShootingObject="";
	double objectMovementAngle=0,objectX=0,objectY=0;
	int score=0,  remainingTime=0, alphaAtomCount=0, betaAtomCount=0,sigmaAtomCount=0,gammaAtomCount=0, 
	alphaPUCount=0,betaPUCount=0,sigmaPUCount=0,gammaPUCount=0;
	ArrayList<Molecule> list;
	Controller controller;
	boolean isShooted;
	public Save(String username
			, int score, int remainingTime, String currentShootingObject,boolean isShooted,double objectX, double objectY, double objectMovementAngle,
			int alphaAtomCount,int betaAtomCount,int sigmaAtomCount,int gammaAtomCount, 
			int alphaPUCount,int betaPUCount,int sigmaPUCount,int gammaPUCount,ArrayList<Molecule> list) 
	{
		this.username=username;
		this.score=score;
		this.remainingTime= remainingTime;
		this.currentShootingObject= currentShootingObject;
		this.objectMovementAngle= objectMovementAngle;
		this.alphaAtomCount= alphaAtomCount;
		this.betaAtomCount= betaAtomCount;
		this.sigmaAtomCount= sigmaAtomCount;
		this.gammaAtomCount= gammaAtomCount;
		this.alphaPUCount= alphaPUCount;
		this.betaPUCount= betaPUCount;
		this.sigmaPUCount= sigmaPUCount;
		this.gammaPUCount= gammaPUCount;
		this.list= list;
		this.objectX=objectX;
		this.objectY=objectY;
		this.isShooted= isShooted;
		
		
		// TODO Auto-generated constructor stub
		
	}
	public Save() {
		
	}
	public Save(ArrayList<Molecule> list) {
		this.list= list;
	}
	public void saveGame() {
		JsonObject obj= new JsonObject();
		Gson gson = new GsonBuilder().create();
		JsonArray array = new JsonArray();
		
		//all the variables are trivial for now.
		obj.addProperty("username", username);
		obj.addProperty("score", score);
		
		//Remaining time as seconds.
		obj.addProperty("remainingTime", remainingTime);
		
		//Object
		obj.addProperty("currentShootingObject", currentShootingObject);
		obj.addProperty("objectX", objectX);
		obj.addProperty("objectY", objectY);
		
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
		
		
		//molecule and its position (position as string, must do split.)
		
		array.add(obj);
		// The first element of the array is the areas indicated above.
		// The next element is the atom location.
		// The very next element may be shooter location.
		// And the rest is molecule location.
		
		// Atom Location
		
		// Molecule locations.
		for(int i=0;i<list.size();i++) {
			JsonObject moleculePositions= new JsonObject();
			moleculePositions.addProperty("type", list.get(i).getId().toString());
			moleculePositions.addProperty("x", list.get(i).getX());
			moleculePositions.addProperty("y", list.get(i).getY());
			array.add(moleculePositions);
		}
		
		FileWriter writer;
		try {
			writer = new FileWriter("saves.txt");
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
		
		
		System.out.println(obj);
	}
	public JsonElement loadGame() {
		Gson gson = new Gson();
		JsonReader reader;
		ArrayList controllerNewObjects= new ArrayList<GameObject>();
		try {
			reader = new JsonReader(new FileReader("saves.txt"));
			JsonArray obj= gson.fromJson(reader, JsonArray.class);
			
//			// Atom Load
//			username= obj.get(0).getAsJsonObject().get("username").getAsString();
//			score= obj.get(0).getAsJsonObject().get("score").getAsInt();
//			remainingTime= obj.get(0).getAsJsonObject().get("remainingTime").getAsInt();
//			currentShootingObject= obj.get(0).getAsJsonObject().get("currentShootingObject").getAsString();
//			objectMovementAngle= obj.get(0).getAsJsonObject().get("objectMovementAngle").getAsDouble();
////			currentShootingObject= obj.get(0).getAsJsonObject().get("currentShootingObject").getAsString();
////			objectMovementAngle= obj.get(0).getAsJsonObject().get("objectMovementAngle").getAsDouble();
//			
//			
//			
//			//Molecules Load
//			for(int i=1;i<obj.size();i++) {
//				System.out.println(obj.get(i).getAsJsonObject().get("type"));
//				Molecule molecule = MoleculeFactory.getMolecule(obj.get(i).getAsJsonObject().get("type").getAsString());
//				
//				molecule.setX(obj.get(i).getAsJsonObject().get("x").getAsDouble());
//				molecule.setY(obj.get(i).getAsJsonObject().get("y").getAsDouble());
//				System.out.println(molecule);
//			}
//			
//			GameObject shootingObject;
//			if(currentShootingObject=="alpha" ||currentShootingObject=="beta" || currentShootingObject=="sigma" || currentShootingObject=="gamma") {
//				shootingObject= new Atom(currentShootingObject);
//			}else {
//				shootingObject= new Powerup(currentShootingObject);
//			}
//			
////			controller.objects.set(0, shootingObject);
//			
////			 Add objects to a list and then to controller.
////			controllerNewObjects.add(0,"lol");
//			
////			controller.addObject(null);
//			reader.close();
			return obj;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}

}
