package br.com.kaio.primeira_api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.com.kaio.primeira_api.dto.ProdutoRequest;
import br.com.kaio.primeira_api.dto.ProdutoResponse;
import br.com.kaio.primeira_api.model.Categoria;
import br.com.kaio.primeira_api.model.Produto;
import br.com.kaio.primeira_api.repository.CategoriaRepository;
import br.com.kaio.primeira_api.repository.ProdutoRepository;

import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public Page<ProdutoResponse> listarTodos(Pageable paginacao) {
        return produtoRepository.findAll(paginacao)
            .map(ProdutoResponse::new);
    }

    public ProdutoResponse criar(ProdutoRequest requisicao) {

        if(produtoRepository.existsByNome(requisicao.getNome())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ja existe um produto com este nome");
        }

        Categoria categoria = categoriaRepository.findById(requisicao.getCategoriaId())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria nao encontrada"));
        
        Produto produto = new Produto(requisicao.getNome(), requisicao.getPreco(), categoria);

        
        produtoRepository.save(produto);

        return new ProdutoResponse(produto);
    }

    public ProdutoResponse atualizar(Long id, ProdutoRequest requisicao) {
        Produto produto = produtoRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto nao encontrado"));
        
        Categoria categoria = categoriaRepository.findById(requisicao.getCategoriaId())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria nao encontrada"));

        produto.setNome(requisicao.getNome());
        produto.setPreco(requisicao.getPreco());
        produto.setCategoria(categoria);

        produtoRepository.save(produto);

        return new ProdutoResponse(produto);
    }

    public void excluir(Long id) {
        if(!produtoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto nao encontrado");
        }
        produtoRepository.deleteById(id);
    }
}