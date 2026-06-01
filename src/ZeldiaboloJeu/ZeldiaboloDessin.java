package ZeldiaboloJeu;

import ZeldiaboloJeu.modele.Hero;
import ZeldiaboloJeu.modele.Labyrinthe;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ZeldiaboloDessin implements DessinJeu {
    ZeldiaboloJeu jeu;
    public ZeldiaboloDessin(ZeldiaboloJeu j) {
        this.jeu = j;
    }

    @Override
    public void dessiner(BufferedImage image) {
        Graphics2D g= (Graphics2D) image.getGraphics();
        int largeurCase = image.getWidth()/10;
        int hauteurCase = image.getHeight()/10;

        g.setColor(Color.RED);
        boolean[][] laby = jeu.laby.getMurs();
        for (int i = 0; i < laby.length; i++) {
            for (int j = 0; j < laby[i].length; j++) {
                if (laby[i][j]) {
                    g.fillRect(i*largeurCase, j*hauteurCase, largeurCase, hauteurCase); //probably false
                }
            }
        }

        g.setColor(Color.GREEN);
        int[] pos = { jeu.perso.getX(), jeu.perso.getY() };
        g.fillOval(pos[0]*largeurCase, pos[1]*hauteurCase, 20, 20);


        //fin
        g.dispose();
    }
}
