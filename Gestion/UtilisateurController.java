// Package : gestion
package Gestion;

import InterfaceUtilisateur.BoundaryEspaceParent;
import InterfaceUtilisateur.BoundaryEspaceEducateur;

public class UtilisateurController {
    public void gestionParent() {
        BoundaryEspaceParent espaceParent = new BoundaryEspaceParent(null);
        espaceParent.afficherEspaceParent();
    }

    public void gestionEducateur() {
        BoundaryEspaceEducateur espaceEducateur = new BoundaryEspaceEducateur(null);
        espaceEducateur.afficherEspaceEducateur();
    }
}