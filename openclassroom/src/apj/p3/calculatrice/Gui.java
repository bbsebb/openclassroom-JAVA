package apj.p3.calculatrice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Gui extends JFrame {

	String[] operateur = {"+","-","/","*"};
	public Gui() {
		super("Calculatrice v2");
		this.setSize(270, 270);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		JPanel pan = (JPanel) this.getContentPane();
		pan.setLayout(new BorderLayout());
		pan.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		pan.add(createLabel(), BorderLayout.NORTH);
		pan.add(createPanChiffre(), BorderLayout.CENTER);
		pan.add(createPanOp(), BorderLayout.EAST);

	}

	private JPanel createPanOp() {

		JPanel panOp = new JPanel();
		panOp.setLayout(new GridLayout(5, 1, 5, 5));
		panOp.add(createBtnCan());
		for (String string : operateur) {
			panOp.add(createBtnOp(string));
		}
		return panOp;
	}

	private JPanel createPanChiffre() {

		JPanel panChiffre = new JPanel();
		panChiffre.setLayout(new GridLayout(4, 3, 5, 5));
		for (int i = 1; i < 10; i++) {
			
			panChiffre.add(this.createBtnChiffre(i));
		}
		panChiffre.add(this.createBtnChiffre("0"));
		panChiffre.add(this.createBtnChiffre("."));
		panChiffre.add(this.createBtnChiffre("="));
		return panChiffre;
	}

	private JLabel createLabel() {

		JLabel label = new JLabel();
		label.setBorder(BorderFactory.createLineBorder(Color.black));
		return label;
	}

	
	private JButton createBtnChiffre(String chiffre) {
		JButton btn = new JButton(chiffre);
		return btn;
	}
	
	private JButton createBtnChiffre(int chiffre) {	
		return createBtnChiffre(Integer.toString(chiffre));
	}
	
	private JButton createBtnEgal() {
		JButton btn = new JButton("=");
		return btn;
	}
	
	private JButton createBtnOp(String op) {
		JButton btn = new JButton(op);
		return btn;
	}
	
	private JButton createBtnCan() {
		JButton btn = new JButton("C");
		return btn;
	}
	
	
	private void actionChiffre(ActionEvent e) {

	}

	private void actionEgal(ActionEvent e) {

	}

	private void actionOperateur(ActionEvent e) {

	}

	private void actionClear(ActionEvent e) {

	}
}
