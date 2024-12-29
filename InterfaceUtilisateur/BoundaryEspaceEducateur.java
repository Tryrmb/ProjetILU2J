// Package : InterfaceUtilisateur
package InterfaceUtilisateur;

import Gestion.CompteController;
import Gestion.EnfantController;
import Modele.Educateur;

import java.util.Scanner;

public class BoundaryEspaceEducateur {
    private Scanner scanner = new Scanner(System.in);
    private CompteController compteController;
    private Educateur educateur;

    // Constructeur
    public BoundaryEspaceEducateur(String email, CompteController compteController) {
        this.compteController = compteController;

        // Récupérer les informations de l'éducateur via CompteController
        this.educateur = compteController.trouverEducateurParEmail(email);
    }

    // Afficher le menu éducateur
    public void afficherMenuEducateur() {
        if (educateur == null) {
            System.out.println("Erreur : Impossible de charger les données de l'éducateur.");
            return;
        }

        int choix;
        do {
            System.out.println("\n--- Menu Éducateur ---");
            System.out.println("1) Ajouter ou modifier une allergie");
            System.out.println("2) Ajouter ou modifier un problème de santé");
            System.out.println("3) Gérer les activités");
            System.out.println("4) Gérer les bilans");
            System.out.println("0) Retour au menu principal");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne restante

            switch (choix) {
                case 1:
                    ajouterModifierAllergie();
                    break;
                case 2:
                    ajouterModifierProblemeDeSante();
                    break;
                case 3:
                    gererActivites();
                    break;
                case 4:
                    gererBilans();
                    break;
                case 0:
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choix != 0);
    }

    // Méthodes spécifiques à l'éducateur

    private void ajouterModifierAllergie() {
        System.out.println("\n--- Ajouter ou Modifier une Allergie ---");
        System.out.print("Nom de l'enfant : ");
        String nomEnfant = scanner.nextLine();

        System.out.print("Nouvelle allergie : ");
        String allergie = scanner.nextLine();

        // Logique pour ajouter ou modifier une allergie
        System.out.println("L'allergie \"" + allergie + "\" a été ajoutée/modifiée pour l'enfant \"" + nomEnfant + "\".");
    }

    private void ajouterModifierProblemeDeSante() {
        System.out.println("\n--- Ajouter ou Modifier un Problème de Santé ---");
        System.out.print("Nom de l'enfant : ");
        String nomEnfant = scanner.nextLine();

        System.out.print("Nouveau problème de santé : ");
        String probleme = scanner.nextLine();

        // Logique pour ajouter ou modifier un problème de santé
        System.out.println("Le problème de santé \"" + probleme + "\" a été ajouté/modifié pour l'enfant \"" + nomEnfant + "\".");
    }

    private void gererActivites() {
        System.out.println("\n--- Gérer les Activités ---");
        // Placeholder pour la gestion des activités
        System.out.println("Fonctionnalité en cours de développement.");
    }

    private void gererBilans() {
        System.out.println("\n--- Gérer les Bilans ---");
        // Placeholder pour la gestion des bilans
        System.out.println("Fonctionnalité en cours de développement.");
    }
}
