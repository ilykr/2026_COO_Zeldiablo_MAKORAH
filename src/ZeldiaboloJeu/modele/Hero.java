package ZeldiaboloJeu.modele;

import moteurJeu.Commande;

import java.util.ArrayList;

public class Hero extends Personnage {
    private int hp;
    private int atk;
    private int x;
    private int y;
    private ArrayList<Objet> inv = new ArrayList<>();
    boolean sestDeplace;

    public Hero(int x, int y, int hp, int atk) {
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

    public boolean getDeplacement(){return this.sestDeplace;}

    public void attaquer(Personnage p, Commande commande) {
        if (commande.espace) {
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
                    int num = p.getHp() - this.atk;
                    p.setHp(num);
                    System.out.println("Le héro attaque: -" + this.atk + "pv" + "(Restant : " + num + ")");
                    adjacent = false;
                }
            }
        }
    }

    public void deplacer(Commande commande) {
        sestDeplace = false;
        if (commande.droite) {
            this.x++;
            sestDeplace = true;
        }
        if (commande.gauche) {
            this.x--;
            sestDeplace = true;
        }
        if (commande.bas) {
            this.y++;
            sestDeplace = true;
        }
        if (commande.haut) {
            this.y--;
            sestDeplace = true;
        }
    }

    public void prendreObjet(Commande com, Labyrinthe l) {
        Objet o = new Objet();
        if (com.recupObjet && (l.etreObjet(this.x,this.y))){
            inv.add(o);
            System.out.println("Le héros a obtenu l'objet "+o.getNom()+".");
            this.afficherInventaire();
        }
    }

    public void afficherInventaire(){
        String ttInv = "Objets dans l'inventaire: ";
        for (Objet o : inv) {
            ttInv.concat(o.getNom() + ", ");
        }
        System.out.println(ttInv);
    }

    public boolean etreMort() {
        return (this.getHp() < 0);
    }
}
