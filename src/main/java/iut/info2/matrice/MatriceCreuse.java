/*
 * MatriceCreuse                               16/09/2026
 * IUT de Rodez, pas de copyright (ni de "copyleft")
 */

package iut.info2.matrice;

import java.util.ArrayList;

/**
 * TODO : commenter la responsabilité SRP de cette classe
 *
 * @author léo arnaud
 */
public class MatriceCreuse {

    private final int LIGNES_DEFAULT = 5;

    private final int COLONNES_DEFAUT = 5;

    private ArrayList<Coefficient> Valeurs;

    private int lignes;

    private int colonnes;

    public MatriceCreuse() {
        this.lignes = LIGNES_DEFAULT;
        this.colonnes = COLONNES_DEFAUT;
    }

    public MatriceCreuse(int lignes, int colonnes) {
        this.lignes = lignes;
        this.colonnes = colonnes;
    }
}
