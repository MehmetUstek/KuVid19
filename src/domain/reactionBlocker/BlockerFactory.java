package domain.reactionBlocker;
import java.util.Random;


public class BlockerFactory {
	static Random random = new Random();
	private static ReactionBlocker blocker;
	public static ReactionBlocker getBlocker(ReactionBlocker blocker,String type) {
		blocker.setType(type);
		return blocker;
	}
	public static ReactionBlocker getBlocker() {
		int i = random.nextInt(4);
		switch(i) {
		case 0:
			blocker= new ReactionBlocker("alpha");
			break;
		case 1:
			blocker= new ReactionBlocker("beta");
			break;
		case 2:
			blocker= new ReactionBlocker("sigma");
			break;
		case 3:
			blocker= new ReactionBlocker("gamma");
			break;
		}
		return blocker;
	}
	public static ReactionBlocker getBlocker(String type) {
		blocker = new ReactionBlocker(type);
		return blocker;
	}	
}
