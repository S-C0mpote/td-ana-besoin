package org.example.systeme.components;

import java.util.Optional;

public interface ILecteur {
    void simulerDetectionBadge(Badge badge);
    Optional<Badge> aDetecterBadge();
    IPorte[] getPorte();
}
