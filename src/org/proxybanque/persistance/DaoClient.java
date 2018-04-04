package org.proxybanque.persistance;

/**
 * *
 * @author O.AVCI & E.SAVARY
 * 
 * 		L'interface DaoClient regroupe toutes les m�thodes qui seront utilis�s par le conseiller sur les objets clients.
 * 		Ces m�thodes sont getClientInfos, saveClient, updateClient, et DeleteClient. Elle sont red�finies dans la classe DaoClientImp.
 *  
 *  			
 */

import org.proxybanque.model.Client;

public interface DaoClient {

	public String getClientInfos(int clientId);

	public void saveClient(Client clientAInserer);

	public void updateClient(Client clientAUpdater);

	public void deleteClient(int id);

}
