package com.plateau.projetwarriorspersonnage;

import java.util.Random;

public class Plateau {
    public Cellule tab[] = new Cellule[64];


    /**
     * fonction qui affecte une cellule à un indice i du tableau, puis lui affecte aléatoirement une surprise, du vide ou un ennemi
     */
    public Plateau() {
        for (int i = 1; i < tab.length; i++) {
            tab[i] = new Cellule();
            Random random = new Random();
            int valueRandom = random.nextInt(3 + 1) + 1;
            if (valueRandom == 1) {
                tab[i].setCellule("vide");
            } else if (valueRandom == 2) {
                tab[i].setCellule("surprise");
            } else if (valueRandom == 3) {
                tab[i].setCellule("ennemi");
            }
        }
    }

    public Cellule contenuTabIndiceI(int indice){
       // System.out.println(tab[indice]);
        return tab[indice];
    }

    /* ****************** Getter et Setter ********************/

    public Cellule[] getTab() {
        return tab;
    }

    public void setTab(Cellule[] tab) {
        this.tab = tab;
    }

    /* ****************** return ********************/
    /*public String toString() {
        return this.getClass()+"Plateau" +
            "tab=" + Arrays.toString(tab);
    }*/



}
