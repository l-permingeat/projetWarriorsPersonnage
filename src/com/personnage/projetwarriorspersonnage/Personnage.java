package com.personnage.projetwarriorspersonnage;

import com.equipement.projetwarriorspersonnage.Equipement;

public class Personnage {
    private String name;
    private String defense;
    private int forceActuelle;
    private int forceMax;
    private int vieActuelle;
    private int vieMax;
    private String image;
    Equipement equipement;


    /**
     * @param name:         nom du personnage
     * @param forceActuelle :
     * @param forceMax      : force maximum
     * @param vieActuelle   : initialisé en dur
     * @param vieMax        : vie maximum
     * @param image         :
     */
    public Personnage(String name, int forceActuelle, int forceMax, int vieActuelle, int vieMax, String image) {
        this.name = name;
        this.forceActuelle = forceActuelle;
        this.forceMax = forceMax;
        this.vieActuelle = vieActuelle;
        this.vieMax = vieMax;
        this.image = image;
    }



    /* ****************** Getter et Setter ********************/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefense() {
        return defense;
    }

    public void setDefense(String defense) {
        this.defense = defense;
    }

    public int getForceActuelle() {
        return forceActuelle;
    }

    public void setForceActuelle(int forceActuelle) {
        this.forceActuelle = forceActuelle;
    }

    public int getForceMax() {
        return forceMax;
    }

    public void setForceMax(int forceMax) {
        this.forceMax = forceMax;
    }

    public int getVieActuelle() {
        return vieActuelle;
    }

    public void setVieActuelle(int vieActuelle) {
        this.vieActuelle = vieActuelle;
    }

    public int getVieMax() {
        return vieMax;
    }

    public void setVieMax(int vieMax) {
        this.vieMax = vieMax;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }

    /* ****************** return ********************/

    public String toString() {
        return this.getClass().getSimpleName() + "\nSon nom : "+this.name+" Sa force actuelle : "+forceActuelle+" Sa force max "+forceMax+" Sa vie actuelle : "+vieActuelle+" Sa vie max "+vieMax;
    }
}//fin class Personnage
