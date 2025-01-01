package exercicios.vendas;

public class Roupa extends Produto {

    public Roupa (String descricao, String categoria, String tamanho, double preco) {
        super(descricao, categoria, tamanho, preco);
    }


    public Roupa() {
        this("","","",0.0);
    }

}
