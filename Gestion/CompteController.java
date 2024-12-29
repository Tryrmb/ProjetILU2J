// Package : Gestion
package Gestion;

import Modele.Educateur;
import Modele.Parent;

import java.util.List;

public class CompteController {
    private DataStorage dataStorage;

    // Constructeur
    public CompteController(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    // Vérifier les identifiants
    public boolean verifierIdentifiants(String email, String motDePasse) {
        return dataStorage.getParents().stream()
                .anyMatch(parent -> parent.getEmail().equals(email) && parent.getMotDePasse().equals(motDePasse));
    }

    // Trouver un parent par email
    public Educateur trouverEducateurParEmail(String email) {
        return dataStorage.getEducateurs().stream()
                .filter(educateur -> educateur.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }
    }

