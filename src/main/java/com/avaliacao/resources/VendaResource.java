package com.avaliacao.resources;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avaliacao.domains.Venda;
import com.avaliacao.domains.dtos.VendaDTO;
import com.avaliacao.services.VendaService;

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
}
