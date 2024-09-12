package com.avaliacao.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.domains.Cliente;
import com.avaliacao.domains.Venda;
import com.avaliacao.domains.dtos.VendaDTO;
import com.avaliacao.repositories.VendaRepository;
import com.avaliacao.services.exceptions.ObjectNotFoundException;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepo;

    @Autowired
    private ClienteService clienteService;

    public Venda findById(UUID id) {
        Optional<Venda> obj =vendaRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id));
    }

    public List<VendaDTO> findAll() {
        return vendaRepo.findAll().stream().map(obj -> new VendaDTO(obj)).collect(Collectors.toList());
    }

    private Venda newVenda(VendaDTO obj) {
        Cliente cliente = clienteService.findById(obj.getCliente());
        Venda venda = new Venda();

        if(obj.getId() != null) {
            venda.setId(obj.getId());
        }

        venda.setCliente(cliente);
        venda.setQtdProdutos(obj.getQtdProdutos());
        venda.setValorTotal(obj.getValorTotal());
        venda.setDesconto(obj.getDesconto());
        venda.setFormaPagamento(obj.getFormaPagamento());

        return venda;
    }

    public Venda create(VendaDTO objDto) {
        return vendaRepo.save(newVenda(objDto));
    }

    public Venda update(UUID id, VendaDTO objDto) {
        objDto.setId(id);
        Venda oldObj = findById(id);
        oldObj = newVenda(objDto);
        return vendaRepo.save(oldObj);
    }

    public void delete(UUID id) {
        vendaRepo.deleteById(id);
    }
}
