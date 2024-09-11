package com.avaliacao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avaliacao.domains.Funcionario;
import com.avaliacao.domains.dtos.FuncionarioDTO;
import com.avaliacao.services.FuncionarioService;

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
}
