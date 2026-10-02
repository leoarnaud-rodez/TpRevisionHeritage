/*
 * FigureGeometrique                               02/10/2026
 * IUT de Rodez, pas de copyright (ni de "copyleft")
 */

package iut.info2.recursivite;

import static java.lang.System.out;

public class FigureGeometrique {

    public static void main(String[] args) {
        out.println("--- Test etoile(4) ---");
        etoile(4);

        out.println("\n--- Test triangleRectangle(4) ---");
        triangleRectangle(4);

        out.println("\n--- Test triangleIsocele(5) ---");
        triangleIsocele(5);

        out.println("\n--- Test losange(7) ---");
        losange(7);
    }

    /**
     * Affiche n espaces sur la même ligne
     * @param n nombre d'espaces à afficher
     */
    public static void blanc(int n) {
        if (n > 0) {
            out.print(' ');
            blanc(n - 1);
        }
    }

    /**
     * Affiche n étoiles puis passe à la ligne suivante
     * Sans effet si n est négatif
     * @param n nombre d'étoiles
     */
    public static void etoile(int n) {
        if (n < 0) {
            return;
        }
        if (n > 0) {
            out.print('*');
            etoile(n - 1);
        } else {
            out.println();
        }
    }

    /**
     * Affiche un triangle rectangle de hauteur n
     * @param n hauteur du triangle
     */
    public static void triangleRectangle(int n) {
        if (n > 0) {
            triangleRectangle(n - 1);
            etoile(n);
        }
    }

    /**
     * Affiche un triangle isocèle de hauteur n.
     * @param n hauteur du triangle
     */
    public static void triangleIsocele(int n) {
        if (n > 0) {
            triangleIsocele(n, 1);
        }
    }

    private static void triangleIsocele(int n, int ligne) {
        if (ligne <= n) {
            blanc(n - ligne);
            etoile(2 * ligne - 1);
            triangleIsocele(n, ligne + 1);
        }
    }

    /**
     * Affiche un losange dont la diagonale comporte n étoiles
     * @param n nombre d'étoiles de la diagonale (doit être impair)
     */
    public static void losange(int n) {
        if (n > 0 && n % 2 != 0) {
            losange(n, 1);
        }
    }

    private static void losange(int n, int ligne) {
        if (ligne <= n) {
            int nbEtoiles = (ligne <= (n + 1) / 2)
                    ? 2 * ligne - 1
                    : 2 * (n - ligne + 1) - 1;
            int nbBlancs = (n - nbEtoiles) / 2;

            blanc(nbBlancs);
            etoile(nbEtoiles);
            losange(n, ligne + 1);
        }
    }
}