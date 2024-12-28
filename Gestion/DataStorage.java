package Gestion;

import Modele.Parent;
import Modele.Enfant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataStorage {
    private List<Parent> parents = new ArrayList<>();

    // Méthode pour charger les données depuis un fichier CSV
    public void chargerDonneesDepuisCSV(String cheminFichier) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(cheminFichier));
        String ligne;

        while ((ligne = reader.readLine()) != null) {
            String[] donnees = ligne.split(",");
            String nomParent = donnees[0];
            String emailParent = donnees[1];
            String motDePasse = donnees[2];
            String nomEnfant = donnees[3];
            String allergies = donnees[4];
            String regime = donnees[5];

            Parent parent = trouverParentParEmail(emailParent);
            if (parent == null) {
                parent = new Parent(nomParent, emailParent, motDePasse);
                parents.add(parent);
            }
            parent.ajouterEnfant(new Enfant(nomEnfant, allergies, regime));
        }
        reader.close();
    }

    // Méthode pour trouver un parent par email
    public Parent trouverParentParEmail(String email) {
        for (Parent parent : parents) {
            if (parent.getEmail().equals(email)) {
                return parent;
            }
        }
        return null;
    }

    // Méthode pour récupérer la liste des parents
    public List<Parent> getParents() {
        return parents;
    }
}
