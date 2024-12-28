// Package : InterfaceUtilisateur
package InterfaceUtilisateur;

import Gestion.CompteController;
import java.util.Scanner;

//Classe BoundaryEspaceParent
public class BoundaryEspaceParent {
 private Scanner scanner = new Scanner(System.in);
 private CompteController compteController;

 public BoundaryEspaceParent(CompteController compteController) {
     this.compteController = compteController;
 }

 public void afficherEspaceParent() {
     System.out.println("\n--- Espace Parent ---");
     System.out.print("Email : ");
     String email = scanner.nextLine();
     System.out.print("Mot de passe : ");
     String motDePasse = scanner.nextLine();

     if (compteController.verifierIdentifiants(email, motDePasse)) {
         System.out.println("Connexion réussie ! Bienvenue " + email);
     } else {
         System.out.println("Échec de la connexion. Vérifiez vos identifiants.");
     }
 }
}
