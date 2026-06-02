package ZeldiaboloJeu.modele;

import moteurJeu.Commande;

public class Hero implements Personnage{
    private int hp;
    private int atk;
    private int x;
    private int y;

    public Hero(int x,int y, int hp, int atk){
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.atk = atk;
    }

    @Override
    public int getHp() {
        return this.hp;
    }

    @Override
    public int getAtk() {
        return this.atk;
    }

    @Override
    public void setHp(int num) {
        this.hp = num;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setX(int num) {
        this.x = num;
    }

    @Override
    public void setY(int num) {
        this.y = num;
    }

    @Override
    public void attaquer(Personnage p) {
        boolean adjacent = false;
        if (getHp() > 0) {
            int pX = getX();
            int pY = getY();
            if (p.getX() == pX && p.getY() == pY - 1 && p.getHp() > 0) { // check haut
                adjacent = true;
            } else if (p.getX() == pX && p.getY() == pY + 1 && p.getHp() > 0) { //check bas
                adjacent = true;
            } else if (p.getX() == pX + 1 && p.getY() == pY && p.getHp() > 0) { //check droite
                adjacent = true;
            } else if (p.getX() == pX - 1 && p.getY() == pY && p.getHp() > 0) { //check gauche
                adjacent = true;
            }
            if (adjacent) {
                int num = p.getHp()-this.atk;
                p.setHp(num);
                System.out.println("Le héro attaque: -" + this.atk+"pv" + "(Restant : " + num + ")");
                adjacent = false;
            }
        }
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