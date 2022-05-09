package com.plateau.projetwarriorspersonnage;

import com.personnage.projetwarriorspersonnage.Personnage;

import java.util.Scanner;

public class SurpriseCellule implements Cellule {


    @Override
    public String toString() {
        return "Une suprise ! Vous la ramasser ? Taper 1 \nVous voulez quitter ? Taper 2";
    }

    public void act(Scanner scanner) {
        if (scanner.nextInt() == 2) {
            System.out.println("A bientôt !");
            System.exit(1);
        }
    }

    @Override
    public void affectation() {

    }

    @Override
    public void open() {

    }
}

