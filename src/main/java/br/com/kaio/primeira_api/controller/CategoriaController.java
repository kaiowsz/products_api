package br.com.kaio.primeira_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kaio.primeira_api.model.Categoria;
import br.com.kaio.primeira_api.repository.CategoriaRepository;

@RestController
public class CategoriaController {
    
    private final CategoriaRepository repository;

    public CategoriaController(CategoriaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/categorias")
    public List<Categoria> listarTodas() {
        return repository.findAll();
    }

}
