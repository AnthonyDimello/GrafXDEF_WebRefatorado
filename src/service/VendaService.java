package service;

import dao.VendaDAO;
import model.Venda;

/**
 * Contém regras de negócio relacionadas a vendas.
 */
public class VendaService {

    private VendaDAO vendaDAO = new VendaDAO();

    public void cadastrarVenda(Venda venda) throws Exception {
        if (venda.getDataVenda() == null) {
            throw new Exception("Data da venda não pode ser nula.");
        }
        if (venda.getValorTotal() <= 0) {
            throw new Exception("Valor total deve ser maior que zero.");
        }
        if (venda.getNomeCliente() == null || venda.getNomeCliente().trim().isEmpty()) {
            throw new Exception("Nome do cliente não pode ser vazio.");
        }
        if (venda.getCpfCliente() == null || venda.getCpfCliente().trim().isEmpty()) {
            throw new Exception("CPF do cliente não pode ser vazio.");
        }
        if (venda.getNomeAtendente() == null || venda.getNomeAtendente().trim().isEmpty()) {
            throw new Exception("Nome do atendente não pode ser vazio.");
        }
        if (venda.getDescricaoProduto() == null || venda.getDescricaoProduto().trim().isEmpty()) {
            throw new Exception("Descrição do produto não pode ser vazia.");
        }
        if (venda.getQuantidade() <= 0) {
            throw new Exception("Quantidade deve ser maior que zero.");
        }
        if (venda.getValorUnitario() <= 0) {
            throw new Exception("Valor unitário deve ser maior que zero.");
        }
        if (venda.getFormaPagamento() == null || venda.getFormaPagamento().trim().isEmpty()) {
            throw new Exception("Forma de pagamento não pode ser vazia.");
        }

        // Calcula o valor total se necessário (segurança extra)
        double valorCalculado = venda.getQuantidade() * venda.getValorUnitario();
        venda.setValorTotal(valorCalculado);

        vendaDAO.salvar(venda);
    }
}


