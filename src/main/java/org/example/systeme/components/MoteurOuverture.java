package org.example.systeme.components;

public class MoteurOuverture {
    public void interrogerLecteur(ILecteur... lecteurs){
        for (ILecteur lecteur : lecteurs) {
            if(lecteur.aDetecterBadge()){
                for (IPorte iPorte : lecteur.getPorte()) {
                    iPorte.ouvrir();
                }
            }
        }
    }
}
