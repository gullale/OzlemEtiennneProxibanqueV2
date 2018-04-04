package org.proxybanque.persistance;

/**
 * *
 * @author O.AVCI & E.SAVARY
 * 
 * 		L'interface DaoConseiller regroupe toutes les méthodes qui seront utilisés par le programme sur les objets Conseiller.
 * 		Ces méthodes sont getClientLogin et getConseillerPassword. Elle sont redéfinies dans la classe DaoConseillerImp.
 *  			
 */

public interface DaoConseiller {

	public String getConseillerLogin(String conseillerLogin);
	public String getConseillerPassword(String conseillerPassword);

}
