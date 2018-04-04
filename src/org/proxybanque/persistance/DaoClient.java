package org.proxybanque.persistance;

/**
 * *
 * @author O.AVCI & E.SAVARY
 * 
 * 		L'interface DaoClient regroupe toutes les méthodes qui seront utilisés par le conseiller sur les objets clients.
 * 		Ces méthodes sont getClientInfos, saveClient, updateClient, et DeleteClient. Elle sont redéfinies dans la classe DaoClientImp.
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
