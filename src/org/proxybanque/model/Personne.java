package org.proxybanque.model;

/**
 * *
 * @author O.AVCI  E.SAVARY
 * 
 * 			La classe Personne permet de créer des objets de type Personne qui seront spécifié Clients ou Conseillers.
 * 			Une personne a les attributs nom, prénom, login, password, adresse, codePostal, telephone, email, ville, id)
 *  		L'id sera auto généré par la Base de données. Il n'apparait donc pas dans le constucteur.
 *  
 *  		Cette classe possède aussi les méthodes Get et Set pour chacun de ses attributs.
 */

public class Personne {

	private String nom;
	private String prenom;
	private String login;
	private String password;
	private String adresse;
	private String codePostal;
	private String telephone;
	private String email;
	private String ville;
	private int id;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	// Constructeur

	public Personne(String nom, String prenom, String login, String password, String adresse, String codePostal,
			String telephone, String email, String ville) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.telephone = telephone;
		this.email = email;
		this.ville = ville;
		
	}

	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Personne(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
	
	
}
