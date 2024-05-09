package exe.gba.projetoecommerce.dto;

public class ProdutoListagemDto {

    private Integer id;
    private String nome;
    private String fabricante;
    private String categoria;
    private int quantidadeEstoque;
    private int quantidadeVendidos;
    private double precoVenda;
    private double precoCompra;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getQuantidadeVendidos() {
        return quantidadeVendidos;
    }

    public void setQuantidadeVendidos(int quantidadeVendidos) {
        this.quantidadeVendidos = quantidadeVendidos;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public double getLucro() {
        return (precoVenda - precoCompra) * quantidadeVendidos;
    }
}
