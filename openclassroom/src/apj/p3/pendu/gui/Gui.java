package apj.p3.pendu.gui;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

public class Gui extends JFrame {

	JPanel pan;
	JScrollPane panAcceuil;
	JScrollPane panTop;
	JScrollPane panRegle;
	JScrollPane panJeu;
	
	
	public Gui() throws IOException {
		super("Le jeu du pendu");
		
		// -- Création des différentes pages du jeu --
		panAcceuil = this.createAccueil();
		panTop = this.createTop();
		panRegle = this.createRegle();
		panJeu = this.createJeu();
		
		// -- Création des frames principales --
		this.setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().width*0.7),(int) (Toolkit.getDefaultToolkit().getScreenSize().height*0.7));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		// -- Création du contenu --
		pan = (JPanel) this.getContentPane();
		pan.add(panAcceuil);
		JMenuBar mn = new JMenuBar();
		this.setJMenuBar(mn);
		
		// -- Creation des menu --
		JMenu mnFichier = new JMenu("Fichier");
		mnFichier.setMnemonic('F');
		mn.add(mnFichier);
		mnFichier.add(this.createMenuNouveau());
		mnFichier.add(this.createMenuRegle());
		mnFichier.add(this.createMenuTop());
		
		JMenu mnAPropos = new JMenu("A propos");
		mn.add(mnAPropos);
		mnAPropos.setMnemonic('A');
		mnAPropos.add(this.createMenuAccueil());
		
		//String str = this.getClass().getResource("file:html/accueil.html").toString();
		System.out.println(this.getClass().getResource("acc.jpg"));
		
	}
	
	
	private JScrollPane createAccueil() throws IOException {
		JEditorPane acceuil = new JEditorPane("file:html/accueil.html");
		acceuil.setEditable( false );
		return new JScrollPane(acceuil);
	}
	private JScrollPane createTop() {
		JEditorPane top = new JEditorPane();
		top.setBackground(Color.blue);
		return new JScrollPane(top);
	}
	private JScrollPane createRegle() throws IOException {
		JEditorPane regle = new JEditorPane("file:html/regle.html");
		
		return new JScrollPane(regle);
	}
	private JScrollPane createJeu() {
		JEditorPane jeu = new JEditorPane();
		jeu.setBackground(Color.red);
		return new JScrollPane(jeu);
	}
	
	
	private AbstractAction createMenuNouveau() { 
		return new AbstractAction("Nouveau") {
	
			private static final long serialVersionUID = 1L;


			{
				putValue(MNEMONIC_KEY, KeyEvent.VK_N);
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK));
				putValue(SHORT_DESCRIPTION,"Nouveau CTRL+N");
			}
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Gui.this.pan.removeAll();
				Gui.this.pan.add(panJeu);
				revalidate();
				
			}
		};
		
	}
	
	private AbstractAction createMenuRegle() { 
		return new AbstractAction("Regle") {

			private static final long serialVersionUID = 1L;


			{
				putValue(MNEMONIC_KEY, KeyEvent.VK_R);
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_R,KeyEvent.CTRL_DOWN_MASK));
				putValue(SHORT_DESCRIPTION,"Nouveau CTRL+R");
			}
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Gui.this.pan.removeAll();
				Gui.this.pan.add(panRegle);
				revalidate();
				
			}
		};
		
	}
	
	private AbstractAction createMenuTop() { 
		return new AbstractAction("Top") {

			private static final long serialVersionUID = 1L;


			{
				putValue(MNEMONIC_KEY, KeyEvent.VK_T);
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_T,KeyEvent.CTRL_DOWN_MASK));
				putValue(SHORT_DESCRIPTION,"Nouveau CTRL+T");
			}
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Gui.this.pan.removeAll();
				Gui.this.pan.add(panTop);
				revalidate();
				
			}
		};
		
	}
	
	private AbstractAction createMenuAccueil() { 
		return new AbstractAction("Accueil") {
			
			private static final long serialVersionUID = 1L;


			{
				putValue(MNEMONIC_KEY, KeyEvent.VK_A);
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_DOWN_MASK));
				putValue(SHORT_DESCRIPTION,"Nouveau CTRL+A");
			}
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Gui.this.pan.removeAll();
				Gui.this.pan.add(panAcceuil);
				revalidate();
				
			}
		};
		
	}
}
