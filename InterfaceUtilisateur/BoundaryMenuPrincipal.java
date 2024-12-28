// Package : InterfaceUtilisateur
package InterfaceUtilisateur;

import Gestion.CompteController;
import Gestion.EnfantController;
import Gestion.ActiviteController;
import Modele.*;
import java.util.Scanner;

// Classe BoundaryMenuPrincipal
public class BoundaryMenuPrincipal {
    private Scanner scanner = new Scanner(System.in);
    private CompteController compteController = new CompteController();

    public void afficherMenuPrincipal() {
        int choix;
        do {
            System.out.println("\n--------- Bienvenue Sur EnfantPro+ ---------");
            System.out.println("1) Espace Parent");
            System.out.println("2) Espace Educateur");
            System.out.println("0) Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    afficherEspaceParent();
                    break;
                case 2:
                    afficherEspaceEducateur();
                    break;
                case 0:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choix != 0);
    }

    private void afficherEspaceParent() {
        BoundaryEspaceParent espaceParent = new BoundaryEspaceParent(compteController);
        espaceParent.afficherEspaceParent();
    }

    private void afficherEspaceEducateur() {
        BoundaryEspaceEducateur espaceEducateur = new BoundaryEspaceEducateur();
        espaceEducateur.afficherEspaceEducateur();
    }
}