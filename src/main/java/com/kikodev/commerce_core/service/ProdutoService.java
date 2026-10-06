package com.kikodev.commerce_core.service;

import com.kikodev.commerce_core.model.Produto;
import com.kikodev.commerce_core.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    //Injeção da dependência do repositório produtos
    public final ProdutoRepository produtoRepository;
    //Construtor para injetar a dependência do repositório produtos
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    //Listar todos os produtos
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    //Pesquisar produto por id
    public Optional<Produto> pesquisarProdutoPorId(Long id) {
        return produtoRepository.findById(id);
    }

    //Adicionar um produto
    public Produto adicionarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    //Remover um produto
    public void removerProduto(long id) {
        produtoRepository.deleteById(id);
    }

}
