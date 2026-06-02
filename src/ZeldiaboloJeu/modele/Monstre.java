package ZeldiaboloJeu.modele;

import moteurJeu.Commande;

public class Monstre implements Personnage {
    private int hp;
    private int atk;
    private int x;
    private int y;

    public Monstre(int x, int y, int hp, int atk) {
        this.hp = hp;
        this.atk = atk;
        this.x = x;
        this.y = y;
    }

    /**
     * Méthode qui retourne les points de vie d'un monstre
     *
     * @return Points de vie
     */
    public int getHp() {
        return hp;
    }

    /**
     * Méthode qui retourne l'attaque d'une monstre
     *
     * @return Puissance d'attaque
     */
    public int getAtk() {
        return atk;
    }

    /**
     * Méthode qui change les points de vie d'un monstre
     *
     * @param num Nouveaux points de vie
     */
    public void setHp(int num) {
        this.hp = num;
    }

    /**
     * Méthode qui renvoie la position X du monstre
     *
     * @return position X
     */
    @Override
    public int getX() {
        return this.x;
    }

    /**
     * Méthode qui renvoie la position Y du monstre
     *
     * @return position Y
     */
    @Override
    public int getY() {
        return this.y;
    }

    /**
     * Méthode qui change la position X du monstre
     *
     * @param num nouvelle position X
     */
    @Override
    public void setX(int num) {
        this.x = num;
    }

    /**
     * Méthode qui change la position X du monstre
     *
     * @param num nouvelle position Y
     */
    @Override
    public void setY(int num) {
        this.y = num;
    }

    /**
     * Méthode qui permet d'attaquer un autre Personnage
     *
     * @param p personnage qui se fait attaquer
     */
    public void attaquer(Personnage p) {
        boolean adjacent = false;
        if (getHp() > 0) {
            int mX = getX();
            int mY = getY();
            if (p.getX() == mX && p.getY() == mY - 1 && p.getHp() > 0) { // check haut
                adjacent = true;
            } else if (p.getX() == mX && p.getY() == mY + 1 && p.getHp() > 0) { //check bas
                adjacent = true;
            } else if (p.getX() == mX + 1 && p.getY() == mY && p.getHp() > 0) { //check droite
                adjacent = true;
            } else if (p.getX() == mX - 1 && p.getY() == mY && p.getHp() > 0) { //check gauche
                adjacent = true;
            }
        }
        if (adjacent) {
            int num = p.getHp() - this.atk;
            p.setHp(num);
            System.out.println("Monstre attaque: -" + this.atk + "pv" + "(Restant : " + num + ")");
            adjacent = false;
        }
    }

    public void deplacer(Commande commande) {
        if (commande.droite) {
            this.x++;
        }
        if (commande.gauche) {
            this.x--;
        }
        if (commande.bas) {
            this.y++;
        }
        if (commande.haut) {
            this.y--;
        }
    }
}
