// Package : Gestion
package Gestion;

import Modele.Compte;
import java.util.ArrayList;
import java.util.List;


//Classe CompteController
public class CompteController {
 private List<Compte> comptes = new ArrayList<>();

 public void ajouterCompte(String email, String motDePasse) {
     comptes.add(new Compte(email, motDePasse));
 }

 public boolean verifierIdentifiants(String email, String motDePasse) {
     return comptes.stream()
             .anyMatch(compte -> compte.getEmail().equals(email) && compte.getMotDePasse().equals(motDePasse));
 }
}