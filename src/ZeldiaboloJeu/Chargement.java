package ZeldiaboloJeu;

import ZeldiaboloJeu.modele.Hero;
import ZeldiaboloJeu.modele.Labyrinthe;
import ZeldiaboloJeu.modele.Monstre;
import ZeldiaboloJeu.modele.Objet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Chargement {
    public static ZeldiaboloJeu chargerJeu(String nomFichier) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(nomFichier)); //lecture du fichier
            String ligne = br.readLine();
            ArrayList<String> lignes = new ArrayList<String>();
            int largMax = 0;
            while (ligne != null) {
                lignes.add(ligne);
                if (ligne.length() > largMax) largMax = ligne.length();
                ligne = br.readLine();
            }

            //creation du labyrinthe
            ZeldiaboloJeu jeu = new ZeldiaboloJeu();
            jeu.laby = new Labyrinthe();
            jeu.laby.murs = new boolean[largMax][lignes.size()];
            for (int y = 0; y < lignes.size(); y++) {
                ligne = lignes.get(y);
                for (int x = 0; x < ligne.length(); x++) {
                    char c = ligne.charAt(x);
                    if (c == Labyrinthe.MUR) {
                        jeu.laby.murs[x][y] = true;
                    } else if (c == Labyrinthe.PJ) {
                        jeu.perso = new Hero(x,y,5,1);
                    } else if (c == Labyrinthe.VIDE) {
                    }
                    else if (c == Labyrinthe.OBJ) {
                        jeu.objets.add(new Objet(x,y));
                    }
                    else if (c == Labyrinthe.MONSTER) {
                        jeu.monstres.add(new Monstre(x,y,3,1));
                    } else {
                        throw new FichierIncorrectException("charactere inconnu" + c);
                    }
                }
            }
            return jeu;
        } catch (FileNotFoundException e) {
            throw new FichierIncorrectException("Fichier non trouvé");
        } catch (IOException e) {
            throw new FichierIncorrectException("erreur de lecture");
        }
    }
}

