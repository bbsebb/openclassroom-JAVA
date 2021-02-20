package apj.p3.calculatrice;

import java.util.regex.Pattern;

public class CalcController extends AbstractController {

	private static final String REGEX_NBR = "^-?[0-9]+\\.?[0-9]*$";
	private static final Pattern PATTERN_NBR = Pattern.compile(REGEX_NBR);
	
	public CalcController(AbstractModel model) {
		this.setModel(model);
		this.setNouveauChiffre(true);
	}

	@Override
	public String controleChiffre(String chiffre) {
		
		
		if (this.isNouveauChiffre())
			this.setChiffre(chiffre);
		else
			this.setChiffre(this.getChiffre() + chiffre);
		this.setNouveauChiffre(false);
		return this.getChiffre();
	}

	@Override
	public boolean controleOp(String operateur) {

		boolean rtr;
		if (this.isNouveauChiffre() && operateur == "-") {
			
			this.controleChiffre(operateur);
			rtr = true;
		} else {
			float nbr;
			if (this.getChiffre() == null || this.getChiffre().isEmpty())
				nbr = 0;
			else
				nbr = (Float.valueOf(this.getChiffre()));
			rtr = true;
			if (opPre == null) {
				this.getModel().setRslt(nbr);
			} else {

				switch (opPre) {
				case "+" -> this.getModel().operationAdditionner(nbr);
				case "-" -> this.getModel().operationSoustraire(nbr);
				case "/" -> this.getModel().operationDiviser(nbr);
				case "*" -> this.getModel().operationMultiplier(nbr);
				default -> rtr = false;
				}
			}
			opPre = operateur;
			if (rtr)
				this.setNouveauChiffre(true);
		}
		
		return rtr;

	}

	@Override
	public boolean controleCancel() {

		this.setNouveauChiffre(true);
		this.setChiffre("0");
		this.getModel().reset();
		return false;
	}

	@Override
	public boolean controleEgal() {
		

		boolean rtr = this.controleOp(null);
		this.setNouveauChiffre(true);
		this.setChiffre("0");
		return rtr;

	}

}
