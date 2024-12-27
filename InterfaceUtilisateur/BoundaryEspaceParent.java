package InterfaceUtilisateur;

import java.util.Scanner;
import Gestion.EnfantController;
import Gestion.CompteController;
import Modele.Enfant;

public class BoundaryEspaceParent {
    private Scanner scanner = new Scanner(System.in);
    private EnfantController enfantController = new EnfantController();
    private CompteController compteController = new CompteController();

    public BoundaryEspaceParent() {
        // Ajouter des comptes et des enfants pour le test
        compteController.ajouterCompte("parent@example.com", "1234");
        enfantController.ajouterEnfant(new Enfant("Asterix", "Gluten", "Vegan"));
        enfantController.ajouterEnfant(new Enfant("Obelix", "Lactose", "Végétarien"));
    }

    public void afficherEspaceParent() {
        System.out.println("\n--- Espace Parent ---");
        System.out.println("Se connecter :");
        System.out.print("Adresse Mail : ");
        String email = scanner.nextLine();
        System.out.print("Mot de Passe : ");
        String password = scanner.nextLine();

        if (compteController.verifierIdentifiants(email, password)) {
            System.out.println("Bienvenue dans votre espace parent, " + email + " !");
            afficherOptionsParent();
        } else {
            System.out.println("Échec de la connexion. Vérifiez vos identifiants.");
        }
    }

    private void afficherOptionsParent() {
        int choix;
        do {
            System.out.println("\n1) Voir Activités");
            System.out.println("2) Voir Santé");
            System.out.println("3) Voir Bilan");
            System.out.println("0) Retour");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    afficherActivites();
                    break;
                case 2:
                    afficherSante();
                    break;
                case 3:
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

    private void afficherActivites() {
        if (enfantController.getEnfants().isEmpty()) {
            System.out.println("Aucun enfant enregistré pour l'instant.");
            return;
        }

        System.out.println("Liste des activités inscrites pour vos enfants :");
        for (Enfant enfant : enfantController.getEnfants()) {
            System.out.println("- Enfant : " + enfant.getNom());
            for (String activite : enfant.getActivites()) {
                System.out.println("  Activité : " + activite);
            }
        }
    }

    private void afficherSante() {
        if (enfantController.getEnfants().isEmpty()) {
            System.out.println("Aucun enfant enregistré pour l'instant.");
            return;
        }

        System.out.println("Santé de vos enfants :");
        for (Enfant enfant : enfantController.getEnfants()) {
            System.out.println("- Enfant : " + enfant.getNom() + ", Allergies : " + enfant.getAllergies() + ", Régime : " + enfant.getRegimeAlimentaire());
        }
    }

    private void afficherBilan() {
        System.out.println("Bilan global de vos enfants :");
        for (Enfant enfant : enfantController.getEnfants()) {
            System.out.println("- Enfant : " + enfant.getNom());
            System.out.println("  Activités inscrites : " + enfant.getActivites().size());
        }
    }
}
