// Package : main
package main;

import Gestion.CompteController;
import Gestion.EnfantController;
import Gestion.DataStorage;
import Gestion.GestionnaireIncompatibilité;
import Gestion.UtilisateurController;
import InterfaceUtilisateur.BoundaryMenuPrincipal;

import java.io.IOException;

public class EnfantPro {
    public static void main(String[] args) {
        // Initialisation des contrôleurs et du stockage
        DataStorage dataStorage = new DataStorage();
        CompteController compteController = new CompteController(dataStorage);
        EnfantController enfantController = new EnfantController(); // Sans dépendance
        GestionnaireIncompatibilité gestionnaireIncompatibilites = new GestionnaireIncompatibilité();

        // Chargement des données depuis les fichiers CSV
        try {
            dataStorage.chargerDonneesParentsDepuisCSV("src/ressources/parents_enfants.csv");
            dataStorage.chargerDonneesEducateursDepuisCSV("src/ressources/educateurs_donnees.csv");
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement des données : " + e.getMessage());
            return;
        }

        // Initialisation du contrôleur utilisateur
        UtilisateurController utilisateurController = new UtilisateurController(
            compteController, enfantController, gestionnaireIncompatibilites
        );

        // Initialisation du menu principal
        BoundaryMenuPrincipal menu = new BoundaryMenuPrincipal(compteController, enfantController);
        menu.afficherMenuPrincipal();
    }
}
