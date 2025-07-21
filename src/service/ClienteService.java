package service;

import dao.ClienteDAO;
import model.Cliente;

/**
 * Classe de serviço para validação e regras de negócio relacionadas ao Cliente.
 */
public class ClienteService {

    private ClienteDAO clienteDAO = new ClienteDAO();

    public void cadastrarCliente(Cliente cliente) throws Exception {
        if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            throw new Exception("Nome do cliente não pode ser vazio.");
        }
        if (cliente.getCpf() == null || cliente.getCpf().length() != 11) {
            throw new Exception("CPF deve conter 11 dígitos.");
        }
        if (cliente.getTelefone() == null || cliente.getTelefone().isEmpty()) {
            throw new Exception("Telefone é obrigatório.");
        }

        clienteDAO.salvar(cliente);
    }
}

