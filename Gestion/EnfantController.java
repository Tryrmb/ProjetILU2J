package Gestion;

import java.util.ArrayList;
import java.util.List;

import Modele.Enfant;

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
}
