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
    public void affectation() {

    }

    @Override
    public void open(Personnage personnage) {
        System.out.println("La case est vide. Votre "+ personnage + "peut se reposer.");

    }

}
