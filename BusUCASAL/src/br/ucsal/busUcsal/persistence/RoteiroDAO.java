package br.ucsal.busUcsal.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.busUcsal.model.Roteiro;

public class RoteiroDAO {

	// Códigos em SQL
	private static final String SQL_ADD_ROTEIRO = "INSERT INTO roteiro (hora, descricao, nomeRoteiro) VALUES (?,?,?);";
	private static final String SQL_REMOVER_ROTEIRO = "DELETE FROM roteiro WHERE idRoteiro=?;";
	private static final String SQL_UPDATE_ROTEIRO = "UPDATE roteiro SET nomeroteiro=?, hora=?, descricao=? where idroteiro=?;";
	private static final String SQL_BUSCAR_TODOS_ROTEIROS = "SELECT * FROM ROTEIRO;";

	// Adiciona o roteiro no HSQLDB
	public static void adicionarRoteiro(Roteiro roteiro) {
		// Pega a coneção do banco de dados
		Connection connection = BusUcsalConnection.getConnection();
		// prepared statement para inserção
		try {
			PreparedStatement stmt = connection.prepareStatement(SQL_ADD_ROTEIRO);

			// seta os valores

			stmt.setString(1, roteiro.getHora());
			stmt.setString(2, roteiro.getDescricao());
			stmt.setString(3, roteiro.getNomeRoteiro());

			// executa
			stmt.execute();
			// fecha conexões
			stmt.close();
			BusUcsalConnection.closeConnection();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Remove o roteiro através do seu id do HSQLDB
	public static void removerRoteiro(Integer id) {

		Connection connection = BusUcsalConnection.getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement(SQL_REMOVER_ROTEIRO);
			// seta os valores
			stmt.setInt(1, id);
			// executa
			stmt.execute();
			// fecha conexões
			stmt.close();
			BusUcsalConnection.closeConnection();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<Roteiro> buscarTodosRoteiros() {

		// Cria o List do tipo Aviso
		List<Roteiro> roteiros = new ArrayList<>();

		// Estabelece conexão com o BD
		Connection connection = BusUcsalConnection.getConnection();
		try {

			// Cria um Statement
			PreparedStatement statement = connection.prepareStatement(SQL_BUSCAR_TODOS_ROTEIROS);

			// Cria um ResultSet e armazena a execução do statement
			ResultSet resultSet = statement.executeQuery();

			// Estrutura de repetição enquanto houver dados no resultSet
			while (resultSet.next()) {

				// Cria um Objeto do tipo Aviso e atribui os dados do BD
				Roteiro roteiro = new Roteiro(resultSet.getInt("idRoteiro"), resultSet.getString("hora"),
						resultSet.getString("descricao"), resultSet.getString("nomeRoteiro"));

				// Adiciona na List o aviso
				roteiros.add(roteiro);

			}

			// Fecha conexões
			statement.close();
			resultSet.close();
			BusUcsalConnection.closeConnection();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return roteiros;
	}

	public static void updateRoteiro(Integer id,String nome, String hora, String descricao) {
		Connection connection = BusUcsalConnection.getConnection();

		try {
			PreparedStatement stmt = connection.prepareStatement(SQL_UPDATE_ROTEIRO);

			// seta os valores

			stmt.setString(1, nome);
			stmt.setString(2, hora);
			stmt.setString(3, descricao);
			stmt.setInt(4, id);

			stmt.executeUpdate();

			stmt.close();
			BusUcsalConnection.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
