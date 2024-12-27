package InterfaceUtilisateur;

import java.util.Scanner;
import Gestion.EnfantController;
import Modele.Enfant;
import Modele.Activite;

public class BoundaryEspaceEducateur {
    private Scanner scanner = new Scanner(System.in);
    private EnfantController enfantController = new EnfantController();

    public void afficherEspaceEducateur() {
        System.out.println("\n--- Espace Éducateur ---");
        System.out.println("Se connecter :");
        System.out.print("Adresse Mail : ");
        String email = scanner.nextLine();
        System.out.print("Mot de Passe : ");
        String password = scanner.nextLine();

        if (email.equals("educateur@example.com") && password.equals("abcd")) {
            System.out.println("Connexion réussie !");
            afficherOptionsEducateur();
        } else {
            System.out.println("Échec de la connexion.");
        }
    }

    private void afficherOptionsEducateur() {
        int choix;
        do {
            System.out.println("\n1) Liste des enfants");
            System.out.println("2) Gérer Activités");
            System.out.println("3) Gérer Santé");
            System.out.println("4) Voir Bilan");
            System.out.println("0) Retour");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    afficherListeEnfants();
                    break;
                case 2:
                    gererActivites();
                    break;
                case 3:
                    gererSante();
                    break;
                case 4:
                    afficherBilan();
                    break;
                case 0:
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choix != 0);
    }

    private void afficherListeEnfants() {
        System.out.println("Liste des enfants :");
        for (Enfant enfant : enfantController.getEnfants()) {
            System.out.println("- " + enfant.getNom());
        }
    }

    private void gererActivites() {
        System.out.println("Ajout d'une activité :");
        System.out.print("Nom de l'enfant : ");
        String nom = scanner.nextLine();
        System.out.print("Nom de l'activité : ");
        String activiteNom = scanner.nextLine();
        System.out.print("Description : ");
        String description = scanner.nextLine();

        Enfant enfant = enfantController.trouverEnfant(nom);
        if (enfant != null) {
            enfant.ajouterActivite(activiteNom);
            System.out.println("Activité ajoutée avec succès.");
        } else {
            System.out.println("Enfant non trouvé.");
        }
    }

    private void gererSante() {
        System.out.println("Gestion de la santé non implémentée.");
    }

    private void afficherBilan() {
        System.out.println("Bilan non disponible pour le moment.");
    }
}
