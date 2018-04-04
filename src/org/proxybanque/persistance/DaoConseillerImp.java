package org.proxybanque.persistance;

/**
 * *
 * @author O.AVCI & E.SAVARY
 * 
 * 		La classe  DaoConseillerImp reprend les méthodes de l'interface DaoConseiller.
 *  
 *  			
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoConseillerImp extends Jdbc implements DaoConseiller {

	/**
	 * *
	 * @author O.AVCI & E.SAVARY
	 * 
	 * 		La méthode getConseiller permet l'affichage de l'Id du conseiller à partir du login.
	 * 		Cette méthode a uniquement été utilisée dans la classe MainTest pour vérifier la liaison
	 * 		entre la base de données et l'application JAVA.
	 *  			
	 */	
	
	
	@Override
	public String getConseillerLogin(String conseillerLogin) {

		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;

		try {
			// Ouvrir la connexion
			cnx = openConnection();

			// Création de la requête
			String sql = "SELECT id FROM conseiller where login=?";

			// Compilation du preparedStatement
			pstmt = cnx.prepareStatement(sql);

			// Completion de la requête
			pstmt.setString(1, conseillerLogin);

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

	@Override
	public String getConseillerPassword(String conseillerPassword) {

		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;

		try {
			// Ouvrir la connexion
			cnx = openConnection();

			// Création de la requête
			String sql = "SELECT password FROM conseiller where password=?";

			// Compilation du preparedStatement
			pstmt = cnx.prepareStatement(sql);

			// Completion de la requête
			pstmt.setString(1, conseillerPassword);

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

}
