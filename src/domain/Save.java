package domain;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;

import domain.atom.Atom;

public class Save {
	String username;
	Atom atom;
	public Save(String username
			, int score, int remainingTime, String currentAtom, double atomMovementAngle,
			int alphaAtomCount,int betaAtomCount,int sigmaAtomCount,int gammaAtomCount, 
			int alphaPUCount,int betaPUCount,int sigmaPUCount,int gammaPUCount) 
	{
		this.username=username;
		// TODO Auto-generated constructor stub
		JsonObject obj= new JsonObject();
		Gson gson = new GsonBuilder().create();
		
		
		//all the variables are trivial for now.
		obj.addProperty("username", "mehmet");
		obj.addProperty("score", 100);
		
		//Remaining time as seconds.
		obj.addProperty("remainingTime", 40);
		obj.addProperty("currentAtom", "alpha");
		
		//Movement angle double.
		obj.addProperty("atomMovementAngle", 0.5);
		//Atoms
		obj.addProperty("alphaAtom", 8);
		obj.addProperty("betaAtom", 8);
		obj.addProperty("sigmaAtom", 8);
		obj.addProperty("gammaAtom", 8);
		
		//Powerups
		obj.addProperty("alphaPU", 8);
		obj.addProperty("betaPU", 8);
		obj.addProperty("sigmaPU", 8);
		obj.addProperty("gammaPU", 8);
		
		
		//molecule and its position (position as string, must do split.)
		obj.addProperty("alphaMolecule", "10,10");
		obj.addProperty("betaMolecule", "10,10");
		obj.addProperty("sigmaMolecule", "10,10");
		obj.addProperty("gammaMolecule", "10,10");
		FileWriter writer;
		try {
			writer = new FileWriter("saves.txt");
			gson.toJson(obj,writer);
//			gson.toJson(atom,writer);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("done");
		
		
		System.out.println(obj);
	}

}
