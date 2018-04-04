package org.proxybanque.persistance;

/**
 * *
 * @author O.AVCI & E.SAVARY
 * 
 * 		La classe DaoClientImp permet d'impl�menter l'interface DaoClient.
 *  	Chaque m�thode de cette interface  sont red�finies.
 *  	Elles commencent toujours par appeler la m�thode openConnexion pour se connecter � la Base de donn�es,
 *  	et se terminent toujours par la m�thode closeConnexion.
 *  			
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.proxybanque.model.Client;
import org.proxybanque.model.Conseiller;

public class DaoClientImp extends Jdbc implements DaoClient {

	// M�thode Get Client
	@Override
	public String getClientInfos(int clientId) {

		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;

		try {
			// Ouvrir la connexion
			cnx = openConnection();

			// Cr�ation de la requ�te
			String sql = "SELECT nom FROM conseiller where clientId=?";

			// Compilation du preparedStatement
			pstmt = cnx.prepareStatement(sql);

			// Completion de la requ�te
			pstmt.setInt(1, clientId);

			// Ex�cuter et r�cup�rer le r�sultat de la requ�te

			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = rs.getString(1);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(cnx, pstmt, rs);

			System.out.println("--> Disconnection... <--");
		}

		return result;
	}

	// M�thode Insert Client

	@Override
	public void saveClient(Client clientAInserer) {

		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// Ouvrir la connexion
			cnx = openConnection();

			// Cr�ation de la requ�te
			String sql = "insert into client( nom, prenom, login, password, adresse, codePostal, ville, telephone, email, conseillerId)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			// Compilation du preparedStatement
			pstmt = cnx.prepareStatement(sql);

			// Completion de la requ�te
			//pstmt.setInt(1, clientAInserer.getId());
			pstmt.setString(1, clientAInserer.getNom());
			pstmt.setString(2, clientAInserer.getPrenom());
			pstmt.setString(3, clientAInserer.getLogin());
			pstmt.setString(4, clientAInserer.getPassword());
			pstmt.setString(5, clientAInserer.getAdresse());
			pstmt.setString(6, clientAInserer.getCodePostal());
			pstmt.setString(7, clientAInserer.getVille());
			pstmt.setString(8, clientAInserer.getTelephone());
			pstmt.setString(9, clientAInserer.getEmail());

			// TO DO : m�thode get conseiller dans services.
			pstmt.setInt(10, 1);

			// Ex�cuter et r�cup�rer le r�sultat de la requ�te

			int i = pstmt.executeUpdate();

			System.out.println(i + "client(s) ont �t� ajout� � la base de donn�es bddozlemetienneproxibanquemysql");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(cnx, pstmt, rs);

			System.out.println("--> Disconnection... <--");
		}

	}
	// M�thode Update Client

	@Override
	public void updateClient(Client clientAUpdater) {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// Ouvrir la connexion
			cnx = openConnection();

			// Cr�ation de la requ�te
			String sql = "update client" + " set nom=? where client.clientId=?";

			// Compilation du preparedStatement
			pstmt = cnx.prepareStatement(sql);

			// Completion de la requ�te
			pstmt.setString(1, clientAUpdater.getNom());
			pstmt.setInt(2, clientAUpdater.getId());

			// Ex�cuter et r�cup�rer le r�sultat de la requ�te

			int i = pstmt.executeUpdate();

			System.out.println("j'ai mis � jour" + i + "ligne(s)");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(cnx, pstmt, rs);

			System.out.println("--> Disconnection... <--");
		}

	}

	// M�thode Delete Client
	@Override
	public void deleteClient(int id) {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// Ouvrir la connexion
			cnx = openConnection();

			// Cr�ation de la requ�te
			String sql = "delete from client" + "where client.clientId=?";

			// Compilation du preparedStatement
			pstmt = cnx.prepareStatement(sql);

			// Completion de la requ�te
			pstmt.setInt(1, id);

			// Ex�cuter et r�cup�rer le r�sultat de la requ�te

			int i = pstmt.executeUpdate();

			System.out.println("j'ai effac�" + i + "ligne(s)");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(cnx, pstmt, rs);

			System.out.println("--> Disconnection... <--");
		}

	}

	// @Override
	// public void insertClient(Client clientAInserer) {
	// // TODO Auto-generated method stub
	// Conseiller cons = clientAInserer.getConseiller();
	// try {
	// // Ouvrir la connexion
	// cnx = openConnection();
	//
	// // Cr�ation de la requ�te
	// String sql = "SELECT prenom FROM conseiller where conseillerId=?";
	//
	// // Compilation du preparedStatement
	// pstmt = cnx.prepareStatement(sql);
	//
	// // Completion de la requ�te
	// pstmt.setInt(1, clientAInserer.g);
	//
	// // Ex�cuter et r�cup�rer le r�sultat de la requ�te
	//
	// rs = pstmt.executeQuery();
	// while (rs.next()) {
	// result = rs.getString(1);
	// }
	// } catch (ClassNotFoundException | SQLException e) {
	// e.printStackTrace();
	// } finally {
	// closeConnection(cnx, pstmt, rs);
	//
	// System.out.println("--> Disconnection... <--");
	// }
	//
	// return result;
	// }
	//
	//
	// }

}
