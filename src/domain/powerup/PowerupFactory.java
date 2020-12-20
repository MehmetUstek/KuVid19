package domain.powerup;

import java.util.Random;


public class PowerupFactory {
	static Random random = new Random();
	public static Powerup getPU(Powerup pu,String type) {
		pu.setType(type);
		return pu;
	}
}
