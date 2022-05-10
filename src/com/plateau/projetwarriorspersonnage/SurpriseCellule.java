package com.plateau.projetwarriorspersonnage;

import com.ennemi.projetwarriorspersonnage.Dragons;
import com.ennemi.projetwarriorspersonnage.Gobelins;
import com.ennemi.projetwarriorspersonnage.Sorciers;
import com.equipement.projetwarriorspersonnage.*;
import com.personnage.projetwarriorspersonnage.Guerrier;
import com.personnage.projetwarriorspersonnage.Magicien;
import com.personnage.projetwarriorspersonnage.Personnage;

import java.util.Random;
import java.util.Scanner;

public class SurpriseCellule implements Cellule {
    Equipement surprise;


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
    public void open() {
        Random random = new Random();
        int valueRandom = random.nextInt(5 + 1) + 1;
        if (valueRandom == 1) {
            surprise = new MassueGuerrier();
        } else if (valueRandom == 2) {
            surprise = new EpeeGuerrier();
        } else if (valueRandom == 3) {
            surprise = new EclairMagicien();
        } else if (valueRandom == 4) {
            surprise = new BouleDeFeuMagicien();
        } else if (valueRandom == 5) {
            surprise = new PotionDeVieTousPersonnage();
        } else if (valueRandom == 6) {
            surprise = new GrandePotionVieTousPersonnage();
        }
        System.out.println("Votre surprise est un.e" + surprise.getName() +" !");

    }
}

