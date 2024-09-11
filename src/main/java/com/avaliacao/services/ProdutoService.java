package com.avaliacao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.domains.Produto;
import com.avaliacao.domains.dtos.ProdutoDTO;
import com.avaliacao.repositories.ProdutoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepo;

    public List<ProdutoDTO> findAll() {
        return produtoRepo.findAll().stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
    }

    public Produto findById(int id) {
        Optional<Produto> obj = produtoRepo.findById(id);
        return obj.orElse(null);
    }
}
