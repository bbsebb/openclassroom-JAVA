package apj.p3.ardoise;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DessinPan extends JPanel{

	private static final long serialVersionUID = 1L;
	
	int x = -15;
	int y = -15;
	
	DessinPan () {

		this.addMouseMotionListener(new MouseMotionListener() {
			

			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			

			public void mouseDragged(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				
				
			}
		}); 
		
	}
	
	public void paintComponent(Graphics gOld) {
		
		Graphics2D g = (Graphics2D) gOld;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.black);
		g.fillOval(x, y, 12, 12);
		repaint();
		
	}
	

}
