package com.avaliacao.resources;

import java.util.List;
import java.util.UUID;
import java.net.URI;

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

import com.avaliacao.domains.Venda;
import com.avaliacao.domains.dtos.VendaDTO;
import com.avaliacao.services.VendaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/venda")
@Tag(name = "Venda", description = "API para gerenciamento das vendas")
public class VendaResource {

    @Autowired
    private VendaService vendaService;

    @Operation(summary = "Buscar venda por ID", description = "Retorna a venda correspondente ao ID fornecido")
    @GetMapping(value = "/{id}")
    public ResponseEntity<VendaDTO> findById(@PathVariable UUID id) {
        Venda obj = this.vendaService.findById(id);
        return ResponseEntity.ok().body(new VendaDTO(obj));
    }

    @Operation(summary = "Listar todas as vendas", description = "Retorna uma lista com todas as vendas cadastrados")
    @GetMapping
    public ResponseEntity<List<VendaDTO>> findAll() {
        return ResponseEntity.ok().body(vendaService.findAll());
    }

    @Operation(summary = "Criar uma nova venda", description = "Cria uma nova venda com base nos dados inseridos")
    @PostMapping
    public ResponseEntity<VendaDTO> create(@Valid @RequestBody VendaDTO objDto) {
        Venda newObj = vendaService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "Atualizar venda", description = "Atualiza os dados da venda com base no ID fornecido")
    @PutMapping(value = "/{id}")
    public ResponseEntity<VendaDTO> update(@PathVariable UUID id, @Valid @RequestBody VendaDTO objDto) {
        Venda obj = vendaService.update(id, objDto);
        return ResponseEntity.ok().body(new VendaDTO(obj));
    }

    @Operation(summary = "Deletar venda", description = "Deleta a venda correspondente ao ID fornecido")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<VendaDTO> delete(@PathVariable UUID id) {
        vendaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
