package domain;

import java.io.*;

import ui.UIController;
public class DatabaseController {
    private Controller gc;
    private UIController uic;
    private DatabaseAdapter databaseAdapter;




    public DatabaseController(Controller gameController, UIController uiController) {
        this.gc = gameController;
        this.uic=uiController;
        this.databaseAdapter=new DatabaseAdapter(new LocalDBController(gc, uic));
    }
    public void saveGame(String fileName) {


        databaseAdapter.saveGame(fileName);
        databaseAdapter=new DatabaseAdapter(new LocalDBController(gc, uic));
        databaseAdapter.saveGame(fileName);

    }

    public void loadGame(String fileName) {
    	databaseAdapter=new DatabaseAdapter(new LocalDBController(gc, uic));
        databaseAdapter.loadGame(fileName);
        gc.setInitialMoleculeCount(gc.objects.size());

    }

    public static void serialize(GameObject obj) {
        try {
            FileOutputStream fileOut = new FileOutputStream("saves.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static GameObject deserialize(String fileName) {
        GameObject obj;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            obj = (GameObject) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Ball class not found");
            c.printStackTrace();
            return null;
        }
        return obj;
    }


}
