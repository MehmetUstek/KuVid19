package domain.shield;

import domain.atom.Atom;

public class Zeta extends ShieldDecorator{
	Atom atom;
	double zetaEfficiencyBoost = 0.2;
	
	public Zeta(Atom atom) {
		super(atom.getType());
		this.atom = atom;
	}
	
	@Override
	public void changeSpeed() {
		// TODO Auto-generated method stub
		atom.setSpeed(atom.getSpeed() * 11/100);
	}

	@Override
	public double getEfficiency() {
		// TODO Auto-generated method stub
		return atom.getEfficiency() + (1 - atom.getEfficiency()) * zetaEfficiencyBoost;
	}
}
