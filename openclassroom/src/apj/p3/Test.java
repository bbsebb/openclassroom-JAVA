package apj.p3;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

public class Test {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// Fenetre f = new Fenetre();
				FenetreJText f2 = new FenetreJText();

			}
		});

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// Fenetre f = new Fenetre();
				FenetreKeyListener f3 = new FenetreKeyListener();

			}
		});

	}
}
