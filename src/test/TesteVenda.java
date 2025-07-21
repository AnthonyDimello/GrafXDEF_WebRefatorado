package test;

import model.Venda;
import service.VendaService;

import java.util.Date;

public class TesteVenda {
    public static void main(String[] args) {
        System.out.println("===== Testando Venda =====");

        // Criação de um objeto Venda com todos os campos necessários
        Venda venda = new Venda(
            0,
            "Mouse Gamer RGB",              // descricaoProduto
            "João da Silva",                // nomeCliente
            "12345678900",                  // cpfCliente
            new Date(),                     // dataVenda
            2,                              // quantidade
            "Cartão de Crédito",            // formaPagamento
            150.00,                         // valorUnitario
            150.0,                            // valorTotal (será calculado pelo serviço)
            "Ana Atendente"                 // nomeAtendente
        );

        VendaService service = new VendaService();

        try {
            service.cadastrarVenda(venda);
            System.out.println("Venda cadastrada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar venda: " + e.getMessage());
        }
    }
}

