package Modele;

//Classe ActiviteRecreative
public class ActiviteRecreative extends Activite {
 private String typeLieu;

 public ActiviteRecreative(String nom, String description, String typeLieu) {
     super(nom, description);
     this.typeLieu = typeLieu;
 }

 public String getTypeLieu() {
     return typeLieu;
 }

 @Override
 public void verifierCompatibilite() {
     System.out.println("Vérification des restrictions pour l'activité récréative : " + getNom());
 }
}
