package systeme.components;

import org.example.systeme.components.ILecteur;
import org.example.systeme.components.IPorte;
import org.example.systeme.components.MoteurOuverture;
import org.junit.Test;
import systeme.components.utils.LecteurFake;
import systeme.components.utils.PorteSpy;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LecteurTest {

    @Test
    public void cas_nominal() {
        IPorte porte = new PorteSpy();
        MoteurOuverture moteurOuverture = new MoteurOuverture(porte);
        ILecteur lecteur = new LecteurFake();

        // CAS NOMINAL
        //ETANT DONNE un lecteur relié à une porte
        // QUAND un badge est passé devant le lecteur
        lecteur.simulerDetectionBadge();

        //Et que ce lecteur est interrogé
        moteurOuverture.interrogerLecteur(lecteur);

        //Alors la porte s'ouvre
        assertTrue(porte.isOpen());
    }

    @Test
    public void cas_sans_interrogation(){
        IPorte porte = new PorteSpy();
        ILecteur lecteur = new LecteurFake();

        //ETANT DONNE un lecteur relié à une porte
        //QUAND un badge est passé devant le lecteur
        lecteur.simulerDetectionBadge();

        //ALORS la porte n'est pas déverrouillée
        assertFalse(porte.isOpen());
    }
}
