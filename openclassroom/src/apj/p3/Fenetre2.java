package apj.p3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetre2 extends JFrame{
	private JPanel container = new JPanel();
	private JComboBox<String> combo = new JComboBox<String>();
	private JLabel label = new JLabel("une ComboBox");
	
	public Fenetre2() {
		this.setTitle("Animation");
		//this.setSize(new Dimension(300,300));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		combo.setPreferredSize(new Dimension(100,20));
		combo.addActionListener(new ItemState());
		combo.setForeground(Color.red);
	    combo.addItem("Option 1");
	    combo.addItem("Option 2");
	    combo.addItem("Option 3");
	    combo.addItem("Option 4");
		JPanel top = new JPanel();
		top.add(label);
		top.add(combo);
		container.add(top,BorderLayout.NORTH);
		this.setContentPane(container);
		this.setVisible(true);
		this.pack();
	}
	
	class ItemState implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("événement déclenché sur : " + combo.getSelectedItem());
		}


		
	}
}
