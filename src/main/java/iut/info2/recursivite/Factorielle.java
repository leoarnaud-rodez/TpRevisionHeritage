/*
 * Fibonnacci                               02/10/2026
 * IUT de Rodez, pas de copyright (ni de "copyleft")
 */

package iut.info2.recursivite;

import static java.lang.System.out;

public class Factorielle {

    public static void main(String[] args) {
        out.print(fact(50));
    }

    public static int fact(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Le paramètre n ne peut pas être négatif : " + n);
        }

        if (n == 1) {
            return 1;
        }

        return n * fact(n-1);
    }
}
