package service;

import dao.ProdutoDAO;
import model.Produto;

/**
 * Classe de serviço responsável por aplicar regras de negócio ao Produto.
 */
public class ProdutoService {

    private ProdutoDAO produtoDAO = new ProdutoDAO();

    public void cadastrarProduto(Produto produto) throws Exception {
        if (produto.getDescricao() == null || produto.getDescricao().isEmpty()) {
            throw new Exception("Descrição do produto não pode ser vazia.");
        }
        if (produto.getQuantidade() < 0) {
            throw new Exception("Quantidade não pode ser negativa.");
        }
        if (produto.getValor() < 0) {
            throw new Exception("Valor não pode ser negativo.");
        }

        produtoDAO.salvar(produto);
    }
}

