package exercicios.vendas;

import java.util.Objects;

public class Produto {
    protected String descricao;
    protected String categoria;
    protected String tamanho;
    protected double preco;
    protected static int id;

    public Produto(String descricao, String categoria, String tamanho, double preco) {
        this.descricao = descricao;
        this.categoria = categoria;
        this.tamanho = tamanho;
        this.preco = preco;
        this.id = getId();
    }

    public Produto() {
        this("","","",0.0);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getTamanho() {
        return tamanho;
    }
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    private int geradorID (){
        int num = (int) (Math.random()*10000);
        return num;
    }

    public int getId() {
        return geradorID();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Double.compare(preco, produto.preco) == 0 && id == produto.id && Objects.equals(descricao, produto.descricao) && Objects.equals(categoria, produto.categoria) && Objects.equals(tamanho, produto.tamanho);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao, categoria, tamanho, preco, id);
    }

    @Override
    public String toString() {
        return "Dados do produto:\n{Descrição = " + descricao
        + "\nCategoria = " + categoria
        + "\nTamanho = " + tamanho
        + "\nPreço unitário = R$ " + preco
        + "\nID = " + geradorID() + "]\n";
    }
}
