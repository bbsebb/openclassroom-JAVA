package apj.p3.calculatrice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Calc extends JFrame{

	public static void main(String[] args) {
		
		JFrame f = new Calc("Calculatrice");
	}

	public Calc(String title) throws HeadlessException {
		super(title);
		
		this.setSize(270,270);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		
		JPanel pan = (JPanel) this.getContentPane();
		
		pan.setLayout(new BorderLayout(20,20));
		pan.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		JLabel panLabel = new JLabel();
		panLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		panLabel.setPreferredSize(new Dimension(250,30));
		panLabel.setText("0");
		panLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JPanel panChiffres = new JPanel();
		panChiffres.setLayout(new GridLayout(4, 3, 10, 10));
		ArrayList<JButton> btnsPanChiffre = new ArrayList<JButton>();
		for(int i = 1 ; i<10; i++) {
			btnsPanChiffre.add(createJbutton(Integer.toString(i)));
		}
		btnsPanChiffre.add(createJbutton(Integer.toString(0)));
		btnsPanChiffre.add(createJbutton("."));
		btnsPanChiffre.add(createJbutton("="));
		
		for(JButton btn : btnsPanChiffre) {
			panChiffres.add(btn);
		}
		
		JPanel panOp = new JPanel();
		panOp.setPreferredSize(new Dimension(50,0));
		ArrayList<JButton> btnsPanOp = new ArrayList<JButton>();
		btnsPanOp.add(createJbutton("C"));
		btnsPanOp.add(createJbutton("+"));
		btnsPanOp.add(createJbutton("-"));
		btnsPanOp.add(createJbutton("*"));
		btnsPanOp.add(createJbutton("/"));
		panOp.setLayout(new GridLayout(5, 1, 5, 5));
		
		for(JButton btn : btnsPanOp) {
			panOp.add(btn);
		}
		
		
		pan.add(panLabel,BorderLayout.NORTH);
		pan.add(panChiffres,BorderLayout.CENTER);
		pan.add(panOp,BorderLayout.EAST);
		this.setVisible(true);
	}
	
	private JButton createJbutton(String titre) {
		JButton btn = new JButton(titre);
		btn.setPreferredSize(new Dimension(20,20));
		return btn;
	}
	
	

}
