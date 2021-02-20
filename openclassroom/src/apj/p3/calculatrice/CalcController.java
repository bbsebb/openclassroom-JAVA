package apj.p3.calculatrice;

public class CalcController extends AbstractController {

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

		float nbr = (Float.valueOf(this.getChiffre()));
		boolean rtr = true;
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
		return rtr;

	}

	@Override
	public boolean controleCancel() {

		this.setNouveauChiffre(true);
		this.getModel().reset();
		return false;
	}

	@Override
	public boolean controleEgal() {
		this.setNouveauChiffre(true);
		return this.controleOp(null);

	}

}
