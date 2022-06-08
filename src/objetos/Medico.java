package objetos;

import java.util.concurrent.TimeUnit;

public class Medico {
    private String nome;
    private int disponibilidade;

    public Medico(String nome){
        this.nome = nome;
        this.disponibilidade = 1;
    }

    public void setDisponibilidade(int disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public int getDisponibilidade() {
        return disponibilidade;
    }

    public String getNome() {
        return nome;
    }

    public void atendePaciente(Paciente paciente){
        System.out.println("O medico: " + this.nome + " está atendendo o paciente: " + paciente.getNome() + " que está sofrendo de: " + paciente.getDoenca());
    }

    public void trataPaciente(Paciente paciente){
        System.out.println("O medico: " + this.nome + " está atendendo o paciente: " + paciente.getNome() + " que estava sofrendo de: " + paciente.getDoenca());
        paciente.setAtendido(true);
    }
}
