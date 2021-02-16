package apj.p3;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Horloge implements Serializable
{

	private static final long serialVersionUID = -3048792873345356468L;
	
	PropertyChangeSupport changeSupport;
	
	public Horloge() {
		changeSupport = new PropertyChangeSupport(this);
	}
	
	LocalDateTime date;

	public String getDate() {
		return date.toString();
	}
	public void setDate(LocalDateTime date) {
		LocalDateTime oldDate = this.date;
		this.date = date;
		changeSupport.firePropertyChange("temps",oldDate,date);
	}
	
	public void run() {
		while(true) {
			this.setDate(LocalDateTime.now());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		changeSupport.addPropertyChangeListener(listener);
	}
	

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		changeSupport.removePropertyChangeListener(listener);
	}
	
}
