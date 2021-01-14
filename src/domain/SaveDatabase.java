package domain;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.google.gson.JsonObject;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;

import org.bson.BsonArray;
import org.bson.Document;
import org.bson.conversions.Bson;

public class SaveDatabase implements ISaveLoad{
	String username="",currentShootingObject="";
	double objectMovementAngle=0,objectX=0,objectY=0, score=0;
	int lengthL=0,remainingTime=0, alphaAtomCount=0, betaAtomCount=0,sigmaAtomCount=0,gammaAtomCount=0, 
	alphaPUCount=0,betaPUCount=0,sigmaPUCount=0,gammaPUCount=0,
	etaCount= 0, lotaCount= 0, thetaCount = 0, zetaCount =0,health=100;
	ArrayList<GameObject> list;
	Controller controller;
	boolean isShooted;
	Save instance;
	double speed;
	double diameter= Controller.L/4;
	public SaveDatabase(Controller controller) {
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
		this.lengthL= controller.getLengthL();
		this.health= controller.getHealth();
		
		
	}
	public void saveGame() {
		
		Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
		mongoLogger.setLevel(Level.SEVERE); // e.g. or Log.WARNING, etc.	
		MongoClient mongoClient = MongoClients.create("mongodb+srv://comp302_user:comp302_password@sandbox.v2mqr.mongodb.net/");
	      // Creating Credentials 
//	      MongoCredential credential; 
//	      credential = MongoCredential.createCredential("mehmet", "TeamPass", 
//	         "mehmet".toCharArray()); 
		MongoDatabase database = mongoClient.getDatabase("Comp302"); // selecting the database 
		System.out.println("asaad");
//		database.createCollection("KuVid");
		
		MongoCollection<Document> collection = database.getCollection("TeamPassCollection"); // collection
		
		
		Document doc = new Document();
		BsonArray array= new BsonArray();
		 //dumping game info to the collection
		doc.append("username", username);
		doc.append("score", score);
		doc.append("speed", speed);
		doc.append("health", health);
		//Remaining time as seconds.
		doc.append("remainingTime", remainingTime);
		lengthL= controller.getLengthL();
		doc.append("lengthL", lengthL);
		//Shooting Object
		currentShootingObject= controller.getShootingObject().getType();
		isShooted= controller.getShootingObject().isShooted();
		objectX = controller.getShootingObject().getX();
		objectY = controller.getShootingObject().getY();
		objectMovementAngle= controller.getShootingObject().getRotationAngle();
		doc.append("currentShootingObject", currentShootingObject);
		doc.append("objectX", objectX);
		doc.append("objectY", objectY);
		doc.append("isShooted", isShooted);
		
		//Movement angle double.
		doc.append("objectMovementAngle", objectMovementAngle);
		
		
		//Atoms
		doc.append("alphaAtom", alphaAtomCount);
		doc.append("betaAtom", betaAtomCount);
		doc.append("sigmaAtom", sigmaAtomCount);
		doc.append("gammaAtom", gammaAtomCount);
		
		//Powerups
		doc.append("alphaPU", alphaPUCount);
		doc.append("betaPU", betaPUCount);
		doc.append("sigmaPU", sigmaPUCount);
		doc.append("gammaPU", gammaPUCount);
		
		//Shields
		doc.append("eta", etaCount);
		doc.append("lota", lotaCount);
		doc.append("theta", thetaCount);
		doc.append("zeta", zetaCount);
		 
	     // saving document to the collection i.e., KuvidCollection
		
		collection.insertOne(doc);
		System.out.println("Document inserted successfully");
		if(list==null) {
			list = new ArrayList<GameObject>();
		}
		for(int i=2;i<controller.objects.size();i++) {
			list.add(controller.objects.get(i));
		}
		// Molecule and Powerup & Reaction Blockers
		for(int i=0;i<list.size();i++) {
			Document puPositions= new Document();
			puPositions.append("type", list.get(i).getType());
			puPositions.append("x", list.get(i).getX());
			puPositions.append("y", list.get(i).getY());
			puPositions.append("speed", list.get(i).getSpeed());
		}
		
		
		 Document my_doc = collection.find().first();
		 my_doc = collection.find(eq("username", "mehmet")).first(); 
		 try {
			 System.out.println(my_doc.toJson()); // printing whole document
	        } catch (NullPointerException e) {
	            System.out.println(e); 
	      }
		 
		 Bson filter = eq("username", "mehmet");
		 DeleteResult result = collection.deleteOne(filter);
         System.out.println(result);
         
	}
	
	public void loadGame() {
		
	}

}
