package apj.p3.ardoise;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class Ardoise extends JFrame{

	
	private static final long serialVersionUID = 1L;

	private DessinPan dessinPan;
	
	Ardoise() {
		super("Mon ardoise");
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel pan = (JPanel) this.getContentPane();
		this.setJMenuBar(createMenuBar());
		pan.add(createToolBar(), BorderLayout.NORTH);
		dessinPan = new DessinPan();
		dessinPan.addMouseListener(new MouseAdapter() {
		 
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.isPopupTrigger()) {
					createPopMenu().show(e.getComponent(), e.getX() , e.getY());
					System.out.println("popu");
				}			
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.isPopupTrigger()) {
					createPopMenu().show(e.getComponent(), e.getX() , e.getY());
					System.out.println("popu");
				}			
			}

		});
		pan.add(dessinPan, BorderLayout.CENTER);
		this.setVisible(true);
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menuFichier = new JMenu("Fichier");
		menuFichier.setMnemonic('F');
		menuBar.add(menuFichier);
		
		menuFichier.add(actEffacer());

		menuFichier.addSeparator();
		

		menuFichier.add(actQuitter());
		
		
		JMenu menuEdition= new JMenu("Edition");
		menuEdition.setMnemonic('E');
		menuBar.add(menuEdition);
		
		JMenu mnEForme = new JMenu("Forme du Pointeur");
		mnEForme.setMnemonic('F');
		menuEdition.add(mnEForme);
		

		mnEForme.add(actRond());

		mnEForme.add(actCarre());
		
		
		menuEdition.addSeparator();
		
		JMenu mnECouleur = new JMenu("Couleur du pointeur");
		mnECouleur.setMnemonic('C');
		menuEdition.add(mnECouleur);
		

		mnECouleur.add(actRouge());

		mnECouleur.add(actBleu());

		mnECouleur.add(actJaune());
		
		
		
		
		return menuBar;
	}

	private JToolBar createToolBar() {
		JToolBar toolBar = new JToolBar();

		toolBar.add(actCarre());
		
		toolBar.add(actRond());
		
		toolBar.addSeparator();
		
		toolBar.add(actRouge());
		
		toolBar.add(actJaune());
		
		toolBar.add(actBleu());
		
		return toolBar;
	}
	
	private JPopupMenu createPopMenu() {
		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.add(actEffacer());
		popupMenu.addSeparator();
		popupMenu.add(actRond());
		popupMenu.add(actCarre());
		popupMenu.add(actRouge());
		popupMenu.add(actBleu());
		popupMenu.add(actJaune());
		return popupMenu;
		
	}
	
	 private AbstractAction actEffacer() {
		return new AbstractAction("Effacer") {

			private static final long serialVersionUID = 1L;

			{
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke('1'));
				putValue(MNEMONIC_KEY, KeyEvent.VK_E);
				putValue(SHORT_DESCRIPTION, "Effacer CTRL + E");
			}
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dessinPan.clear();
			}
		};
		
	}
	
	private AbstractAction actQuitter() {
		return new AbstractAction("Quitter") {

			private static final long serialVersionUID = 1L;

			{
				
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));
				putValue(MNEMONIC_KEY, KeyEvent.VK_K);
				putValue(SHORT_DESCRIPTION, "Quitter CTRL + Q");
			}
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Ardoise.this.dispose();
			}
		};
		
	}
	
	private AbstractAction actCarre() {
		return new AbstractAction("Carre", new ImageIcon("icons/carre_noir.png")) {

			private static final long serialVersionUID = 1L;

			{
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
				putValue(MNEMONIC_KEY, KeyEvent.VK_C);
				putValue(SHORT_DESCRIPTION, "Forme carré CTRL + C");
			}
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dessinPan.setForme("carre");
			}
		};
		
	}
	
	private AbstractAction actRond() {
		return new AbstractAction("Rond", new ImageIcon("icons/rond_noir.png")) {

			private static final long serialVersionUID = 1L;

			{
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK));
				putValue(MNEMONIC_KEY, KeyEvent.VK_R);
				putValue(SHORT_DESCRIPTION, "Forme rond CTRL + R");
			}
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dessinPan.setForme("rond");
			}
		};
		
	}
	
	private AbstractAction actRouge() {
		return new AbstractAction("Rouge", new ImageIcon("icons/rouge.png")) {

			private static final long serialVersionUID = 1L;

			{
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
				putValue(MNEMONIC_KEY, KeyEvent.VK_R);
				putValue(SHORT_DESCRIPTION, "Couleur rouge CTRL + O");
			}
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dessinPan.setCouleur(Color.red);
			}
		};
		
	}
	
	private AbstractAction actBleu() {
		return new AbstractAction("Bleu", new ImageIcon("icons/bleu.png")) {

			private static final long serialVersionUID = 1L;

			{
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.CTRL_DOWN_MASK));
				putValue(MNEMONIC_KEY, KeyEvent.VK_B);
				putValue(SHORT_DESCRIPTION, "Couleur bleu CTRL + B");
			}
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dessinPan.setCouleur(Color.blue);
			}
		};
		
	}
	
	private AbstractAction actJaune() {
		return new AbstractAction("Jaune", new ImageIcon("icons/jaune.png")) {

			private static final long serialVersionUID = 1L;

			{
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_J, KeyEvent.CTRL_DOWN_MASK));
				putValue(MNEMONIC_KEY, KeyEvent.VK_J);
				putValue(SHORT_DESCRIPTION, "Couleur jaune CTRL + J");
			}
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dessinPan.setCouleur(Color.yellow);
			}
		};
		
	}



}
