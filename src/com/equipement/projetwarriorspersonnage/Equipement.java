package com.equipement.projetwarriorspersonnage;

public class Equipement {


    private String name;
    private int niveauAttaque;
    private int rendsPointDeVie;

    public Equipement(String name, int niveauAttaque){
        this.name=name;
        this.niveauAttaque=niveauAttaque;
    }

    /* ****************** Getter et Setter ********************/

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getNiveauAttaque() {
        return niveauAttaque;
    }

    public void setNiveauAttaque(String niveauAttaque) {
        this.niveauAttaque = Integer.parseInt(niveauAttaque);
    }

    public int getRendsPointDeVie() {
        return rendsPointDeVie;
    }

    public void setRendsPointDeVie(int rendsPointDeVie) {
        this.rendsPointDeVie = rendsPointDeVie;
    }

}//fin
