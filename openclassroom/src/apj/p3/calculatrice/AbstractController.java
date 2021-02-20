package apj.p3.calculatrice;

public abstract class AbstractController {
	
	String chiffre;
	String op;
	String opPre = null;
	AbstractModel model;
	boolean nouveauChiffre;
	
	public abstract String controleChiffre (String chiffre) ;
	
	public abstract boolean controleOp(String operateur);
	
	public abstract boolean controleCancel();
	
	public abstract boolean controleEgal();

	protected String getChiffre() {
		return chiffre;
	}

	protected void setChiffre(String chiffre) {
		this.chiffre = chiffre;
	}

	protected String getOp() {
		return op;
	}

	protected void setOp(String op) {
		this.op = op;
	}

	protected AbstractModel getModel() {
		return model;
	}

	protected void setModel(AbstractModel model) {
		this.model = model;
	}

	protected String getOpPre() {
		return opPre;
	}

	protected void setOpPre(String opPre) {
		this.opPre = opPre;
	}

	protected boolean isNouveauChiffre() {
		return nouveauChiffre;
	}

	protected void setNouveauChiffre(boolean nouveauChiffre) {
		this.nouveauChiffre = nouveauChiffre;
	}
	
	
	
	

}
