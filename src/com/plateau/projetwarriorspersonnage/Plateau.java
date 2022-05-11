package com.plateau.projetwarriorspersonnage;

import com.ennemi.projetwarriorspersonnage.Ennemi;
import com.exception.PersonnageHorsPlateauException;

import java.util.Random;

public class Plateau {
    public Cellule tab[] = new Cellule[30];
    Ennemi ennemi;


    /**
     * fonction qui affecte une cellule à un indice i du tableau, puis lui affecte aléatoirement une surprise, du vide ou un ennemi
     */
    public Plateau() {
        for (int i = 1; i < tab.length; i++) {
            Random random = new Random();
            int valueRandom = random.nextInt(2 + 1) + 1;
            //  System.out.println("Valeur random "+valueRandom);
            if (valueRandom == 1) {
                tab[i] = new VideCellule();
              //  tab[i].open();

            } else if (valueRandom == 2) {
                tab[i] = new SurpriseCellule();
              //  tab[i].open();

            } else if (valueRandom == 3) {
                tab[i] = new EnnemyCellule();
               // tab[i].open();

               /* int valueRandomEnnemy = random.nextInt(2 + 1) + 1;
                if (valueRandomEnnemy == 1) {
                    tab[i] = new Dragons();
                    //personnage.setEquipement(new MassueGuerrier());
                } else if (valueRandomEnnemy == 2) {
                    ennemi = new Gobelins();
                } else if (valueRandomEnnemy == 3) {
                    ennemi = new Sorciers();
                }
                System.out.println("Le type d'ennemi est un " + ennemi.getName() + " !");*/

            }
        }
    }

    /**
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
