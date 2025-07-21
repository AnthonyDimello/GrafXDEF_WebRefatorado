package test;

import model.Cliente;
import service.ClienteService;

/**
 * Classe de teste para cadastro de cliente.
 */
public class TesteCliente {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(0, "João da Silva", "11988887777", "12345678900", "joao@gmail.com", "Rua Exemplo, 123");
        ClienteService service = new ClienteService();

        try {
            service.cadastrarCliente(cliente);
            System.out.println("Cliente cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }
}

