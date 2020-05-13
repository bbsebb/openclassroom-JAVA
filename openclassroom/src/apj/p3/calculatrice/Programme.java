package apj.p3.calculatrice;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class Programme {
public static void main(String[] args) {
	Fenetre f = new Fenetre();
	f.setVisible(true);
	}



}
class Fenetre extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Fenetre() {
		super("Calculatrice");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400, 600);
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		this.setContentPane(p);
		
		
	}
}
