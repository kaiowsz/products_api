package br.com.kaio.primeira_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kaio.primeira_api.model.Produto;

// interface herda comandos de bancos de dados pra usar com a classe produto
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // O Spring cria o SQL automaticamente: "SELECT count(*) > 0 FROM produto WHERE nome = ?"
    boolean existsByNome(String nome);
}