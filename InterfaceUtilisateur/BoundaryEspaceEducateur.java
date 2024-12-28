package InterfaceUtilisateur;

import java.util.Scanner;
import Gestion.EnfantController;
import Modele.Enfant;

//Classe BoundaryEspaceEducateur
public class BoundaryEspaceEducateur {
 private Scanner scanner = new Scanner(System.in);
 private EnfantController enfantController;

 public BoundaryEspaceEducateur(EnfantController enfantController) {
     this.enfantController = enfantController;
 }

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
     BoundaryGestionActivitesIU gestionActivites = new BoundaryGestionActivitesIU();
     gestionActivites.gererActivites();
 }
}
