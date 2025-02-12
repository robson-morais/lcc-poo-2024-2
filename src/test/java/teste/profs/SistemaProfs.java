package teste.profs;
import exercicios.profs.Dia;
import exercicios.profs.Horario;
import exercicios.profs.Sistema;
import org.junit.jupiter.api.Test;
import exercicios.profs.exceptions.DisciplinaJaExisteE;
import exercicios.profs.exceptions.ProfessorInexistenteE;
import exercicios.profs.exceptions.ProfessorJaExisteE;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.LinkedList;

public class SistemaProfs {

    private Sistema sistema;

    @Test
    public void testaCadastroProfs(){

        this.sistema = new Sistema();

        try {
            //i)
            sistema.cadastraProfessor(111, "José");
            //ii)
            List<String> disciplinasDeJose = sistema.consultaNomesDisciplinasDoProfessor(111);
            assertTrue(disciplinasDeJose.size()==0);
            assertEquals(0, disciplinasDeJose.size());
            //iii)
            List<Horario> horariosDisciplina = new LinkedList<>();
            Horario horarioAula1 = new Horario(Dia.TERCA, 10, 12);
            horariosDisciplina.add(horarioAula1);
            Horario horarioAula2 = new Horario(Dia.TERCA, 13, 15);
            horariosDisciplina.add(horarioAula2);
            sistema.cadastraDisciplina("POO", 22, 111, horariosDisciplina);

            //iv)
            List<String> disciplinasDeJoseDepois = sistema.consultaNomesDisciplinasDoProfessor(111);
            assertEquals(1, disciplinasDeJoseDepois.size());
            assertTrue(disciplinasDeJoseDepois.get(0).equals("POO"));

            //v)

            List <Horario> horariosJose = sistema.consultaHorariosDeAulaDoProfessor(111);
            assertEquals(2, horariosJose.size());
            Horario primeiroHorario= horariosJose.get(0);
            Horario segundoHorario = horariosJose.get(1);
            assertEquals(horarioAula1, primeiroHorario);
            assertEquals(horarioAula2, segundoHorario);
            assertTrue(horariosJose.get(0).getDia()== Dia.TERCA);
            assertTrue(horariosJose.get(1).getDia()== Dia.TERCA);
            assertTrue(horariosJose.get(0).getHoraInicio()==10);
            assertTrue(horariosJose.get(0).getHoraFim()==12);
            assertTrue(horariosJose.get(1).getHoraInicio()==13);
            assertTrue(horariosJose.get(1).getHoraFim()==15);
        } catch (ProfessorJaExisteE | DisciplinaJaExisteE | ProfessorInexistenteE e){
            e.printStackTrace();
            fail("Exceção não esperada");
        }
    }


}