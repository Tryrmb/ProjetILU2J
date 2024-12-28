package Modele;

import java.util.ArrayList;
import java.util.List;

// Classe Parent
public class Parent {
    private String nom;
    private String email;
    private String motDePasse;
    private List<Enfant> enfants;

    public Parent(String nom, String email, String motDePasse) {
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.enfants = new ArrayList<>();
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public List<Enfant> getEnfants() {
        return enfants;
    }

    public void ajouterEnfant(Enfant enfant) {
        if (!enfants.contains(enfant)) {
            enfants.add(enfant);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Parent{nom='").append(nom)
                .append("', email='").append(email)
                .append("', enfants=[");
        for (Enfant enfant : enfants) {
            sb.append("\n  ").append(enfant.toString());
        }
        sb.append("\n]}");
        return sb.toString();
    }
}
