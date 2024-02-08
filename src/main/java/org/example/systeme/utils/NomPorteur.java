package org.example.systeme.utils;

import org.example.systeme.exceptions.InvalideNameException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NomPorteur {
    private final String REGEX_PATTERN = "^(?!\\s+$)[a-zA-Z0-9\\s]{1,25}$";
    private final String nom;

    public NomPorteur(String nom) throws InvalideNameException {
        if(nom == null)
            throw new InvalideNameException("Le nom n'est pas valide");

        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        Matcher matcher = pattern.matcher(nom);
        if(!matcher.matches())
            throw new InvalideNameException("Le nom n'est pas valide");
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}
