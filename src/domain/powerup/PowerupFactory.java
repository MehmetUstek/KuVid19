package domain.powerup;

import java.util.Random;


public class PowerupFactory {
	static Random random = new Random();
	private static Powerup powerup;
	public static Powerup getPU(Powerup pu,String type) {
		pu.setType(type);
		return pu;
	}
	public static Powerup getPU() {
		int i = random.nextInt(4);
		switch(i) {
		case 0:
			powerup= new Powerup("+alpha");
			break;
		case 1:
			powerup= new Powerup("+beta");
			break;
		case 2:
			powerup= new Powerup("+sigma");
			break;
		case 3:
			powerup= new Powerup("+gamma");
			break;
		}
		return powerup;
	}
	public static Powerup getPU(String type) {
		powerup = new Powerup(type);
		return powerup;
	}
	
}
