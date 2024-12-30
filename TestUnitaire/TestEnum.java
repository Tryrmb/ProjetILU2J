package TestUnitaire;

import Enumeration.TypeActivite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestEnum {
    public static void main(String[] args) {
        TypeActivite activite = TypeActivite.ALLERGIE;
        System.out.println("Type d'activité : " + activite);
    }
}
