package test;

import model.Produto;
import service.ProdutoService;

/**
 * Classe de teste para validar o cadastro de produtos.
 */
public class TesteProduto {
    public static void main(String[] args) {
        Produto produto = new Produto(0, "Caneta Azul", 50, 1.99);
        ProdutoService service = new ProdutoService();

        try {
            service.cadastrarProduto(produto);
            System.out.println("Produto cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar produto: " + e.getMessage());
        }
    }
}

