// Package : Gestion (Control avec Généricité)
package Gestion;

import Modele.Utilisateur;
import Modele.Activite;
import java.util.ArrayList;

// Classe générique pour gérer différents types d'activités
public class ActiviteController<T extends Activite> {
    private ArrayList<T> activites = new ArrayList<>();

    public void ajouterActivite(T activite) {
        activites.add(activite);
    }

    public void afficherActivites() {
        System.out.println("Liste des activités :");
        for (T activite : activites) {
            System.out.println("- " + activite.getNom() + " : " + activite.getDescription());
        }
    }

    public void verifierCompatibilites() {
        for (T activite : activites) {
            activite.verifierCompatibilite();
        }
    }
}