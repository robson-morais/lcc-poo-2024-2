package provas;

import provas.exceptions.RoupaInexistenteException;
import provas.exceptions.RoupaJaExisteException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SistemaGerenciadorDeLoja implements SistemaLojaRoupas {

    Map<String, Roupa> roupas;

    public SistemaGerenciadorDeLoja (Map <String, Roupa> roupasList) {
        this.roupas = roupasList;
    }

    @Override
    public List<Roupa> pesquisaRoupasPortTamanho(Tamanho t) {

        List<Roupa> roupas1 = new ArrayList<>();
        for (Roupa r: this.roupas.values()) {
            if (r.getTamanho() == t) {
                roupas1.add(r);
            }
        }
        return roupas1;
    }

    @Override
    public List<Roupa> pesquisaRoupasPorDescricao(String descricao) {

        List<Roupa> roupas2 = new ArrayList<>();
        for (Roupa r: this.roupas.values()) {
            if (r.getDescricao().equalsIgnoreCase(descricao)){
                roupas2.add(r);
            }
        }
        return roupas2;
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
    public void alterarEstoqueDeRoupa(String codigoRoupa, int quant) throws RoupaInexistenteException {
        if (existe(codigoRoupa)) {
            this.roupas.get(codigoRoupa).setQuantidade(quant);
        } else {
            throw new RoupaInexistenteException();
        }
    }

    @Override
    public int pesquisaEstoqueRoupa(String codigoRoupa) throws RoupaInexistenteException {
        if (existe(codigoRoupa)) {
            return this.roupas.get(codigoRoupa).getQuantidade();
        } else {
            throw new RoupaInexistenteException();
        }
    }

    public boolean existe (String codigoRoupa) {
        return this.roupas.containsKey(codigoRoupa);
    }
}
