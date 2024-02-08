package systeme.components;

import org.example.systeme.components.Badge;
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

        // QUAND un badge VALIDE est passé devant le lecteur
        lecteurFake.simulerDetectionBadge(Badge.DEBLOQUE);

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

        // QUAND un badge VALIDE est passé devant le lecteur sans que le lecteur ne soit interrogé
        lecteurFake.simulerDetectionBadge(Badge.DEBLOQUE);

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

    @Test
    public void cas_plusieurs_portes(){
        // ETANT DONNE un lecteur relié à une porte
        IPorte porteSpy = new PorteSpy();
        IPorte porteSpy2 = new PorteSpy();
        ILecteur lecteurFake = new LecteurFake(porteSpy, porteSpy2);
        MoteurOuverture moteurOuverture = new MoteurOuverture();


        // QUAND un badge valide est passé devant le lecteur
        lecteurFake.simulerDetectionBadge(Badge.DEBLOQUE);

        //ET on interroge ce lecteur
        moteurOuverture.interrogerLecteur(lecteurFake);

        // ALORS les portes sont deverouillées
        assertTrue(porteSpy.isOpen());
        assertTrue(porteSpy2.isOpen());
    }

    @Test
    public void cas_plusieurs_lecteurs(){
        // ETANT DONNE un lecteur relié à une porte
        IPorte porteSpy = new PorteSpy();
        ILecteur lecteurFake = new LecteurFake(porteSpy);
        ILecteur lecteurFake2 = new LecteurFake(porteSpy);
        MoteurOuverture moteurOuverture = new MoteurOuverture();


        // QUAND un badge VALIDE est passé devant le lecteur 2
        lecteurFake2.simulerDetectionBadge(Badge.DEBLOQUE);

        //ET on interroge les 2 lecteurs
        moteurOuverture.interrogerLecteur(lecteurFake, lecteurFake2);

        // ALORS la porte est deverouillée
        assertTrue(porteSpy.isOpen());
    }

    @Test
    public void cas_plusieurs_lecteurs_plusieurs_portes(){
        // ETANT DONNE chaque lecteur relié à sa porte
        IPorte porteSpy = new PorteSpy();
        IPorte porteSpy2 = new PorteSpy();
        ILecteur lecteurFake = new LecteurFake(porteSpy);
        ILecteur lecteurFake2 = new LecteurFake(porteSpy2);
        MoteurOuverture moteurOuverture = new MoteurOuverture();

        // QUAND un badge valide est passé devant le lecteur 2
        lecteurFake2.simulerDetectionBadge(Badge.DEBLOQUE);

        //ET on interroge les 2 lecteurs
        moteurOuverture.interrogerLecteur(lecteurFake, lecteurFake2);

        // ALORS seule la porte 2 est deverouillée
        assertTrue(porteSpy2.isOpen());
        assertFalse(porteSpy.isOpen());
    }

    @Test
    public void cas_badge_invalide_detecte() {
        // ETANT DONNE un lecteur relié à une porte
        IPorte porteSpy = new PorteSpy();
        ILecteur lecteurFake = new LecteurFake(porteSpy);
        MoteurOuverture moteurOuverture = new MoteurOuverture();

        // QUAND un badge INVALIDE est passé devant le lecteur
        lecteurFake.simulerDetectionBadge(Badge.BLOQUE);

        // ET que ce lecteur est interrogé
        moteurOuverture.interrogerLecteur(lecteurFake);

        // ALORS la porte n'est pas deverouillée
        assertFalse(porteSpy.isOpen());
    }
    @Test
    public void plusieurs_lecteurs_plusieurs_badges_invalide(){
        // ETANT DONNE chaque lecteur relié à sa porte
        IPorte porteSpy = new PorteSpy();
        IPorte porteSpy2 = new PorteSpy();
        ILecteur lecteurFake = new LecteurFake(porteSpy);
        ILecteur lecteurFake2 = new LecteurFake(porteSpy2);
        MoteurOuverture moteurOuverture = new MoteurOuverture();

        // QUAND un badge valide est passé devant le lecteur 2
        lecteurFake2.simulerDetectionBadge(Badge.DEBLOQUE);

        // ET un badge INVALIDE est passé devant le lecteur 1
        lecteurFake.simulerDetectionBadge(Badge.BLOQUE);
        //ET on interroge les 2 lecteurs
        moteurOuverture.interrogerLecteur(lecteurFake, lecteurFake2);

        // ALORS seule la porte 2 est deverouillée
        assertTrue(porteSpy2.isOpen());
        assertFalse(porteSpy.isOpen());
    }

}
