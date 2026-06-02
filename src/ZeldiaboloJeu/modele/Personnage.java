package ZeldiaboloJeu.modele;

import moteurJeu.Commande;

<<<<<<< HEAD
public interface Personnage {
    public int getHp();
    public int getAtk();
    public void setHp(int num);
    public int getX();
    public int getY();
    public void setX(int num);
    public void setY(int num);
    public void attaquer(Personnage p);

    public void deplacer(Commande c);
=======
public abstract class Personnage {
    private int hp;
    private int atk;
    private int x;
    private int y;

    public int getHp() { return this.hp; }
    public int getAtk() { return this.atk; }
    public void setHp(int num) { this.hp = num;}
    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public void setX(int num) { this.x = num; }
    public void setY(int num) { this.y = num; }
>>>>>>> 43a4a6821f71b02fc049690c3196a8079c58e414
}
