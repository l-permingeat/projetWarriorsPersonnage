package com.plateau.projetwarriorspersonnage;

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
        return "Une suprise ! Vous la ramassez ? Taper 1 \nVous voulez quitter ? Taper 2";
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
            surprise = new Massue();
        } else if (valueRandom == 2) {
            surprise = new Epee();
        } else if (valueRandom == 3) {
            surprise = new Eclair();
        } else if (valueRandom == 4) {
            surprise = new BouleDeFeu();
        } else if (valueRandom == 5) {
            surprise = new PotionDeVie();
        } else if (valueRandom == 6) {
            surprise = new GrandePotionVie();
        }
        System.out.println("Votre surprise est un.e " + surprise.getName() + " !");

    }

    @Override
    public void action(Personnage personnage) {
        if ((surprise instanceof Eclair || surprise instanceof BouleDeFeu) && personnage instanceof Magicien) {
            personnage.setEquipement(surprise);
            System.out.println("Vous avez récupéré un.e " + personnage.getEquipement().getName() + ". Il vous apporte " + personnage.getEquipement().getNiveauAttaque() + " de force");
        } else if ((surprise instanceof Massue || surprise instanceof Epee) && personnage instanceof Guerrier) {
            personnage.setEquipement(surprise);
            System.out.println("Vous avez récupéré un.e " + personnage.getEquipement().getName() + ". Il vous apporte " + personnage.getEquipement().getNiveauAttaque() + " de force");
        } else if ((surprise instanceof PotionDeVie || surprise instanceof GrandePotionVie) && (personnage instanceof Guerrier || personnage instanceof Magicien)) {
            if ((personnage.getVieActuelle() + surprise.getNiveauAttaque()) > personnage.getVieMax()) {
                personnage.setVieActuelle(personnage.getVieMax());
                System.out.println("Vous avez maintenant " + personnage.getVieActuelle() + " vie.s");
            } else {
                personnage.setVieActuelle(personnage.getVieActuelle() + surprise.getNiveauAttaque());
            }

        }
    }
}

