/*
 * TestPileGenComplet                               23/09/2026
 * IUT de Rodez, pas de copyright (ni de "copyleft")
 */

package iut.info2.pile.test;

import iut.info2.pile.PileGen;

/**
 * Programme de test pour la classe générique PileGen.
 * Valide le bon fonctionnement des méthodes de la pile pour différents types d'objets (Integer, String)
 * ainsi que le comportement face aux exceptions.
 *
 * @author Léo Arnaud
 */
public class TestPileGenComplet {

    /**
     * Vérifie que la pile spécifiée est bien vide au moment de sa création.
     *
     * @param p la pile à tester
     * @param nomPile le nom de la pile pour le message de test
     */
    private static void testCreationPileVide(PileGen<?> p, String nomPile) {
        if (p.estVide()) {
            System.out.println("Création avec succès de la pile " + nomPile + " (vide) ! " + p);
        } else {
            System.out.println("Test NOK pour la création de la pile " + nomPile);
        }
    }

    /**
     * Teste la méthode statique de comparaison des capacités des piles.
     *
     * @param p la première pile de référence
     * @param identique une pile ayant la même capacité que p
     * @param differente une pile ayant une capacité différente de p
     */
    private static void testCapacite(PileGen<?> p, PileGen<?> identique, PileGen<?> differente) {
        if (PileGen.memeCapacite(p, identique)
                && !PileGen.memeCapacite(p, differente)
                && !PileGen.memeCapacite(identique, differente)) {
            System.out.println("Test OK pour la méthode memeCapacite.");
        } else {
            System.out.println("Test NOK pour la méthode memeCapacite.");
        }
    }

    /**
     * Teste l'égalité entre plusieurs instances de piles.
     *
     * @param p la pile de référence
     * @param identique une pile ayant le même contenu et la même capacité que p
     * @param differente une pile différente
     */
    private static void testEgalite(PileGen<?> p, PileGen<?> identique, PileGen<?> differente) {
        if (p.equals(identique) && !p.equals(differente)) {
            System.out.println("Test OK pour la méthode equals.");
        } else {
            System.out.println("Test NOK pour la méthode equals.");
        }
    }

    /**
     * Exécute la série de tests sur une pile d'entiers (Integer).
     */
    private static void testAvecIntegers() {
        System.out.println("=== TEST 1 : PileGen<Integer> ===");

        try {
            PileGen<Integer> p = new PileGen<>(5);
            PileGen<Integer> inverse = new PileGen<>(5);
            PileGen<Integer> grandePile = new PileGen<>(10);

            testCreationPileVide(p, "p");
            testCreationPileVide(inverse, "inverse");
            testCreationPileVide(grandePile, "grandePile");

            testCapacite(p, inverse, grandePile);
            testEgalite(p, inverse, grandePile);

            for (int n = 1; n <= 5; n++) {
                p.empiler(n);
            }

            System.out.println("\nContenu de p : " + p);

            while (!p.estVide()) {
                inverse.empiler(p.sommet());
                p.depiler();
            }

            System.out.println("Contenu de inverse : " + inverse);
            System.out.println("p est devenue vide ? " + (p.estVide() ? "OK" : "NOK"));

        } catch (Exception e) {
            System.out.println("Erreur inattendue : " + e.getMessage());
        }
    }

    /**
     * Exécute la série de tests sur une pile de chaînes de caractères (String).
     */
    private static void testAvecStrings() {
        System.out.println("\n=== TEST 2 : PileGen<String> ===");

        try {
            PileGen<String> pileChaines = new PileGen<>(3);
            pileChaines.empiler("Rodez");
            pileChaines.empiler("IUT");
            pileChaines.empiler("BUT2");

            System.out.println("Sommet attendu 'BUT2' -> Obtenu : " + pileChaines.sommet());
            System.out.println("Affichage : " + pileChaines);

            pileChaines.depiler();
            System.out.println("Après un dépiler, nouveau sommet attendu 'IUT' -> Obtenu : " + pileChaines.sommet());

        } catch (Exception e) {
            System.out.println("Erreur inattendue : " + e.getMessage());
        }
    }

    /**
     * Vérifie la levée des exceptions attendues dans diverses conditions d'erreur.
     */
    private static void testDesExceptions() {
        System.out.println("\n=== TEST 3 : Validation des exceptions ===");
        int testOk = 0;

        // Constructeur à capacité négative
        try {
            new PileGen<Integer>(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Test OK : Capacité négative levée.");
            testOk++;
        }

        // Empiler sur pile pleine
        try {
            PileGen<String> p = new PileGen<>(1);
            p.empiler("A");
            p.empiler("B");
        } catch (IllegalStateException e) {
            System.out.println("Test OK : Empiler sur pile pleine levé.");
            testOk++;
        }

        // Dépiler sur pile vide
        try {
            PileGen<Double> p = new PileGen<>(5);
            p.depiler();
        } catch (IllegalStateException e) {
            System.out.println("Test OK : Dépiler sur pile vide levé.");
            testOk++;
        }

        // Accès au sommet sur pile vide
        try {
            PileGen<Double> p = new PileGen<>(5);
            p.sommet();
        } catch (IllegalStateException e) {
            System.out.println("Test OK : Sommet sur pile vide levé.");
            testOk++;
        }

        if (testOk == 4) {
            System.out.println("--> Succès de tous les tests d'exceptions !");
        }
    }

    /**
     * Point d'entrée principal pour lancer les séries de tests.
     *
     * @param args arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        testAvecIntegers();
        testAvecStrings();
        testDesExceptions();
    }
}