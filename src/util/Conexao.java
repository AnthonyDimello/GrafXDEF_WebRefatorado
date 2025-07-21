package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe utilitária para obter conexão com o banco de dados.
 */
public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/grafx3";
    private static final String USUARIO = "root";
    private static final String SENHA = "121424@nthonY"; // substitua se necessário

    public static Connection getConexao() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}

