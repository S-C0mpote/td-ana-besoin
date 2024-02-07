package org.example.systeme.components;

public enum Badge {
    BLOQUE(true),
    DEBLOQUE(false);

    private boolean bloque;

    private Badge(boolean bloque){
        this.bloque = bloque;
    }

    public boolean isBloque() {
        return bloque;
    }
}
