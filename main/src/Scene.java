import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Scene extends JPanel {

    private ImageIcon icoFond;
    private Image imgFond1;

    private ImageIcon icoMario; //* code provisoire
    private Image imgMario; //* code provisoire

    private int xFond1;

    private void createPath(){
        String filePath = "![](../fondEcran.png)";
        File file = new File(filePath);
        String path = file.getPath();
        System.out.println(path);
    }



    //**** CONSTRUCTEUR ****//
    public Scene(){

        super();

        this.xFond1 = -50;

        icoFond = new ImageIcon(Objects.requireNonNull(getClass().getResource("fondEcran.png")));
        this.imgFond1 = this.icoFond.getImage();
        icoMario = new ImageIcon(Objects.requireNonNull(getClass().getResource("marioMarcheDroite.png")));
        this.imgMario = this.icoMario.getImage();
    }


    //**** METHODES ****//
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;

        g2.drawImage(this.imgFond1, this.xFond1, 0, null); // Dessin de l'image de fond
        g2.drawImage(imgMario, 300, 245, null); //*** code provisoire
    }
}
