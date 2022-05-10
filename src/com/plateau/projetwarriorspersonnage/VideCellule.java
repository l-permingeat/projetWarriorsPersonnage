package com.plateau.projetwarriorspersonnage;

import com.personnage.projetwarriorspersonnage.Personnage;

import java.util.Scanner;

public class VideCellule implements Cellule {



    @Override
    public String toString() {
        return "Cette case est vide, vous voulez continuer ? Taper 1 \nVous voulez quitter ? Taper 2";
    }

    public void act(Scanner scanner) {
        if (scanner.nextInt() == 2) {
            System.out.println("A bientôt !");
            System.exit(1);
        }
    }



    @Override
    public void open() {
        System.out.println("La case est vide. Vous pouvez vous reposer.");

    }

}
