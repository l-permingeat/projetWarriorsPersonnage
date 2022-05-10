package com.plateau.projetwarriorspersonnage;


import com.ennemi.projetwarriorspersonnage.Ennemi;
import com.personnage.projetwarriorspersonnage.Personnage;

import java.util.Scanner;

public interface Cellule {

     void act(Scanner scanner);

    void open();

    void action(Personnage personnage);
}
