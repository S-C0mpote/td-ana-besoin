package org.example.systeme.components;

public class MoteurOuverture {
    public void interrogerLecteur(ILecteur lecteur){
        if(lecteur.aDetecterBadge()){
            lecteur.getPorte().ouvrir();
        }
    }
}
