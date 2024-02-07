package org.example.systeme.components;

public class MoteurOuverture {
    public void interrogerLecteur(ILecteur lecteur){
        if(lecteur.aDetecterBadge()){
            for (IPorte iPorte : lecteur.getPorte()) {
                iPorte.ouvrir();
            }
        }
    }
}
