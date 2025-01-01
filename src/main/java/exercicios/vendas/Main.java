package exercicios.vendas;

import javax.swing.JOptionPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(java.lang.String[] args) {

        Produto a = new Produto("A", "Roupas", "M", 100);
        Produto b = new Produto("B", "Roupas", "G", 10);

        List<Produto> produtosList = new ArrayList<>();
        Vendas produtos = new Vendas(produtosList);

        // Adicionando os produtosList à lista
        produtosList.add(a); produtosList.add(b);

        boolean start = false;
        int input = 0;

        while (!start) {

            input = Integer.parseInt(JOptionPane.showInputDialog("Gerenciamento de produtos da loja:\n\n(1) Cadastrar produto\n(2) Consultar Inventário\n(3) Pesquisar produto\n(4) Atualizar produto\n(5) Sair"));

            switch (input) {
                case 1:
                    try {
                        String descricao = JOptionPane.showInputDialog("Descrição: ");
                        String categoria = JOptionPane.showInputDialog("Categoria: ");
                        String tamanho = JOptionPane.showInputDialog("Tamanho: ");
                        double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço unitário: "));
                        produtos.cadastrarProduto(new Produto(descricao, categoria, tamanho, preco));
                        JOptionPane.showMessageDialog(null, "Produto cadastrado no sistema.\n");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                    break;


                case 2:
                    JOptionPane.showMessageDialog(null, produtosList);
                    break;

                case 3:
                    String descricao = JOptionPane.showInputDialog("Digite a descrição do produto: ");
                    JOptionPane.showMessageDialog(null, produtos.pesquisarProduto(descricao));
                    break;

                case 4:
                    String descricaoAtual = JOptionPane.showInputDialog("Digite a descrição do produto: ");
                    if (produtos.encontrarProdutoPorDescricao(descricaoAtual)) {
                        String novaDescricao = JOptionPane.showInputDialog("Produto encontrado! Atualize as informações do produto:\n1. Descrição: ");
                        String novaCategoria = JOptionPane.showInputDialog("2. Categoria:");
                        String novoTamanho = JOptionPane.showInputDialog("3. Tamanho:");
                        double novoPreco = Double.parseDouble(JOptionPane.showInputDialog("4. preço:"));
                        JOptionPane.showMessageDialog(null, produtos.atualizarProduto(descricaoAtual,novaDescricao, novaCategoria, novoTamanho, novoPreco));
                    } else {
                        JOptionPane.showMessageDialog(null, "Produto com descrição '" + descricaoAtual + "' não encontrado");
                    }
                    break;

                case 5:
                    start = true;
            }
        }
    }
}
