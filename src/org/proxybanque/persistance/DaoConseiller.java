package org.proxybanque.persistance;

/**
 * *
 * @author O.AVCI & E.SAVARY
 * 
 * 		L'interface DaoConseiller regroupe toutes les m�thodes qui seront utilis�s par le programme sur les objets Conseiller.
 * 		Ces m�thodes sont getClientLogin et getConseillerPassword. Elle sont red�finies dans la classe DaoConseillerImp.
 *  			
 */

public interface DaoConseiller {

	public String getConseillerLogin(String conseillerLogin);
	public String getConseillerPassword(String conseillerPassword);

}
