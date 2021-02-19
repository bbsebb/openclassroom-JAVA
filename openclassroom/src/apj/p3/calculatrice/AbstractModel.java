package apj.p3.calculatrice;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;



public abstract class AbstractModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	int rslt;
	PropertyChangeSupport support;
	
	AbstractModel() {
		support = new PropertyChangeSupport(this);
	}
	
	public abstract boolean operationAdditionner ();
	public abstract boolean operationSoustraire ();
	public abstract boolean operationDiviser ();
	public abstract boolean operationMultiplier ();
	public abstract boolean reset ();
	
	protected int getRslt() {
		return rslt;
	}
	protected void setRslt(int rslt) {
		support.firePropertyChange("resultat", this.rslt, rslt);
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
	
	

