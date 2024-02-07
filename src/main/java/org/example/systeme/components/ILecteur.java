package org.example.systeme.components;

import org.example.systeme.permissions.BadgePermission;

public interface ILecteur {
    void simulerDetectionBadge(BadgePermission badgePermission);
    boolean aDetecterBadge();
    IPorte[] getPorte();
}
