package com.avaliacao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.domains.Cliente;
import com.avaliacao.domains.dtos.ClienteDTO;
import com.avaliacao.repositories.ClienteRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepo;

    public List<ClienteDTO> findAll() {
        return clienteRepo.findAll().stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
    }

    public Cliente findById(Long id) {
        Optional<Cliente> obj = clienteRepo.findById(id);
        return obj.orElse(null);
    }

    public Cliente findByCpf(String cpf) {
        Optional<Cliente> obj = clienteRepo.findByCpf(cpf);
        return obj.orElse(null);
    }
}
