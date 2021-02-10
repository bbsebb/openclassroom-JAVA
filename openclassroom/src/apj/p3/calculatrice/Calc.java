package apj.p3.calculatrice;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calc extends JFrame{

	public static void main(String[] args) {
		
		JFrame f = new Calc("Calculatrice");
	}

	public Calc(String title) throws HeadlessException {
		super(title);
		
		this.setSize(400,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		
		JPanel pan = (JPanel) this.getContentPane();
		
		pan.setLayout(new BorderLayout(20,20));
		
		JLabel panLabel = new JLabel();
		
		JPanel panChiffres = new JPanel();
		panChiffres.setLayout(new GridLayout(4, 3, 10, 10));
		JPanel panOp = new JPanel();
		panOp.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		
		
		this.setVisible(true);
	}
	
	

}
