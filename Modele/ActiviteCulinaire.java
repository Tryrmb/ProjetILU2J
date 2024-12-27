package Modele;

//Classe ActiviteCulinaire hérite de Activite
public class ActiviteCulinaire extends Activite {
 private String typeCuisine;

 	public ActiviteCulinaire(String nom, String description, String typeCuisine) {
 		super(nom, description);
 		this.typeCuisine = typeCuisine;
 	}

 	public String getTypeCuisine() {
 		return typeCuisine;
 	}

 	@Override
 	public void verifierCompatibilite() {
 		System.out.println("Vérification des allergies pour l'activité culinaire : " + getNom());
 	}
 
}