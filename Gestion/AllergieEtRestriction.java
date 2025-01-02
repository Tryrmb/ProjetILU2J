// Package : Gestion
package Gestion;

import java.util.ArrayList;
import java.util.List;

// Classe générique
public class AllergieEtRestriction<T> {
    private T[] typeRestrictions;
    private String[] descriptions;
    private int[] niveauxGravite;
    private String[] actionsPrevention;
    private int tailleMax;
    private int currentSize;

    // Constructeur pour initialiser les tableaux avec une taille maximale
    public AllergieEtRestriction(int tailleMax) {
        this.tailleMax = tailleMax;
        this.typeRestrictions = (T[]) new Object[tailleMax];
        this.descriptions = new String[tailleMax];
        this.niveauxGravite = new int[tailleMax];
        this.actionsPrevention = new String[tailleMax];
        this.currentSize = 0;
    }

    // Méthode pour ajouter une restriction
    public void ajouterRestriction(T restriction, String description, int niveau, String action)
            throws RestrictionIncompatibleException {
        if (niveau < 0 || niveau > 10) {
            throw new RestrictionIncompatibleException("Le niveau de gravité doit être compris entre 0 et 10.");
        }
        if (currentSize >= tailleMax) {
            throw new RestrictionIncompatibleException("Impossible d'ajouter une nouvelle restriction : tableau plein.");
        }
        typeRestrictions[currentSize] = restriction;
        descriptions[currentSize] = description;
        niveauxGravite[currentSize] = niveau;
        actionsPrevention[currentSize] = action;
        currentSize++;
    }

    // Méthode pour vérifier la compatibilité
    public boolean verifierCompatibilite(T restriction) {
        for (int i = 0; i < currentSize; i++) {
            if (typeRestrictions[i].equals(restriction)) {
                return false;
            }
        }
        return true;
    }

    // Méthode pour générer une alerte
    public void genererAlerte(int index) {
        if (index >= 0 && index < currentSize) {
            System.out.println("ALERTE : Restriction détectée !");
            System.out.println("Type : " + typeRestrictions[index]);
            System.out.println("Description : " + descriptions[index]);
            System.out.println("Niveau de gravité : " + niveauxGravite[index]);
            System.out.println("Action préventive : " + actionsPrevention[index]);
        } else {
            System.out.println("Indice invalide pour générer une alerte.");
        }
    }

    // Classe interne pour gérer les notifications
    public class Notification {
        public void envoyerNotification(T restriction) {
            System.out.println("Notification : La restriction \"" + restriction
                    + "\" pourrait poser un problème. Veuillez vérifier.");
        }
    }
}

