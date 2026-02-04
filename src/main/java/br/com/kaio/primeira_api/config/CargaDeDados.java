package br.com.kaio.primeira_api.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.kaio.primeira_api.model.Categoria;
import br.com.kaio.primeira_api.model.Produto;
import br.com.kaio.primeira_api.repository.CategoriaRepository;
import br.com.kaio.primeira_api.repository.ProdutoRepository;

@Configuration
public class CargaDeDados {
    // O Spring roda tudo que é @Bean do tipo CommandLineRunner assim que o app inicia.
    @Bean
    public CommandLineRunner executar(ProdutoRepository productRepository, CategoriaRepository categoriaRepository) {
        return args -> {

            if(categoriaRepository.count() > 0) {
                System.out.println("Banco de dados ja esta populado. Pulando carga de dados...");
                return;
            }

            Categoria eletronicos = new Categoria("Eletronicos");
            categoriaRepository.save(eletronicos);

            productRepository.save(new Produto("Mouse Gamer", 150.00, eletronicos));
            productRepository.save(new Produto("Teclado Mecanico", 350.00, eletronicos));

            System.out.println(">> Banco de dados iniciado com sucesso.");
        };
    }
}