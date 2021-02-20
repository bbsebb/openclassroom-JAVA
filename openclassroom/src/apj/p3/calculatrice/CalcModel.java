package apj.p3.calculatrice;

import java.beans.PropertyChangeListener;

public class CalcModel extends AbstractModel{


	private static final long serialVersionUID = 1L;



	@Override
	public boolean reset() {
		this.setRslt(0);
		return false;
	}


	@Override
	public boolean operationAdditionner(float nbr) {
		this.setRslt(this.getRslt() + nbr);
		return false;
	}



	@Override
	public boolean operationSoustraire(float nbr) {
		this.setRslt(this.getRslt() - nbr);
		return false;
	}



	@Override
	public boolean operationDiviser(float nbr) {
		this.setRslt(this.getRslt() / nbr);
		return false;
	}



	@Override
	public boolean operationMultiplier(float nbr) {
		this.setRslt(this.getRslt() * nbr);
		return false;
	}


	@Override
	public boolean egal() {
		for(PropertyChangeListener str : this.getSupport().getPropertyChangeListeners("resultat")) {
			System.out.println(str);
		}
		
		
		return false;
	}
	
	

}
