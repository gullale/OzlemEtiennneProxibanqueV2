package org.proxybanque.model;

/**
 * *
 * @author O.AVCI  E.SAVARY
 * 
 * 			La classe Compte courant h�rite de la classe compte.
 * 			Elle a en plus le param�tre d�couvert autoris�.
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
