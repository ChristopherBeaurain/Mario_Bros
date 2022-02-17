package jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//***** La classe Clavier g�re les actions utilisateur au clavier *****//
public class Clavier implements KeyListener {


    //**** METHODES **//
    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // fl�che droite

            if (Main.scene.getxPos() == -1) {
                Main.scene.setxPos(0);     // R�initialisation de setxPos
                Main.scene.setxFond1(-50); // R�initialisation de xFond1
                Main.scene.setxFond2(750); // R�initialisation de xFond2
            }
            Main.scene.setDx(1);  // D�placement du fond vers la gauche lors de l'appui sur la touche "fl�che droite"

        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) { // fl�che gauche
            Main.scene.setDx(-1); // D�placement du fond vers la droite lors de l'appui sur la touche "fl�che gauche"
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Main.scene.setDx(0);
    } // Remise � 0 de la variable dx de la l'objet scene

    // lors du rel�chement des touches
    @Override
    public void keyTyped(KeyEvent e) {
    }
}