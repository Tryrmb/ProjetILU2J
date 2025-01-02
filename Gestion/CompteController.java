// Package : Gestion
package Gestion;

import Modele.Parent;
import Modele.Educateur;
import java.util.List;

public class CompteController {
    private DataStorage dataStorage;

    public CompteController(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    public boolean verifierIdentifiants(String email, String motDePasse) {
        Parent parent = dataStorage.trouverParentParEmail(email);
        return parent != null && parent.getMotDePasse().equals(motDePasse);
    }

    public boolean verifierIdentifiantsEducateur(String email, String motDePasse) {
        System.out.println("Tentative d'authentification :");
        System.out.println("Email fourni : " + email);
        System.out.println("Mot de passe fourni : " + motDePasse);

        Educateur educateur = trouverEducateurParEmail(email);

        if (educateur == null) {
            System.out.println("Échec : Aucun éducateur trouvé avec l'email " + email);
            return false;
        }

        System.out.println("Éducateur trouvé : " + educateur.getEmail());
        System.out.println("Mot de passe attendu : " + educateur.getMotDePasse());

        if (educateur.getMotDePasse().equals(motDePasse)) {
            System.out.println("Authentification réussie !");
            return true;
        } else {
            System.out.println("Échec : Mot de passe incorrect.");
            return false;
        }
    }

    public Parent trouverParentParEmail(String email) {
        return dataStorage.trouverParentParEmail(email);
    }

    public Educateur trouverEducateurParEmail(String email) {
        List<Educateur> listeEducateurs = dataStorage.getEducateurs();
        for (Educateur educateur : listeEducateurs) {
            if (educateur.getEmail().equals(email)) {
                return educateur;
            }
        }
        return null;
    }

}
