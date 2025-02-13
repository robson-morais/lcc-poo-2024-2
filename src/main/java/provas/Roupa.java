package provas;

public class Roupa {

    private String codigo;
    private String descricao;
    private int quantidade;
    private Tamanho tamanho;

    public Roupa(String codigo, String descricao, int quant, Tamanho tamanho) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.quantidade = quant;
        this.tamanho = tamanho;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setQuantidade (int quant) {
        this.quantidade = quant;
    }

    @Override
    public String toString() {
        return "Roupa [código = " + codigo + '\'' +
                "descricao = " + descricao + '\'' +
                "quantidade = " + quantidade +
                "tamanho = " + tamanho + "]\n";
    }
}
