package Modele;

import Enumeration.TypeActivite;

/**
 * Classe abstraite Activite
 * Modélise une activité en crèche en prenant en compte les allergies et les
 * restrictions alimentaires des participants.
 */
public abstract class Activite {
    private String nom;
    private String description;
    private TypeActivite typeActivite;

    // Attributs pour gérer les participants et leurs informations
    private String[] participants;
    private String[] restrictionsAlimentaires;
    private String[] contactsParents;
    private int participantCount = 0;
    private static final int MAX_PARTICIPANTS = 50; // Taille maximale

    // Constructeur
    public Activite(String nom, String description, TypeActivite typeActivite) {
        this.nom = nom;
        this.description = description;
        this.typeActivite = typeActivite;
        this.participants = new String[MAX_PARTICIPANTS];
        this.restrictionsAlimentaires = new String[MAX_PARTICIPANTS];
        this.contactsParents = new String[MAX_PARTICIPANTS];
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public TypeActivite getTypeActivite() {
        return typeActivite;
    }

    // Méthodes abstraites
    public abstract void verifierCompatibiliteParticipants();
    public abstract void gererIncompatibilites();

    // Méthodes concrètes

    /**
     * Ajoute un participant avec sa restriction alimentaire et son contact parent.
     *
     * @param enfant        Nom de l'enfant participant
     * @param restriction   Restriction alimentaire de l'enfant
     * @param contactParent Coordonnées du parent (email ou téléphone)
     * @throws IllegalStateException Si la capacité maximale est atteinte
     */
    public void ajouterParticipant(String enfant, String restriction, String contactParent) {
        if (participantCount >= MAX_PARTICIPANTS) {
            throw new IllegalStateException("Nombre maximum de participants atteint.");
        }
        participants[participantCount] = enfant;
        restrictionsAlimentaires[participantCount] = restriction;
        contactsParents[participantCount] = contactParent;
        participantCount++;
    }

    /**
     * Affiche les participants, leurs restrictions alimentaires et les contacts des parents.
     */
    public void afficherParticipants() {
        System.out.println("Participants de l'activité : " + nom);
        for (int i = 0; i < participantCount; i++) {
            System.out.println(" - Enfant : " + participants[i]);
            System.out.println("   Restriction : " + restrictionsAlimentaires[i]);
            System.out.println("   Contact parent : " + contactsParents[i]);
        }
    }

    /**
     * Envoie une notification générique aux parents.
     *
     * @param message Message à envoyer aux parents
     */
    public void notifierParents(String message) {
        System.out.println("Envoi de notifications aux parents...");
        for (int i = 0; i < participantCount; i++) {
            System.out.println("Notification envoyée à " + contactsParents[i] + " : " + message);
        }
    }
}
