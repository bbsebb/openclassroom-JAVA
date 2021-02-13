package apj.p3.ardoise;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class Ardoise extends JFrame{

	
	private static final long serialVersionUID = 1L;

	Ardoise() {
		super("Mon ardoise");
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		JPanel pan = (JPanel) this.getContentPane();
		this.setJMenuBar(createMenuBar());
		pan.add(createToolBar(), BorderLayout.NORTH);
		pan.add(new dessinPan(), BorderLayout.CENTER);
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menuFichier = new JMenu("Fichier");
		menuFichier.setMnemonic('F');
		menuBar.add(menuFichier);
		
		JMenuItem mnFEffacer = new JMenuItem("Effacer");
		mnFEffacer.setMnemonic('E');
		mnFEffacer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
		menuFichier.add(mnFEffacer);
		
		menuFichier.addSeparator();
		
		JMenuItem mnFQuitter = new JMenuItem("Quitter");
		mnFQuitter.setMnemonic('Q');
		mnFQuitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));
		menuFichier.add(mnFQuitter);
		
		
		JMenu menuEdition= new JMenu("Edition");
		menuEdition.setMnemonic('E');
		menuBar.add(menuEdition);
		
		JMenu mnEForme = new JMenu("Forme du Pointeur");
		mnEForme.setMnemonic('F');
		menuEdition.add(mnEForme);
		
		JMenuItem mnEFRond = new JMenuItem("Rond");
		mnEFRond.setMnemonic('R');
		mnEFRond.setIcon(new ImageIcon("icons/rond_noir.png"));
		mnEForme.add(mnEFRond);
		JMenuItem mnEFCarre = new JMenuItem("Carre");
		mnEFCarre.setIcon(new ImageIcon("icons/carre_noir.png"));
		mnEFCarre.setMnemonic('C');
		mnEForme.add(mnEFCarre);
		
		
		menuEdition.addSeparator();
		
		JMenu mnECouleur = new JMenu("Couleur du pointeur");
		mnECouleur.setMnemonic('C');
		menuEdition.add(mnECouleur);
		
		JMenuItem mnECRouge = new JMenuItem("Rouge");
		mnECRouge.setIcon(new ImageIcon("icons/rouge.png"));
		mnECRouge.setMnemonic('R');
		mnECouleur.add(mnECRouge);
		JMenuItem mnECBleu = new JMenuItem("Bleu");
		mnECBleu.setIcon(new ImageIcon("icons/bleu.png"));
		mnECBleu.setMnemonic('B');
		mnECouleur.add(mnECBleu);
		JMenuItem mnECJaune = new JMenuItem("Jaune");
		mnECJaune.setIcon(new ImageIcon("icons/jaune.png"));
		mnECJaune.setMnemonic('J');
		mnECouleur.add(mnECJaune);
		
		
		
		
		return menuBar;
	}

	private JToolBar createToolBar() {
		JToolBar toolBar = new JToolBar();
		
		JButton toolCarre = new JButton(new ImageIcon("icons/carre_noir.png"));
		toolCarre.setToolTipText("Mettre le pinceau en forme carré");
		toolBar.add(toolCarre);
		
		JButton toolRond = new JButton(new ImageIcon("icons/rond_noir.png"));
		toolRond.setToolTipText("Mettre le pinceau en forme rond");
		toolBar.add(toolRond);
		
		toolBar.addSeparator();
		
		JButton toolRouge = new JButton(new ImageIcon("icons/rouge.png"));
		toolRouge.setToolTipText("Mettre le pinceau en rouge");
		toolBar.add(toolRouge);
		
		JButton toolJaune = new JButton(new ImageIcon("icons/jaune.png"));
		toolJaune.setToolTipText("Mettre le pinceau en jaune");
		toolBar.add(toolJaune);
		
		JButton toolBleu = new JButton(new ImageIcon("icons/bleu.png"));
		toolBleu.setToolTipText("Mettre le pinceau en bleu");
		toolBar.add(toolBleu);
		return toolBar;
	}



}
