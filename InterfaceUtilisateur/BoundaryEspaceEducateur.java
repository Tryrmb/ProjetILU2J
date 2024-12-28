package InterfaceUtilisateur;

import java.util.Scanner;
import Gestion.EnfantController;
import Modele.Enfant;
import Modele.Activite;

//Classe BoundaryEspaceEducateur
public class BoundaryEspaceEducateur {
 private Scanner scanner = new Scanner(System.in);
 private EnfantController enfantController = new EnfantController();

 public void afficherEspaceEducateur() {
     System.out.println("\n--- Espace Éducateur ---");
     int choix;
     do {
         System.out.println("1) Liste des enfants");
         System.out.println("2) Gérer les activités");
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
             case 0:
                 System.out.println("Retour au menu principal.");
                 break;
             default:
                 System.out.println("Choix invalide, veuillez réessayer.");
         }
     } while (choix != 0);
 }

 private void afficherListeEnfants() {
     System.out.println("\nListe des enfants :");
     for (Enfant enfant : enfantController.getEnfants()) {
         System.out.println("- " + enfant.getNom());
     }
 }

 private void gererActivites() {
     System.out.println("Gestion des activités en cours de développement.");
 }
}