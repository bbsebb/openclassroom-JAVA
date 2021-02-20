package apj.p3.calculatrice;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class AbstractModel {
	float rslt;
	PropertyChangeSupport support;
	
	AbstractModel() {
		support = new PropertyChangeSupport(this);
	}
	
	public abstract boolean operationAdditionner (float nbr);
	public abstract boolean operationSoustraire (float nbr);
	public abstract boolean operationDiviser (float nbr);
	public abstract boolean operationMultiplier (float nbr);
	public abstract boolean reset ();

	
	protected float getRslt() {
		return rslt;
	}
	protected void setRslt(float rslt) {
		support.firePropertyChange("resultat", this.rslt , rslt);
		this.rslt = rslt;
	}

	protected PropertyChangeSupport getSupport() {
		return support;
	}

	protected void setSupport(PropertyChangeSupport support) {
		this.support = support;
	}

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.support.removePropertyChangeListener(listener);
    }

	
	
	
	
}
