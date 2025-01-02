// Package : Gestion
package Gestion;


/**
 * Exception personnalisée pour gérer les restrictions incompatibles.
 */public class RestrictionIncompatibleException extends Exception {
    public RestrictionIncompatibleException(String message) {
        super(message);
    }
}