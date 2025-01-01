package teste.multimidia;


import aulas.multimidia.Filme;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FilmeTest {

    @Test
    public void testaConstrutor() {
        Filme filme1 = new Filme("Titanic", 120,1998);
        assertTrue(filme1.getTitulo().equals("Titanic"));
        assertEquals(120,filme1.getDuracao());
        assertEquals(1998,filme1.getAnoLancamento());
    }
}
