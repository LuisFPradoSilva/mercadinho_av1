package com.avaliacao.domains;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.avaliacao.domains.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;

    @Column(unique = true)
    protected String cpf;
    protected String nome;

    @Column(unique = true)
    protected String telefone;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCadastro = LocalDate.now();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "perfis")
    protected Set<Integer> tipoPessoa = new HashSet<>();
    
    public Pessoa() {
        addTipoPessoa(TipoPessoa.CLIENTE);
    }

    public Pessoa(Long id, String cpf, String nome, String telefone) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        addTipoPessoa(TipoPessoa.CLIENTE);
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
        Pessoa other = (Pessoa) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }

}
