package org.proxybanque.model;

/**
 * *
 * 
 * @author O.AVCI  E.SAVARY
 * 
 *         La classe Client hérite de la classe personne. Le client possède
 *         l'attribut supplémentaire idConseiller ainsi que les méthodes get et set qui lui sont spécifique.
 *
 */

public class Client extends Personne {

	private int idConseiller;

	// Constructeur

	public Client(String nom, String prenom, String login, String password, String adresse, String codePostal,
			String telephone, String email, String ville, int idConseiller) {
		super(nom, prenom, login, password, adresse, codePostal, telephone, email, ville);
		this.setIdConseiller(idConseiller);
	}

	
	
	public int getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

}
