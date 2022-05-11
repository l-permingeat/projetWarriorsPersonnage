package com.plateau.projetwarriorspersonnage;

import com.ennemi.projetwarriorspersonnage.Dragon;
import com.ennemi.projetwarriorspersonnage.Ennemi;
import com.ennemi.projetwarriorspersonnage.Gobelin;
import com.ennemi.projetwarriorspersonnage.Sorcier;
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
            ennemi = new Dragon();
            //personnage.setEquipement(new MassueGuerrier());
        } else if (valueRandom == 2) {
            ennemi = new Gobelin();
        } else if (valueRandom == 3) {
            ennemi = new Sorcier();
        }
        System.out.println("Le type d'ennemi est un " + ennemi.getName() + " !");

    }

    public void action(Personnage personnage) {
        //Le personnage attaque l'ennemi : soustraction du nb de force du personnage au nb de vie de l'ennemi
        ennemi.setPointDeVieActuelle(ennemi.getPointDeVieActuelle() - calculForce(personnage));
        if (ennemi.getPointDeVieActuelle() <= 0) {
            System.out.println("Suite à votre attaque "+ennemi.getName() + " est mort !");
        } else {
            //L'ennemi attaque le personnage : soustraction du nb de force de l'ennemi au nb de vie du personnage
            personnage.setVieActuelle(personnage.getVieActuelle() - ennemi.getPointDattaque());
            if (personnage.getVieActuelle() <= 0) {
                System.out.println("L'attaque de l'ennemi a été fatale, "+personnage.getName() + " est mort ! Fin du jeu...");
                System.exit(1);
            } else {
                System.out.println("Suite au combat " + personnage.getName() + " a maintenant " + personnage.getVieActuelle() + " vie.s, le jeu continue ! ");
            }
        }
    }

    public int calculForce(Personnage personnage) {
        int force = 0;
        if (personnage.getEquipement() == null) {
            //force d'attaque du personnage + force d'attaque de l'équipement
            force = personnage.getForceActuelle();
        } else if ((personnage.getForceActuelle() + personnage.getEquipement().getNiveauAttaque()) < personnage.getForceMax()) {
            force = personnage.getForceMax();
        }
        return force;
    }

    /* ****************** Getter et Setter ********************/

    public Ennemi getEnnemi() {
        return ennemi;
    }

    public void setEnnemi(Ennemi ennemi) {
        this.ennemi = ennemi;
    }


}
