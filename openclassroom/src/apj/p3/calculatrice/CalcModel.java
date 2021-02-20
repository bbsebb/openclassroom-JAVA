package apj.p3.calculatrice;

public class CalcModel extends AbstractModel{


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



	
	

}
