package ZeldiaboloJeu;

import ZeldiaboloJeu.modele.*;

import java.util.ArrayList;

import static java.lang.reflect.Array.getChar;

public class ZeldiaboloJeu {

    public Hero perso;
    public Labyrinthe laby;

    public final static String HAUT = "Haut";
    public final static String BAS = "Bas";
    public final static String DROITE = "Droite";
    public final static String GAUCHE = "Gauche";

    public char getChar(int x, int y) {
        char res = ' ';

        // récupération du caractère mur
        if (this.laby.getMurs()[x][y]) {
            res = Labyrinthe.MUR;
        }

        // récupération du caractère perso
        if (this.perso.getX() == x && this.perso.getY() == y) {
            res = Labyrinthe.PJ;
        }

        return res;
    }

    public static int[] getSuivant(int x, int y, String action) throws ActionInconnueException {
        int[] i = {0};
        if (action == HAUT) {
            return new int[]{x, y - 1};
        } else if (action == BAS) {
            return new int[]{x, y + 1};
        } else if (action == GAUCHE) {
            return new int[]{x - 1, y};
        } else if (action == DROITE) {
            return new int[]{x + 1, y};
        } else throw new ActionInconnueException("Action inconnue");
    }

    public void deplacerPerso(String action) throws ActionInconnueException {
        // init des variables x y
        int x = 0;
        int y = 0;

        // si action, on calcule avec getSuivant et on change x et y
        int[] next = getSuivant(perso.getX(), perso.getY(), action);
        x = next[0];
        y = next[1];

        // si pas de mur
        if (!laby.etreMur(x, y)) {
            perso.setX(x);
            perso.setY(y);
        }
    }

    public boolean etreFini() {
        return false;
    }


    public String toString() {
        return ("Jeu{" +
                "perso=" + perso +
                ", laby=" + laby +
                '}');
    }

    public String jeuToString() {
        StringBuilder result = new StringBuilder();

        int width = laby.murs.length; //largeur
        int height = laby.murs[0].length; //hauteur

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                result.append(getChar(x, y));
            }
            result.append("\n");
        }
        return result.toString();
    }
}
