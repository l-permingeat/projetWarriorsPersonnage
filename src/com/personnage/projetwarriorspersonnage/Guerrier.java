package com.personnage.projetwarriorspersonnage;

import javax.xml.namespace.QName;
import java.util.Collections;

public class Guerrier extends Personnage {


    /**
     * @param name          : le nom sera donné par l'utilisateur
     * @param forceActuelle
     * @param forceMax
     * @param vieActuelle
     * @param vieMax
     * @param image
     */
   /* public Guerrier() {
        this("Default Guerrier");
    }*/


   /* public Guerrier(String name){

    }*/

    public Guerrier(String name) {
        super(name, 5, 10, 5, 10, "g");
    }



}

