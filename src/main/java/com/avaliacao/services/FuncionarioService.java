package com.avaliacao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.domains.Funcionario;
import com.avaliacao.domains.dtos.FuncionarioDTO;
import com.avaliacao.repositories.FuncionarioRepository;
import com.avaliacao.services.exceptions.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepo;

    public List<FuncionarioDTO> findAll() {
        return funcionarioRepo.findAll().stream().map(obj -> new FuncionarioDTO(obj)).collect(Collectors.toList());
    }

    public Funcionario findById(Long id) {
        Optional<Funcionario> obj = funcionarioRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id));
    } 

    public Funcionario findByCpf(String cpf) {
        Optional<Funcionario> obj = funcionarioRepo.findByCpf(cpf);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! CPF: " + cpf));
    }

    public Funcionario crate(FuncionarioDTO objDto) {
        objDto.setId(null);
        Funcionario newObj = new Funcionario(objDto);
        return funcionarioRepo.save(newObj);
    }
}
