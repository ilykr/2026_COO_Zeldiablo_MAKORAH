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
    public ArrayList<Objet> objets = new ArrayList<>();

    public final static String HAUT = "Haut";
    public final static String BAS = "Bas";
    public final static String DROITE = "Droite";
    public final static String GAUCHE = "Gauche";


    /**
     *
     * @return
     */
    public Commande deplacementRandom() {
        Commande c = new Commande();
        int choix = (int) (Math.random() * 4);

        switch (choix) {
            case 0 -> c.haut = true;
            case 1 -> c.bas = true;
            case 2 -> c.gauche = true;
            case 3 -> c.droite = true;
        }
        return c;
    }

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

        for (int i = 0; i < monstres.size(); i++) {
            if (this.monstres.get(i).getX() == x && this.monstres.get(i).getY() == y) {
                res = Labyrinthe.MONSTER;
            }
        }

        return res;
    }

    /**
     *
     * @param x
     * @param y
     * @param c
     * @return
     */
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

    /**
     *
     * @param c commande utilisateur
     */
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

        //verifier si la case suivante est un monstre
        for (int i = 0; i < monstres.size(); i++) {
            if (monstres.get(i).getX() == x && monstres.get(i).getY() == y) {
                monstre = true;
            }
        }

        boolean demandeDeplacement = c.gauche || c.droite || c.haut || c.bas;

        // si pas de mur
        if (!laby.etreMur(x, y) && !monstre && !laby.etreBarriere(x,y)) {
            perso.deplacer(c);

            if (demandeDeplacement) {
                //deplacement monstres
                for (Monstre m : monstres) {
                    if (m.getHp() > 0) {
                        boolean monstreBloque = false;
                        Commande move = deplacementRandom();
                        // si action, on calcule avec getSuivant et on change x et y
                        next = getSuivant(m.getX(), m.getY(), move);
                        x = next[0];
                        y = next[1];

                        //verifier si la case suivante est un monstre ou le hero
                        if (perso.getX() == x && perso.getY() == y) {
                            monstreBloque = true;
                        }
                        for (int i = 0; i < monstres.size(); i++) {
                            if (monstres.get(i).getX() == x && monstres.get(i).getY() == y) {
                                monstreBloque = true;
                            }
                        }
                        if (m instanceof Troll){
                            if (perso.getDeplacement()){
                                m.setHp(+1);
                            }
                        }
                        if (m instanceof Fantome) {
                            if (!monstreBloque && !laby.etreBarriere(x,y)) {
                                m.deplacer(move);
                                m.attaquer(this.perso);
                            }
                        } else {
                            if (!laby.etreMur(x, y) && !monstreBloque && !laby.etreBarriere(x,y)) {
                                m.deplacer(move);
                                m.attaquer(this.perso);
                            }
                        }
                    }
                }
            }
        }
        for (Monstre m : monstres) {
            perso.attaquer(m, c);
        }
    }

    /**
     *
     * @return
     */
    public boolean etreFini() {
        if (perso.etreMort()) {
            System.out.println("Votre personnage est mort, GAME OVER!");
            return true;
        } else return false;
    }


    /**
     *
     * @return
     */
    public String toString() {
        return ("Jeu{" +
                "perso=" + perso +
                ", laby=" + laby +
                '}');
    }

    /**
     *
     * @return
     */
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
