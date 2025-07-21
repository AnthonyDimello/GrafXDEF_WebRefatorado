package service;

import dao.UsuarioDAO;
import model.Usuario;

import java.sql.SQLException;
import java.util.List;

public class UsuarioService {

    private UsuarioDAO usuarioDAO;

    public UsuarioService() throws SQLException {
        this.usuarioDAO = new UsuarioDAO();
    }

    // Método para verificar se login já existe
    public boolean loginExiste(String login) {
        return usuarioDAO.loginExiste(login);
    }

    // Método para cadastrar usuário com verificação de duplicidade
    public void cadastrarUsuario(Usuario usuario) throws Exception {
        if (usuario.getLogin() == null || usuario.getLogin().isEmpty()) {
            throw new IllegalArgumentException("Login não pode ser vazio");
        }
        if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
            throw new IllegalArgumentException("Senha não pode ser vazia");
        }
        if (loginExiste(usuario.getLogin())) {
            throw new Exception("Login já cadastrado: " + usuario.getLogin());
        }
        usuarioDAO.inserir(usuario);
    }

    // Método para autenticar usuário
    public Usuario autenticar(String login, String senha) {
        return usuarioDAO.autenticar(login, senha);
    }

    // Método para listar todos os usuários
    public List<Usuario> listarUsuarios() {
        return usuarioDAO.listarTodos();
    }

    // Método para excluir usuário pelo login (opcional)
    public void excluirUsuario(String login) throws SQLException {
        usuarioDAO.excluir(login);
    }
}



