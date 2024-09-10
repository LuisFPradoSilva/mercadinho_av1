package com.avaliacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avaliacao.domains.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
