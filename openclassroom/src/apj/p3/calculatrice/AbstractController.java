package apj.p3.calculatrice;

import java.util.regex.Pattern;

public abstract class AbstractController {

	String rgx;
	Pattern pattern;
	String chiffre;
	String op;
	String opPre = null;
	AbstractModel model;
	boolean nouveauChiffre;
	boolean negatif;

	AbstractController() {
		this.setRgx(".*");
		this.pattern = Pattern.compile(rgx);
		this.setChiffre(null);
		this.setOp(null);
		this.setOpPre(null);
		this.setModel(null);
		this.setNouveauChiffre(true);
		this.setNegatif(false);
	}

	/**
	 * Controle le chiffre est correcte
	 * @param chiffre correspond au bouton appuyé
	 * @return le nombre complèt à afficher
	 */
	public abstract String controleChiffre(String chiffre);

	public abstract void controleOp(String operateur);

	public abstract void controleCancel();

	public abstract void controleEgal();

	protected String getChiffre() {
		return chiffre;
	}

	protected void setChiffre(String chiffre) {
		if (chiffre != null) {
			if (pattern.matcher(chiffre).matches())
				this.chiffre = chiffre;
			else
				throw new IllegalArgumentException("Erreur : chiffre incorrect");
		}
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
		if(nouveauChiffre)
			this.setNegatif(false);
		this.nouveauChiffre = nouveauChiffre;
	}

	public String getRgx() {
		return rgx;
	}

	public void setRgx(String rgx) {
		this.rgx = rgx;
	}

	public boolean isNegatif() {
		return negatif;
	}

	public void setNegatif(boolean negatif) {
		this.negatif = negatif;
	}
	
	

}
