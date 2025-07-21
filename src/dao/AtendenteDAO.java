package dao;

import model.Atendente;
import util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AtendenteDAO {

    // Verifica se CPF já existe
    public boolean cpfExiste(String cpf) {
        String sql = "SELECT 1 FROM atendentes WHERE cpf = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.err.println("Erro ao verificar CPF: " + e.getMessage());
            return false;
        }
    }

    // Insere um novo atendente
    public void inserir(Atendente atendente) throws SQLException {
        String sql = "INSERT INTO atendentes (nome, telefone, cpf, senha) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, atendente.getNome());
            stmt.setString(2, atendente.getTelefone());
            stmt.setString(3, atendente.getCpf());
            stmt.setString(4, atendente.getSenha());
            stmt.executeUpdate();
        }
    }

    // Lista todos os atendentes
    public List<Atendente> listarTodos() {
        List<Atendente> lista = new ArrayList<>();
        String sql = "SELECT * FROM atendentes";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Atendente a = new Atendente();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setTelefone(rs.getString("telefone"));
                a.setCpf(rs.getString("cpf"));
                a.setSenha(rs.getString("senha"));
                lista.add(a);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar atendentes: " + e.getMessage());
        }
        return lista;
    }

    // Exclui atendente pelo ID
    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM atendentes WHERE id = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}


