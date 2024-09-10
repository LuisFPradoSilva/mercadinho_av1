package com.avaliacao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.domains.Cliente;
import com.avaliacao.domains.Funcionario;
import com.avaliacao.domains.Produto;
import com.avaliacao.domains.Venda;
import com.avaliacao.repositories.ClienteRepository;
import com.avaliacao.repositories.FuncionarioRepository;
import com.avaliacao.repositories.ProdutoRepository;
import com.avaliacao.repositories.VendaRepository;

@Service
public class DBService {

    @Autowired
    private ClienteRepository clienteRepo;

    @Autowired
    private FuncionarioRepository funcionarioRepo;

    @Autowired
    private ProdutoRepository produtoRepo;

    @Autowired
    private VendaRepository vendaRepo;

    public void initDB() {
        Cliente cliente1 = new Cliente(1L, "456789885", "Luis", "55569252");
        Funcionario funcionario1 = new Funcionario(1L, "85692211", "Fernando", "44488796", "Faxineiro", 1560.45);
        Produto produto1 = new Produto(1, "Arroz", 15.45, 1.00, 111);
        Venda venda1 = new Venda(null, 1, 15.45, 0.55, "Dinheiro", cliente1);

        clienteRepo.save(cliente1);
        funcionarioRepo.save(funcionario1);
        produtoRepo.save(produto1);
        vendaRepo.save(venda1);
    }
}
