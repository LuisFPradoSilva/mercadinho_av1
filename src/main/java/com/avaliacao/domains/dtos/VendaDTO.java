package com.avaliacao.domains.dtos;

import java.time.LocalDate;
import java.util.UUID;

import com.avaliacao.domains.Venda;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class VendaDTO {

    private UUID id;

    @Positive(message = "O campo quantidade de produtos deve ser maior que zero")
    private double qtdProdutos;

    @Positive(message = "O campo valor total deve ser maior que zero")
    private double valorTotal;

    @Positive(message = "O campo desconto deve ser maior que zero")
    private double desconto;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataVenda = LocalDate.now();

    @NotNull(message = "O campo forma de pagamento é obrigatório!")
    private String formaPagamento;

    @NotNull(message = "O campo cliente é obrigatório!")
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
