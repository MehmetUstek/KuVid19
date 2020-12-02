package ui;

public class PowerupFactory {
	static PowerupFactory instance;
	public PowerupFactory() {
		// TODO Auto-generated constructor stub
	}
	public static synchronized PowerupFactory getInstance() {
		if (instance == null)
		instance = new PowerupFactory();
		return instance;
	}
}
