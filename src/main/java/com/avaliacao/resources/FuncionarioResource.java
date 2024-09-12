package com.avaliacao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.avaliacao.domains.Funcionario;
import com.avaliacao.domains.dtos.FuncionarioDTO;
import com.avaliacao.services.FuncionarioService;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioResource {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity <List<FuncionarioDTO>> findAll() {
        return ResponseEntity.ok().body(funcionarioService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FuncionarioDTO> findById(@PathVariable Long id) {
        Funcionario obj = this.funcionarioService.findById(id);
        return ResponseEntity.ok().body(new FuncionarioDTO(obj));
    }

    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<FuncionarioDTO> findByCpf(@PathVariable String cpf) {
        Funcionario obj = this.funcionarioService.findByCpf(cpf);
        return ResponseEntity.ok().body(new FuncionarioDTO(obj));
    }

    @PostMapping
    public ResponseEntity<FuncionarioDTO> create(@Valid @RequestBody FuncionarioDTO objDto) {
        Funcionario newObj = funcionarioService.crate(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
