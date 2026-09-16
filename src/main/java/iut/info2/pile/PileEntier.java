/*
 * PileEntier.java                                          10 sept. 2026
 * IUT de Rodez, pas de copyright (ni de "copyleft")
 */

package iut.info2.pile;

import java.util.Objects;

/**
 * Implémente en java le TP de développement efficace qui permet d'effectuer
 * des opérations de piles, on précise ici qu'il s'agit des piles de
 * pirouette cacahouette.
 *
 * @author leo.arnaud
 */
public class PileEntier {

    /* attribut de la classe représentant la capacité de la pile*/
    private int capacitePile;

    /* Nombre d'élément que la pile contient à un instant donné */
    private int taille;

    /* Pile */
    private int[] pile;

    private final int CAPACITE_DEFAUT = 10;

    /**
     * Constructeur par défaut de la classe Pile
     * Crée une pile vide avec la capacité par défaut
     */
    public PileEntier() {
        this.capacitePile = CAPACITE_DEFAUT;
        this.taille = 0;
        this.pile = new int[capacitePile];
    }

    /**
     * Constructeur de la pile exigeant la capacité de la pile à créer.
     *
     * @param capacite de la pile qu'il faut créer
     * @throws IllegalArgumentException si la capacité est <= 0
     */
    public PileEntier(int capacite) {
        if (capacite <= 0) {
            throw new IllegalArgumentException("La capacité doit être positive.");
        }
        this.capacitePile = capacite;
        this.taille = 0;
        this.pile = new int[capacitePile];
    }

    /**
     * Teste si la pile est vide.
     *
     * @return boolean : true si la pile est vide, false sinon
     */
    public boolean estVide() {
        return this.taille == 0;
    }

    /**
     * Renvoie le nombre d'éléments actuellement présents dans la pile.
     *
     * @return int : le nombre d'éléments dans la pile
     */
    public int getTaille() {
        return this.taille;
    }

    /**
     * Indique si la pile est pleine.
     *
     * @return boolean : true si la pile est pleine, false sinon
     */
    public boolean estPleine() {
        return this.taille == this.capacitePile;
    }

    /**
     * Empile un nouvel entier au sommet de la pile.
     *
     * @param valeur l'entier à ajouter
     * @throws IllegalStateException si la pile est pleine
     */
    public void empiler(int valeur) {
        if (estPleine()) {
            throw new IllegalStateException("Impossible d'empiler : la pile est pleine.");
        }
        this.pile[this.taille] = valeur;
        this.taille++;
    }

    /**
     * Renvoie la valeur située au sommet de la pile sans la retirer.
     *
     * @return int : la valeur au sommet
     * @throws IllegalStateException si la pile est vide
     */
    public int sommet() {
        if (estVide()) {
            throw new IllegalStateException("La pile est vide : aucun sommet.");
        }
        return this.pile[this.taille - 1];
    }

    /**
     * Dépile l'élément au sommet de la pile.
     *
     * @throws IllegalStateException si la pile est vide
     */
    public void depiler() {
        if (estVide()) {
            throw new IllegalStateException("Impossible de dépiler : la pile est vide.");
        }
        this.taille--;
    }

    /**
     * Détermine si deux piles ont la même capacité.
     *
     * @param pile1 la première pile à comparer
     * @param pile2 la seconde pile à comparer
     * @return true si les deux piles sont non nulles et ont la même capacité, false sinon
     */
    public static boolean memeCapacite(PileEntier pile1, PileEntier pile2) {
        if (pile1 == null || pile2 == null) {
            return false;
        }
        return pile1.capacitePile == pile2.capacitePile;
    }

    /**
     * Représentation de la pile sous forme de chaîne de caractères.
     */
    @Override
    public String toString() {
        if (estVide()) {
            return "[ sommet =  ]";
        }

        String resultat = "[ sommet =  ";
        for (int i = this.taille - 1; i >= 0; i--) {
            resultat += this.pile[i] + " | ";
        }

        return resultat + " ]";
    }

    /**
     * Vérifie si deux piles sont identiques (même capacité et même contenu).
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        PileEntier autre = (PileEntier) obj;

        if (!memeCapacite(this, autre) || this.taille != autre.taille) {
            return false;
        }

        for (int i = 0; i < this.taille; i++) {
            if (this.pile[i] != autre.pile[i]) {
                return false;
            }
        }
        return true;
    }
}