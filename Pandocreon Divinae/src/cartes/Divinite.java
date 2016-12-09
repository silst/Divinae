/**
 * 
 */
package cartes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;

import org.omg.CORBA.INTERNAL;

import dogme.Dogme;
import effets.Capacite;
import origine.LibelleOrigine;
import origine.Origine;

/**
 * @author Lallement
 *
 */
public class Divinite extends Carte {
	
	/* ---------- Attributs ---------- */
	/**
	 * Nom de la divinit�
	 */
	private String nomDivinite;
	
	/**
	 * Tableau contenant les trois dogmes d'une divinit�
	 */
	private Dogme[] dogmesDivinite;
	
	/**
	 * Disponibilite de la capacite de la divinite
	 */
	private boolean capaciteDispo = true;
	
	/**
	 * Capacite unique de la divinit�
	 */
	private Capacite capaciteDivinite;
	
	/**
	 * Nombre total de prieres rassembl�es par la divinit�.
	 */
	private int totalPrieres = 0;
	
	
	/* ---------- Constructeurs ---------- */
	/**
	 * On supprime le constructeur publique par d�faut
	 * afin d'�viter la cr�ation d'objets sans informations permettant leur identification   
	 */
	private Divinite() {
		super();
	}
	
	/**
	 * Constructeur avec arguments
	 * @param {String} nom : nom de la divinit� nouvellement cr��e
	 * @param {Origine} origine : origine de la divinit�
	 */
	public Divinite(String nom, Origine origine) {
		super(origine);
		this.nomDivinite = nom;
	}
	
	/**
	 * Constructeur avec arguments
	 * @param {String} nom : nom � attribuer � la divinite
	 * @param {Origine} origine : Origine de la divinit� nouvellement cr��e
	 * @param {Capacite} capacite : Capacite unique � attribuer � la Divinite
	 * @param {Dogme[]} dogmes : tableau de dogmes � attribuer � la divinite
	 */
	public Divinite(String nom, Origine origine, Capacite capacite, Dogme[] dogmes) {
		super(origine);
		this.nomDivinite = nom;
		this.capaciteDivinite = capacite;
		this.dogmesDivinite = dogmes;
	}
	

	/* ---------- Getters & Setters ---------- */
	/**
	 * Accesseur pour l'attribut nomDivinite
	 * @return {String} nomDivinite : retourne le nom de la divinit�
	 */
	public String getNomDivinite() {
		return this.nomDivinite;
	}

	/**
	 * Modificateur pour l'attribut nomDivinite
	 * @param {String} nom : nouveau nom � attribuer � la divinite   
	 */
	public void setNomDivinite(String nom) {
		this.nomDivinite = nom;
	}

	/**
	 * Accesseur pour l'attribut dogmesDivinite
	 * @return {Dogme[]} dogmesDivinite : tableau des dogmes de la divinit�
	 */
	public Dogme[] getDogmesDivinite() {
		return this.dogmesDivinite;
	}

	/**
	 * Modificateur pour l'attribut dogmesDivinite
	 * @param {Dogme[]} dogmes : tableau de dogmes � attribuer � la divinit� 
	 */
	public void setDogmesDivinite(Dogme[] dogmes) {
		this.dogmesDivinite = dogmes;
	}

	/**
	 * Accesseur pour l'attribut capaciteDispo
	 * @return {boolean} capaciteDispo : retourne la valeur de l'attribut capaciteDispo. True si la capacit� est disponible, false sinon
	 */
	public boolean isCapaciteDispo() {
		return this.capaciteDispo;
	}

	/**
	 * Modificateur pour l'attribut capaciteDispo
	 * Si la capacit� est disponible au temps tn-1, elle devient indisponible au temps tn
	 * Si la capacit� est indisponible au temps tn-1, elle devient disponible au temps tn
	 */
	public void setCapaciteDispo() {
		this.capaciteDispo = (this.capaciteDispo) ? false : true;
	}

	/**
	 * Accesseur pour l'attribut capaciteDivinite
	 * @return {Capacite} capaciteDivinite : retourne la capacite unique de la divinite
	 */
	public Capacite getCapaciteDivinite() {
		return this.capaciteDivinite;
	}

	/**
	 * Modificateur pour l'attribut capaciteDivinite
	 * @param {Capacite} capacite : capacit� � attribuer � la divinit�
	 */
	public void setCapaciteDivinite(Capacite capacite) {
		this.capaciteDivinite = capacite;
	}

	/**
	 * Accesseur pour l'attribut totalPrieres
	 * @return {int} totalPrieres : retourne le nombre de pri�res obtenues par la divinit�
	 */
	public int getTotalPrieres() {
		return this.totalPrieres;
	}

	/**
	 * Modificateur pour l'attribut capaciteDivinite
	 * @param {int} prieres : nombre de pri�re � attribuer � la divinit�
	 */
	public void setTotalPrieres(int nbPrieres) {
		this.totalPrieres = nbPrieres;
	}
	
	
	/* ---------- M�thodes ---------- */
	/**
	 * M�thode retournant toutes les divinites
	 * @return {ArrayList<Divinite>} divinites : retourne un ArrayList contenant toutes les divinites
	 */
	public static ArrayList<Carte> getAll() {
		ArrayList<Carte> divinites = new ArrayList<Carte>();
		// TODO Utilisation d'un FileReader
		BufferedReader file;
		try {
			file = new BufferedReader(new FileReader("divinites.txt"));
			
			try {
				String nom;
				String libOrigine;
				Origine origine;				
				
				while(file.ready()) {
					
					for (int i = 0; i < 1; i++) {
						String ligne = file.readLine();
						int separateur = ligne.indexOf(' ');
						libOrigine = ligne.substring(separateur + 1 , ligne.lastIndexOf(' '));
						System.out.println(libOrigine);
						
						nom = ligne.substring(0, separateur);
						
						
						switch (libOrigine) {
						case "JOUR":
							origine = new Origine(LibelleOrigine.JOUR);
							break;

						case "NUIT":
							origine = new Origine(LibelleOrigine.NUIT);
							break;
							
						case "NEANT":
							origine = new Origine(LibelleOrigine.NEANT);
							break;
						
						case "AUBE":
							origine = new Origine(LibelleOrigine.AUBE);
							break;
							
						case "CREPUSCULE":
							origine = new Origine(LibelleOrigine.CREPUSCULE);
							break;
						default :
							origine = null;
							break;
						}
						
						Divinite d = new Divinite(nom, origine);
						divinites.add(d);
					}
				}
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		return divinites;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Divinite.getAll();
	}

}
