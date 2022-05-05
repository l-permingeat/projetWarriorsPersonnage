import com.personnage.projetwarriorspersonnage.Guerrier;
import com.personnage.projetwarriorspersonnage.Magicien;
import com.personnage.projetwarriorspersonnage.Personnage;
import com.plateau.projetwarriorspersonnage.Cellule;
import com.plateau.projetwarriorspersonnage.DeVirtuel;
import com.plateau.projetwarriorspersonnage.Plateau;

import java.util.Scanner;

public class Main {
    private DeVirtuel de;
    private Plateau plateau;
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
    public void modifierNomPersonnage(Personnage personnage) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Comment voulez vous renommer votre personnage ? ");
        String reponseModifNomPersonnage = scanner.nextLine();
        personnage.setName(reponseModifNomPersonnage);
        System.out.println("Votre personnage est un.e" + personnage);
        questionConfirmationPersonnage(personnage);
    }

    /* ***************************** Calculer position  ********************************************* */
    public void calculerPosition() {
        int positionActuelle = 0;
        int nouvellePosition = positionActuelle + this.de.lancerDe();
        //si nouvellePosition <= 64 alors trouver une solution
        avancerPersonnage(nouvellePosition);
        positionActuelle = nouvellePosition;

    }

    /* ***************************** Faire avancer le personnage  ********************************************* */
    public void avancerPersonnage(int position) {
        System.out.println("");
        System.out.println("Votre personnage est sur la case " + position + " du plateau");
        System.out.println("Dans cette case il y a un.e " + this.plateau.contenuTabIndiceI(position));
        decisionPersonnage(this.plateau.contenuTabIndiceI(position));
        System.out.println("Si vous voulez relancer le dé taper 1");
        System.out.println("Vous voulez quitter ? Taper 2 ");
        int reponsePersonnage = scanner.nextInt();

        if (reponsePersonnage == 1) {
            calculerPosition();
        } else {
            System.out.println("A bientôt !");
            System.exit(1);
        }

    }

    /* ***************************** Décision du personnage  ********************************************* */
    public void decisionPersonnage(Cellule valeurCase) {
        if (valeurCase.equals("ennemi")) {
            System.out.println("Vous devez combattre !");
            System.out.println("Vous voulez quitter ? Taper 1");
            int reponsePersonnage = scanner.nextInt();
            if (reponsePersonnage == 1) {
                System.out.println("Je sais pas comment sortir");
            }
        } else if (valeurCase.equals("surprise")) {
            System.out.println("Voulez vous ramasser la surprise ?");
            System.out.println("Si oui ? Taper 1");
            System.out.println("Si non ? Taper 2");
            int reponsePersonnage = scanner.nextInt();
            if (reponsePersonnage == 1) {
                System.out.println("Vous avez ramasser la surprise");
            } else {
                System.out.println("Tant pis pour vous");
            }
        } else if (valeurCase.equals("vide")) {
            System.out.println("Rien ne se passe");
        } else {
            System.out.println("On continue");
        }
    }

    /* ***************************** Execution du code  ********************************************* */
    public static void main(String[] args) {
        Main menu = new Main();
        menu.start();
    } // fin void main
} // fin class Main




