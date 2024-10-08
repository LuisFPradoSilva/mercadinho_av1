package com.avaliacao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.avaliacao.domains.Produto;
import com.avaliacao.domains.dtos.ProdutoDTO;
import com.avaliacao.services.ProdutoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/produto")
@Tag(name = "Produto", description = "API para gerenciamento dos produtos")
public class ProdutoResouce {

    @Autowired
    private ProdutoService produtoService;

    @Operation(summary = "Listar todos os produtos", description = "Retorna uma lista com todos os produtos cadastrados")
    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findAll() {
        return ResponseEntity.ok().body(produtoService.findAll());
    }

    @Operation(summary = "Buscar produto por ID", description = "Retorna o produto correspondente ao ID fornecido")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable int id) {
        Produto obj = this.produtoService.findById(id);
        return ResponseEntity.ok().body(new ProdutoDTO(obj));
    }

    @Operation(summary = "Criar um novo produto", description = "Cria um novo produto com base nos dados inseridos")
    @PostMapping
    public ResponseEntity<ProdutoDTO> create(@Valid @RequestBody ProdutoDTO objDto) {
        Produto newObj = produtoService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "Atualizar produto", description = "Atualiza os dados do produto com base no ID fornecido")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> update(@PathVariable int id, @Valid @RequestBody ProdutoDTO onjDto) {
        Produto obj = produtoService.update(id, onjDto);
        return ResponseEntity.ok().body(new ProdutoDTO(obj));
    }

    @Operation(summary = "Deletar produto", description = "Deleta o produto correspondente ao ID fornecido")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> delete(@PathVariable int id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
