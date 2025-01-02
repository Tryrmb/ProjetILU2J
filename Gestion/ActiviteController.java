// Package : Gestion
package Gestion;

import Modele.Activite;
import java.util.HashMap;
import java.util.Map;

// Classe ActiviteController
public class ActiviteController<T extends Activite> {
    private Map<String, T[]> activitesParEnfant = new HashMap<>();
    private static final int TAILLE_MAX = 10; // Taille maximale des tableaux pour chaque enfant

    public void ajouterActivite(String nomEnfant, T activite) {
        T[] activites = activitesParEnfant.getOrDefault(nomEnfant, (T[]) new Activite[TAILLE_MAX]);

        // Trouver la prochaine position libre dans le tableau
        for (int i = 0; i < TAILLE_MAX; i++) {
            if (activites[i] == null) {
                activites[i] = activite;
                activitesParEnfant.put(nomEnfant, activites);
                return;
            }
        }
        System.out.println("Impossible d'ajouter l'activité : tableau plein pour " + nomEnfant);
    }

    public void afficherActivites(String nomEnfant) {
        T[] activites = activitesParEnfant.getOrDefault(nomEnfant, (T[]) new Activite[TAILLE_MAX]);
        boolean aucuneActivite = true;

        System.out.println("Activités pour " + nomEnfant + " :");
        for (T activite : activites) {
            if (activite != null) {
                System.out.println("- " + activite.getNom() + ": " + activite.getDescription());
                aucuneActivite = false;
            }
        }

        if (aucuneActivite) {
            System.out.println("Aucune activité trouvée pour " + nomEnfant);
        }
    }
}

