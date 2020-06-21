package br.ucsal.busUcsal.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ucsal.busUcsal.model.Usuario;

public class UsuarioDAO {

	// Códigos em SQL
	private static final String SQL_BUSCAR_USUARIO = "SELECT * FROM USUARIO WHERE matricula=? AND SENHA=?;";

	// Autentifica o usuário
	public static Usuario autenticate(Integer matricula, String senha) {

		//Estabelece conexão com o BD
		Connection connection = BusUcsalConnection.getConnection();
		try {

			// Cria um Statement
			PreparedStatement statement = connection.prepareStatement(SQL_BUSCAR_USUARIO);

			// Seta valores no Statement
			statement.setInt(1, matricula);
			statement.setString(2, senha);

			// Cria um ResultSet e armazena a execução do statement
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				
				Usuario usuario = new Usuario(resultSet.getString("nome"), resultSet.getInt("matricula"), resultSet.getString("senha"), resultSet.getString("email"));
				
				// Fecha conexões
				statement.close();
				resultSet.close();
				BusUcsalConnection.closeConnection();
				
				// Instancia o Usuario
				return usuario;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}



}
