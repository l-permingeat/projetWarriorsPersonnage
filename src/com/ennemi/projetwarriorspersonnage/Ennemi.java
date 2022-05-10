package com.ennemi.projetwarriorspersonnage;

public abstract class Ennemi {
    private int pointDeVieActuelle;
    private int pointDattaque;

    private String name;

    public Ennemi(int pointDeVieActuelle,int pointDattaque, String name){
        this.pointDeVieActuelle=pointDeVieActuelle;
        this.pointDattaque=pointDattaque;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPointDeVieActuelle() {
        return pointDeVieActuelle;
    }

    public void setPointDeVieActuelle(int pointDeVieActuelle) {
        this.pointDeVieActuelle = pointDeVieActuelle;
    }

}
