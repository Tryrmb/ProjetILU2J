// Package : modele
package Modele;

import java.util.ArrayList;

public class Enfant {
    private String nom;
    private String allergies;
    private String regimeAlimentaire;
    private ArrayList<String> activites = new ArrayList<>();

    public Enfant(String nom, String allergies, String regimeAlimentaire) {
        this.nom = nom;
        this.allergies = allergies;
        this.regimeAlimentaire = regimeAlimentaire;
    }

    public String getNom() {
        return nom;
    }

    public String getAllergies() {
        return allergies;
    }

    public String getRegimeAlimentaire() {
        return regimeAlimentaire;
    }

    public ArrayList<String> getActivites() {
        return activites;
    }

    public void ajouterActivite(String activite) {
        activites.add(activite);
    }
}
