package com.avaliacao.resources;

import java.util.List;
import java.util.UUID;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/venda")
public class VendaResource {

    @Autowired
    private VendaService vendaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<VendaDTO> findById(@PathVariable UUID id) {
        Venda obj = this.vendaService.findById(id);
        return ResponseEntity.ok().body(new VendaDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<VendaDTO>> findAll() {
        return ResponseEntity.ok().body(vendaService.findAll());
    }

    @PostMapping
    public ResponseEntity<VendaDTO> create(@Valid @RequestBody VendaDTO objDto) {
        Venda newObj = vendaService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<VendaDTO> update(@PathVariable UUID id, @Valid @RequestBody VendaDTO objDto) {
        Venda obj = vendaService.update(id, objDto);
        return ResponseEntity.ok().body(new VendaDTO(obj));
    }
}
