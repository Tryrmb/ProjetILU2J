package Modele;

public class Compte {
    private String email;
    private String motDePasse;

    // Constructeur
    public Compte(String email, String motDePasse) {
        this.email = email;
        this.motDePasse = motDePasse;
    }

    // Getter pour l'email
    public String getEmail() {
        return email;
    }

    // Getter pour le mot de passe
    public String getMotDePasse() {
        return motDePasse;
    }

    // Setter pour l'email (si nécessaire)
    public void setEmail(String email) {
        this.email = email;
    }

    // Setter pour le mot de passe (si nécessaire)
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "email='" + email + '\'' +
                '}';
    }
}
