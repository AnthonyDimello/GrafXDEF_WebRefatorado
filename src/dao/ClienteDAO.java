package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelas operações de persistência relacionadas à entidade Cliente.
 * Utiliza JDBC para interagir com o banco de dados.
 */
public class ClienteDAO {

    /**
     * Verifica se um CPF já está cadastrado no banco.
     */
    public boolean cpfExiste(String cpf) {
        String sql = "SELECT * FROM cliente WHERE cpf = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            System.out.println("Erro ao verificar CPF: " + e.getMessage());
            return false;
        }
    }

    /**
     * Cadastra um novo cliente no banco de dados.
     */
    public boolean cadastrarCliente(Cliente cliente) {
        if (cpfExiste(cliente.getCpf())) {
            System.out.println("CPF já cadastrado: " + cliente.getCpf());
            return false;
        }

        String sql = "INSERT INTO cliente (nome, telefone, cpf, email, endereco) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getEndereco());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
            return false;
        }
    }

    /**
     * Retorna a lista de todos os clientes cadastrados.
     */
    public List<Cliente> buscarTodos() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                c.setCpf(rs.getString("cpf"));
                c.setEmail(rs.getString("email"));
                c.setEndereco(rs.getString("endereco"));
                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar clientes: " + e.getMessage());
        }
        return lista;
    }

    /**
     * Exclui um cliente pelo ID.
     */
    public boolean excluirCliente(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao excluir cliente: " + e.getMessage());
            return false;
        }
    }

   /**
 * Atualiza os dados de um cliente existente no banco.
 */
public boolean salvar(Cliente cliente) {
    String sql = "UPDATE cliente SET nome = ?, telefone = ?, cpf = ?, email = ?, endereco = ? WHERE id = ?";

    try (Connection conn = Conexao.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getTelefone());
        stmt.setString(3, cliente.getCpf());
        stmt.setString(4, cliente.getEmail());
        stmt.setString(5, cliente.getEndereco());
        stmt.setInt(6, cliente.getId());

        int linhasAfetadas = stmt.executeUpdate();
        return linhasAfetadas > 0;

    } catch (SQLException e) {
        System.out.println("Erro ao atualizar cliente: " + e.getMessage());
        return false;
    }
}
}


