package com.avaliacao.domains;


import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

@Entity
@Table(name = "venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private double qtdProdutos;
    private double valorTotal;
    private double desconto;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataVenda = LocalDate.now();
    private String formaPagamento;

    @ManyToOne
    @JoinColumn(name = "idcliente")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(name = "venda_produtos", joinColumns = @JoinColumn(name = "venda_id"), inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<Produto> produtos = new ArrayList<>();

    public Venda() {
    }

    public Venda(UUID id, double qtdProdutos, double valorTotal, double desconto, String formaPagamento,
            Cliente cliente) {
        this.id = id;
        this.qtdProdutos = qtdProdutos;
        this.valorTotal = valorTotal;
        this.desconto = desconto;
        this.formaPagamento = formaPagamento;
        this.cliente = cliente;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Venda other = (Venda) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
