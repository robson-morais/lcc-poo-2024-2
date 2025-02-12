package exercicios.profs;

public class Horario {

    private int horaInicio;
    private int horaFim;
    private Dia dia;

    public Horario(Dia dia, int horaInicio, int horaFim){
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public int getHoraInicio() {
        return this.horaInicio;
    }

    public int getHoraFim() {
        return this.horaFim;
    }

    public Dia getDia() {
        return this.dia;
    }
}