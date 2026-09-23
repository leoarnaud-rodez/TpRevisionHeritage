/*
 * PileGen                               23/09/2026
 * IUT de Rodez, pas de copyright (ni de "copyleft")
 */

package iut.info2.pile;

import java.util.Objects;

/**
 * Implémentation générique d'une pile bornée.
 * Permet de gérer des éléments de n'importe quel type objet.
 *
 * @param <T> le type des éléments stockés dans la pile
 * @author Léo Arnaud
 */
public class PileGen<T> {

    /** Capacité par défaut d'une pile si aucune n'est spécifiée */
    private static final int CAPACITE_DEFAUT = 10;

    /** Capacité maximale d'éléments pouvant être contenus dans la pile */
    private int capacitePile;

    /** Nombre d'éléments actuellement présents dans la pile */
    private int taille;

    /** Tableau d'éléments génériques représentant la pile */
    private T[] pile;

    /**
     * Constructeur par défaut.
     * Crée une pile vide avec la capacité par défaut (10).
     */
    @SuppressWarnings("unchecked")
    public PileGen() {
        this.capacitePile = CAPACITE_DEFAUT;
        this.taille = 0;
        this.pile = (T[]) new Object[capacitePile];
    }

    /**
     * Constructeur avec capacité spécifiée.
     *
     * @param capacite la capacité maximale souhaitée pour la pile
     * @throws IllegalArgumentException si la capacité est inférieure ou égale à 0
     */
    @SuppressWarnings("unchecked")
    public PileGen(int capacite) {
        if (capacite <= 0) {
            throw new IllegalArgumentException("La capacité doit être positive.");
        }
        this.capacitePile = capacite;
        this.taille = 0;
        this.pile = (T[]) new Object[capacitePile];
    }

    /**
     * Indique si la pile est vide.
     *
     * @return true si la pile ne contient aucun élément, false sinon
     */
    public boolean estVide() {
        return this.taille == 0;
    }

    /**
     * Renvoie le nombre d'éléments actuellement présents dans la pile.
     *
     * @return le nombre d'éléments dans la pile
     */
    public int getTaille() {
        return this.taille;
    }

    /**
     * Indique si la pile a atteint sa capacité maximale.
     *
     * @return true si la pile est pleine, false sinon
     */
    public boolean estPleine() {
        return this.taille == this.capacitePile;
    }

    /**
     * Ajoute un nouvel élément au sommet de la pile.
     *
     * @param valeur l'élément à ajouter dans la pile
     * @throws IllegalStateException si la pile est déjà pleine
     */
    public void empiler(T valeur) {
        if (estPleine()) {
            throw new IllegalStateException("Impossible d'empiler : la pile est pleine.");
        }
        this.pile[this.taille] = valeur;
        this.taille++;
    }

    /**
     * Renvoie l'élément situé au sommet de la pile sans le retirer.
     *
     * @return l'élément au sommet de la pile
     * @throws IllegalStateException si la pile est vide
     */
    public T sommet() {
        if (estVide()) {
            throw new IllegalStateException("La pile est vide : aucun sommet.");
        }
        return this.pile[this.taille - 1];
    }

    /**
     * Retire l'élément situé au sommet de la pile.
     *
     * @throws IllegalStateException si la pile est vide
     */
    public void depiler() {
        if (estVide()) {
            throw new IllegalStateException("Impossible de dépiler : la pile est vide.");
        }
        this.taille--;
        this.pile[this.taille] = null; // Libération de la référence pour économiser de la place
    }

    /**
     * Compare la capacité de deux piles.
     *
     * @param pile1 la première pile à comparer
     * @param pile2 la seconde pile à comparer
     * @return true si les deux piles ont la même capacité et sont non nulles, false sinon
     */
    public static boolean memeCapacite(PileGen<?> pile1, PileGen<?> pile2) {
        if (pile1 == null || pile2 == null) {
            return false;
        }
        return pile1.capacitePile == pile2.capacitePile;
    }

    /**
     * Représentation sous forme de chaîne de caractères du contenu de la pile.
     *
     * @return une chaîne décrivant les éléments de la pile du sommet vers la base
     */
    @Override
    public String toString() {
        if (estVide()) {
            return "[ sommet =  ]";
        }

        StringBuilder resultat = new StringBuilder("[ sommet =  ");
        for (int i = this.taille - 1; i >= 0; i--) {
            resultat.append(this.pile[i]).append(" | ");
        }
        resultat.append(" ]");
        return resultat.toString();
    }

    /**
     * Détermine si la pile courante est égale à un autre objet.
     * Deux piles sont égales si elles ont la même capacité, la même taille et les mêmes éléments dans le même ordre.
     *
     * @param obj l'objet à comparer avec la pile courante
     * @return true si l'objet est égal à la pile, false sinon
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        PileGen<?> autre = (PileGen<?>) obj;

        if (!memeCapacite(this, autre) || this.taille != autre.taille) {
            return false;
        }

        for (int i = 0; i < this.taille; i++) {
            if (!Objects.equals(this.pile[i], autre.pile[i])) {
                return false;
            }
        }
        return true;
    }
}