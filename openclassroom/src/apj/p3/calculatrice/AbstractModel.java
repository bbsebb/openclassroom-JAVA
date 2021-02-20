package apj.p3.calculatrice;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public abstract class AbstractModel implements Serializable {

	private static final long serialVersionUID = 1L;

	float rslt;
	PropertyChangeSupport support;

	AbstractModel() {
		support = new PropertyChangeSupport(this);
		this.setRslt(0);
	}

	public abstract boolean operationAdditionner(float nbr);

	public abstract boolean operationSoustraire(float nbr);

	public abstract boolean operationDiviser(float nbr);

	public abstract boolean operationMultiplier(float nbr);

	public abstract boolean reset();
	
	public abstract boolean egal();

	protected float getRslt() {
		return rslt;
	}

	protected void setRslt(float rslt) {
		this.getSupport().firePropertyChange("resultat", this.rslt, rslt);
		this.rslt = rslt;
	}

	protected PropertyChangeSupport getSupport() {
		return support;
	}

	protected void setSupport(PropertyChangeSupport support) {
		this.support = support;
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		this.support.removePropertyChangeListener(listener);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {

		this.support.addPropertyChangeListener(listener);
	}
}
