// Package : gestion
package Gestion;

import Modele.Enfant;
import java.util.ArrayList;

public class EnfantController {
    private ArrayList<Enfant> enfants = new ArrayList<>();

    public void ajouterEnfant(Enfant enfant) {
        enfants.add(enfant);
    }

    public ArrayList<Enfant> getEnfants() {
        return enfants;
    }

    public Enfant trouverEnfant(String nom) {
        for (Enfant enfant : enfants) {
            if (enfant.getNom().equals(nom)) {
                return enfant;
            }
        }
        return null;
    }

    public void afficherListeEnfants() {
        if (enfants.isEmpty()) {
            System.out.println("Aucun enfant inscrit.");
        } else {
            System.out.println("Liste des enfants inscrits :");
            for (Enfant enfant : enfants) {
                System.out.println("- " + enfant.getNom());
            }
        }
    }
}