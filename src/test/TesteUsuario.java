
import service.UsuarioService;

import java.util.List;
import model.Usuario;

public class TesteUsuario {
    public static void main(String[] args) {

        try {
            UsuarioService usuarioService = new UsuarioService();

            // 1. Teste de cadastro de novo usuário
            Usuario novoUsuario = new Usuario("admin1", "senha123", "Administrador");

            try {
                usuarioService.cadastrarUsuario(novoUsuario);
                System.out.println("Usuário cadastrado com sucesso!");
            } catch (Exception e) {
                System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
            }

            // 2. Teste de autenticação
            Usuario autenticado = usuarioService.autenticar("admin1", "senha123");
            if (autenticado != null) {
                System.out.println("Autenticação bem-sucedida: " + autenticado.getLogin());
            } else {
                System.err.println("Falha na autenticação.");
            }

            // 3. Teste de listagem
            List<Usuario> usuarios = usuarioService.listarUsuarios();
            System.out.println("Lista de usuários:");
            for (Usuario u : usuarios) {
                System.out.println(" - " + u);
            }

            // 4. Teste de exclusão
            try {
                usuarioService.excluirUsuario("admin1");
                System.out.println("Usuário excluído com sucesso.");
            } catch (Exception e) {
                System.err.println("Erro ao excluir usuário: " + e.getMessage());
            }

        } catch (Exception e) {
            System.err.println("Erro geral nos testes: " + e.getMessage());
        }
    }
}


