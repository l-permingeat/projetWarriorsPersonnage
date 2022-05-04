import com.equipement.projetwarriorspersonnage.MassueGuerrier;
import com.personnage.projetwarriorspersonnage.Guerrier;
import com.personnage.projetwarriorspersonnage.Magicien;
import com.personnage.projetwarriorspersonnage.Personnage;

import java.util.Scanner;

public class Main {
    public void start(){

    }
    public Personnage creerPersonnage() {
        Scanner scanner = new Scanner(System.in);
        //j'initialise une variable de type objet issue de la class Personnage
        Personnage personnage = null;
        System.out.print("Souhaitez vous créer un magicien ou un guerrier ? ");
        String reponseTypePersonnage = scanner.nextLine();
        System.out.print("Comment voulez vous le nommer ? ");
        String reponseNomPersonnage = scanner.nextLine();

        if (reponseTypePersonnage.equals("guerrier")) {
            personnage= new Guerrier(reponseNomPersonnage);
            //personnage.setEquipement(new MassueGuerrier());
        } else if (reponseTypePersonnage.equals("magicien")) {
            personnage = new Magicien((reponseNomPersonnage));
        }

        //System.out.println("Votre personnage est un "  +reponseTypePersonnage+ ". Il s'appelle : "+personnage.getName());
        System.out.println("Votre personnage est un.e "+ personnage);

        return personnage;
    }//fin créer personnage



    public static void main(String[] args) {

        Main menu = new Main();
        menu.creerPersonnage();
        menu.start();

    } // fin void main
} // fin class Main




