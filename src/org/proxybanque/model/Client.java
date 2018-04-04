package org.proxybanque.model;

/**
 * *
 * 
 * @author O.AVCI  E.SAVARY
 * 
 *         La classe Client h�rite de la classe personne. Le client poss�de
 *         l'attribut suppl�mentaire idConseiller ainsi que les m�thodes get et set qui lui sont sp�cifique.
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
