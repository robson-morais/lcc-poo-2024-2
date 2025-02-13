package provas;

import provas.exceptions.RoupaInexistenteException;
import provas.exceptions.RoupaJaExisteException;

import java.util.List;

public interface SistemaLojaRoupas {
    public List<Roupa> pesquisaRoupasPortTamanho (Tamanho t);
    public List<Roupa> pesquisaRoupasPorDescricao (String descricao);
    public Tamanho consultaTamanhoDaRoupa (String codigoRoupa) throws RoupaInexistenteException;
    public void cadastraRoupa(String codigoRoupa, String descricao, Tamanho tamanho, int quantidade) throws RoupaJaExisteException;
    public void alterarEstoqueDeRoupa (String codigoRoupa) throws RoupaInexistenteException;
    public int pesquisaEstoqueRoupa (String codigoRoupa) throws RoupaInexistenteException;
}
