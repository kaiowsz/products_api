package br.com.kaio.primeira_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProdutoRequest {
    @NotBlank(message = "O nome eh obrigatorio")
    @Size(min = 3, message = "O nome deve ter no minimo 3 caracteres")
    private String nome;

    @Positive(message = "O preco deve ser maior que zero")
    private double preco;

    @NotNull(message = "O ID da categoria eh obrigatorio")
    private Long categoriaId;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public Long getCategoriaId() { return categoriaId; }
    public void setCategoriaId(Long categoriaId) { this.categoriaId = categoriaId; }


}
