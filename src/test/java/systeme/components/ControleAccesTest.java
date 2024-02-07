package systeme.components;

import org.example.systeme.components.ILecteur;
import org.example.systeme.components.IPorte;
import org.example.systeme.components.MoteurOuverture;
import org.junit.Test;
import systeme.components.utils.LecteurFake;
import systeme.components.utils.PorteSpy;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControleAccesTest {

    @Test
    public void cas_nominal() {
        // ETANT DONNE un lecteur relié à une porte
        IPorte porteSpy = new PorteSpy();
        ILecteur lecteurFake = new LecteurFake(porteSpy);
        MoteurOuverture moteurOuverture = new MoteurOuverture();

        // QUAND un badge est passé devant le lecteur
        lecteurFake.simulerDetectionBadge();

        // ET que ce lecteur est interrogé
        moteurOuverture.interrogerLecteur(lecteurFake);

        // ALORS la porte est deverrouillée
        assertTrue(porteSpy.isOpen());
    }

    @Test
    public void CasSansInterrogation(){
        // ETANT DONNE un lecteur relié à une porte
        IPorte porteSpy = new PorteSpy();
        ILecteur lecteurFake = new LecteurFake(porteSpy);

        // QUAND un badge est passé devant le lecteur sans que le lecteur ne soit interrogé
        lecteurFake.simulerDetectionBadge();

        // ALORS la porte n'est pas deverrouillée
        assertFalse(porteSpy.isOpen());
    }

    @Test
    public void cas_sans_detection(){
        // ETANT DONNE un lecteur relié à une porte
        IPorte porteSpy = new PorteSpy();
        ILecteur lecteurFake = new LecteurFake(porteSpy);
        MoteurOuverture moteurOuverture = new MoteurOuverture();

        // QUAND on interroge ce lecteur sans qu'il ait détecté un badge
        moteurOuverture.interrogerLecteur(lecteurFake);

        // ALORS la porte n'est pas deverrouillée
        assertFalse(porteSpy.isOpen());
    }
}
