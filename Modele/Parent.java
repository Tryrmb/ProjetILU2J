package Modele;

public class Parent {
    private String nom;
    private String email;
    private String motDePasse;
    private Enfant[] enfants;
    private int enfantCount;
    private static final int MAX_ENFANTS = 10; // Taille maximale des enfants

    public Parent(String nom, String email, String motDePasse) {
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.enfants = new Enfant[MAX_ENFANTS];
        this.enfantCount = 0;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public Enfant[] getEnfants() {
        Enfant[] result = new Enfant[enfantCount];
        System.arraycopy(enfants, 0, result, 0, enfantCount);
        return result;
    }

    public void ajouterEnfant(Enfant enfant) {
        if (enfantCount < MAX_ENFANTS) {
            enfants[enfantCount++] = enfant;
        } else {
            System.err.println("Impossible d'ajouter un enfant : limite atteinte.");
        }
    }
}
