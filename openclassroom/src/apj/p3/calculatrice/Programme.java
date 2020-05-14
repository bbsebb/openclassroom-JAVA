package apj.p3.calculatrice;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
		JPanel chiffre = new JPanel();
		JPanel operateur = new JPanel();
		JLabel aff = new JLabel();
		p.setLayout(new BorderLayout());
		p.add(chiffre, BorderLayout.CENTER);
		p.add(operateur, BorderLayout.EAST);
		p.add(aff, BorderLayout.NORTH);
		this.setContentPane(p);
		
		
	}
}
