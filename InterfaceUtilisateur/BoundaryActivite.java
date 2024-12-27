// Package : InterfaceUtilisateur (Boundary avec Généricité)
package InterfaceUtilisateur;

import Gestion.ActiviteController;
import Modele.Activite;
import Modele.ActiviteCulinaire;
import Modele.ActiviteRecreative;
import java.util.Scanner;

public class BoundaryActivite<T extends Activite> {
    private ActiviteController<T> activiteController;
    private Scanner scanner;

    public BoundaryActivite(ActiviteController<T> activiteController) {
        this.activiteController = activiteController;
        this.scanner = new Scanner(System.in);
    }

    public void ajouterActiviteCulinaire() {
        System.out.print("Nom de l'activité : ");
        String nom = scanner.nextLine();
        System.out.print("Description : ");
        String description = scanner.nextLine();
        System.out.print("Type de cuisine : ");
        String typeCuisine = scanner.nextLine();

        ActiviteCulinaire activite = new ActiviteCulinaire(nom, description, typeCuisine);
        activiteController.ajouterActivite((T) activite);
        System.out.println("Activité culinaire ajoutée avec succès.");
    }

    public void ajouterActiviteRecreative() {
        System.out.print("Nom de l'activité : ");
        String nom = scanner.nextLine();
        System.out.print("Description : ");
        String description = scanner.nextLine();
        System.out.print("Type de lieu : ");
        String typeLieu = scanner.nextLine();

        ActiviteRecreative activite = new ActiviteRecreative(nom, description, typeLieu);
        activiteController.ajouterActivite((T) activite);
        System.out.println("Activité récréative ajoutée avec succès.");
    }

    public void afficherActivites() {
        activiteController.afficherActivites();
    }

    public void verifierCompatibilites() {
        activiteController.verifierCompatibilites();
    }
}
