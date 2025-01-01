package exercicios.vendas;

public class Calcado extends Produto {

    public Calcado (String descricao, String categoria, String tamanho, double preco) {
        super(descricao, categoria, tamanho, preco);    
    }

    public Calcado() {
        super("","","",0.0);
    }
}
