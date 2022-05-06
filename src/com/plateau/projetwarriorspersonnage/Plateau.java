package com.plateau.projetwarriorspersonnage;

import com.exception.PersonnageHorsPlateauException;

import java.util.Random;

public class Plateau {
    public Cellule tab[] = new Cellule[10];


    /**
     * fonction qui affecte une cellule à un indice i du tableau, puis lui affecte aléatoirement une surprise, du vide ou un ennemi
     */
    public Plateau() {
        for (int i = 1; i < tab.length; i++) {
            Random random = new Random();
            int valueRandom = random.nextInt(3 + 1) + 1;
            if (valueRandom == 1) {
                tab[i] = new VideCellule();
            } else if (valueRandom == 2) {
                tab[i] = new SurpriseCellule();
            } else if (valueRandom == 3) {
                tab[i] = new EnnemyCellule();
            }
        }
    }

    /**
     *
     * @param indice un entier qui permettra d'indiquer l'indice du tableau que l'on veut consulter
     * @return le contenu du tableau à l'indice donné
     * @throws PersonnageHorsPlateauException indique que cette méthode peut déclencher une exception
     */
    public Cellule contenuTabIndiceI(int indice) throws PersonnageHorsPlateauException {
        if (indice < tab.length) {
            return tab[indice];
        }
        //si la condition au dessus est fausse, alors une excepetion est levée
        throw new PersonnageHorsPlateauException();
    }

    /**
     *
     * @return la longeur de mon tableau
     */
    public int getSize() {
        return tab.length;
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
