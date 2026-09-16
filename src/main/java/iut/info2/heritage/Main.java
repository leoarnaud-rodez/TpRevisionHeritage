package iut.info2.heritage;

import java.util.Scanner;

public class Main {
    /**
     *
     * @param args not used
     */
    public static void main(String[] args) {

        Scanner entree = new Scanner(System.in);
        Individu membre1,
                 membre2,
                 membre3,
                 membre4,
                 membre5;
        
        Individu[] groupe = new Individu[] {
            membre1 = new Individu(),
            membre2 = new Individu(),
            membre3 = new Individu(),
            membre4 = new Individu(),
            membre5 = new Individu()

        };

        for(int indice = 0; indice < 5; indice ++) {
            System.out.println("emplacement " + (indice + 1) + "/5 du tableau.\nSouhaitez-vous créer une instance"
            				   + " d'Individu (n'import quelle touche) ou de Personne (saisir \"pers\")");
            String choix = entree.nextLine();
            if (!choix.equals("pers")) {
                System.out.println("Veuillez entrer les informations concernant l'individu");
                groupe[indice] = new Individu();
            } else {
                System.out.println("Veuillez entrer les informations concernant la personne");
                groupe[indice] = new Personne();
            }
            groupe[indice].saisir();
        }

        /*
         * for(int indice = 0; indice < 5; indice ++) {
         *     groupe[indice].afficher();
         * }
         */

        /*
         * Personne citoyen1 = new Personne();
         * Personne citoyen2 = new Personne("Frederic", "Barrios");
         * Personne citoyen3 = new Personne("Léo", "ScoobyDoo", "3630363067", "contact@leoarnaud.fr");
         *
         * citoyen1.afficher();
         * citoyen2.afficher();
         * citoyen3.afficher();
         *
         * citoyen1.saisir();
         *
         * citoyen1.afficher();
         * citoyen2.afficher();
         * citoyen3.afficher();
         *
         * System.out.println(citoyen1.informations());
         * System.out.println(citoyen2.informations());
         * System.out.println(citoyen3.informations());
         */


    }
}