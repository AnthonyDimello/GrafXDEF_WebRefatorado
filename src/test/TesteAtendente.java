package test;

import model.Atendente;
import service.AtendenteService;

import java.sql.SQLException;
import java.util.List;

public class TesteAtendente {

    public static void main(String[] args) {
        try {
            AtendenteService service = new AtendenteService();

            // Testar cadastro
            Atendente atendente = new Atendente();
            atendente.setNome("João da Silva");
            atendente.setTelefone("11999998888");
            atendente.setCpf("12345678903");
            atendente.setSenha("senha123");

            try {
                service.cadastrarAtendente(atendente);
                System.out.println("Atendente cadastrado com sucesso!");
            } catch (Exception e) {
                System.err.println("Erro ao cadastrar atendente: " + e.getMessage());
            }

            // Testar listagem
            List<Atendente> lista = service.listarAtendentes();
            System.out.println("Lista de atendentes:");
            for (Atendente a : lista) {
                System.out.println("ID: " + a.getId() + " | Nome: " + a.getNome() +
                                   " | CPF: " + a.getCpf() + " | Telefone: " + a.getTelefone());
            }

            // Opcional: testar exclusão 
            /*
            if (!lista.isEmpty()) {
                int idParaExcluir = lista.get(0).getId();
                service.excluirAtendente(idParaExcluir);
                System.out.println("Atendente com ID " + idParaExcluir + " excluído.");
            }
            */

        } catch (SQLException e) {
            System.err.println("Erro ao iniciar serviço de atendente: " + e.getMessage());
        }
    }
}


