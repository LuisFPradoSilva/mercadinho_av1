package com.avaliacao.domains;

import java.util.List;
import java.util.stream.Collectors;

import com.avaliacao.domains.dtos.ClienteDTO;
import com.avaliacao.domains.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;

@Entity
public class Cliente extends Pessoa {

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Venda> vendas = new ArrayList<>();

    public Cliente() {
        super();
        addTipoPessoa(TipoPessoa.CLIENTE);
    }

    public Cliente(Long id, String cpf, String nome, String telefone) {
        super(id, cpf, nome, telefone);
        addTipoPessoa(TipoPessoa.CLIENTE);
    }

    public Cliente(ClienteDTO obj) {
        this.id = obj.getId();
        this.cpf = obj.getCpf();
        this.nome = obj.getNome();
        this.telefone = obj.getTelefone();
        this.dataCadastro = obj.getDataCadastro();
        this.tipoPessoa = obj.getTipoPessoa().stream().map(x -> x.getId()).collect(Collectors.toSet());
        addTipoPessoa(TipoPessoa.CLIENTE);
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

}
