package org.example.systeme.components;

public class MoteurOuverture {

    private IPorte[] portes;
    public MoteurOuverture(IPorte... portes){
        this.portes = portes;
    }
    public void interrogerLecteur(ILecteur lecteur){
        if(lecteur.aDetecterBadge()){
            for (IPorte porte : portes) {
                porte.ouvrir();
            }
        }
    }
}
