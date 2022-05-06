import com.personnage.projetwarriorspersonnage.Guerrier;
import com.personnage.projetwarriorspersonnage.Magicien;
import com.personnage.projetwarriorspersonnage.Personnage;
import com.plateau.projetwarriorspersonnage.Cellule;
import com.plateau.projetwarriorspersonnage.DeVirtuel;
import com.plateau.projetwarriorspersonnage.EnnemyCellule;
import com.plateau.projetwarriorspersonnage.Plateau;

import java.util.Scanner;

public class Main {
    private DeVirtuel de;
    private Plateau plateau;
    private int positionActuelle = 0;
    Scanner scanner;

    /* ***************************** Constructeur de main ********************************************* */
    public Main() {
        this.de = new DeVirtuel(6);
        this.plateau = new Plateau();
        this.scanner = new Scanner(System.in);
    }

    /* ***************************** Fonction de départ ********************************************* */

    /**
     * Pose les questions de base pour orienter le joueur
     * Pas de parametre attendu
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, go pour une super partie ! ");
        System.out.println("Commençons par créer le personnage : Taper 1 ");
        System.out.println("Personnage déja créé ? Commencer à jouer en tapant 2  ");
        System.out.println("Quitter ?  Taper 3 ");

        int reponseChoix = scanner.nextInt();

        if (reponseChoix == 1) {
            //envoi vers la fonction création de personnage
            creerPersonnage();

        } else if (reponseChoix == 2) {
            //envoi vers la fonction pour faire avancer un personnage
            System.out.print("Fonctionnalité en cours de création");
            calculerPosition();

        } else if (reponseChoix == 3) {
            // met fin au jeux
            System.out.print("A bientôt ! ^-^ ");
        }
    }

    /* ***************************** Fonction création du personnage ********************************************* */

    /**
     * Permet de créer le personnage, guerrier ou magicien
     *
     * @return le personnage créé
     */
    public Personnage creerPersonnage() {
        Scanner scanner = new Scanner(System.in);
        //j'initialise une variable de type objet issue de la class Personnage
        Personnage personnage = null;

        System.out.print("Souhaitez vous créer un magicien ou un guerrier ? ");
        String reponseTypePersonnage = scanner.nextLine();
        System.out.print("Comment voulez vous le nommer ? ");
        String reponseNomPersonnage = scanner.nextLine();

        if (reponseTypePersonnage.equals("guerrier")) {
            personnage = new Guerrier(reponseNomPersonnage);
            //personnage.setEquipement(new MassueGuerrier());

        } else if (reponseTypePersonnage.equals("magicien")) {
            personnage = new Magicien((reponseNomPersonnage));
        }

        //System.out.println("Votre personnage est un "  +reponseTypePersonnage+ ". Il s'appelle : "+personnage.getName());
        System.out.println("Votre personnage est un.e " + personnage);

        //appelle de la fonction pour demander au joueur s'il souhaite modifier le nom de son personnage
        questionConfirmationPersonnage(personnage);

        return personnage;
    }

    /* ***************************** Fonction est ce que le personnage convient ? ********************************************* */

    /**
     * Fonction qui demande au joueur s'il veut modifier le nom du personnage
     *
     * @param personnage attends en parametre l'objet personnage choisi par le joueur
     */
    public void questionConfirmationPersonnage(Personnage personnage) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Votre personnage vous convient ? Taper 1");
        System.out.print("Sinon, taper 2 ");
        int reponseChoix = scanner.nextInt();

        if (reponseChoix == 1) {
            System.out.println("");
            System.out.println("Super, nous pouvons passer à la suite !  ");
            //appel de la fonction qui calcule la position puis qui fais avancer le personnage
            calculerPosition();
        } else if (reponseChoix == 2) {
            modifierNomPersonnage(personnage);
        }
    }

    /* ***************************** Fonction modifier le nom du personnage  ********************************************* */

    /**
     * Fonction qui modifie le nom du personnage si le joueur le souhaite
     *
     * @param personnage attends en parametre l'objet personnage choisi par le joueur
     */
    public void modifierNomPersonnage(Personnage personnage) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Comment voulez vous renommer votre personnage ? ");
        String reponseModifNomPersonnage = scanner.nextLine();
        personnage.setName(reponseModifNomPersonnage);
        System.out.println("Votre personnage est un.e" + personnage);
        questionConfirmationPersonnage(personnage);
    }

    /* ***************************** Calculer position  ********************************************* */

    /**
     * Fonction qui lance le dé et calcul la position du joueur
     */
    public void calculerPosition() {
        //si nouvellePosition < 64 alors trouver une solution
        // if(nouvellePosition<64){
        //   }
        while (positionActuelle < plateau.getSize()) {
            positionActuelle = positionActuelle + this.de.lancerDe();
            if (positionActuelle >= plateau.getSize()) {
                System.out.print("Vous avez gagné ! ");
                System.exit(1);
                break;
            }
            avancerPersonnage(positionActuelle);
        }
    }

    /* ***************************** Faire avancer le personnage  ********************************************* */

    /**
     * fonction qui fait avancer le personnage sur le plateau et indique ce qu'il y a sur la case
     *
     * @param position attends en paramètre la position du joueur
     */
    public void avancerPersonnage(int position) {
        System.out.println("");
        System.out.println("Vous avez lancé les dés, votre personnage est maintenant sur la case " + position + " du plateau");
        decisionPersonnage(this.plateau.contenuTabIndiceI(position));
    }

    /* ***************************** Décision du personnage  ********************************************* */

    /**
     * Fonction en pause pour le moment
     * ?? propose aux joueurs des choix en fonction de ce qu'il rencontre sur la case ??
     *
     * @param args
     */
    public void decisionPersonnage(Cellule cellule) {
        System.out.println(cellule);
        cellule.act(scanner);
        calculerPosition();
    }


    /* ***************************** Execution du code  ********************************************* */
    public static void main(String[] args) {
        Main menu = new Main();
        menu.start();
    } // fin void main
} // fin class Main




