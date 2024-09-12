package com.avaliacao.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.domains.Venda;
import com.avaliacao.domains.dtos.VendaDTO;
import com.avaliacao.repositories.VendaRepository;
import com.avaliacao.services.exceptions.ObjectNotFoundException;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepo;

    public Venda findById(UUID id) {
        Optional<Venda> obj =vendaRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id));
    }

    public List<VendaDTO> findAll() {
        return vendaRepo.findAll().stream().map(obj -> new VendaDTO(obj)).collect(Collectors.toList());
    }
}
