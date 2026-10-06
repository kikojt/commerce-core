package com.kikodev.commerce_core.service;

import com.kikodev.commerce_core.exceptions.NotFoundException;
import com.kikodev.commerce_core.model.Produto;
import com.kikodev.commerce_core.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Produto pesquisarProdutoPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto com o ID " + id + " não encontrado."));
    }

    //Adicionar um produto
    public Produto adicionarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    //Remover um produto
    public void removerProduto(long id) {
        if (!produtoRepository.existsById(id)) {
            throw new NotFoundException("Produto com o ID " + id + " não encontrado.");
        }
        produtoRepository.deleteById(id);
    }

}
