package br.ucsal.busUcsal.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BusUcsalConnection {

	// Atributos para conexão
	private static final String DRIVER_CLASS = "org.hsqldb.jdbcDriver";
	// Nome do usuario no PC
	private static final String SEU_USUARIO_NO_PC = "natal";
	private static final String URL = "jdbc:hsqldb:file:C:\\Users\\" + SEU_USUARIO_NO_PC + "\\git\\BusUCSAL\\base\\BusuUcsa.db";
	private static final String USUARIO = "SA";
	private static final String SENHA = "";
	private static Connection connection;

	// Estabelece conexão com HSQLDB
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER_CLASS);

			connection = DriverManager.getConnection(URL, USUARIO, SENHA);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	// Fecha conexão com HSQLDB
	public static void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
