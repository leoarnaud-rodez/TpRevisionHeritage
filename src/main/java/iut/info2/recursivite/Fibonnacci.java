/*
 * Fibonnacci                               02/10/2026
 * IUT de Rodez, pas de copyright (ni de "copyleft")
 */

package iut.info2.recursivite;

import static java.lang.System.out;

public class Fibonnacci {

    public static void main(String[] args) {
        out.println("U_0 = " + fibonacci(0));
        out.println("U_1 = " + fibonacci(1));
        out.println("U_5 = " + fibonacci(5));
        out.println("U_30 = " + fibonacci(30));
        out.println("U_300 = " + fibonacci(300));
    }

    /**
     * Calcule le n-ième terme de la suite de Fibonacci[cite: 1].
     * Termes initiaux : U_0 = 1, U_1 = 1[cite: 1].
     *
     * @param n le rang du terme à calculer
     * @return la valeur du terme U_n
     * @throws IllegalArgumentException si n est négatif
     */
    public static int fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Le paramètre n ne peut pas être négatif : " + n);
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}