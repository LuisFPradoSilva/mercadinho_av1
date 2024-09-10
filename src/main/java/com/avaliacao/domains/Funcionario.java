package com.avaliacao.domains;

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
