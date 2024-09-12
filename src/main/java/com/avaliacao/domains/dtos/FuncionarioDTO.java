package com.avaliacao.domains.dtos;

import java.util.Set;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.stream.Collectors;

import com.avaliacao.domains.Funcionario;
import com.avaliacao.domains.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FuncionarioDTO {

    protected Long id;

    @NotNull(message = "O campo CPF não pode ser nulo")
    @NotBlank(message = "O campo CPF não pode ser vazio")
    protected String cpf;

    @NotNull(message = "O campo nome não pode ser nulo")
    @NotBlank(message = "O campo nome não pode ser vazio")
    protected String nome;

    @NotNull(message = "O campo telefone não pode ser nulo")
    @NotBlank(message = "O campo telefone não pode ser vazio")
    protected String telefone;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCadastro = LocalDate.now();
    protected Set<Integer> tipoPessoa = new HashSet<>();

    @NotNull(message = "O campo cargo não pode ser nulo")
    @NotBlank(message = "O campo cargo não pode ser vazio")
    protected String cargo;

    @NotNull(message = "O campo salario não pode ser nulo")
    @NotBlank(message = "O campo salario não pode ser vazio")
    protected double salario;

    public FuncionarioDTO() {
    }

    public FuncionarioDTO(Funcionario obj) {
        this.id = obj.getId();
        this.cpf = obj.getCpf();
        this.nome = obj.getNome();
        this.telefone = obj.getTelefone();
        this.dataCadastro = obj.getDataCadastro();
        this.tipoPessoa = obj.getTipoPessoa().stream().map(x -> x.getId()).collect(Collectors.toSet());
        this.cargo = obj.getCargo();
        this.salario = obj.getSalario();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Set<TipoPessoa> getTipoPessoa() {
        return tipoPessoa.stream().map(x -> TipoPessoa.toEnum(x)).collect(Collectors.toSet());
    }

    public void addTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa.add(tipoPessoa.getId());
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
