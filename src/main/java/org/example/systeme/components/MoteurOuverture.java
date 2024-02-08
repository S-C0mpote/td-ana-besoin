package org.example.systeme.components;

public class MoteurOuverture {
    public void interrogerLecteur(ILecteur... lecteurs) {
        for (ILecteur lecteur : lecteurs) {
            if (lecteur.aDetecterBadge().isPresent()) {
                Badge b = lecteur.aDetecterBadge().get();
                if (!b.isBloque() && b.estAttribue()) {
                    for (IPorte iPorte : lecteur.getPorte()) {
                        iPorte.ouvrir();
                    }
                }
            }
        }
    }
}
