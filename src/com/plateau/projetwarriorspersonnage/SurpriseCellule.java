package com.plateau.projetwarriorspersonnage;

import java.util.Scanner;

public class SurpriseCellule extends Cellule {


    @Override
    public String toString() {
        return " Une suprise ! vouls la ramasser ? Taper 1 \nVous voulez quitter ? Taper 2";
    }

    public void act(Scanner scanner) {
        if (scanner.nextInt() == 2) {
            System.out.println("A bientôt !");
            System.exit(1);
        }
    }
}

