import com.exception.PersonnageHorsPlateauException;
import com.personnage.projetwarriorspersonnage.Guerrier;
import com.personnage.projetwarriorspersonnage.Magicien;
import com.personnage.projetwarriorspersonnage.Personnage;
import com.plateau.projetwarriorspersonnage.Cellule;
import com.plateau.projetwarriorspersonnage.DeVirtuel;
import com.plateau.projetwarriorspersonnage.Plateau;

import java.util.Scanner;

public class Game {
    private DeVirtuel de;
    private Plateau plateau;
    private int positionActuelle = 0;
    Scanner scanner;
    private com.exception.PersonnageHorsPlateauException PersonnageHorsPlateauException;
    Personnage personnage;


    /* ***************************** Constructeur de main ********************************************* */
    public Game() {
        this.de = new DeVirtuel(6);
        this.plateau = new Plateau();
        this.scanner = new Scanner(System.in);
        this.PersonnageHorsPlateauException = new PersonnageHorsPlateauException();
    }

    /* ***************************** Fonction de départ ********************************************* */

    /**
     * Pose les questions de base pour orienter le joueur
     * Pas de parametre attendu
     */
    public void start() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Hello, go pour une super partie ! ");
            System.out.println("Commençons par créer le personnage : Taper 1 \nPersonnage déja créé ? Commencer à jouer en tapant 2 \nQuitter ?  Taper 3");

            int reponseChoix = scanner.nextInt();

            if (reponseChoix == 1) {
                //envoi vers la fonction création de personnage
                 creerPersonnage();
            } else if (reponseChoix == 2) {
                calculerPosition();

            } else if (reponseChoix == 3) {
                // met fin au jeux
                System.out.print("A bientôt ! ^-^ ");
            } else {
                System.out.println("Mauvaise saisie \n Vous devez taper 1, 2 ou 3");
                start();
            }
        } catch (Exception e) {
            System.out.println("Il y a une erreur - fonction Start");
            start();
        }
    }

    /* ***************************** Fonction création du personnage ********************************************* */

    /**
     * Permet de créer le personnage, guerrier ou magicien
     *
     * @return le personnage créé
     */
    public void creerPersonnage() {
        //j'initialise une variable de type objet issue de la class Personnage
       // Personnage personnage = null;
        try {
            System.out.print("Souhaitez vous créer un magicien ou un guerrier ? ");
            String reponseTypePersonnage = scanner.nextLine();
            System.out.print("Comment voulez vous le nommer ? ");
            String reponseNomPersonnage = scanner.nextLine();

            if (reponseTypePersonnage.equals("guerrier")) {
                this.personnage = new Guerrier(reponseNomPersonnage);
                //personnage.setEquipement(new MassueGuerrier());

            } else if (reponseTypePersonnage.equals("magicien")) {
                this.personnage = new Magicien((reponseNomPersonnage));
            }
        } catch (Exception e) {
            System.out.print(" Mauvaise saisie, vous devez taper guerrier ou magicien ");
        }

        //System.out.println("Votre personnage est un "  +reponseTypePersonnage+ ". Il s'appelle : "+personnage.getName());
        System.out.println("Votre personnage est un.e " + personnage);

        //appelle de la fonction pour demander au joueur s'il souhaite modifier le nom de son personnage
        questionConfirmationPersonnage();

      //  return personnage;
    }

    /* ***************************** Fonction est ce que le personnage convient ? ********************************************* */

    /**
     * Demande au joueur s'il veut modifier le nom du personnage
     *
     * @param personnage attends en parametre l'objet personnage choisi par le joueur
     */
    public void questionConfirmationPersonnage() {
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
            modifierNomPersonnage();
        }
    }

    /* ***************************** Fonction modifier le nom du personnage  ********************************************* */

    /**
     * Modifie le nom du personnage si le joueur le souhaite
     * @param personnage attends en parametre l'objet personnage choisi par le joueur
     */
    public void modifierNomPersonnage() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Comment voulez vous renommer votre personnage ? ");
        String reponseModifNomPersonnage = scanner.nextLine();
        personnage.setName(reponseModifNomPersonnage);
        System.out.println("Votre personnage est un.e" + personnage);
        questionConfirmationPersonnage();
    }

    /* ***************************** Calculer position  ********************************************* */

    /**
     * Lance le dé et calcul la position du joueur
     */
    public void calculerPosition() {
        try {
            while (true) {
                positionActuelle = positionActuelle + this.de.lancerDe();
                avancerPersonnage(positionActuelle);
            }
            //écoute si une exception se produit, traitement de l'exception executé
        } catch (PersonnageHorsPlateauException e){
            System.out.print(e);
            System.exit(1);
        }

       /* while (positionActuelle < plateau.getSize()) {
            positionActuelle = positionActuelle + this.de.lancerDe();
            if (positionActuelle >= plateau.getSize()) {
                System.out.print("Vous avez gagné ! ");
                System.exit(1);
                break;
            }
            avancerPersonnage(positionActuelle);
        }*/
    }

    /* ***************************** Faire avancer le personnage  ********************************************* */

    /**
     * Fait avancer le personnage sur le plateau et indique ce qu'il y a sur la case
     *
     * @param position attends en paramètre la position du joueur
     */
    public void avancerPersonnage(int position)throws PersonnageHorsPlateauException {
        System.out.println("Vous avez lancé les dés. " + personnage.getName() + " est sur la case " + position + " du plateau");
        decisionPersonnage(this.plateau.contenuTabIndiceI(position));
    }

    /* ***************************** Décision du personnage  ********************************************* */

    /**
     * Propose aux joueurs des choix en fonction de ce qu'il rencontre sur la case
     * @param cellule, c'est l'objet qu'il y a dans la cellule (ennemi, vide, surprise...)
     */
    public void decisionPersonnage(Cellule cellule) {
        System.out.println(cellule);
        cellule.act(scanner);
       // System.out.println("le personnage est " + personnage );
        //open affiche quel type de surprise c'est (massue, epée...) ou le type d'ennemi (gobelins...)
        cellule.open();

        cellule.action(personnage);

        // /!\ ici il doit y avoir l'appel d'une méthode combat /!\

        //fait avancer le personnage
        calculerPosition();
    }

} // fin class Main




