package systeme.components.utils;

import org.example.systeme.components.ILecteur;
import org.example.systeme.components.IPorte;

public class LecteurFake implements ILecteur {
    private final IPorte porte;
    private boolean canOpen = false;

    public LecteurFake(IPorte porte) {
        this.porte = porte;
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
    public IPorte getPorte() {
        return porte;
    }
}
