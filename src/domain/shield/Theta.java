package domain.shield;
import domain.atom.Atom;

public class Theta extends ShieldDecorator{
	Atom atom;
	double low = 0.05;
	double high = 0.15;
	
	double thetaEfficiencyBoost = Math.random() * (high - low) + low;
	
	public Theta(Atom atom) {
		super(atom.getType());
		this.atom = atom;
	}
	
	@Override
	public void changeSpeed() {
		// TODO Auto-generated method stub
		atom.setSpeed(atom.getSpeed() * 9/100);
	}

	@Override
	public double getEfficiency() {
		// TODO Auto-generated method stub
		return atom.getEfficiency() + (1 - atom.getEfficiency()) * thetaEfficiencyBoost;
	}
}
