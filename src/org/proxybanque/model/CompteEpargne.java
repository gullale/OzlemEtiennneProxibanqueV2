package org.proxybanque.model;

/**
 * *
 * @author O.AVCI  E.SAVARY
 * 
 * 			La classe Compte Epargne hérite de la classe compte.
 * 			Elle a en plus le paramètre taux de rémunération.
 *  			
 */

public class CompteEpargne extends Compte {

	double tauxDeRemuneration;

	// Constructeur

	public CompteEpargne(int numero, String dateOuverture, double solde) {
		super(numero, dateOuverture, solde);
		// TODO Auto-generated constructor stub
	}

	// Getter and Setter
	public double getTauxDeRemuneration() {
		return tauxDeRemuneration;
	}

	public void setTauxDeRemuneration(double tauxDeRemuneration) {
		this.tauxDeRemuneration = tauxDeRemuneration;
	}

}
