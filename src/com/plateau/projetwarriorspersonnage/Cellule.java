package com.plateau.projetwarriorspersonnage;


import com.ennemi.projetwarriorspersonnage.Ennemi;
import com.personnage.projetwarriorspersonnage.Personnage;

import java.util.Scanner;

public interface Cellule {

     void act(Scanner scanner);

    /**
     * Ouvre le contenu d'une case
     */
    void open();

    /**
     * déclenche le combat ou la ramasse de la surprise
     * @param personnage le type de personnage (guerrier, magicien)
     */

    void action(Personnage personnage);
}
