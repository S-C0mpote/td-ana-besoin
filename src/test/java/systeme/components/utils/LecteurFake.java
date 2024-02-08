package systeme.components.utils;

import org.example.systeme.components.Badge;
import org.example.systeme.components.ILecteur;
import org.example.systeme.components.IPorte;

import java.util.Optional;

public class LecteurFake implements ILecteur {
    private final IPorte[] portes;
    private Badge badge = null;

    public LecteurFake(IPorte... portes) {
        this.portes = portes;
    }
    @Override
    public void simulerDetectionBadge(Badge badge) {
        this.badge = badge;
    }

    @Override
    public Optional<Badge> aDetecterBadge() {
        return Optional.ofNullable(badge);
    }
    @Override
    public IPorte[] getPorte() {
        return portes;
    }
}
