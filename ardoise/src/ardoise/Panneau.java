package ardoise;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Panneau extends JPanel {
	private List<Point> trace = new ArrayList<Point>();
	private String forme = "Rond";
	private int taille = 20;
	private Color couleur = Color.blue;	


	public Panneau(){
		this.addMouseMotionListener(new MouseMotionListener(){
			@Override
			public void mouseDragged(MouseEvent e) {
				int posX = e.getX();
				int posY = e.getY();
				trace.add(new Point(forme, posX, posY, taille, couleur));
				repaint();
			}

			@Override
			public void mouseMoved(MouseEvent e) {}
		});
	}
  
	public void paintComponent(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		if (!this.trace.isEmpty()){
			for (Point point: this.trace){
				int posX = point.getPosXPoint();
				int posY = point.getPosYPoint();
				int taille = point.getTaille();
				Color couleur = point.getCouleur();
				g.setColor(couleur);
				if (point.getForme().equals("Rond")){
					g.fillOval(posX, posY, taille , taille);
				}else
				{
					g.fillRect(posX, posY, taille, taille);
				}
			}
		}
	}

	public String getForme() {
		return forme;
	}

	public void setForme(String forme) {
		this.forme = forme;
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

	public void effacer() {
		this.trace.clear();
		repaint();
		
	}

}

