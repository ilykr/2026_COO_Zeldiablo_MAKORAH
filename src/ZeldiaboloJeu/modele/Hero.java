package ZeldiaboloJeu.modele;

public class Hero implements Personnage{
    private int hp;
    private int atk;
    private int x;
    private int y;

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
        int num = p.getHp()-this.atk;
        p.setHp(num);
    }
}
