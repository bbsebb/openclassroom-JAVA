package apj.p3;

import javax.swing.SwingUtilities;

public class Test {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// Fenetre f = new Fenetre();
				 new FenetreJText();

			}
		});

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// Fenetre f = new Fenetre();
				 new FenetreKeyListener();

			}
		});

	}
}
