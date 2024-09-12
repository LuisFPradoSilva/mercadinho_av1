package com.avaliacao.domains.dtos;

import java.time.LocalDate;
import java.util.UUID;

import com.avaliacao.domains.Venda;
import com.fasterxml.jackson.annotation.JsonFormat;

public class VendaDTO {

    private UUID id;
    private double qtdProdutos;
    private double valorTotal;
    private double desconto;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataVenda = LocalDate.now();
    private String formaPagamento;
    private Long cliente;
    private String nomeCliente;

    public VendaDTO() {
    }

    public VendaDTO(Venda venda) {
        this.id = venda.getId();
        this.qtdProdutos = venda.getQtdProdutos();
        this.valorTotal = venda.getValorTotal();
        this.desconto = venda.getDesconto();
        this.dataVenda = venda.getDataVenda();
        this.formaPagamento = venda.getFormaPagamento();
        this.cliente = venda.getCliente().getId();
        this.nomeCliente = venda.getCliente().getNome();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getQtdProdutos() {
        return qtdProdutos;
    }

    public void setQtdProdutos(double qtdProdutos) {
        this.qtdProdutos = qtdProdutos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Long getCliente() {
        return cliente;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    
}
