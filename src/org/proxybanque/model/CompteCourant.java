package org.proxybanque.model;

/**
 * *
 * @author O.AVCI  E.SAVARY
 * 
 * 			La classe Compte courant hérite de la classe compte.
 * 			Elle a en plus le paramètre découvert autorisé.
 *  			
 */

public class CompteCourant extends Compte {

	double decouvertAutorise;

	// Constructeur

	public CompteCourant(int numero, String dateOuverture, double solde) {
		super(numero, dateOuverture, solde);
		// TODO Auto-generated constructor stub
	}

	public double getDecouvertAutorise() {
		return decouvertAutorise;
	}

	public void setDecouvertAutorise(double decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}
	
	// Getter and Setter
		
}
