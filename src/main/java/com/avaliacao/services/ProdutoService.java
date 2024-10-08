package com.avaliacao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.domains.Produto;
import com.avaliacao.domains.dtos.ProdutoDTO;
import com.avaliacao.repositories.ProdutoRepository;
import com.avaliacao.services.exceptions.DataIntegrityViolationException;
import com.avaliacao.services.exceptions.ObjectNotFoundException;

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
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id));
    }

    public Produto create(ProdutoDTO objDto) {
        objDto.setId(0);
        Produto newObj = new Produto(objDto);
        return produtoRepo.save(newObj);
    }

    public Produto update(int id, ProdutoDTO objDto) {
        objDto.setId(id);
        Produto oldObj = findById(id);
        oldObj = new Produto(objDto);
        return produtoRepo.save(oldObj);
    }

    public void delete(int id) {
        Produto obj = findById(id);

        if(obj.getVendas().size() > 0) {
            throw new DataIntegrityViolationException("O produto já está presente em vendas realizadas!");
        }
        produtoRepo.deleteById(id);
    }
}
