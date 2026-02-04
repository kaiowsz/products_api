package br.com.kaio.primeira_api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

@RestController
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/api/produtos")
    //@Valid faz as verificações de tipagem no produto antes de jogar pra função.
    public ProdutoResponse criarNovo(@RequestBody @Valid ProdutoRequest requisicao) {
        return produtoService.criar(requisicao);
    }

    @DeleteMapping("/api/produtos/{id}")
    public void excluir(@PathVariable Long id) {
        produtoService.excluir(id);
    }

    @PutMapping("/api/produtos/{id}")
    public ProdutoResponse atualizar(@PathVariable Long id, @RequestBody @Valid ProdutoRequest requisicao) {
        return produtoService.atualizar(id, requisicao);
    }

    @GetMapping("/api/produtos")
    public Page<ProdutoResponse> listarTodos(
        @PageableDefault(size = 10, page = 0, sort = "nome") Pageable paginacao
    ) {
        return produtoService.listarTodos(paginacao);
    }
}
