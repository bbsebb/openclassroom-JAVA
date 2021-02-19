package apj.p3;

import java.awt.HeadlessException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MaFenetre extends JFrame   {

	private static final long serialVersionUID = 1L;

	private JLabel label;
	public MaFenetre(String title) throws HeadlessException {
		super(title);
		Horloge h = new Horloge();
		h.addPropertyChangeListener((e) -> label.setText(e.getPropertyName() + " " + e.getNewValue()));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(400,600);
		
		label = new JLabel();
		this.getContentPane().add(label);
	
		this.setVisible(true);
		h.run();	
	}

	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		JFrame f = new MaFenetre("ma fenetre");
	}


	
	


}
