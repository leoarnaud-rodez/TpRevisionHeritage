/*
 * Personne                            06/09/2026
 *  IUT de Rodez                       no copyright nor copyleft
 */
package iut.info2.heritage;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Représente une Personne par :
 *  - un nom et un prénom hérités de la classe indivdu
 *  - un numéro de téléphone
 *  - un email
 * @author TPD
 */
public class Personne extends Individu {

	/** Objet de type Scanner pour exploiter les entrées clavier de l'utilisateur */
	private static Scanner entrees = new Scanner(System.in);

	/** Mail par défaut */
	private static final String DEFAULT_MAIL = "inconnu@inconu";

	/** regex du format correct d'un mail */
	private static final  Pattern REGEX_EMAIL = Pattern.compile("^[\\_\\.\\-\\p{Alnum}]+@[\\_\\-\\p{Alnum}]+\\.\\p{Alnum}{2,3}$");

	/**  Numéro de téléphone de la personne */
	private final Telephone telephone;

	/** Email de la personne */
	private String email;

	/** Constructeur par défaut */
	public Personne(){
		telephone = new Telephone();
		email = DEFAULT_MAIL;
	}

	/** Constructeur par un nom et un prénom */
	public Personne(String nom, String prenom){
		telephone = new Telephone();
		email = DEFAULT_MAIL;
		super(nom, prenom);
	}

	/** Constructeur par un nom, un prenom, un email et un numéro de téléphone */
	public Personne(String nom, String prenom, String telephone, String email){
		this.telephone = new Telephone(telephone);
		this.email = email;
		super(nom, prenom);
	}

	/** Renvoie les informations sur une personne sous forme d'une chaîne de caractères dans l'ordre
	 *  Nom Prenom
	 *   numéro de téléphone
	 *   adresse email
	 */
	public String informations() {
		return super.toString()  + "\n"  + email + "\n" + telephone.getNumero();
	}

	/** Afficher sur la console une chaîne de caractères */
	@Override
	public void afficher(){
		System.out.println(informations());
	}

	/**  vérifier la validité d'un email*/
	private boolean mailValide(){
		return REGEX_EMAIL.matcher(email).matches();
	}

	/** Saisir au clavier les 4 infos d'une personne afin de la modifier*/
	public void saisir() {
		boolean correct = false;
		super.saisir();
		telephone.saisir();
		do {
			System.out.print("Email ? ");
			email = entrees.nextLine();
			correct = mailValide();
			if (!correct) {
				System.out.println("Email invalide. Recommencez ! ");
			}
		} while (!correct);
	}
}