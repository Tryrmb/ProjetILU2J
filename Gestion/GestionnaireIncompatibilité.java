// Package : Gestion
package Gestion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GestionnaireIncompatibilité {
    private Map<String, Set<String>> incompatibilites;

    public GestionnaireIncompatibilité() {
        this.incompatibilites = new HashMap<>();
    }

    // Charger les incompatibilités depuis un fichier CSV
    public void chargerIncompatibilites(String cheminFichier) {
        // Exemple de traitement simplifié. Ajouter votre logique pour charger depuis le fichier.
        incompatibilites.put("Natation", Set.of("Asthme grave", "Allergie au chlore"));
        incompatibilites.put("Cuisine", Set.of("Allergie au gluten", "Allergie aux noix"));
    }

    // Vérifie si une activité est compatible avec une liste d'allergies ou de problèmes de santé
    public boolean estCompatible(String activite, Set<String> conditions) {
        if (!incompatibilites.containsKey(activite)) {
            return true; // Pas de restrictions pour cette activité
        }
        for (String condition : conditions) {
            if (incompatibilites.get(activite).contains(condition)) {
                return false; // Une incompatibilité est trouvée
            }
        }
        return true;
    }

    // Obtenir les raisons d'incompatibilité
    public Set<String> obtenirIncompatibilites(String activite, Set<String> conditions) {
        Set<String> raisons = new HashSet<>();
        if (!incompatibilites.containsKey(activite)) {
            return raisons;
        }
        for (String condition : conditions) {
            if (incompatibilites.get(activite).contains(condition)) {
                raisons.add(condition);
            }
        }
        return raisons;
    }
}
