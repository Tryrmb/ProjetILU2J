package Gestion;

import Modele.Activite;
import java.util.ArrayList;
import java.util.List;

public class ActiviteController<T extends Activite> {
    private List<T> activites = new ArrayList<>();

    public void ajouterActivite(String nomEnfant, T activite) {
        activites.add(activite);
    }

    public void afficherActivites(String nomEnfant) {
        if (activites.isEmpty()) {
            System.out.println("Aucune activité disponible.");
        } else {
            System.out.println("Liste des activités :");
            for (T activite : activites) {
                System.out.println("- " + activite.getNom() + ": " + activite.getDescription());
            }
        }
    }

    public void verifierCompatibilites() {
        for (T activite : activites) {
            activite.verifierCompatibilite();
        }
    }
}

