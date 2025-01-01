package exercicios.vendas;

import java.io.IOException;
import java.util.List;

public class Vendas implements VendasInterface {

    private List<Produto> produtos;

    public Vendas (List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public void cadastrarProduto(Produto produto) throws IOException {
        if (this.produtos.contains(produto)) {
            throw new IOException("O produto já está cadastrado no sistema.");
        } else {
            this.produtos.add(produto);
        }
    }

    @Override
    public String atualizarProduto(String descricaoAtual, String newDescricao, String newCategoria, String newTamanho, double newPreco) {
        String produtoAtual = "";
        Produto novoProduto = null;
        for (Produto p: this.produtos) {
            if (p.getDescricao().equalsIgnoreCase(descricaoAtual)) {
                produtoAtual += p.toString();
                novoProduto = p;
                break;
            }
        }

        novoProduto.setDescricao(newDescricao);
        novoProduto.setCategoria(newCategoria);
        novoProduto.setTamanho(newTamanho);
        novoProduto.setPreco(newPreco);

        return "Dados atualizados do produto:\n" + novoProduto + "\nDados anteriores do produto:\n" + produtoAtual;
    }

    @Override
    public String pesquisarProduto(String descricao) {
        Produto produtoFounded = null;
        for (Produto p: this.produtos) {
            if (p.getDescricao().equalsIgnoreCase(descricao)) {
                produtoFounded = p;
                break;
            }
        }
        if (produtoFounded != null) {
            return produtoFounded.toString();
        } else {
            return "Produto com descrição '" + descricao + "' não encontrado no sistema";
        }

    }

    public boolean encontrarProdutoPorDescricao (java.lang.String descricao) {
        boolean achou = false;
        for (Produto p: this.produtos) {
            if (p.getDescricao().equalsIgnoreCase(descricao)) {
                achou = true;
                break;
            }
        }
        return achou;
    }
}
