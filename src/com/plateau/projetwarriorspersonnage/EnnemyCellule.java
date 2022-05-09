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
    public void affectation() {
        Random random = new Random();
        int valueRandom = random.nextInt(2 + 1) + 1;
        if (valueRandom == 1) {
            ennemi=new Dragons();
            //personnage.setEquipement(new MassueGuerrier());
        } else if (valueRandom == 2) {
            ennemi=new Gobelins();
        } else if (valueRandom == 3) {
             ennemi=new Sorciers();
        }
    }
    @Override
    public void open() {
        Random random = new Random();
        int valueRandom = random.nextInt(2 + 1) + 1;
        if (valueRandom == 1) {
            ennemi=new Dragons();
            //personnage.setEquipement(new MassueGuerrier());
        } else if (valueRandom == 2) {
            ennemi=new Gobelins();
        } else if (valueRandom == 3) {
            ennemi=new Sorciers();
        }
        System.out.println("Le type d'ennemi est "+ennemi.getName());

       // if (personnage instanceof Magicien){}


    }

    public Ennemi getEnnemi() {
        return ennemi;
    }

    public void setEnnemi(Ennemi ennemi) {
        this.ennemi = ennemi;
    }


}
