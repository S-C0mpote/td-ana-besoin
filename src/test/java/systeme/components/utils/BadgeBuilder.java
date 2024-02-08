package systeme.components.utils;

import org.example.systeme.components.Badge;
import org.example.systeme.exceptions.InvalideNameException;
import org.example.systeme.utils.NomPorteur;

public class BadgeBuilder {

    public static Badge buildBadgeWithAttribution() throws InvalideNameException {
        Badge badge = Badge.DEBLOQUE;
        badge.attribuer(new NomPorteur("MICHEL"));
        return badge;
    }

    public static Badge buildBadgeSansAttribution_DEBLOQUE() {
        return Badge.DEBLOQUE;
    }
    public static Badge buildBadgeSansAttribution_BLOQUE() {
        return Badge.BLOQUE;
    }

    public static Badge buildBadgeAvecAttribution_BLOQUE() throws InvalideNameException {
        Badge badge = Badge.BLOQUE;
        badge.attribuer(new NomPorteur("MICHEL"));
        return badge;
    }
}
