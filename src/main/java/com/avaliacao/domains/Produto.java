package com.avaliacao.domains;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import com.avaliacao.domains.enums.TipoProduto;
import com.avaliacao.domains.enums.UnidadeMedida;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String descricao;
    private double valor;
    private double peso;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFabricacao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataValidade;
    private double qtdEstoque;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tipoproduto")
    private Set<Integer> tipoProduto = new HashSet<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "unidademedida")
    private Set<Integer> unidadeMedida = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "produtos")
    private List<Venda> vendas = new ArrayList<>();
    
    public Produto() {
        addTipoProduto(TipoProduto.COMIDA);
        addUnidadeMedida(UnidadeMedida.UN);
    }

    public Produto(int id, String descricao, double valor, double peso, double qtdEstoque) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.peso = peso;
        this.qtdEstoque = qtdEstoque;
        addTipoProduto(TipoProduto.COMIDA);
        addUnidadeMedida(UnidadeMedida.UN);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public double getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(double qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Set<TipoProduto> getTipoProduto() {
        return tipoProduto.stream().map(x -> TipoProduto.toEnum(x)).collect(Collectors.toSet());
    }

    public void addTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto.add(tipoProduto.getId());
    }

    public Set<UnidadeMedida> getUnidadeMedida() {
        return unidadeMedida.stream().map(x -> UnidadeMedida.toEnum(x)).collect(Collectors.toSet());
    }

    public void addUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida.add(unidadeMedida.getId());
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
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
        Produto other = (Produto) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
