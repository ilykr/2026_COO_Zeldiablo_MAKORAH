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
            ZeldiaboloJeu jeu = Chargement.chargerJeu("documents/niveaux/default.txt");
            System.out.println(jeu.jeuToString());
            ZeldiaboloDessin dessin = new ZeldiaboloDessin(jeu);

            MoteurGraphique moteur = new MoteurGraphique(jeu, dessin);
            moteur.lancerJeu(400,400);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
