package com.avaliacao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.domains.dtos.ProdutoDTO;
import com.avaliacao.repositories.ProdutoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepo;

    public List<ProdutoDTO> findAll() {
        return produtoRepo.findAll().stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
    }
}
