package com.plateau.projetwarriorspersonnage;

import java.util.Scanner;

public class EnnemyCellule extends Cellule {

    @Override
    public String toString() {
        return "Il y a un ennemi ! Voulez vous combattre ? Taper 1 \nVous voulez quitter ? Taper 2";
    }

    public void act(Scanner scanner) {
        if (scanner.nextInt() == 2) {
            System.out.println("A bientôt !");
            System.exit(1);
        }
    }
}
