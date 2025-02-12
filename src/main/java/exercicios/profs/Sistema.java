package exercicios.profs;

import exercicios.profs.exceptions.DisciplinaInexistenteE;
import exercicios.profs.exceptions.DisciplinaJaExisteE;
import exercicios.profs.exceptions.ProfessorInexistenteE;
import exercicios.profs.exceptions.ProfessorJaExisteE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sistema implements ProfInterface {

    private Map <Integer, Professor> professores = new HashMap<>();
    private Map <Integer, Disciplina> disciplinas = new HashMap<>();


    @Override
    public List<Horario> consultaHorariosDeAulaDoProfessor(int matriculaProf) throws ProfessorInexistenteE {

        List<Horario> horarios = new ArrayList<>();

        if (this.professores.containsKey(matriculaProf)) {
            for (Disciplina d: this.disciplinas.values()) {
                if (d.getMatriculaProfessor() == matriculaProf) {
                    horarios = d.getHorarios();
                }
            }
        } else {
            throw new ProfessorInexistenteE("Professor não cadastrado");
        }
        return horarios;
    }


    @Override
    public List<String> consultaNomesDisciplinasDoProfessor(int matriculaProf) {
        List<String> nomesDisciplinas = new ArrayList<>();

        if (this.professores.containsKey(matriculaProf)) {
            for (Disciplina d: this.disciplinas.values()) {
                if (d.getMatriculaProfessor() == matriculaProf) {
                    nomesDisciplinas.add(d.getNome());
                }
            }

        } return nomesDisciplinas;
    }

    @Override
    public void cadastraProfessor(int matriculaProf, String nome) throws ProfessorJaExisteE {
        if (this.professores.containsKey(matriculaProf)) {
            throw new ProfessorJaExisteE("Professor já cadastrado");
        } else {
            this.professores.put(matriculaProf, new Professor(nome, matriculaProf));
        }
    }

    @Override
    public void cadastraDisciplina(String nomeDisciplina, int codigoDisciplina, int matriculaProfessor, List<Horario> horarios) throws DisciplinaJaExisteE {
        if (!this.disciplinas.containsKey(codigoDisciplina)) {
            this.disciplinas.put(codigoDisciplina, new Disciplina(nomeDisciplina, codigoDisciplina, matriculaProfessor, horarios));
        } else {
            throw new DisciplinaJaExisteE("Disciplina já cadastrada");
        }
    }

    @Override
    public Disciplina pesquisaDisciplina(int codigoDisciplina) throws DisciplinaInexistenteE {
        Disciplina disciplina = this.disciplinas.get(codigoDisciplina);
        if (disciplina == null){
            throw new DisciplinaInexistenteE("Disciplina não cadastrada no sistema");
        } else {
            return disciplina;
        }
    }

    @Override
    public Professor pesquisaProfessor(int matriculaProfessor) throws ProfessorInexistenteE {
        Professor professor = this.professores.get(matriculaProfessor);
        if (professor == null) {
            throw new ProfessorInexistenteE("Professor não cadastrado no sistema");
        } else {
            return professor;
        }
    }
}
