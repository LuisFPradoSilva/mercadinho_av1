package com.avaliacao.resources;

import java.net.URI;
import java.util.List;

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

import com.avaliacao.domains.Cliente;
import com.avaliacao.domains.dtos.ClienteDTO;
import com.avaliacao.services.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/cliente")
@Tag(name = "Cliente", description = "API para gerenciamento dos clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @Operation(summary = "Listar todos os clientes", description = "Retorna uma lista com todos os clientes cadastrados")
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {
        return ResponseEntity.ok().body(clienteService.findAll());
    }

    @Operation(summary = "Buscar cliente por ID", description = "Retorna o cliente correspondente ao ID fornecido")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Long id) {
        Cliente obj = this.clienteService.findById(id);
        return ResponseEntity.ok().body(new ClienteDTO(obj));
    }

    @Operation(summary = "Buscar cliente por CPF", description = "Retorna o cliente correspondente ao CPF fornecido")
    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable String cpf) {
        Cliente obj = this.clienteService.findByCpf(cpf);
        return ResponseEntity.ok().body(new ClienteDTO(obj));
    }

    @Operation(summary = "Criar um novo cliente", description = "Cria um novo cliente com base nos dados inseridos")
    @PostMapping
    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO objDto) {
        Cliente newObj = clienteService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "Atualizar cliente", description = "Atualiza os dados do cliente com base no ID fornecido")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Long id, @Valid @RequestBody ClienteDTO objDto) {
        Cliente obj = clienteService.update(id, objDto);
        return ResponseEntity.ok().body(new ClienteDTO(obj));
    }

    @Operation(summary = "Deletar cliente", description = "Deleta o cliente correspondente ao ID fornecido")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
