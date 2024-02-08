package org.example.systeme.components;

import org.example.systeme.utils.NomPorteur;

public enum Badge {
    BLOQUE(true),
    DEBLOQUE(false);

    private final boolean bloque;
    private NomPorteur attribution;
    Badge(boolean bloque){
        this.bloque = bloque;
    }

    public boolean isBloque() {
        return bloque;
    }

    public void attribuer(NomPorteur nom){
        this.attribution = nom;
    }

    public void retirerAttribution(){
        this.attribution = null;
    }

    public boolean estAttribue(){
        return attribution != null && attribution.getNom() != null;
    }

    public NomPorteur getAttribution() {
        return attribution;
    }
}
