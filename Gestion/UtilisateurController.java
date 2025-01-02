// Package : Gestion
package Gestion;

import InterfaceUtilisateur.BoundaryEspaceParent;
import InterfaceUtilisateur.BoundaryEspaceEducateur;

public class UtilisateurController {
    private CompteController compteController;
    private EnfantController enfantController;
    private GestionnaireIncompatibilité gestionnaireIncompatibilites;

    public UtilisateurController(CompteController compteController, EnfantController enfantController, GestionnaireIncompatibilité gestionnaireIncompatibilites) {
        this.compteController = compteController;
        this.enfantController = enfantController;
        this.gestionnaireIncompatibilites = gestionnaireIncompatibilites;
    }

    public void gestionParent(String email) {
        BoundaryEspaceParent espaceParent = new BoundaryEspaceParent(email, compteController, enfantController);
        espaceParent.afficherMenuParent(); // Appelle le menu parent
    }

    public void gestionEducateur(String email) {
        BoundaryEspaceEducateur espaceEducateur = new BoundaryEspaceEducateur(email, compteController, enfantController, gestionnaireIncompatibilites);
        espaceEducateur.afficherMenuEducateur();
    }
}

