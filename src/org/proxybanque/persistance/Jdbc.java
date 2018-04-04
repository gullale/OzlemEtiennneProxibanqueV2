package org.proxybanque.persistance;

/**
 * *
 * @author O.AVCI & E.SAVARY
 * 
 * 		Cette Classe abstraite contient le code de connexion � la Base de Donn�e.
 * 		Les param�tres de connexion sont enregistr�s et la m�thode openConnection est r�utilis�e par
 * 		chaque classe contenu dans le package DAO pour ouvrir et fermer les connexions avec la base de donn�es.
 *  	De m�me, la fermeture de cette connexion se fera par l'appel de la m�thode closeConnexion.		
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Jdbc {

	// param�tres pour acceder � bddozlemetienneproxibanquemysql.sql

	public static final String driver = "com.mysql.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/bddozlemetienneproxibanquemysql";
	public static final String login = "root";
	public static final String password = "";

	public static final Connection openConnection() throws ClassNotFoundException, SQLException {

		Connection connection = null;

		// Chargement du driver

		Class.forName(driver);

		// Cr�ation de la connexion

		connection = DriverManager.getConnection(url, login, password);

		System.out.println("--> Connection... <--");

		return connection;
	}

	public void closeConnection(Connection connection, PreparedStatement pstmt, ResultSet rs) {

		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
