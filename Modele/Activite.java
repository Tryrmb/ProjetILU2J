// Package : Modele
package Modele;

import java.util.ArrayList;
import java.util.List;

// Classe abstraite Activite
public abstract class Activite {
    private String nom;
    private String description;

    public Activite(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public abstract void verifierCompatibilite();
}