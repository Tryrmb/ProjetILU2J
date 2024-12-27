package InterfaceUtilisateur;

import java.util.Scanner;
import Gestion.UtilisateurController;

public class BoundaryMenuPrincipal {
    private Scanner scanner = new Scanner(System.in);
    private UtilisateurController utilisateurController = new UtilisateurController();

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
                    utilisateurController.gestionParent();
                    break;
                case 2:
                    utilisateurController.gestionEducateur();
                    break;
                case 0:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choix != 0);
    }
}