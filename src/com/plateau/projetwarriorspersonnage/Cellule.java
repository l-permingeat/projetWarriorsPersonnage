package com.plateau.projetwarriorspersonnage;


import java.util.Scanner;

public abstract class Cellule {
    String contenu;

    public Cellule(String contenu){
        this.contenu=contenu;
    }

    /* ****************** Getter et Setter ********************/

    /**
     *
     * @return une string cellule
     */
    public String getContenu() {
        return contenu;
    }
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    /* ****************** return ********************/
    public String toString() {
        return getContenu();
    }

    public abstract void act(Scanner scanner);
}
