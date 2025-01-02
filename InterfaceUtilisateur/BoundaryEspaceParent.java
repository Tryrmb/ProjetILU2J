// Package : InterfaceUtilisateur
package InterfaceUtilisateur;

import Gestion.CompteController;
import Gestion.EnfantController;
import Modele.Parent;

import java.util.Scanner;

public class BoundaryEspaceParent {
    private Scanner scanner = new Scanner(System.in);
    private CompteController compteController;
    private EnfantController enfantController;
    private Parent parent;

    public BoundaryEspaceParent(String email, CompteController compteController, EnfantController enfantController) {
        this.compteController = compteController;
        this.enfantController = enfantController;
        this.parent = compteController.trouverParentParEmail(email); // Récupérer les infos du parent
    }

    public void afficherMenuParent() {
        if (parent == null) {
            System.out.println("Erreur : Impossible de charger les données du parent.");
            return;
        }

        int choix;
        do {
            System.out.println("\n--- Menu Parent ---");
            System.out.println("1) Voir les activités des enfants");
            System.out.println("2) Voir les informations santé des enfants");
            System.out.println("3) Voir les bilans");
            System.out.println("0) Retour au menu principal");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne restante

            switch (choix) {
                case 1:
                    afficherActivitesEnfants();
                    break;
                case 2:
                    afficherSanteEnfants();
                    break;
                case 3:
                    afficherBilans();
                    break;
                case 0:
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choix != 0);
    }

    private void afficherActivitesEnfants() {
        System.out.println("\n--- Activités des enfants ---");
        for (var enfant : parent.getEnfants()) {
            if (enfant != null) {
                System.out.println("Enfant : " + enfant.getNom());
                for (var activite : enfant.getActivites()) {
                    if (activite != null) {
                        System.out.println(" - Activité : " + activite);
                    }
                }
            }
        }
    }

    private void afficherSanteEnfants() {
        System.out.println("\n--- Informations santé des enfants ---");
        for (var enfant : parent.getEnfants()) {
            if (enfant != null) {
                System.out.println("Enfant : " + enfant.getNom());
                System.out.println(" - Allergies : " + enfant.getAllergies());
                System.out.println(" - Régime alimentaire : " + enfant.getRegimeAlimentaire());
            }
        }
    }

    private void afficherBilans() {
        System.out.println("\n--- Bilans des enfants ---");
        for (var enfant : parent.getEnfants()) {
            if (enfant != null) {
                System.out.println("Bilan pour " + enfant.getNom() + ": Fonctionnalité en cours de développement.");
            }
        }
    }
}
