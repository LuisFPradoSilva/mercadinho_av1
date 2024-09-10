package com.avaliacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avaliacao.domains.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
