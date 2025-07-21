package model;

import java.util.Date;

public class Venda {
    private int id;
    private String descricaoProduto;
    private String nomeCliente;
    private String cpfCliente;
    private Date dataVenda;
    private int quantidade;
    private String formaPagamento;
    private double valorUnitario;
    private double valorTotal;
    private String nomeAtendente;

    // Construtor vazio
    public Venda() {}

    // Construtor simplificado (para testes rápidos)
    public Venda(int id, Date dataVenda, double valorTotal, int idCliente, int idAtendente) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
        
    }

    // Construtor completo, com todos os campos necessários para o banco atual
    public Venda(int id, String descricaoProduto, String nomeCliente, String cpfCliente, Date dataVenda,
                 int quantidade, String formaPagamento, double valorUnitario, double valorTotal, String nomeAtendente) {
        this.id = id;
        this.descricaoProduto = descricaoProduto;
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.dataVenda = dataVenda;
        this.quantidade = quantidade;
        this.formaPagamento = formaPagamento;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.nomeAtendente = nomeAtendente;
    }

    // Getters e setters para todos os atributos

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getNomeAtendente() {
        return nomeAtendente;
    }

    public void setNomeAtendente(String nomeAtendente) {
        this.nomeAtendente = nomeAtendente;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", descricaoProduto='" + descricaoProduto + '\'' +
                ", nomeCliente='" + nomeCliente + '\'' +
                ", cpfCliente='" + cpfCliente + '\'' +
                ", dataVenda=" + dataVenda +
                ", quantidade=" + quantidade +
                ", formaPagamento='" + formaPagamento + '\'' +
                ", valorUnitario=" + valorUnitario +
                ", valorTotal=" + valorTotal +
                ", nomeAtendente='" + nomeAtendente + '\'' +
                '}';
    }
}




