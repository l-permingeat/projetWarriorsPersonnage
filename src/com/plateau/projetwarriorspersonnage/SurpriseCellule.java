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
        System.out.println("coucou la surprise" + surprise);
        if ((surprise instanceof Eclair || surprise instanceof BouleDeFeu) && personnage instanceof Magicien) {
            personnage.setEquipement(surprise);
            System.out.println("Vous avez récupéré un " + personnage.getEquipement().getName() + ". Il vous apporte " + personnage.getEquipement().getNiveauAttaque() + " de force");
        } else if ((surprise instanceof Massue || surprise instanceof Epee) && personnage instanceof Guerrier) {
            personnage.setEquipement(surprise);
            System.out.println("Vous avez récupéré un " + personnage.getEquipement().getName() + ". Il vous apporte " + personnage.getEquipement().getNiveauAttaque() + " de force");
        } else if ((surprise instanceof PotionDeVie || surprise instanceof GrandePotionVie) && (personnage instanceof Guerrier || personnage instanceof Magicien)) {
            personnage.setVieActuelle(personnage.getVieActuelle()+surprise.getNiveauAttaque());
            System.out.println("Vous avez maintenant "+personnage.getVieActuelle()+" vie.s");
        }

            /*if (surprise instanceof Eclair && personnage instanceof Magicien) {
                personnage.setEquipement(new Eclair());

            } else if (surprise instanceof BouleDeFeu && personnage instanceof Magicien) {
                personnage.setEquipement(new BouleDeFeu());
            } else if (surprise instanceof Massue && personnage instanceof Guerrier) {
                personnage.setEquipement(new Massue());
            } else if (surprise instanceof Epee && personnage instanceof Guerrier) {
                personnage.setEquipement(new Epee());
            } else if (surprise instanceof PotionDeVie && (personnage instanceof Guerrier || personnage instanceof Magicien)) {
                personnage.setEquipement(new PotionDeVie());
            } else if (surprise instanceof GrandePotionVie && (personnage instanceof Guerrier || personnage instanceof Magicien)) {
                personnage.setEquipement(new GrandePotionVie());
            }
            System.out.println("Vous avez récupérer un " + personnage.getEquipement().getName() + ". Il vous apporte " + personnage.getEquipement().getNiveauAttaque() + " de force");
            System.out.println("");
        }*/
    }
}

