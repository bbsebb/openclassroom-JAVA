package apj.p3.calculatrice;

import javax.swing.JFrame;

public class App {

	public static void main(String[] args) {
		
		JFrame f = new Gui(new CalcModel());
		f.setVisible(true);

	}

}
