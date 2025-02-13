package provas;

import provas.exceptions.RoupaInexistenteException;
import provas.exceptions.RoupaJaExisteException;

import java.util.List;
import java.util.Map;

public class SistemaGerenciadorDeLoja implements SistemaLojaRoupas {

    Map<String, Roupa> roupas;

    public SistemaGerenciadorDeLoja (Map <String, Roupa> roupasList) {
        this.roupas = roupasList;
    }

    @Override
    public List<Roupa> pesquisaRoupasPortTamanho(Tamanho t) {
        return List.of();
    }

    @Override
    public List<Roupa> pesquisaRoupasPorDescricao(String descricao) {
        return List.of();
    }

    @Override
    public Tamanho consultaTamanhoDaRoupa (String codigoRoupa) throws RoupaInexistenteException {
        //Roupa r = this.roupas.get(codigoRoupa);
        // return r.getTamanho();
        return this.roupas.get(codigoRoupa).getTamanho();

    }

    @Override
    public void cadastraRoupa(String codigoRoupa, String descricao, Tamanho tamanho, int quantidade) throws RoupaJaExisteException {

        if (!this.roupas.containsKey(codigoRoupa)) {
            this.roupas.put(codigoRoupa, new Roupa(codigoRoupa, descricao, quantidade, tamanho));
        } else {
            throw new RoupaJaExisteException();
        }
    }

    @Override
    public void alterarEstoqueDeRoupa(String codigoRoupa) throws RoupaInexistenteException {

    }

    @Override
    public int pesquisaEstoqueRoupa(String codigoRoupa) throws RoupaInexistenteException {
        return 0;
    }
}
