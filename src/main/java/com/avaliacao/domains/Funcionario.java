package com.avaliacao.domains;

import java.util.stream.Collectors;

import com.avaliacao.domains.dtos.FuncionarioDTO;
import com.avaliacao.domains.enums.TipoPessoa;

import jakarta.persistence.Entity;

@Entity
public class Funcionario extends Pessoa {

    private String cargo;
    private double salario;

    public Funcionario() {
        super();
        addTipoPessoa(TipoPessoa.FUNCIONARIO);
    }

    public Funcionario(Long id, String cpf, String nome, String telefone, String cargo, double salario) {
        super(id, cpf, nome, telefone);
        this.cargo = cargo;
        this.salario = salario;
        addTipoPessoa(TipoPessoa.FUNCIONARIO);
    }

    public Funcionario(FuncionarioDTO obj) {
        this.id = obj.getId();
        this.cpf = obj.getCpf();
        this.nome = obj.getNome();
        this.telefone = obj.getTelefone();
        this.dataCadastro = obj.getDataCadastro();
        this.tipoPessoa = obj.getTipoPessoa().stream().map(x -> x.getId()).collect(Collectors.toSet());
        addTipoPessoa(TipoPessoa.FUNCIONARIO);
        addTipoPessoa(TipoPessoa.CLIENTE);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
