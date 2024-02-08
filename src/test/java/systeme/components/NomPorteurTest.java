package systeme.components;

import org.example.systeme.exceptions.InvalideNameException;
import org.example.systeme.utils.NomPorteur;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NomPorteurTest {

    @Test
    public void taille_minimal_maximal_ok() {
        assertThrows(InvalideNameException.class, () -> new NomPorteur(""));
        assertThrows(InvalideNameException.class, () -> new NomPorteur("EEEEEEEEEEEEEEEEEEEEEEEEEE"));
    }
    @Test
    public void caractere_espace_uniquement_non_autorise() {
        assertThrows(InvalideNameException.class, () -> new NomPorteur(" "));
        assertThrows(InvalideNameException.class, () -> new NomPorteur("               "));
    }

    @Test
    public void caractere_special_non_autorise() {
        assertThrows(InvalideNameException.class, () -> new NomPorteur("MICHEL*"));
        assertThrows(InvalideNameException.class, () -> new NomPorteur("MICHEL^"));
        assertThrows(InvalideNameException.class, () -> new NomPorteur("MICHELê"));
        assertThrows(InvalideNameException.class, () -> new NomPorteur("MICHELË"));
        assertThrows(InvalideNameException.class, () -> new NomPorteur("MIC HELË9"));
        assertThrows(InvalideNameException.class, () -> new NomPorteur("MIC HEL\n\b"));
    }

    @Test
    public void noms_ok(){
        assertDoesNotThrow(() -> new NomPorteur("MICHEL"));
        assertDoesNotThrow(() -> new NomPorteur("MICHEL44000"));
        assertDoesNotThrow(() -> new NomPorteur("michel44000"));
        assertDoesNotThrow(() -> new NomPorteur("michel44000 du44   e"));
    }

}
