package com.plateau.projetwarriorspersonnage;

import com.ennemi.projetwarriorspersonnage.Dragons;
import com.ennemi.projetwarriorspersonnage.Ennemi;
import com.ennemi.projetwarriorspersonnage.Gobelins;
import com.ennemi.projetwarriorspersonnage.Sorciers;
import com.personnage.projetwarriorspersonnage.Guerrier;
import com.personnage.projetwarriorspersonnage.Magicien;
import com.personnage.projetwarriorspersonnage.Personnage;

import java.util.Random;
import java.util.Scanner;

public class EnnemyCellule implements Cellule {
    Ennemi ennemi;

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

    @Override
    public void open() {
        Random random = new Random();
        int valueRandom = random.nextInt(2 + 1) + 1;
        if (valueRandom == 1) {
            ennemi = new Dragons();
            //personnage.setEquipement(new MassueGuerrier());
        } else if (valueRandom == 2) {
            ennemi = new Gobelins();
        } else if (valueRandom == 3) {
            ennemi = new Sorciers();
        }
        System.out.println("Le type d'ennemi est un " + ennemi.getName() + " !");

        // if (personnage instanceof Magicien){}
    }

    public void action(Personnage personnage) {
        //Le personnage attaque l'ennemi : soustraction du nb de force du personnage au nb de vie de l'ennemi
        ennemi.setPointDeVieActuelle(ennemi.getPointDeVieActuelle() - personnage.getForceActuelle());

        if (ennemi.getPointDeVieActuelle() <= 0) {
            System.out.println(ennemi.getName() + " est mort !");
        } else {
            //L'ennemi attaque le personnage : soustraction du nb de force de l'ennemi au nb de vie du personnage
            personnage.setVieActuelle(personnage.getVieActuelle() - ennemi.getPointDeVieActuelle());
            if (personnage.getVieActuelle() <= 0) {
                System.out.println(personnage.getName() + " est mort ! Fin du jeu...");
                System.exit(1);
            }else{
                System.out.println(personnage.getName()+ " a maintenant "+personnage.getVieActuelle()+" vie.s, le jeu continue ! ");
            }
        }

    }


    public Ennemi getEnnemi() {
        return ennemi;
    }

    public void setEnnemi(Ennemi ennemi) {
        this.ennemi = ennemi;
    }


}
