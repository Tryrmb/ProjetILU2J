// Package : Gestion
package Gestion;

import Modele.Parent;
import Modele.Educateur;
import Modele.Enfant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe DataStorage
 * Gère le chargement et la gestion des données à partir de fichiers CSV pour les parents, éducateurs et enfants.
 */
public class DataStorage {
    private List<Parent> parents = new ArrayList<>();
    private List<Educateur> educateurs = new ArrayList<>();

    /**
     * Charge les données des parents depuis un fichier CSV.
     *
     * @param cheminFichier Le chemin du fichier CSV contenant les données des parents.
     * @throws IOException En cas de problème de lecture du fichier.
     */
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
                String motDePasse = donnees[3].trim();
                String nomEnfant = donnees[4].trim();
                String allergies = donnees[5].trim();
                String regimeAlimentaire = donnees[6].trim();

                Parent parent = trouverParentParEmail(emailParent);
                if (parent == null) {
                    parent = new Parent(nomParent, emailParent, motDePasse);
                    parents.add(parent);
                }

                Enfant enfant = new Enfant(nomEnfant, allergies, regimeAlimentaire);
                parent.ajouterEnfant(enfant);
            } catch (Exception e) {
                System.err.println("Erreur lors du traitement de la ligne : " + ligne);
            }
        }
        reader.close();
    }

    /**
     * Charge les données des éducateurs depuis un fichier CSV.
     *
     * @param cheminFichier Le chemin du fichier CSV contenant les données des éducateurs.
     * @throws IOException En cas de problème de lecture du fichier.
     */
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
                String nomEducateur = donnees[1].trim();
                String emailEducateur = donnees[2].trim();
                String motDePasse = donnees[3].trim();

                Educateur educateur = new Educateur(nomEducateur, emailEducateur, motDePasse);
                educateurs.add(educateur);
            } catch (Exception e) {
                System.err.println("Erreur lors du traitement de la ligne : " + ligne);
            }
        }
        reader.close();
    }

    /**
     * Recherche un parent par son email.
     *
     * @param email L'email du parent recherché.
     * @return Le parent correspondant, ou null s'il n'est pas trouvé.
     */
    public Parent trouverParentParEmail(String email) {
        for (Parent parent : parents) {
            if (parent.getEmail().equals(email)) {
                return parent;
            }
        }
        return null;
    }

    /**
     * Recherche un éducateur par son email.
     *
     * @param email L'email de l'éducateur recherché.
     * @return L'éducateur correspondant, ou null s'il n'est pas trouvé.
     */
    public Educateur trouverEducateurParEmail(String email) {
        for (Educateur educateur : educateurs) {
            if (educateur.getEmail().equals(email)) {
                return educateur;
            }
        }
        return null;
    }

    /**
     * Retourne la liste des parents chargés.
     *
     * @return La liste des parents.
     */
    public List<Parent> getParents() {
        return parents;
    }

    /**
     * Retourne la liste des éducateurs chargés.
     *
     * @return La liste des éducateurs.
     */
    public List<Educateur> getEducateurs() {
        return educateurs;
    }

    /**
     * Affiche la liste des parents chargés.
     */
    public void afficherParents() {
        System.out.println("\n--- Liste des Parents ---");
        for (Parent parent : parents) {
            System.out.println("Nom : " + parent.getNom() + ", Email : " + parent.getEmail() + ", Mot de passe : " + parent.getMotDePasse());
        }
    }

    /**
     * Affiche la liste des éducateurs chargés.
     */
    public void afficherEducateurs() {
        System.out.println("\n--- Liste des Éducateurs ---");
        for (Educateur educateur : educateurs) {
            System.out.println("Nom : " + educateur.getNom() + ", Email : " + educateur.getEmail() + ", Mot de passe : " + educateur.getMotDePasse());
        }
    }
}

