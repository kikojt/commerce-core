package com.kikodev.commerce_core.controller;

import com.kikodev.commerce_core.model.Produto;
import com.kikodev.commerce_core.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commerce-core")
public class ProdutoController {

    //Injeção de dependência do serviço de produto
    private final ProdutoService produtoService;
    //Construtor para injetar o serviço de produto
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    //Endpoint para listar todos os produtos
    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    //Endpoint para obter um produto pelo ID
    public ResponseEntity<Produto> obterProdutoPorId(@PathVariable Long id) {
        return produtoService.pesquisarProdutoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Endpoint para adicionar um novo produto
    @PostMapping
    public Produto adicionarProduto(@RequestBody Produto produto) {
        return produtoService.adicionarProduto(produto);
    }

    //Endpoint para remover um produto pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerProduto(@PathVariable Long id) {
        produtoService.removerProduto(id);
        return ResponseEntity.noContent().build();
    }

}
