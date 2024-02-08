package systeme.components;

import org.example.systeme.components.Badge;
import org.example.systeme.components.ILecteur;
import org.example.systeme.components.IPorte;
import org.example.systeme.components.MoteurOuverture;
import org.example.systeme.exceptions.InvalideNameException;
import org.example.systeme.utils.NomPorteur;
import org.junit.Test;
import org.mockito.Mockito;
import systeme.components.utils.LecteurFake;
import systeme.components.utils.PorteSpy;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ControleAccesTest {


    @Test
    public void cas_nominal() throws InvalideNameException {
        // ETANT DONNE un lecteur relié à une porte
        IPorte porteSpy = new PorteSpy();
        ILecteur lecteurFake = new LecteurFake(porteSpy);
        MoteurOuverture moteurOuverture = new MoteurOuverture();
        Badge badge = Badge.DEBLOQUE;
        badge.attribuer(new NomPorteur("MICHEL"));
        // QUAND un badge non bloque et attribué est passé devant le lecteur
        lecteurFake.simulerDetectionBadge(badge);

        // ET que ce lecteur est interrogé
        moteurOuverture.interrogerLecteur(lecteurFake);

        // ALORS la porte est deverrouillée
        assertTrue(porteSpy.isOpen());
    }

    @Test
    public void CasSansInterrogation() throws InvalideNameException {
        // ETANT DONNE un lecteur relié à une porte
        IPorte porteSpy = new PorteSpy();
        ILecteur lecteurFake = new LecteurFake(porteSpy);
        Badge badge = Badge.DEBLOQUE;
        badge.attribuer(new NomPorteur("MICHEL"));
        // QUAND un badge debloque et attribué est passé devant le lecteur sans que le lecteur ne soit interrogé
        lecteurFake.simulerDetectionBadge(badge);

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
    public void cas_plusieurs_portes() throws InvalideNameException {
        // ETANT DONNE un lecteur relié à une porte
        IPorte porteSpy = new PorteSpy();
        IPorte porteSpy2 = new PorteSpy();
        ILecteur lecteurFake = new LecteurFake(porteSpy, porteSpy2);
        MoteurOuverture moteurOuverture = new MoteurOuverture();
        Badge badge = Badge.DEBLOQUE;
        badge.attribuer(new NomPorteur("MICHEL"));

        // QUAND un badge DEBLOQUE et attribué est passé devant le lecteur
        lecteurFake.simulerDetectionBadge(badge);

        //ET on interroge ce lecteur
        moteurOuverture.interrogerLecteur(lecteurFake);

        // ALORS les portes sont deverouillées
        assertTrue(porteSpy.isOpen());
        assertTrue(porteSpy2.isOpen());
    }

    @Test
    public void cas_plusieurs_lecteurs() throws InvalideNameException {
        // ETANT DONNE un lecteur relié à une porte
        IPorte porteSpy = new PorteSpy();
        ILecteur lecteurFake = new LecteurFake(porteSpy);
        ILecteur lecteurFake2 = new LecteurFake(porteSpy);
        MoteurOuverture moteurOuverture = new MoteurOuverture();
        Badge badge = Badge.DEBLOQUE;
        badge.attribuer(new NomPorteur("MICHEL"));

        // QUAND un badge non bloque et attribué est passé devant le lecteur 2
        lecteurFake2.simulerDetectionBadge(badge);

        //ET on interroge les 2 lecteurs
        moteurOuverture.interrogerLecteur(lecteurFake, lecteurFake2);

        // ALORS la porte est deverouillée
        assertTrue(porteSpy.isOpen());
    }

    @Test
    public void cas_plusieurs_lecteurs_plusieurs_portes() throws InvalideNameException {
        // ETANT DONNE chaque lecteur relié à sa porte
        IPorte porteSpy = new PorteSpy();
        IPorte porteSpy2 = new PorteSpy();
        ILecteur lecteurFake = new LecteurFake(porteSpy);
        ILecteur lecteurFake2 = new LecteurFake(porteSpy2);
        MoteurOuverture moteurOuverture = new MoteurOuverture();
        Badge badge = Badge.DEBLOQUE;
        badge.attribuer(new NomPorteur("MICHEL"));
        // QUAND un badge non bloque et attribué est passé devant le lecteur 2
        lecteurFake2.simulerDetectionBadge(badge);

        //ET on interroge les 2 lecteurs
        moteurOuverture.interrogerLecteur(lecteurFake, lecteurFake2);

        // ALORS seule la porte 2 est deverouillée
        assertTrue(porteSpy2.isOpen());
        assertFalse(porteSpy.isOpen());
    }

    @Test
    public void cas_badge_bloque_detecte() {
        // ETANT DONNE un lecteur relié à une porte
        IPorte porteSpy = new PorteSpy();
        ILecteur lecteurFake = new LecteurFake(porteSpy);
        MoteurOuverture moteurOuverture = new MoteurOuverture();
        Badge badge = Badge.BLOQUE;

        // QUAND un badge BLOQUE est passé devant le lecteur
        lecteurFake.simulerDetectionBadge(badge);

        // ET que ce lecteur est interrogé
        moteurOuverture.interrogerLecteur(lecteurFake);

        // ALORS la porte n'est pas deverouillée
        assertFalse(porteSpy.isOpen());
    }
    @Test
    public void plusieurs_lecteurs_plusieurs_badges_BLOQUE() throws InvalideNameException {
        // ETANT DONNE chaque lecteur relié à sa porte
        IPorte porteSpy = new PorteSpy();
        IPorte porteSpy2 = new PorteSpy();
        ILecteur lecteurFake = new LecteurFake(porteSpy);
        ILecteur lecteurFake2 = new LecteurFake(porteSpy2);
        MoteurOuverture moteurOuverture = new MoteurOuverture();
        Badge badge = Badge.BLOQUE;

        Badge badge2 = Badge.DEBLOQUE;
        badge.attribuer(new NomPorteur("MICHEL"));

        // QUAND un badge non bloque et attribué est passé devant le lecteur 2
        lecteurFake2.simulerDetectionBadge(badge2);

        // ET un badge BLOQUE est passé devant le lecteur 1
        lecteurFake.simulerDetectionBadge(badge);
        //ET on interroge les 2 lecteurs
        moteurOuverture.interrogerLecteur(lecteurFake, lecteurFake2);

        // ALORS seule la porte 2 est deverouillée
        assertTrue(porteSpy2.isOpen());
        assertFalse(porteSpy.isOpen());
    }
    @Test
    public void cas_badge_bloque_et_attribue() throws InvalideNameException {
        // ETANT DONNE un lecteur relié à une porte
        IPorte porteSpy = new PorteSpy();
        ILecteur lecteurFake = new LecteurFake(porteSpy);
        MoteurOuverture moteurOuverture = new MoteurOuverture();
        Badge badge = Badge.BLOQUE;
        badge.attribuer(new NomPorteur("MICHEL"));
        // QUAND un badge BLOQUE et attribué est passé devant le lecteur
        lecteurFake.simulerDetectionBadge(badge);

        // ET que ce lecteur est interrogé
        moteurOuverture.interrogerLecteur(lecteurFake);

        // ALORS la porte n'est pas deverouillée
        assertFalse(porteSpy.isOpen());
    }

    @Test
    public void cas_badge_retirer_attribution() throws InvalideNameException {
        // ETANT DONNE un lecteur relié à une porte
        IPorte porteSpy = Mockito.spy(new PorteSpy());
        ILecteur lecteurFake = new LecteurFake(porteSpy);
        MoteurOuverture moteurOuverture = new MoteurOuverture();
        Badge badge = Badge.DEBLOQUE;
        badge.attribuer(new NomPorteur("MICHEL"));
        // QUAND un badge DEBLOQUE et attribué est passé devant le lecteur
        lecteurFake.simulerDetectionBadge(badge);

        // ET que ce lecteur est interrogé
        moteurOuverture.interrogerLecteur(lecteurFake);

        // la porte est deverouillée
        assertTrue(porteSpy.isOpen());

        // ET si on desattribue le badge
        badge.retirerAttribution();

        // QUE le badge passe devant le lecteur
        lecteurFake.simulerDetectionBadge(badge);

        // ET que ce lecteur est interrogé
        moteurOuverture.interrogerLecteur(lecteurFake);

        //alors la porte n'a pas eu de signal d'ouverture
        verify(porteSpy, times(1)).ouvrir();
    }

    @Test
    public void cas_badge_attribution() throws InvalideNameException {
        // ETANT DONNE un lecteur relié à une porte
        IPorte porteSpy = Mockito.spy(new PorteSpy());
        ILecteur lecteurFake = new LecteurFake(porteSpy);
        MoteurOuverture moteurOuverture = new MoteurOuverture();
        Badge badge = Badge.DEBLOQUE;

        // QUAND un badge DEBLOQUE et non attribué est passé devant le lecteur
        lecteurFake.simulerDetectionBadge(badge);

        // ET que ce lecteur est interrogé
        moteurOuverture.interrogerLecteur(lecteurFake);

        // la porte est pas deverouillée
        assertFalse(porteSpy.isOpen());

        // ET si on attribue le badge
        badge.attribuer(new NomPorteur("MICHEL"));

        // QUE le badge passe devant le lecteur
        lecteurFake.simulerDetectionBadge(badge);

        // ET que ce lecteur est interrogé
        moteurOuverture.interrogerLecteur(lecteurFake);

        //ALors la porte est ouverte
        assertTrue(porteSpy.isOpen());

        //La porte n'a été ouverte que une seule fois
        verify(porteSpy, times(1)).ouvrir();
    }
}
