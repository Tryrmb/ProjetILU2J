// Package : Modele
package Modele;

import java.util.ArrayList;
import java.util.List;

import Enumeration.TypeActivite;


//Classe Activite
public abstract class Activite {
 private String nom;
 private String description;
 private TypeActivite typeActivite; // Enum pour le type d'activité

 public Activite(String nom, String description, TypeActivite typeActivite) {
     this.nom = nom;
     this.description = description;
     this.typeActivite = typeActivite;
 }

 public String getNom() {
     return nom;
 }

 public String getDescription() {
     return description;
 }

 public TypeActivite getTypeActivite() {
     return typeActivite;
 }

 public abstract void verifierCompatibilite();
}
