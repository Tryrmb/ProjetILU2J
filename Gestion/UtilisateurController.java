// Package : gestion
package Gestion;

import InterfaceUtilisateur.BoundaryEspaceParent;
import InterfaceUtilisateur.BoundaryEspaceEducateur;

public class UtilisateurController {
    public void gestionParent() {
        BoundaryEspaceParent espaceParent = new BoundaryEspaceParent();
        espaceParent.afficherEspaceParent();
    }

    public void gestionEducateur() {
        BoundaryEspaceEducateur espaceEducateur = new BoundaryEspaceEducateur();
        espaceEducateur.afficherEspaceEducateur();
    }
}