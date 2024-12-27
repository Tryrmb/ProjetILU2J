// Package : Gestion
package Gestion;

import Modele.Compte;
import java.util.ArrayList;

public class CompteController {
    private ArrayList<Compte> comptes = new ArrayList<>();

    // Ajouter un nouveau compte
    public void ajouterCompte(String email, String motDePasse) {
        comptes.add(new Compte(email, motDePasse));
    }

    // Vérifier les identifiants d'un utilisateur
    public boolean verifierIdentifiants(String email, String motDePasse) {
        for (Compte compte : comptes) {
            if (compte.getEmail().equals(email) && compte.getMotDePasse().equals(motDePasse)) {
                return true;
            }
        }
        return false;
    }

    // Afficher tous les comptes enregistrés (pour debug)
    public void afficherComptes() {
        System.out.println("Liste des comptes :");
        for (Compte compte : comptes) {
            System.out.println("- Email : " + compte.getEmail());
        }
    }
}
