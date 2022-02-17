package jeu;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import personnages.Mario;


//***** La classe Scene est le classe la plus importante de l'application. *****//
//***** Elle est accessible par toutes les autres classes, contient le "moteur" de l'application *****//
//***** Elle g�re la partie graphique. *****//
@SuppressWarnings("serial")
public class Scene extends JPanel {


    //**** VARIABLES **//
    private ImageIcon icoFond;
    private Image imgFond1;
    private Image imgFond2;

    private ImageIcon icoChateau1;
    private Image imgChateau1;
    private ImageIcon icoDepart;
    private Image imgDepart;

    private int xFond1;
    private int xFond2;
    private int dx;
    private int xPos; // position absolue dans le jeu

    public Mario mario;


    //**** CONSTRUCTEUR ****//
    public Scene() {

        super();

        this.xFond1 = -50;
        this.xFond2 = 750;
        this.dx = 0;
        this.xPos = -1;

        icoFond = new ImageIcon(getClass().getResource("/Images/fondEcran.png"));
        this.imgFond1 = this.icoFond.getImage();
        this.imgFond2 = this.icoFond.getImage();

        this.icoChateau1 = new ImageIcon(getClass().getResource("/Images/chateau1.png"));
        this.imgChateau1 = this.icoChateau1.getImage();
        this.icoDepart = new ImageIcon(getClass().getResource("/Images/depart.png"));
        this.imgDepart = this.icoDepart.getImage();

        mario = new Mario(300, 245);

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new Clavier());

        Thread chronoEcran = new Thread(new Chrono());
        chronoEcran.start();
    }


    //**** GETTERS ****//
    public int getDx() {
        return dx;
    }

    public int getxPos() {
        return xPos;
    }


    //**** SETTERS ****//
    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setxFond1(int xFond1) {
        this.xFond1 = xFond1;
    }

    public void setxFond2(int xFond2) {
        this.xFond2 = xFond2;
    }


    //**** METHODES ****//
    public void deplacementFond() { // D�placement des images "fixes" de l'�cran simulant le d�placement de mario

        if (this.xPos >= 0) {
            // Mise � jour des positions des �l�ments du jeu lors du d�placement de mario
            this.xPos = this.xPos + this.dx;
            this.xFond1 = this.xFond1 - this.dx;
            this.xFond2 = this.xFond2 - this.dx;
        }
        // Permanence du fond d'�cran
        if (this.xFond1 == -800) {
            this.xFond1 = 800;
        } else if (this.xFond2 == -800) {
            this.xFond2 = 800;
        } else if (this.xFond1 == 800) {
            this.xFond1 = -800;
        } else if (this.xFond2 == 800) {
            this.xFond2 = -800;
        }
    }


    public void paintComponent(Graphics g) { // Dessin de toutes les images visibles � l'�cran (appel toutes les 3 ms environ)

        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;

        this.deplacementFond();

        g2.drawImage(this.imgFond1, this.xFond1, 0, null); // Fond1
        g2.drawImage(this.imgFond2, this.xFond2, 0, null); // Fond 2
        g2.drawImage(this.mario.getImgMario(), 300, 245, null); //*** code provisoire
        g2.drawImage(this.imgChateau1, 10 - this.xPos, 95, null); // Ch�teau du d�but
        g2.drawImage(this.imgDepart, 220 - this.xPos, 234, null); // Panneau d�part
    }
}