package apj.p3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MaFenetre extends JFrame {

	private static final long serialVersionUID = 1L;

	public MaFenetre(String title) throws HeadlessException {
		super(title);

		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(300, 400);
		this.setVisible(true);
		
	}

	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		JFrame f = new MaFenetre("ma fenetre");

	}
	
	


}
