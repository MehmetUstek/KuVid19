package domain.powerup;

import java.util.Random;


public class PowerupFactory {
	static Random random = new Random();
	public static Powerup getPU(Powerup pu,String type) {
		if(type== "") {
			int i = random.nextInt(3);
			switch(i) {
			case 0:
				pu.setType("+alpha");
				break;
			case 1:
				pu.setType("+beta");
				break;
			case 2:
				pu.setType("+sigma");
				break;
			case 3:
				pu.setType("+gamma");
				break;
			}
			return pu;
		}
		else {
			pu.setType(type);
			return pu;
		}
		
	}
}
