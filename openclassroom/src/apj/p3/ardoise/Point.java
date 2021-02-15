package apj.p3.ardoise;

import java.awt.Color;

public class Point {
	int y;
	int x;
	Color couleur = Color.black;
	String forme = "carre";
	
	public Point(int x, int y, Color couleur, String forme) {
		super();
		this.y = y;
		this.x = x;
		this.couleur = couleur;
		this.forme = forme;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
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
	
}
