package apj.p3.ardoise;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

public class DessinPan extends JPanel{

	private static final long serialVersionUID = 1L;
	
	int x = -15;
	int y = -15;
	Color couleur = Color.black;
	String forme = "rond";
	ArrayList<Point> points = new ArrayList<Point>();
	
	DessinPan () {
		
		this.addMouseMotionListener(new MouseMotionAdapter() {

			public void mouseDragged(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				points.add(new Point(x,y,couleur,forme));
				repaint();
			}
		}); 
		
	}
	
	public void paintComponent(Graphics g) {		
		super.paintComponent(g);
		Iterator<Point> pts = points.iterator();
		while(pts.hasNext()) {
			Point pt = pts.next();
			g.setColor(pt.getCouleur());
			if(pt.getForme() == "rond")
				g.fillOval(pt.getX(), pt.getY(), 12, 12);	
			else
				g.fillRect(pt.getX(), pt.getY(), 12, 12);
		}
		
	}

	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public String getForme() {
		return forme;
	}

	public void setForme(String forme) {
		this.forme = forme;
	}
	
	public void clear() {
		this.x=-12;
		this.y=-12;
		points.clear();
		repaint();
	}
	
	

}
