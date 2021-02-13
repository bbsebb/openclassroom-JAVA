package apj.p3.calculatrice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Calc extends JFrame {

	private static final long serialVersionUID = 1L;

	float resultat = 0;
	float nombreEnCours = 0;
	String nbrEnCours = "";
	String affichage = "0";
	JLabel panLabel;
	String operateurPre = "";
	boolean demarrage = true;

	public static void main(String[] args) {

		JFrame f = new Calc("Calculatrice");
	}

	public Calc(String title) throws HeadlessException {
		super(title);

		this.setSize(270, 270);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);

		JPanel pan = (JPanel) this.getContentPane();
		pan.setLayout(new BorderLayout(20, 20));
		pan.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		panLabel = new JLabel();
		panLabel.setText(affichage);
		panLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		panLabel.setPreferredSize(new Dimension(250, 30));
		panLabel.setText("0");
		panLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		JPanel panChiffres = new JPanel();
		panChiffres.setLayout(new GridLayout(4, 3, 10, 10));
		ArrayList<JButton> btnsPanChiffre = new ArrayList<JButton>();
		for (int i = 1; i < 10; i++) {
			btnsPanChiffre.add(createBtnChiffre(Integer.toString(i)));
		}
		btnsPanChiffre.add(createBtnChiffre(Integer.toString(0)));
		btnsPanChiffre.add(createBtnChiffre("."));
		btnsPanChiffre.add(createBtnEgal("="));

		for (JButton btn : btnsPanChiffre) {
			panChiffres.add(btn);
		}

		JPanel panOp = new JPanel();
		panOp.setPreferredSize(new Dimension(50, 0));
		ArrayList<JButton> btnsPanOp = new ArrayList<JButton>();
		btnsPanOp.add(createBtnClear("C"));
		btnsPanOp.add(createBtnOp("+"));
		btnsPanOp.add(createBtnOp("-"));
		btnsPanOp.add(createBtnOp("*"));
		btnsPanOp.add(createBtnOp("/"));
		panOp.setLayout(new GridLayout(5, 1, 5, 5));

		for (JButton btn : btnsPanOp) {
			panOp.add(btn);
		}

		pan.add(panLabel, BorderLayout.NORTH);
		pan.add(panChiffres, BorderLayout.CENTER);
		pan.add(panOp, BorderLayout.EAST);
		this.setVisible(true);
	}

	private String getOperateurPre() {
		return operateurPre;
	}

	private void setOperateurPre(String operateurPre) {
		this.operateurPre = operateurPre;
	}

	private float getResultat() {
		return resultat;
	}

	private void setResultat(float resultat) {
		this.resultat = resultat;
	}

	private float getNombreEnCours() {
		return nombreEnCours;
	}

	private void setNombreEnCours(float nombreEnCours) {
		this.nombreEnCours = nombreEnCours;
	}
	
	private void actionBtnChiffre (ActionEvent e) {
		String ajoutChiffre = btnToString(e);
		this.nbrEnCours = (demarrage)? ajoutChiffre : this.nbrEnCours +  ajoutChiffre;
		demarrage = false;
		this.setNombreEnCours(Float.valueOf(nbrEnCours));
		panLabel.setText(nbrEnCours);
		
	}
	
	private void actionBtnOp (ActionEvent e) {

		
		switch (this.getOperateurPre()) {
		case "+" -> this.setResultat(this.getResultat() + this.getNombreEnCours());
		case "-" -> this.setResultat(this.getResultat() - this.getNombreEnCours());
		case "*" -> this.setResultat(this.getResultat() * this.getNombreEnCours());
		case "/" -> this.setResultat(this.getResultat() / this.getNombreEnCours());
		default -> this.setResultat(this.getNombreEnCours());
		}
		panLabel.setText(Float.toString(this.getResultat()));

		this.setOperateurPre(btnToString(e));
		this.setNombreEnCours(0);
		demarrage = true;
	}
	
	private void actionBtnEgal (ActionEvent e) {
		actionBtnOp(e);
		panLabel.setText(Float.toString(this.getResultat()));
		demarrage = true;
	}
	
	private void actionBtnClear (ActionEvent e) {
		actionClearAff ();
		this.setResultat(0);
		
	}
	
	private void actionClearAff () {
		this.nbrEnCours = "";
		panLabel.setText("0");
		demarrage = true;
	}
	
	

	private JButton createBtn(String titre) {
		JButton btn = new JButton(titre);
		btn.setPreferredSize(new Dimension(20, 20));
		return btn;
	}

	private JButton createBtnChiffre(String titre) {
		JButton btn = createBtn(titre);
		btn.addActionListener(this::actionBtnChiffre);
		return btn;
	}

	private JButton createBtnOp(String titre) {
		JButton btn = createBtn(titre);
		btn.addActionListener(this::actionBtnOp);
		return btn;
	}

	private JButton createBtnClear(String titre) {
		JButton btn = createBtn(titre);
		btn.addActionListener(this::actionBtnClear);
		return btn;
	}
	
	private JButton createBtnEgal(String titre) {
		JButton btn = createBtn(titre);
		btn.addActionListener(this::actionBtnEgal);
		demarrage = true;
		return btn;
	}
	
	private String btnToString (ActionEvent e) {
		
		
		return ((JButton) e.getSource()).getText();
	}

	

}
