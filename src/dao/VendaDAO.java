package dao;

import model.Venda;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

/**
 * DAO responsável por operações de banco de dados com a entidade Venda.
 */
public class VendaDAO {

    public void salvar(Venda venda) throws SQLException {
    String sql = "INSERT INTO venda (descricao_produto, nome_cliente, cpf_cliente, data_venda, quantidade, forma_pagamento, valor_unitario, valor_total, nome_atendente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = Conexao.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, venda.getDescricaoProduto());
        stmt.setString(2, venda.getNomeCliente());
        stmt.setString(3, venda.getCpfCliente());
        stmt.setDate(4, new Date(venda.getDataVenda().getTime()));
        stmt.setInt(5, venda.getQuantidade());
        stmt.setString(6, venda.getFormaPagamento());
        stmt.setDouble(7, venda.getValorUnitario());
        stmt.setDouble(8, venda.getValorTotal());
        stmt.setString(9, venda.getNomeAtendente());

        stmt.executeUpdate();
    }
}
}
