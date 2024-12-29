// Package : Gestion
package Gestion;

import Modele.Parent;
import Modele.Enfant;
import Modele.Educateur;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataStorage {
    private List<Parent> parents = new ArrayList<>();
    private List<Educateur> educateurs = new ArrayList<>();

    // Charger les données des parents depuis un fichier CSV
    public void chargerDonneesParentsDepuisCSV(String cheminFichier) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(cheminFichier));
        String ligne;
        boolean isFirstLine = true;

        while ((ligne = reader.readLine()) != null) {
            if (isFirstLine) {
                isFirstLine = false;
                continue;
            }
            try {
                String[] donnees = ligne.split(",");
                String nomParent = donnees[1].trim();
                String emailParent = donnees[2].trim();
                String motDePasse = donnees[12].trim();
                String nomEnfant = donnees[3].trim();
                String allergies = String.join(", ", donnees[4].trim(), donnees[5].trim(), donnees[6].trim(), donnees[7].trim());
                String regimeAlimentaire = donnees[8].trim();
                String problemeDeSante = donnees[9].trim();

                Parent parent = trouverParentParEmail(emailParent);
                if (parent == null) {
                    parent = new Parent(nomParent, emailParent, motDePasse);
                    parents.add(parent);
                }

                Enfant enfant = new Enfant(nomEnfant, allergies, regimeAlimentaire);
                enfant.ajouterActivite("Problème de santé : " + problemeDeSante);
                parent.ajouterEnfant(enfant);
            } catch (Exception e) {
                System.err.println("Erreur lors du traitement de la ligne : " + ligne);
            }
        }
        reader.close();
    }

    // Charger les données des éducateurs depuis un fichier CSV
    public void chargerDonneesEducateursDepuisCSV(String cheminFichier) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(cheminFichier));
        String ligne;
        boolean isFirstLine = true;

        while ((ligne = reader.readLine()) != null) {
            if (isFirstLine) {
                isFirstLine = false;
                continue;
            }
            try {
                String[] donnees = ligne.split(",");
                String nomEducateur = donnees[0].trim();
                String emailEducateur = donnees[1].trim();
                String motDePasse = donnees[2].trim();

                Educateur educateur = new Educateur(nomEducateur, emailEducateur, motDePasse);
                educateurs.add(educateur);
            } catch (Exception e) {
                System.err.println("Erreur lors du traitement de la ligne : " + ligne);
            }
        }
        reader.close();
    }

    public Parent trouverParentParEmail(String email) {
        for (Parent parent : parents) {
            if (parent.getEmail().equals(email)) {
                return parent;
            }
        }
        return null;
    }

    public Educateur trouverEducateurParEmail(String email) {
        for (Educateur educateur : educateurs) {
            if (educateur.getEmail().equals(email)) {
                return educateur;
            }
        }
        return null;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Educateur> getEducateurs() {
        return educateurs;
    }
}
