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

public class Save {
	String username,currentShootingObject;
	double objectMovementAngle;
	int score,  remainingTime, alphaAtomCount, betaAtomCount,sigmaAtomCount,gammaAtomCount, 
	alphaPUCount,betaPUCount,sigmaPUCount,gammaPUCount;
	ArrayList<Molecule> list;
	Controller controller;
	public Save(String username
			, int score, int remainingTime, String currentShootingObject, double objectMovementAngle,
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
		this.controller= controller;
		
		
		// TODO Auto-generated constructor stub
		
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
		obj.addProperty("currentShootingObject", currentShootingObject);
		
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
		obj.addProperty("alphaMolecule", "10,10");
		obj.addProperty("betaMolecule", "10,10");
		obj.addProperty("sigmaMolecule", "10,10");
		obj.addProperty("gammaMolecule", "10,10");
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
	public JsonElement loadGame(Controller controller) {
		Gson gson = new Gson();
		JsonReader reader;
		ArrayList controllerNewObjects= new ArrayList<GameObject>();
		try {
			reader = new JsonReader(new FileReader("saves.txt"));
			JsonArray obj= gson.fromJson(reader, JsonArray.class);
			
			// Atom Load
			username= obj.get(0).getAsJsonObject().get("username").getAsString();
			score= obj.get(0).getAsJsonObject().get("score").getAsInt();
			remainingTime= obj.get(0).getAsJsonObject().get("remainingTime").getAsInt();
			currentShootingObject= obj.get(0).getAsJsonObject().get("currentShootingObject").getAsString();
			objectMovementAngle= obj.get(0).getAsJsonObject().get("objectMovementAngle").getAsDouble();
			currentShootingObject= obj.get(0).getAsJsonObject().get("currentShootingObject").getAsString();
			objectMovementAngle= obj.get(0).getAsJsonObject().get("objectMovementAngle").getAsDouble();
			
			
			
			//Molecules Load
			for(int i=1;i<obj.size();i++) {
				System.out.println(obj.get(i).getAsJsonObject().get("type"));
				Molecule molecule = MoleculeFactory.getMolecule(obj.get(i).getAsJsonObject().get("type").getAsString());
				
				molecule.setX(obj.get(i).getAsJsonObject().get("x").getAsDouble());
				molecule.setY(obj.get(i).getAsJsonObject().get("y").getAsDouble());
				System.out.println(molecule);
			}
			
			
			// Add objects to a list and then to controller.
//			controllerNewObjects.add(0,)
			
			controller.addObject(null);
			reader.close();
			return obj;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}

}
