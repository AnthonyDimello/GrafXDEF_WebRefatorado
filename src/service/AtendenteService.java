package service;

import dao.AtendenteDAO;
import model.Atendente;

import java.sql.SQLException;
import java.util.List;

public class AtendenteService {

    private AtendenteDAO atendenteDAO;

    public AtendenteService() throws SQLException {
        this.atendenteDAO = new AtendenteDAO();
    }

    // Método para verificar se CPF já existe
    public boolean cpfExiste(String cpf) {
        return atendenteDAO.cpfExiste(cpf);
    }

    // Método para cadastrar atendente com verificação de duplicidade
    public void cadastrarAtendente(Atendente atendente) throws Exception {
        if (atendente.getCpf() == null || atendente.getCpf().isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser vazio");
        }
        if (cpfExiste(atendente.getCpf())) {
            throw new Exception("CPF já cadastrado: " + atendente.getCpf());
        }
        atendenteDAO.inserir(atendente);
    }

    // Método para listar atendentes
    public List<Atendente> listarAtendentes() {
        return atendenteDAO.listarTodos();
    }

    // Método para excluir atendente pelo ID
    public void excluirAtendente(int id) throws SQLException {
        atendenteDAO.excluir(id);
    }
}


