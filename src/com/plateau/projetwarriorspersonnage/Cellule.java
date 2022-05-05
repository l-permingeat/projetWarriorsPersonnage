package com.plateau.projetwarriorspersonnage;


public class Cellule {
    String cellule;

    /* ****************** Getter et Setter ********************/

    /**
     *
     * @return une string cellule
     */
    public String getCellule() {
        return cellule;
    }
    public void setCellule(String cellule) {
        this.cellule = cellule;
    }

    /* ****************** return ********************/
    public String toString() {
        return getCellule();
    }
}
