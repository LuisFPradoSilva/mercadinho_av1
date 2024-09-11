package com.avaliacao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.domains.dtos.FuncionarioDTO;
import com.avaliacao.repositories.FuncionarioRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepo;

    public List<FuncionarioDTO> findAll() {
        return funcionarioRepo.findAll().stream().map(obj -> new FuncionarioDTO(obj)).collect(Collectors.toList());
    }
}
