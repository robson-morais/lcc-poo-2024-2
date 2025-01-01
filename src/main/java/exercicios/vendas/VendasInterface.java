package exercicios.vendas;

import java.io.IOException;

public interface VendasInterface {

    void cadastrarProduto (Produto produto) throws IOException;
    String atualizarProduto (String descricaoAtual, String newDescricao, String newCategoria, String newTamanho, double newPreco);
    String pesquisarProduto(String descricao);
}
