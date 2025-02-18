package provas;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import provas.exceptions.RoupaInexistenteException;
import provas.exceptions.RoupaJaExisteException;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class roupasTest {
    SistemaGerenciadorDeLoja sistema;
    Map<String,Roupa> roupas;

    @BeforeEach
    void setUp() {
        this.sistema = new SistemaGerenciadorDeLoja(roupas);
    }

    @Test
    public void sistemaRoupas() {
        try {
            sistema.cadastraRoupa("1", "Camisa 1",  Tamanho.G, 90);
            System.out.println("antes: " + roupas.get("1").getQuantidade());
            sistema.alterarEstoqueDeRoupa("1", 86);
            sistema.cadastraRoupa("2", "Camisa 2",  Tamanho.M, 27);

            System.out.println(sistema.pesquisaEstoqueRoupa("2"));

            System.out.println("depois: " + roupas.get("1").getQuantidade());

        } catch (RoupaJaExisteException | RoupaInexistenteException r) {
            r.printStackTrace();
        }

        assertTrue(sistema.existe("1"));
    }
}
