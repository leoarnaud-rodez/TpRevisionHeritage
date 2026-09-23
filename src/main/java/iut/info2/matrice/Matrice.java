/*
 * Matrice                               23/09/2026
 * IUT de Rodez, pas de copyright (ni de "copyleft")
 */

package iut.info2.matrice;

import java.util.ArrayList;

/**
 * Représente une matrice creuse de nombres réels.
 * Une matrice creuse est optimisée en mémoire en ne stockant que ses coefficients non nuls
 * dans une liste dynamique {@link ArrayList}.
 *
 * @author Léo Arnaud
 * @version 1.0
 */
public class Matrice {

    /** Nombre de lignes par défaut */
    private static final int LIGNES_DEFAUT = 5;

    /** Nombre de colonnes par défaut */
    private static final int COLONNES_DEFAUT = 5;

    /** Liste des coefficients non nuls stockés dans la matrice */
    private ArrayList<Coefficient> valeurs;

    /** Nombre total de lignes de la matrice */
    private int lignes;

    /** Nombre total de colonnes de la matrice */
    private int colonnes;

    /**
     * Constructeur par défaut.
     * Crée une matrice creuse de dimension 5x5.
     */
    public Matrice() {
        this(LIGNES_DEFAUT, COLONNES_DEFAUT);
    }

    /**
     * Constructeur avec dimensions paramétrées.
     *
     * @param lignes le nombre de lignes de la matrice
     * @param colonnes le nombre de colonnes de la matrice
     * @throws IllegalArgumentException si l'une des dimensions est inférieure ou égale à 0
     */
    public Matrice(int lignes, int colonnes) {
        if (lignes <= 0 || colonnes <= 0) {
            throw new IllegalArgumentException("Les dimensions doivent être strictement positives.");
        }
        this.lignes = lignes;
        this.colonnes = colonnes;
        this.valeurs = new ArrayList<>();
    }

    /**
     * Accesseur sur le nombre de lignes.
     *
     * @return le nombre de lignes
     */
    public int getLignes() {
        return lignes;
    }

    /**
     * Accesseur sur le nombre de colonnes.
     *
     * @return le nombre de colonnes
     */
    public int getColonnes() {
        return colonnes;
    }

    /**
     * Vérifie la validité des coordonnées d'une case de la matrice.
     *
     * @param numLigne le numéro de ligne à tester
     * @param numColonne le numéro de colonne à tester
     * @throws IllegalArgumentException si les coordonnées sont hors limites
     */
    private void verifierCoordonnees(int numLigne, int numColonne) {
        if (numLigne < 1 || numLigne > lignes || numColonne < 1 || numColonne > colonnes) {
            throw new IllegalArgumentException("Coordonnées hors limites : (" + numLigne + "," + numColonne + ")");
        }
    }

    /**
     * Supprime de la liste le coefficient présent aux coordonnées spécifiées, s'il existe.
     *
     * @param numLigne numéro de la ligne
     * @param numColonne numéro de la colonne
     * @return true si un coefficient a été trouvé et supprimé, false sinon
     */
    private boolean supprimer(int numLigne, int numColonne) {
        for (int i = 0; i < valeurs.size(); i++) {
            if (valeurs.get(i).estSitue(numLigne, numColonne)) {
                valeurs.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Modifie ou insère la valeur d'un coefficient aux coordonnées indiquées.
     * Si la valeur passée est 0, l'élément est supprimé de la structure creuse.
     *
     * @param numLigne numéro de la ligne
     * @param numColonne numéro de la colonne
     * @param valeur valeur à affecter
     * @throws IllegalArgumentException si les coordonnées sont invalides
     */
    public void setValeur(int numLigne, int numColonne, double valeur) {
        verifierCoordonnees(numLigne, numColonne);

        // Suppression de l'éventuelle valeur qui était la avant
        supprimer(numLigne, numColonne);

        // Ajout uniquement si la valeur n'est pas nulle parce que sinon : sans intérêt ici
        if (valeur != 0) {
            valeurs.add(new Coefficient(numLigne, numColonne, valeur));
        }
    }

    /**
     * Accède à la valeur du coefficient situé aux coordonnées spécifiées.
     *
     * @param numLigne numéro de la ligne
     * @param numColonne numéro de la colonne
     * @return la valeur du coefficient si présent, 0.0 sinon
     * @throws IllegalArgumentException si les coordonnées sont invalides
     */
    public double getValeur(int numLigne, int numColonne) {
        verifierCoordonnees(numLigne, numColonne);

        for (Coefficient c : valeurs) {
            if (c.estSitue(numLigne, numColonne)) {
                return c.getValeur();
            }
        }
        return 0.0;
    }

    /**
     * Affiche sur la console l'ensemble des coefficients non nuls stockés.
     */
    public void afficher() {
        if (valeurs.isEmpty()) {
            System.out.println("Matrice nulle (aucun coefficient non nul).");
            return;
        }
        for (Coefficient c : valeurs) {
            System.out.println(c);
        }
    }
}