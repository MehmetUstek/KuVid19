package ui;

public class MoleculeFactory {
	static MoleculeFactory instance;
	public MoleculeFactory() {
		// TODO Auto-generated constructor stub
	}
	public static synchronized MoleculeFactory getInstance() {
		if (instance == null)
		instance = new MoleculeFactory();
		return instance;
	}
}
