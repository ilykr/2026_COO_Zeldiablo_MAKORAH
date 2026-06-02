package ZeldiaboloJeu.modele;

import moteurJeu.Commande;

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
}
