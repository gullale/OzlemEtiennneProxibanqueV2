package org.proxybanque.model;

public class Conseiller extends Personne {

	/**
	 * *
	 * @author O.AVCI  E.SAVARY
	 * 
	 * 			La classe Conseiller hérite de la classe Personne.
	 * 			  			
	 */
	
	
	
	// Constructeur

	public Conseiller(String nom, String prenom, String login, String password, String adresse, String codePostal,
			String telephone, String email, String ville) {
		super(nom, prenom, login, password, adresse, codePostal, telephone, email, ville);
		// TODO Auto-generated constructor stub
		
		}

	public Conseiller() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Conseiller(String login, String password) {
		super(login, password);
		// TODO Auto-generated constructor stub
	}
	
	
		
}

