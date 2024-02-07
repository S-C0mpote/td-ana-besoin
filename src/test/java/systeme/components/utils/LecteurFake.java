package systeme.components.utils;

import org.example.systeme.components.ILecteur;
import org.example.systeme.components.IPorte;

public class LecteurFake implements ILecteur {
    private final IPorte[] portes;
    private boolean canOpen = false;

    public LecteurFake(IPorte... portes) {
        this.portes = portes;
    }
    @Override
    public void simulerDetectionBadge() {
        canOpen = true;
    }

    @Override
    public boolean aDetecterBadge() {
        return canOpen;
    }
    @Override
    public IPorte[] getPorte() {
        return portes;
    }
}
