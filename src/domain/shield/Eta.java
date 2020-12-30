package domain.shield;

import domain.atom.Atom;

public class Eta extends ShieldDecorator{
	Atom atom;
	double etaEfficiencyBoost = 0.05;
	
	public Eta(Atom atom) {
		super(atom.getType());
		this.atom = atom;
	}
	
	@Override
	public void changeSpeed() {
		// TODO Auto-generated method stub
		atom.setSpeed(atom.getSpeed() * 5/100);
	}

	@Override
	public double getEfficiency() {
		// TODO Auto-generated method stub
		if(atom.getNeutrons() != atom.getProtons()) {
			return atom.getEfficiency()+ (1 - atom.getEfficiency()) * (atom.getNeutrons() - atom.getProtons()) / atom.getProtons();
		} else {
			return atom.getEfficiency()+ (1 - atom.getEfficiency()) * etaEfficiencyBoost;
		}
	}
	
}
