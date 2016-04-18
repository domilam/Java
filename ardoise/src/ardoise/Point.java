package ardoise;

import java.awt.Color;

public class Point {
	private String forme = "carre";
	private int posXPoint;
	private int posYPoint;
	private int taille;
	private Color couleur;
	
	public Point(String forme, int posX, int posY, int taille, Color couleur){
		this.forme = forme;
		this.posXPoint = posX;
		this.posYPoint = posY;
		this.taille = taille;
		this.couleur = couleur;
	}
	public String getForme() {
		return forme;
	}
	public void setForme(String forme) {
		this.forme = forme;
	}
	public int getPosXPoint() {
		return posXPoint;
	}
	public void setPosXPoint(int posXPoint) {
		this.posXPoint = posXPoint;
	}
	public int getPosYPoint() {
		return posYPoint;
	}
	public void setPosYPoint(int posYPoint) {
		this.posYPoint = posYPoint;
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	public Color getCouleur() {
		return couleur;
	}
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
}
