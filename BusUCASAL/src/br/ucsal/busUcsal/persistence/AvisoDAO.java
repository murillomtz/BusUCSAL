package br.ucsal.busUcsal.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.busUcsal.model.Aviso;

public class AvisoDAO {

	// C�digos em SQL
	private static final String SQL_ADD_AVISO = "INSERT INTO Aviso (nome, descricao) VALUES (?,?);";
	private static final String SQL_REMOVER_AVISO = "DELETE FROM aviso WHERE idAviso=?;";
	private static final String SQL_BUSCAR_TODOS_AVISOS = "SELECT * FROM AVISO;";

	// Adiciona o aviso no HSQLDB
	public static void adicionaAviso(Aviso aviso) {
		Connection connection = BusUcsalConnection.getConnection();
		// prepared statement para inser��o
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(SQL_ADD_AVISO);

			// seta os valores

			stmt.setString(1, aviso.getNome());
			stmt.setString(2, aviso.getDescricao());

			// executa
			stmt.execute();
			stmt.close();
			BusUcsalConnection.closeConnection();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Remove o aviso atrav�s do seu id do HSQLDB
	public static void removerAviso(Integer id) {
		Connection connection = BusUcsalConnection.getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement(SQL_REMOVER_AVISO);
			// seta os valores
			stmt.setInt(1, id);
			// executa
			stmt.execute();
			// fecha conex�es
			stmt.close();
			BusUcsalConnection.closeConnection();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Busca todos os avisos no HSQLDB
	public static List<Aviso> buscarTodosAvisos() {

		// Cria o List do tipo Aviso
		List<Aviso> avisos = new ArrayList<>();

		// Estabelece conex�o com o BD
		Connection connection = BusUcsalConnection.getConnection();
		try {

			// Cria um Statement
			PreparedStatement statement = connection.prepareStatement(SQL_BUSCAR_TODOS_AVISOS);

			// Cria um ResultSet e armazena a execu��o do statement
			ResultSet resultSet = statement.executeQuery();

			// Estrutura de repeti��o enquanto houver dados no resultSet
			while (resultSet.next()) {

				// Cria um Objeto do tipo Aviso e atribui os dados do BD
				Aviso aviso = new Aviso(resultSet.getInt("idaviso"), resultSet.getString("nome"),
						resultSet.getString("descricao"));

				// Adiciona na List o aviso
				avisos.add(aviso);

			}

			// Fecha conex�es
			statement.close();
			resultSet.close();
			BusUcsalConnection.closeConnection();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return avisos;
	}
}
