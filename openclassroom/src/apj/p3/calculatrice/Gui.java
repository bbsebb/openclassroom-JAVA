package apj.p3.calculatrice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui extends JFrame {

	private static final long serialVersionUID = 1L;
	String[] operateur = { "+", "-", "/", "*" };
	/* On associe un model abstrait */
	AbstractModel calcModel;
	/* On associe un controller abstrait */
	AbstractController controller;
	JLabel label;

	public Gui(AbstractModel caclModel) {

		super("Calculatrice v2");
		
		this.calcModel = new CalcModel();
		this.controller = new CalcController(this.calcModel);
		
		/* -- Construction de la JFRAME -- */
		this.setSize(270, 270);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		/* -- Construction des composants -- */
		JPanel pan = (JPanel) this.getContentPane();
		pan.setLayout(new BorderLayout());
		pan.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		this.label = createLabel();
		pan.add(this.label, BorderLayout.NORTH);
		pan.add(createPanChiffre(), BorderLayout.CENTER);
		pan.add(createPanOp(), BorderLayout.EAST);

	}

	/**
	 * 
	 * @return le JPanel où se trouve les boutons des opérations et clear 
	 */
	private JPanel createPanOp() {

		JPanel panOp = new JPanel();
		panOp.setLayout(new GridLayout(5, 1, 5, 5));
		panOp.add(createBtnClear());
		for (String string : operateur) {
			panOp.add(createBtnOp(string));
		}
		return panOp;

	}

	/**
	 * 
	 * @return le JPanel où se trouve les chiffres, le point et le bouton égal
	 */
	private JPanel createPanChiffre() {

		JPanel panChiffre = new JPanel();
		panChiffre.setLayout(new GridLayout(4, 3, 5, 5));
		for (int i = 1; i < 10; i++) {

			panChiffre.add(this.createBtnChiffre(i));
		}
		panChiffre.add(this.createBtnChiffre("0"));
		panChiffre.add(this.createBtnChiffre("."));
		panChiffre.add(this.createBtnEgal());
		return panChiffre;
	}

	/**
	 * 
	 * @return le JLabel d'affichage des resultats
	 */
	private JLabel createLabel() {

		JLabel label = new JLabel();
		label.setBorder(BorderFactory.createLineBorder(Color.black));
		label.setText("0");
		calcModel.addPropertyChangeListener((e) -> label.setText(e.getNewValue().toString()));
		return label;
	}

	private JButton createBtnChiffre(String chiffre) {
		JButton btn = new JButton(chiffre);
		btn.addActionListener(this::actionChiffre);
		return btn;
	}

	private JButton createBtnChiffre(int chiffre) {
		return createBtnChiffre(Integer.toString(chiffre));
	}

	private JButton createBtnEgal() {
		JButton btn = new JButton("=");
		btn.addActionListener(this::actionEgal);
		return btn;
	}

	private JButton createBtnOp(String op) {
		JButton btn = new JButton(op);
		btn.addActionListener(this::actionOperateur);
		return btn;
	}

	private JButton createBtnClear() {
		JButton btn = new JButton("C");
		btn.addActionListener(this::actionClear);
		return btn;
	}

	private void actionChiffre(ActionEvent e) {	
		try {
			this.label.setText(controller.controleChiffre(((JButton) e.getSource()).getText()));
		} catch (IllegalArgumentException e1) {
			this.actionClear(e);
			this.label.setText(e1.getMessage());
		}
	}

	private void actionEgal(ActionEvent e) {
		try {
			controller.controleEgal();
		} catch (IllegalArgumentException e1) {
			this.actionClear(e);
			this.label.setText(e1.getMessage());
		}
	}

	private void actionOperateur(ActionEvent e) {
		String txtBtn = ((JButton) e.getSource()).getText();

		try {
			controller.controleOp(txtBtn);
		} catch (IllegalArgumentException e1) {
			this.actionClear(e);
			this.label.setText(e1.getMessage());
		}

	}

	private void actionClear(ActionEvent e) {
		controller.controleCancel();
	}
}
