package br.com.kaio.primeira_api;

import org.springframework.data.jpa.repository.JpaRepository;

// interface herda comandos de bancos de dados pra usar com a classe produto
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // O Spring cria o SQL automaticamente: "SELECT count(*) > 0 FROM produto WHERE nome = ?"
    boolean existsByNome(String nome);
}