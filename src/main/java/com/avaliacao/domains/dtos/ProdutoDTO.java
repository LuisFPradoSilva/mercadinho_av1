package com.avaliacao.domains.dtos;

import com.avaliacao.domains.Produto;
import com.avaliacao.domains.enums.TipoProduto;
import com.avaliacao.domains.enums.UnidadeMedida;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.Set;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.stream.Collectors;

public class ProdutoDTO {

    protected int id;

    @NotNull(message = "O campo descrição não pode ser nulo")
    @NotBlank(message = "O campo descrição não pode ser vazio")
    protected String descricao;

    @Positive(message = "O campo valor deve ser maior que zero")
    protected double valor;

    @Positive(message = "O campo peso deve ser maior que zero")
    protected double peso;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataFabricacao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataValidade;

    @Positive(message = "O campo quantidade em estoque deve ser maior que zero")
    protected double qtdEstoque;
    protected Set<Integer> tipoProduto = new HashSet<>();
    protected Set<Integer> unidadeMedida = new HashSet<>();

    public ProdutoDTO() {
    }

    public ProdutoDTO(Produto obj) {
        this.id = obj.getId();
        this.descricao = obj.getDescricao();
        this.valor = obj.getValor();
        this.peso = obj.getPeso();
        this.dataFabricacao = obj.getDataFabricacao();
        this.dataValidade = obj.getDataValidade();
        this.qtdEstoque = obj.getQtdEstoque();
        this.tipoProduto = obj.getTipoProduto().stream().map(x -> x.getId()).collect(Collectors.toSet());
        this.unidadeMedida = obj.getUnidadeMedida().stream().map(x -> x.getId()).collect(Collectors.toSet());
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

    
}
