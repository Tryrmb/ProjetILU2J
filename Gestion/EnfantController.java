// Package : Gestion
package Gestion;

import Modele.Enfant;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe EnfantController
 * Gère les opérations sur les enfants, notamment l'ajout, la recherche et la gestion des données.
 */
public class EnfantController {
    private List<Enfant> enfants = new ArrayList<>();

    /**
     * Ajoute un enfant à la liste des enfants.
     *
     * @param enfant L'enfant à ajouter.
     */
    public void ajouterEnfant(Enfant enfant) {
        enfants.add(enfant);
    }

    /**
     * Retourne la liste des enfants gérés par ce contrôleur.
     *
     * @return Liste des enfants.
     */
    public List<Enfant> getEnfants() {
        return enfants;
    }

    /**
     * Recherche un enfant par son nom dans la liste des enfants.
     *
     * @param nom Le nom de l'enfant à rechercher.
     * @return L'enfant correspondant au nom, ou null s'il n'est pas trouvé.
     */
    public Enfant trouverEnfantParNom(String nom) {
        for (Enfant enfant : enfants) {
            if (enfant.getNom().equalsIgnoreCase(nom)) {
                return enfant;
            }
        }
        return null; // Retourne null si aucun enfant ne correspond
    }

    /**
     * Affiche tous les enfants et leurs informations de base (nom, allergies, régime alimentaire).
     */
    public void afficherEnfants() {
        System.out.println("\n--- Liste des Enfants ---");
        if (enfants.isEmpty()) {
            System.out.println("Aucun enfant enregistré.");
        } else {
            for (Enfant enfant : enfants) {
                System.out.println("Nom : " + enfant.getNom());
                System.out.println("Allergies : " + enfant.getAllergies());
                System.out.println("Régime Alimentaire : " + enfant.getRegimeAlimentaire());
                System.out.println("-------------------------");
            }
        }
    }
}
