package exercicios.profs;

import exercicios.profs.exceptions.DisciplinaInexistenteE;
import exercicios.profs.exceptions.DisciplinaJaExisteE;
import exercicios.profs.exceptions.ProfessorInexistenteE;
import exercicios.profs.exceptions.ProfessorJaExisteE;

import java.util.List;

public interface ProfInterface {
    public List<Horario> consultaHorariosDeAulaDoProfessor(int matriculaProf)
            throws ProfessorInexistenteE;
    public List <String> consultaNomesDisciplinasDoProfessor(int matriculaProf);
    public void cadastraProfessor(int matriculaProf, String nome)
            throws ProfessorJaExisteE;
    public void cadastraDisciplina(String nomeDisciplina, int codigoDisciplina,
                                   int matriculaProfessor, List<Horario> horarios) throws
            DisciplinaJaExisteE;
    public Disciplina pesquisaDisciplina(int codigoDisciplina) throws
            DisciplinaInexistenteE;
    public Professor pesquisaProfessor(int matriculaProfessor) throws
            ProfessorInexistenteE;
}
