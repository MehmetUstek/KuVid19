package domain.shield;

import domain.atom.Atom;

public class Lota extends ShieldDecorator {
	Atom atom;
	double lotaEfficiencyBoost = 0.1;
	double efficiency;
	
	public Lota(Atom atom) {
		super(atom.getType());
		this.atom= atom;
	}

	
	@Override
	public void changeSpeed() {
		// TODO Auto-generated method stub
		atom.setSpeed(atom.getSpeed() * 7/100);
	}

	@Override
	public double getEfficiency() {
		// TODO Auto-generated method stub
		return atom.getEfficiency()+ (1 - atom.getEfficiency()) * lotaEfficiencyBoost;
	}

}
