package ZeldiaboloJeu;

import ZeldiaboloJeu.modele.Fantome;
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

        g.setColor(Color.GRAY);
        boolean[][] laby = jeu.laby.getMurs();
        int colonnes = laby.length;
        int lignes = laby[0].length;
        int largeurCase = image.getWidth()/colonnes;
        int hauteurCase = image.getHeight()/lignes;

        for (int i = 0; i < laby.length; i++) {
            for (int j = 0; j < laby[i].length; j++) {
                if (laby[i][j]) {
                    g.fillRect(i*largeurCase, j*hauteurCase, largeurCase, hauteurCase); //probably false
                }
            }
        }

        //dessinner le hero
        g.setColor(Color.GREEN);
        int[] pos = { jeu.perso.getX(), jeu.perso.getY() };

        int largeurPerso = (int) (largeurCase * 0.65);
        int hauteurPerso = (int) (hauteurCase * 0.65);

        int offsetX = (largeurCase - largeurPerso) / 2;
        int offsetY = (hauteurCase - hauteurPerso) / 2;

        int pixelX = (pos[0] * largeurCase) + offsetX;
        int pixelY = (pos[1] * hauteurCase) + offsetY;

        g.fillOval(pixelX, pixelY, largeurPerso, hauteurPerso);

        //dessinner les monstres
        g.setColor(Color.RED);
        for (int i = 0; i < jeu.monstres.toArray().length; i++) {
            int[] pos2 = { jeu.monstres.get(i).getX(), jeu.monstres.get(i).getY() };

            pixelX = (pos2[0] * largeurCase) + offsetX;
            pixelY = (pos2[1] * hauteurCase) + offsetY;
            if (jeu.monstres.get(i) instanceof Fantome) {
                g.setColor(Color.PINK);
            } else { g.setColor(Color.RED); }

            g.fillOval(pixelX, pixelY, largeurPerso, hauteurPerso);
        }

        //fin
        g.dispose();
    }
}
