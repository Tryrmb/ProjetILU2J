// Package : Gestion
package Gestion;

import Modele.Compte;
import java.util.ArrayList;

//Classe CompteController
public class CompteController {
 private ArrayList<Compte> comptes = new ArrayList<>();

 public void ajouterCompte(String email, String motDePasse) {
     comptes.add(new Compte(email, motDePasse));
 }

 public boolean verifierIdentifiants(String email, String motDePasse) {
     for (Compte compte : comptes) {
         if (compte.getEmail().equals(email) && compte.getMotDePasse().equals(motDePasse)) {
             return true;
         }
     }
     return false;
 }

 public void afficherComptes() {
     System.out.println("Liste des comptes :");
     for (Compte compte : comptes) {
         System.out.println("- Email : " + compte.getEmail());
     }
 }
}
