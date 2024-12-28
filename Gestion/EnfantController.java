package Gestion;

import java.util.ArrayList;
import Modele.Enfant;

// Classe EnfantController
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
}