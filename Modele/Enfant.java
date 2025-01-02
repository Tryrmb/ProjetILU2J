package Modele;

import Gestion.AllergieEtRestriction;
import java.util.HashSet;
import java.util.Set;

public class Enfant {
    private String nom;
    private String allergies;
    private String regimeAlimentaire;
    private String[] activites;
    private int activiteCount;
    private static final int MAX_ACTIVITES = 10; // Taille maximale des activités

    // Attributs supplémentaires
    private Set<String> problemesDeSante; // Ensemble des problèmes de santé
    private Set<String> conditionsMedicales; // Allergies et problèmes combinés
    private String bilan; // Bilan de l'enfant

    public Enfant(String nom, String allergies, String regimeAlimentaire) {
        this.nom = nom;
        this.allergies = allergies;
        this.regimeAlimentaire = regimeAlimentaire;
        this.activites = new String[MAX_ACTIVITES];
        this.activiteCount = 0;
        this.problemesDeSante = new HashSet<>();
        this.conditionsMedicales = new HashSet<>();
        this.conditionsMedicales.add(allergies); // Ajouter les allergies aux conditions médicales
        this.bilan = ""; // Initialisation vide
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getAllergies() {
        return allergies;
    }

    public String getRegimeAlimentaire() {
        return regimeAlimentaire;
    }

    public String getBilan() {
        return bilan;
    }

    public Set<String> getProblemesDeSante() {
        return problemesDeSante;
    }

    public Set<String> getConditionsMedicales() {
        return conditionsMedicales;
    }

    public String[] getActivites() {
        String[] result = new String[activiteCount];
        System.arraycopy(activites, 0, result, 0, activiteCount);
        return result;
    }

    // Setters
    public void setBilan(String bilan) {
        this.bilan = bilan;
    }

    // Méthodes pour gérer les activités
    public void ajouterActivite(String activite) {
        if (activiteCount < MAX_ACTIVITES) {
            activites[activiteCount++] = activite;
        } else {
            System.err.println("Impossible d'ajouter l'activité : limite atteinte.");
        }
    }

    // Méthodes pour gérer les problèmes de santé
    public void ajouterProblemeDeSante(String probleme) {
        problemesDeSante.add(probleme);
        conditionsMedicales.add(probleme);
    }

    // Méthodes pour gérer les allergies
    public void ajouterAllergie(String allergie) {
        conditionsMedicales.add(allergie);
    }

    public boolean supprimerAllergie(String allergie) {
        if (conditionsMedicales.remove(allergie)) {
            return true;
        }
        return false;
    }

    // Méthode pour afficher les informations de l'enfant
    public void afficherInfos() {
        System.out.println("Nom : " + nom);
        System.out.println("Allergies : " + allergies);
        System.out.println("Régime Alimentaire : " + regimeAlimentaire);
        System.out.println("Bilan : " + bilan);
        System.out.println("Problèmes de Santé : " + problemesDeSante);
        System.out.println("Activités : ");
        for (int i = 0; i < activiteCount; i++) {
            System.out.println(" - " + activites[i]);
        }
    }
}
