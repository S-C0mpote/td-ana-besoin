package org.example.systeme.components;

public interface ILecteur {
    void simulerDetectionBadge(Badge badge);
    boolean aDetecterBadge();
    IPorte[] getPorte();
}
