import ZeldiaboloJeu.ZeldiaboloJeu;
import ZeldiaboloJeu.Chargement;
import ZeldiaboloJeu.ZeldiaboloDessin;
import moteurJeu.Jeu;
import moteurJeu.MoteurGraphique;
import ZeldiaboloJeu.ActionInconnueException;
import java.io.IOException;

public class MainZeldiabolo {
    static void main(String[] args) {
        try {
            ZeldiaboloJeu jeu = Chargement.chargerJeu("documents/niveaux/niveau1.txt");
            System.out.println(jeu.jeuToString());
            ZeldiaboloDessin dessin = new ZeldiaboloDessin(jeu);
            int colonnes = jeu.laby.getMurs().length;
            int lignes = jeu.laby.getMurs()[0].length;
            int tailleCase = 40;
            int largeurFenetre = colonnes * tailleCase;
            int hauteurFenetre = lignes * tailleCase;

            MoteurGraphique moteur = new MoteurGraphique(jeu, dessin);
            moteur.lancerJeu(largeurFenetre,hauteurFenetre);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
