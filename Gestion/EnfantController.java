package Gestion;

import java.util.ArrayList;
import java.util.List;

import Modele.Enfant;
import Modele.Parent;

// Classe EnfantController
//Classe EnfantController
public class EnfantController {
 private List<Enfant> enfants = new ArrayList<>();

 public void ajouterEnfant(Enfant enfant) {
     enfants.add(enfant);
 }

 public List<Enfant> getEnfants() {
     return enfants;
 }

public Parent trouverParentParEmail(String email) {
	// TODO Auto-generated method stub
	return null;
}


}
