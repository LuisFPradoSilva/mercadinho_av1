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

import com.avaliacao.domains.Funcionario;
import com.avaliacao.domains.dtos.FuncionarioDTO;
import com.avaliacao.services.FuncionarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/funcionario")
@Tag(name = "Funcionario", description = "API para gerenciamento dos funcionarios")
public class FuncionarioResource {

    @Autowired
    private FuncionarioService funcionarioService;

    @Operation(summary = "Listar todos os funcionarios", description = "Retorna uma lista com todos os funcionarios cadastrados")
    @GetMapping
    public ResponseEntity <List<FuncionarioDTO>> findAll() {
        return ResponseEntity.ok().body(funcionarioService.findAll());
    }

    @Operation(summary = "Buscar funcionario por ID", description = "Retorna o funcionario correspondente ao ID fornecido")
    @GetMapping(value = "/{id}")
    public ResponseEntity<FuncionarioDTO> findById(@PathVariable Long id) {
        Funcionario obj = this.funcionarioService.findById(id);
        return ResponseEntity.ok().body(new FuncionarioDTO(obj));
    }

    @Operation(summary = "Buscar funcionario por CPF", description = "Retorna o funcionario correspondente ao CPF fornecido")
    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<FuncionarioDTO> findByCpf(@PathVariable String cpf) {
        Funcionario obj = this.funcionarioService.findByCpf(cpf);
        return ResponseEntity.ok().body(new FuncionarioDTO(obj));
    }

    @Operation(summary = "Criar um novo funcionario", description = "Cria um novo funcionario com base nos dados inseridos")
    @PostMapping
    public ResponseEntity<FuncionarioDTO> create(@Valid @RequestBody FuncionarioDTO objDto) {
        Funcionario newObj = funcionarioService.crate(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "Atualizar funcionario", description = "Atualiza os dados do funcionario com base no ID fornecido")
    @PutMapping(value = "/{id}")
    public ResponseEntity<FuncionarioDTO> update(@PathVariable Long id, @Valid @RequestBody FuncionarioDTO objDto) {
        Funcionario obj = funcionarioService.update(id, objDto);
        return ResponseEntity.ok().body(new FuncionarioDTO(obj));
    }

    @Operation(summary = "Deletar funcionario", description = "Deleta o funcionario correspondente ao ID fornecido")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<FuncionarioDTO> delete(@PathVariable Long id) {
        funcionarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
