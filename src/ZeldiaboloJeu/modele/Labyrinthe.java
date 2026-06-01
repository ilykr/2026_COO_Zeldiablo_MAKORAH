package ZeldiaboloJeu.modele;

import java.util.Arrays;

public class Labyrinthe {
    public boolean[][] murs; //matrice qui contient les coordonées de murs

    //charactère des différents éléments
    public final static char MUR = '#';
    public final static char PJ = '@';
    public final static char VIDE = ' ';
    public final static char MONSTER = '%';

    public boolean etreMur(int x, int y) {
        return murs[x][y];
    }

    @Override
    public String toString() {
        return "Labyrinthe{" +
                "murs=" + Arrays.toString(murs) +
                '}';
    }

    public boolean[][] getMurs() {
        return murs;
    }
}
