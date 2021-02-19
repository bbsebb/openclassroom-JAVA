package apj.p3.calculatrice;

public abstract class AbstractController {
	
	String chiffre;
	String op;
	AbstractModel model;
	
	public abstract String controleChiffre () ;
	
	public abstract boolean controleOp();
	
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
	
	
	

}
