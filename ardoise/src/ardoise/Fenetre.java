package ardoise;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;



public class Fenetre extends JFrame {
	private Panneau panDeTrace = new Panneau();
	private JMenuBar barreMenu = new JMenuBar();
	private JMenu fichier = new JMenu("Fichier"), edition = new JMenu("Edition");
	private JMenuItem effacer = new JMenuItem("Nouveau"), quitter = new JMenuItem("Quitter");
	private JMenu forme = new JMenu("Forme"), couleur = new JMenu("Couleur");
	private JMenuItem rond = new JMenuItem("Rond"), carre = new JMenuItem("Carré");
	private JMenuItem rouge = new JMenuItem("Rouge"), vert = new JMenuItem("Vert"), bleu = new JMenuItem("Bleu");
	private JButton btnRond = new JButton(new ImageIcon("images/rond.png")),
					btnCarre = new JButton(new ImageIcon("images/carre.png")),
					btnRouge = new JButton(new ImageIcon("images/rouge.png")),
					btnVert = new JButton(new ImageIcon("images/vert.png")),
					btnBleu = new JButton(new ImageIcon("images/bleu.png"));
	private JToolBar toolBar = new JToolBar();
	private Color fondButton = Color.white;

	public Fenetre(){
		this.setTitle("Ardoise");
		this.setSize(700, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.initMenu();
		this.initToolBar();
		this.getContentPane().add(panDeTrace, BorderLayout.CENTER);;
		this.setVisible(true);
	}

	private void initToolBar() {
		
		// Ajout des icones
		btnRond.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panDeTrace.setForme("Rond");
				if (btnRond.getBackground().equals(fondButton)){
					btnRond.setBackground(Color.gray);
					btnCarre.setBackground(fondButton);
				}
				
			}
		});
		btnRond.setBackground(Color.gray);
		
		btnCarre.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				panDeTrace.setForme("Carre");
				if (btnCarre.getBackground().equals(fondButton)){
					btnCarre.setBackground(Color.gray);
					btnRond.setBackground(fondButton);
				}
			}
		});
		

		btnRouge.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				panDeTrace.setCouleur(Color.red);;
				if (btnRouge.getBackground().equals(fondButton)){
					btnRouge.setBackground(Color.gray);
					btnVert.setBackground(fondButton);
					btnBleu.setBackground(fondButton);
				}
			}
		});

		btnVert.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				panDeTrace.setCouleur(Color.green);;
				if (btnVert.getBackground().equals(fondButton)){
					btnVert.setBackground(Color.gray);
					btnRouge.setBackground(fondButton);
					btnBleu.setBackground(fondButton);
				}
			}
		});		

		btnBleu.setBackground(Color.gray);
		btnBleu.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				panDeTrace.setCouleur(Color.blue);;
				if (btnBleu.getBackground().equals(fondButton)){
					btnBleu.setBackground(Color.gray);
					btnRouge.setBackground(fondButton);
					btnVert.setBackground(fondButton);
				}
			}
		});		
		
		btnCarre.setBackground(fondButton);
		btnRouge.setBackground(fondButton);
		btnVert.setBackground(fondButton);
		
		toolBar.add(btnRond);
		toolBar.add(btnCarre);
		toolBar.addSeparator(new Dimension(30,30));
		
		toolBar.add(btnRouge);
		toolBar.add(btnVert);
		toolBar.add(btnBleu);
		
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		
	}

	private void initMenu() {
		// Construction du menu couleur
		rouge.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				panDeTrace.setCouleur(Color.red);
			}
		});
		
		vert.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				panDeTrace.setCouleur(Color.green);
			}
		});
		
		bleu.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				panDeTrace.setCouleur(Color.blue);
			}
		});
		couleur.add(rouge);
		couleur.add(vert);
		couleur.add(bleu);
		
		//Construction du menu forme
		rond.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				panDeTrace.setForme("Rond");
			}
		});
		
		carre.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				panDeTrace.setForme("Carre");
			}
		});
		forme.add(rond);
		forme.add(carre);
		
		//Listener de effacer et quitter
		effacer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panDeTrace.effacer();
			}
			
		});
		
		quitter.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		//Construction du menu Fichier
		fichier.add(effacer);
		fichier.addSeparator();
		fichier.add(quitter);
		
		//les accélérateurs
		effacer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_MASK));
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,KeyEvent.CTRL_DOWN_MASK));
		
		//Le Mnémonic pour fichier
		fichier.setMnemonic('F');
		
		//Construction du menu Edition
		edition.add(forme);
		edition.add(couleur);
		edition.setMnemonic('E');
		
		//Construction de la barre de menu
		barreMenu.add(fichier);
		barreMenu.add(edition);
		
		//Affectation de la barre de Menu à la fenêtre
		this.setJMenuBar(barreMenu);
	}
}
