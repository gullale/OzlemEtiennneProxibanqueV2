package org.proxybanque.persistance;

/**
 * *
 * @author O.AVCI & E.SAVARY
 * 
 * 		La classe DaoClientImp permet d'implémenter l'interface DaoClient.
 *  	Chaque méthode de cette interface  sont redéfinies.
 *  	Elles commencent toujours par appeler la méthode openConnexion pour se connecter à la Base de données,
 *  	et se terminent toujours par la méthode closeConnexion.
 *  			
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.proxybanque.model.Client;
import org.proxybanque.model.Conseiller;

public class DaoClientImp extends Jdbc implements DaoClient {

	// Méthode Get Client
	@Override
	public String getClientInfos(int clientId) {

		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;

		try {
			// Ouvrir la connexion
			cnx = openConnection();

			// Création de la requête
			String sql = "SELECT nom FROM conseiller where clientId=?";

			// Compilation du preparedStatement
			pstmt = cnx.prepareStatement(sql);

			// Completion de la requête
			pstmt.setInt(1, clientId);

			// Exécuter et récupérer le résultat de la requête

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

	// Méthode Insert Client

	@Override
	public void saveClient(Client clientAInserer) {

		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// Ouvrir la connexion
			cnx = openConnection();

			// Création de la requête
			String sql = "insert into client( nom, prenom, login, password, adresse, codePostal, ville, telephone, email, conseillerId)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			// Compilation du preparedStatement
			pstmt = cnx.prepareStatement(sql);

			// Completion de la requête
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

			// TO DO : méthode get conseiller dans services.
			pstmt.setInt(10, 1);

			// Exécuter et récupérer le résultat de la requête

			int i = pstmt.executeUpdate();

			System.out.println(i + "client(s) ont été ajouté à la base de données bddozlemetienneproxibanquemysql");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(cnx, pstmt, rs);

			System.out.println("--> Disconnection... <--");
		}

	}
	// Méthode Update Client

	@Override
	public void updateClient(Client clientAUpdater) {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// Ouvrir la connexion
			cnx = openConnection();

			// Création de la requête
			String sql = "update client" + " set nom=? where client.clientId=?";

			// Compilation du preparedStatement
			pstmt = cnx.prepareStatement(sql);

			// Completion de la requête
			pstmt.setString(1, clientAUpdater.getNom());
			pstmt.setInt(2, clientAUpdater.getId());

			// Exécuter et récupérer le résultat de la requête

			int i = pstmt.executeUpdate();

			System.out.println("j'ai mis à jour" + i + "ligne(s)");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(cnx, pstmt, rs);

			System.out.println("--> Disconnection... <--");
		}

	}

	// Méthode Delete Client
	@Override
	public void deleteClient(int id) {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// Ouvrir la connexion
			cnx = openConnection();

			// Création de la requête
			String sql = "delete from client" + "where client.clientId=?";

			// Compilation du preparedStatement
			pstmt = cnx.prepareStatement(sql);

			// Completion de la requête
			pstmt.setInt(1, id);

			// Exécuter et récupérer le résultat de la requête

			int i = pstmt.executeUpdate();

			System.out.println("j'ai effacé" + i + "ligne(s)");

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
	// // Création de la requête
	// String sql = "SELECT prenom FROM conseiller where conseillerId=?";
	//
	// // Compilation du preparedStatement
	// pstmt = cnx.prepareStatement(sql);
	//
	// // Completion de la requête
	// pstmt.setInt(1, clientAInserer.g);
	//
	// // Exécuter et récupérer le résultat de la requête
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
