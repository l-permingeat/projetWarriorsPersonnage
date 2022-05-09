package com.plateau.projetwarriorspersonnage;


import com.personnage.projetwarriorspersonnage.Personnage;

import java.util.Scanner;

public interface Cellule {

     void act(Scanner scanner);

     void affectation();

    void open();
}
