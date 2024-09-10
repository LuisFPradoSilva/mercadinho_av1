package com.avaliacao.repositories;

import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avaliacao.domains.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, UUID> {

}
