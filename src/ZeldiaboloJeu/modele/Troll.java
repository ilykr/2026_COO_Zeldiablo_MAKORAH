package ZeldiaboloJeu.modele;

import moteurJeu.Commande;

import java.util.Timer;
import java.util.TimerTask;

public class Troll extends Monstre{

    private int hp;
    private int atk;
    private int x;
    private int y;


    public Troll(int x, int y, int hp, int atk) { super(x,y,hp,atk);
    }

}
