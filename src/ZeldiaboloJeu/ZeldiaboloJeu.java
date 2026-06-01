package ZeldiaboloJeu;

import ZeldiaboloJeu.modele.*;
import moteurJeu.Commande;
import moteurJeu.Jeu;
import java.util.ArrayList;

import static java.lang.reflect.Array.getChar;

public class ZeldiaboloJeu implements Jeu {

    public Hero perso;
    public ArrayList<Monstre> monstres = new ArrayList<>();
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

        for (int i = 0; i< monstres.toArray().length; i++) {
            if (this.monstres.get(i).getX() == x && this.monstres.get(i).getY() == y) {
                res = Labyrinthe.MONSTER;
            }
        }

        return res;
    }

    public static int[] getSuivant(int x, int y, Commande c) {
        int[] i = {0, 0};
        if (c.haut) {
            return new int[]{x, y - 1};
        } else if (c.bas) {
            return new int[]{x, y + 1};
        } else if (c.gauche) {
            return new int[]{x - 1, y};
        } else if (c.droite) {
            return new int[]{x + 1, y};
        } else return i;
    }

    @Override
    public void evoluer(Commande c) {
        // init des variables x y et monstre
        int x = 0;
        int y = 0;
        boolean monstre = false;

        // si action, on calcule avec getSuivant et on change x et y
        int[] next = getSuivant(perso.getX(), perso.getY(), c);
        x = next[0];
        y = next[1];

        for (int i = 0; i< monstres.toArray().length; i++) {
            if (monstres.get(i).getX() == x && monstres.get(i).getY() == y) {
                monstre = true;
            }
        }

        // si pas de mur
        if (!laby.etreMur(x, y) && monstre == false) {
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
