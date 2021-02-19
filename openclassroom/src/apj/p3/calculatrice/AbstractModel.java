package apj.p3.calculatrice;

import java.beans.PropertyChangeSupport;

public abstract class AbstractModel {
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
		this.rslt = rslt;
	}

	protected PropertyChangeSupport getSupport() {
		return support;
	}

	protected void setSupport(PropertyChangeSupport support) {
		this.support = support;
	}
	
	
	
}
