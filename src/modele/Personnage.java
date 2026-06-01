package modele;

public interface Personnage {
    public int getHp();
    public int getAtk();
    public void setHp(int num);
    public void attaquer(Personnage p);
}
