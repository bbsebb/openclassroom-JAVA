package apj.p3;

import javax.swing.JFrame;

public class Fenetre extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Fenetre () {
		
		
	this.setTitle("Ma première fenêtre Java");
	this.setSize(400,100);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //On prévient notre JFrame que notre JPanel sera son content pane
    this.setContentPane(new Panneau());  
    
    this.setVisible(true);
	}
}
