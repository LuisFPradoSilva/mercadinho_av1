package com.avaliacao.domains;

import java.util.List;

import com.avaliacao.domains.enums.TipoPessoa;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;

@Entity
public class Cliente extends Pessoa {

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

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

}
