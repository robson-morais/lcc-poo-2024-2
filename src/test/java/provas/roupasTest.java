package provas;

import org.junit.Test;
import provas.exceptions.RoupaInexistenteException;
import provas.exceptions.RoupaJaExisteException;

import java.util.HashMap;
import java.util.Map;

public class roupasTest {

    @Test
    public void sistemaRoupas() {
        Map<String,Roupa> roupas = new HashMap<>();
        SistemaGerenciadorDeLoja sistema = new SistemaGerenciadorDeLoja(roupas);
        try {
            sistema.cadastraRoupa("111", "Camisa 1",  Tamanho.G, 90);
            sistema.consultaTamanhoDaRoupa("111");
            System.out.println(sistema.consultaTamanhoDaRoupa("111"));
        } catch (RoupaJaExisteException | RoupaInexistenteException r) {
            r.printStackTrace();
        }
    }
}
