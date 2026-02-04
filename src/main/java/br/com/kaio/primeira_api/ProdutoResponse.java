package br.com.kaio.primeira_api;

public class ProdutoResponse {
    private Long id;
    private String titulo;
    private double preco;
    private String nomeDaCategoria;
    
    // Constructor
    public ProdutoResponse(Produto produto) {
        this.id = produto.getId();
        this.titulo = produto.getNome();
        this.preco = produto.getPreco();
        if(produto.getCategoria() != null) {
            this.nomeDaCategoria = produto.getCategoria().getNome();
        }
    }

    // Getters
    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public double getPreco() { return preco; }
    public String getNomeDaCategoria() { return nomeDaCategoria; }
}
 