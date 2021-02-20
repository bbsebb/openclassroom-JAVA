package apj.p3.calculatrice;

import java.util.regex.Pattern;

public class CalcController extends AbstractController {

	public CalcController(AbstractModel model) {
		this.setModel(model);
		this.setRgx("^-?[0-9]+\\.?[0-9]*$");
		this.pattern = Pattern.compile(this.rgx);
		this.setNouveauChiffre(true);
	}

	@Override
	public String controleChiffre(String chiffre) {

		/* Si le chiffre doit être négatif */
		String strNegation = "";
		if (this.isNegatif()) {
			strNegation = "-";
			this.setNegatif(false);
		}

		/* pour le premier chiffre, ou les chiffre juste après avoir appuyer sur un operateur */
		if (this.isNouveauChiffre())
			this.setChiffre(strNegation + chiffre);
		else
			this.setChiffre(strNegation + this.getChiffre() + chiffre);
		this.setNouveauChiffre(false);
		return this.getChiffre();
	}

	@Override
	public void controleOp(String operateur) {

		/* Si on appuie plusieurs fois sur un operateur à la suite (gestion des chiffres négatifs qui utilisent le même bouton) */
		if ((this.isNouveauChiffre() && operateur != "-")
				|| (this.isNouveauChiffre() && operateur == "-" && this.isNegatif())) {
			throw new IllegalArgumentException("Erreur : formule incorrecte");
		}

		/* On gère les chiffres négatifs autrement qu les operateur */
		if (this.isNouveauChiffre() && operateur == "-") {
			this.setNegatif(true);
		} else {
			float nbr;
			/* l'affichage du zero initial doit etre géré de facon particulière */
			if (this.getChiffre() == null || this.getChiffre().isEmpty())
				nbr = 0;
			else
				nbr = (Float.valueOf(this.getChiffre()));

			/* On ne fait pas d'operation au premier appui sur un opérateur */
			if (opPre != null) {
				switch (opPre) {
				case "+" -> this.getModel().operationAdditionner(nbr);
				case "-" -> this.getModel().operationSoustraire(nbr);
				case "/" -> this.getModel().operationDiviser(nbr);
				case "*" -> this.getModel().operationMultiplier(nbr);

				}
			} else {
				this.getModel().setRslt(nbr);
			}
			this.setOpPre(operateur);
			this.setNouveauChiffre(true);
		}

	}

	@Override
	public void controleCancel() {

		this.setNouveauChiffre(true);
		this.setChiffre("0");
		this.getModel().reset();
	}

	@Override
	public void controleEgal() {
		if (this.isNouveauChiffre()) {
			throw new IllegalArgumentException("Erreur : formule incorrecte");
		}

		float nbr = (Float.valueOf(this.getChiffre()));
		switch (this.getOpPre()) {
		case "+" -> this.getModel().operationAdditionner(nbr);
		case "-" -> this.getModel().operationSoustraire(nbr);
		case "/" -> this.getModel().operationDiviser(nbr);
		case "*" -> this.getModel().operationMultiplier(nbr);
		}
		this.setOpPre(null);
		this.setNouveauChiffre(true);
		this.setChiffre("0");

	}

}
