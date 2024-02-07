package systeme.components.utils;

import org.example.systeme.components.ILecteur;
import org.example.systeme.components.IPorte;
import org.example.systeme.permissions.BadgePermission;

public class LecteurFake implements ILecteur {
    private final IPorte[] portes;
    private boolean canOpen = false;

    public LecteurFake(IPorte... portes) {
        this.portes = portes;
    }
    @Override
    public void simulerDetectionBadge(BadgePermission badgePermission) {
        if(BadgePermission.VALIDE.equals(badgePermission))
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
