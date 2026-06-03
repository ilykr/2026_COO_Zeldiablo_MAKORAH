package ZeldiaboloJeu.modele;

import moteurJeu.Commande;

public class Troll extends Monstre{

    private int hp;
    private int atk;
    private int x;
    private int y;


    public Troll(int x, int y, int hp, int atk) { super(x,y,hp,atk);
    }


    /**
     * Méthode qui vérifie si le troll s'est fait attaqué lors du tour
     * @param
     */

    public boolean estAttaqué(Commande c){
        boolean attaqué = false;
        if (!c.espace) {
            this.hp++;
        }
    }
}
