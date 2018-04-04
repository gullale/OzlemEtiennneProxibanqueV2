package org.proxybanque.persistance;

/**
 * *
 * @author O.AVCI & E.SAVARY
 * 
 * 		La classe  DaoConseillerImp reprend les m�thodes de l'interface DaoConseiller.
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
	 * 		La m�thode getConseiller permet l'affichage de l'Id du conseiller � partir du login.
	 * 		Cette m�thode a uniquement �t� utilis�e dans la classe MainTest pour v�rifier la liaison
	 * 		entre la base de donn�es et l'application JAVA.
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

			// Cr�ation de la requ�te
			String sql = "SELECT id FROM conseiller where login=?";

			// Compilation du preparedStatement
			pstmt = cnx.prepareStatement(sql);

			// Completion de la requ�te
			pstmt.setString(1, conseillerLogin);

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

	@Override
	public String getConseillerPassword(String conseillerPassword) {

		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;

		try {
			// Ouvrir la connexion
			cnx = openConnection();

			// Cr�ation de la requ�te
			String sql = "SELECT password FROM conseiller where password=?";

			// Compilation du preparedStatement
			pstmt = cnx.prepareStatement(sql);

			// Completion de la requ�te
			pstmt.setString(1, conseillerPassword);

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

}
