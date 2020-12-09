package domain;



import java.io.*;
import java.util.LinkedList;

import ui.UIController;
import ui.UIGameObject;

public class LocalDBController implements SaveLoad{

    private Controller GC;
    private UIController UIC;

    public LocalDBController(Controller gc, UIController uic){
        this.GC=gc;
        this.UIC=uic;
    }

    @Override
    public void saveGame(String fileName) {
        System.out.println("Local save was called.");
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            LinkedList<LinkedList> objectLists = new LinkedList<>();
            objectLists.add(GC.objects);
            objectLists.add((LinkedList) UIC.objects);
            out.writeObject(objectLists);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    @Override
    public void loadGame(String fileName) {
        LinkedList<LinkedList> objectLists;
        System.out.println("Local load was called.");
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            objectLists = (LinkedList<LinkedList>) in.readObject();
            LinkedList<GameObject> domainObjects = objectLists.get(0);
            LinkedList<UIGameObject> guiObjects = objectLists.get(1);
            GC.objects = domainObjects;
            UIC.objects = guiObjects;
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }
}
