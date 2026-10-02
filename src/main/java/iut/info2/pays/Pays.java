/*
 * Pays                               23/09/2026
 * IUT de Rodez, pas de copyright (ni de "copyleft")
 */

package iut.info2.pays;

import java.util.TreeSet;
import java.util.ArrayList;

/**
 * Gère la gestion d'un pays et ses voisins via une collection arraylist
 *
 * @author léo arnaud
 */
public class Pays {

    private String nom;
    private TreeSet<String> voisins;

    /**
     * Constructeur sans voisin d'un pays
     *
     * @param nom
     */
    public Pays(String nom) {
        verifierNomPays(nom);
        this.nom = nom;
        this.voisins = new TreeSet<>();
    }

    /**
     * Constructeur avec voisins d'un pays
     *
     * @param nom
     * @param voisins
     */
    public Pays(String nom, String[] voisins) {
        this(nom);
        for (String voisin : voisins) {
            ajouterVoisin(voisin);
        }
    }

    /**
     * @return le nombre de voisins
     */
    public int nombreVoisin() {
        return this.voisins.size();
    }

    /**
     * vérifie si le nom d'un pays est valide (passe sans faire d'erreur, on ne vérifie pas si le terme
     * est syntaxiquement corret
     * @param nom du pays dont il faut tester la validité
     */
    private void verifierNomPays(String nom) {
        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("Le nom du Pays est invalide.");
        }
    }

    /**
     * ajoute un voisin à un pays en vérifiant si le nom du voisin est bon
     *
     * @param voisin à ajouté au pays
     */
    public void ajouterVoisin(String voisin) {
        verifierNomPays(voisin);
        this.voisins.add(voisin);
    }

    public boolean aPourVoisin(String nomPays) {
        if (nomPays == null) {
            return false;
        }
        return this.voisins.contains(nomPays);
    }

    public boolean aPourVoisin(ArrayList<String> listePays) {
        if (listePays == null) {
            return false;
        }
        TreeSet<String> ensembleListe = new TreeSet<>(listePays);
        return this.voisins.equals(ensembleListe);
    }

    public int nombreCommun(ArrayList<String> listePays) {
        if (listePays == null) {
            return 0;
        }
        TreeSet<String> ensembleListe = new TreeSet<>(listePays);
        ensembleListe.retainAll(this.voisins);
        return ensembleListe.size();
    }

    /**
     * Getter du nom des pays
     * @return le nom du pays
     */
    public String getNom() {
        return this.nom;
    }

    public TreeSet<String> getVoisins() {
        return this.voisins;
    }

    public String toString() {
        return this.nom + " a pour voisin " + this.voisins.toString();
    }
}