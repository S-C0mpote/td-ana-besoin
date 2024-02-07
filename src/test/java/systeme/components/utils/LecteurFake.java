package systeme.components.utils;

import org.example.systeme.components.ILecteur;

public class LecteurFake implements ILecteur {
    private boolean canOpen;
    public void simulerDetectionBadge() {
        canOpen = true;
    }

    public boolean aDetecterBadge(){
        return canOpen;
    }
}
