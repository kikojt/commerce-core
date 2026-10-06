package com.kikodev.commerce_core.repository;

import com.kikodev.commerce_core.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
