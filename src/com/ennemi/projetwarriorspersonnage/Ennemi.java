package com.ennemi.projetwarriorspersonnage;

public abstract class Ennemi {
    private int pointDeVieActuelle;
    private int pointDattaque;
    private String name;

    /**
     *
     * @param pointDeVieActuelle les points de vie de l'ennemi
     * @param pointDattaque les points dont il dispose pour attaquer
     * @param name le nom de l'ennemi
     */
    public Ennemi(int pointDeVieActuelle,int pointDattaque, String name){
        this.pointDeVieActuelle=pointDeVieActuelle;
        this.pointDattaque=pointDattaque;
        this.name=name;
    }

    /* ****************** Getter et Setter ********************/

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPointDattaque() {
        return pointDattaque;
    }

    public void setPointDattaque(int pointDattaque) {
        this.pointDattaque = pointDattaque;
    }
    public int getPointDeVieActuelle() {
        return pointDeVieActuelle;
    }

    public void setPointDeVieActuelle(int pointDeVieActuelle) {
        this.pointDeVieActuelle = pointDeVieActuelle;
    }

}
