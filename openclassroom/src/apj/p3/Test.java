package apj.p3;

import javax.swing.SwingUtilities;

import apj.p3.calculatrice.Calculatrice;

//import javax.swing.JFrame;

public class Test {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Calculatrice f = new Calculatrice();
				f.setVisible(true);
			}
		});
	

	}

}
