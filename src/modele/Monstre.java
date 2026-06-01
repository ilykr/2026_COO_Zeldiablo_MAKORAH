package modele;

public class Monstre implements Personnage {
    private int hp;
    private int atk;

    public Monstre(int hp, int atk) {
        this.hp = hp;
        this.atk = atk;
    }

    /**
     *
     * @return
     */
    public int getHp() {
        return hp;
    }

    /**
     *
     * @return
     */
    public int getAtk() {
        return atk;
    }

    /**
     *
     * @param num
     */
    public void setHp(int num) {
        this.hp = num;
    }

    /**
     *
     * @param p
     * @return
     */
    public void attaquer(Personnage p) {
        int num = p.getHp()-this.atk;
        p.setHp(num);
    }
}
