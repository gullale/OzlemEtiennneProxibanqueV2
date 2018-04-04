package org.proxybanque.services;

/**
 * *
 * @author O.AVCI & E.SAVARY
 * 
 * 		Classe principale du package service o� sont d�finies les m�thodes de l'interface ServicePourConseiller.
 * 		Ces m�thodes ont pour vocation de r�pondre aux besoins de l'utilisateur et appellent les m�thodes du package persistance.
 *  			
 */

import org.proxybanque.model.Client;
import org.proxybanque.persistance.DaoClientImp;
import org.proxybanque.persistance.DaoConseillerImp;

public class OperationConseiller implements ServicePourConseiller {

	private DaoConseillerImp daoConseiller = new DaoConseillerImp();
	private DaoClientImp daoClient = new DaoClientImp();

	/// red�finition de la m�thode v�rification login & password

	@Override
	public boolean verificationLoginPassword(String login, String password) {

		String loginDao = daoConseiller.getConseillerLogin(login);
		String passwordDao = daoConseiller.getConseillerPassword(password);

		if (loginDao != null && loginDao.equals(login) && passwordDao != null && passwordDao.equals(password)) {

			return true;
		} else {
			return false;
		}

	}

	@Override
	public void insertClient(Client client) {

		daoClient.saveClient(client);

	}

	/// red�finition de la m�thode insertClient

}
