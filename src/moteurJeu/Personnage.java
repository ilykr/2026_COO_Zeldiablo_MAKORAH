package moteurJeu;

/**
 * Classe Personnage
 */
public class Personnage {

    /**
     * Attributs de la classe Personnage
     */
    private int x;
    private int y;

    public Personnage(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void deplacer(Commande commande) {
        if (commande.droite) {
            this.x ++;
        }
        if (commande.gauche) {
            this.x --;
        }
        if (commande.bas) {
            this.y ++;
        }
        if (commande.haut) {
            this.y --;
        }
    }

}
