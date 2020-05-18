package apj.p3.calculatrice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Programme {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Fenetre f = new Fenetre();
				f.setVisible(true);
			}
		});

	}

}

class Fenetre extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel affichage,boutonCentral,boutonDroit;
	JLabel resultat;
	String[] boutonStr = {"1","2","3","4","5","6","7","8","9","0",".","=","C","+","-","*","/"};
	Bouton[] boutons = new Bouton[boutonStr.length];
	boolean operateurBool = false;
	String affStr ="";
	double affDb = 0;
	String operateur;
	
	Fenetre() {
		this.setTitle("Caculatrice");
		this.setSize(new Dimension(255,300));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout(5, 5));
		boutonCentral = new JPanel();
		boutonCentral.setPreferredSize(new Dimension(190,250));
		boutonDroit = new JPanel();
		boutonDroit.setPreferredSize(new Dimension(60,250));
		affichage = new JPanel();
		affichage.setPreferredSize(new Dimension(250,50));
		resultat = new JLabel("0");
		resultat.setHorizontalAlignment(JLabel.RIGHT);
		resultat.setPreferredSize(new Dimension(240,40));
		resultat.setFont(new Font("Arial", Font.BOLD, 20));
		resultat.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.affichage.add(resultat);
		this.getContentPane().add(affichage,BorderLayout.NORTH);
		this.getContentPane().add(boutonCentral,BorderLayout.CENTER);
		this.getContentPane().add(boutonDroit,BorderLayout.EAST);	
		for(int i = 0; i < boutonStr.length;i++) {
			if(i<11) {
				boutons[i] = new Bouton(boutonStr[i]);
				boutons[i].addActionListener(new Chiffre());
				boutonCentral.add(boutons[i]);
			} else if(i == 11) {
				boutons[i] = new Bouton(boutonStr[i]);
				boutons[i].addActionListener(new Egal());
				boutonCentral.add(boutons[i]);
			} else if( i>11 ) {
				boutons[i] = new Bouton(boutonStr[i]);
				boutonDroit.add(boutons[i]);
				switch(i) {
				case 12:
					boutons[i].addActionListener(new Reset());
					break;
				case 13:
					boutons[i].addActionListener(new Addition());
					break;
				case 14:
					boutons[i].addActionListener(new Soustraction());
					break;
				case 15:
					boutons[i].addActionListener(new Multiplication());
					break;
				case 16:
					boutons[i].addActionListener(new Division());
					break;
				}
			}
			
		}
	}
	
	void reset() {
		
	}
	
	void calc() {
	
		switch(operateur) {
		case "+":
			this.affDb = Double.valueOf(this.resultat.getText()) + this.affDb;
			break;
		case "-":
			this.affDb -= Double.valueOf(this.resultat.getText());
			break;
		case "*":
			this.affDb = Double.valueOf(this.resultat.getText())* this.affDb;
			break;
		case "/":
			this.affDb =  this.affDb / Double.valueOf(this.resultat.getText());
			break;
		}
		
	}
	
	class Addition implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			affStr = "";
			
			if(operateurBool) 
				calc();
			else 
				affDb = Double.valueOf(resultat.getText());
			resultat.setText(String.valueOf(affDb));
			System.out.println(affDb);
			operateur = "+";
			operateurBool = true;
			
		}
		
	}
	class Soustraction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			affStr = "";
			
			if(operateurBool) 
				calc();
			else 
				affDb = Double.valueOf(resultat.getText());
			resultat.setText(String.valueOf(affDb));
			operateur = "-";
			operateurBool = true;
		}
		
	}
	class Multiplication implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			affStr = "";
			
			if(operateurBool) 
				calc();
			else 
				affDb = Double.valueOf(resultat.getText());
			resultat.setText(String.valueOf(affDb));
			operateur = "*";
			operateurBool = true;
		}
		
	}
	class Division implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			affStr = "";
			
			if(operateurBool) 
				calc();
			else 
				affDb = Double.valueOf(resultat.getText());
			resultat.setText(String.valueOf(affDb));
			operateur = "/";
			operateurBool = true;
		}
		
	}
	class Reset implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class Egal implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(operateurBool) calc();
			
			resultat.setText(String.valueOf(affDb));
		}
		
	}
	class Chiffre implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			affStr += ((Bouton)e.getSource()).getText();
			resultat.setText(affStr);
		}
		
	}
}

class Bouton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Bouton (String nom) {
		super(nom);
		this.setPreferredSize(new Dimension(50,35));
	}
}
