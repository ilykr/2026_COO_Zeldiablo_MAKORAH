package ZeldiaboloJeu.modele;

public interface Personnage {
    public int getHp();
    public int getAtk();
    public void setHp(int num);
    public int getX();
    public int getY();
    public void setX(int num);
    public void setY(int num);
    public void attaquer(Personnage p);
}
