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
class Fenetre extends JFrame implements ActionListener{
	JLabel resultat;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Fenetre() {
		this.setTitle("Calculatrice TOP");
		this.setSize(240, 260);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pan = new JPanel() ;
		pan.setLayout(new BorderLayout());
		JPanel panChiffres = new JPanel();	
		panChiffres.setPreferredSize(new Dimension(165,225));
		JPanel panOperateurs = new JPanel();	
		panOperateurs.setPreferredSize(new Dimension(55,225));
		JPanel ecran = new JPanel();
		resultat = new JLabel("0");
		Font police = new Font("Arial", Font.BOLD, 20);
		resultat.setFont(police);
		ecran.setPreferredSize(new Dimension(220, 30));
		resultat.setPreferredSize(new Dimension(220, 20));
		resultat.setHorizontalAlignment(JLabel.RIGHT);
			
		resultat.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		String[] chiffres = {"1","2","3","4","5","6","7","8","9","0",".","="};
		String[] operateurs = {"C","+","-","*","/"};
		this.setContentPane(pan);
		for(String chiffre : chiffres) {
			Bouton b = new Bouton(chiffre);
			b.setPreferredSize(new Dimension(50, 40));
			panChiffres.add(b);
			b.addActionListener(this);
			
		}
		for(String operateur : operateurs) {
			Bouton b = new Bouton(operateur);
			b.setPreferredSize(new Dimension(50, 31));
			panOperateurs.add(b);
			b.addActionListener(this);
		}
		ecran.add(resultat);
		pan.add(ecran,BorderLayout.NORTH);
		pan.add(panChiffres,BorderLayout.CENTER);
		pan.add(panOperateurs,BorderLayout.EAST);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getActionCommand());
		resultat.setText(e.getActionCommand());
		
	}
	

	
}

class Bouton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Bouton(String nom) {
		super(nom);



	}
	
	
	
	
}
