package org.proxybanque.services;

import org.proxybanque.model.Client;

public interface ServicePourConseiller {

	public boolean verificationLoginPassword(String login, String password);

	public void insertClient(Client client);

}
