package objetos;

import java.util.LinkedList;

public class Hospital extends Thread{
    private LinkedList<Paciente> filaPacientes;
    private Medico medico;

    public Hospital(Medico medico){
        filaPacientes = new LinkedList<Paciente>();
        this.medico = medico;
    }

    public void addPacientes(Paciente paciente){
        this.filaPacientes.addLast(paciente);
    }

    public int tamanhoFila(){
        return this.filaPacientes.size();
    }

    @Override
    public void run() {
        Paciente atual = filaPacientes.pollFirst();
        do{
            if(medico.getDisponibilidade()==1){
                medico.setDisponibilidade(0);
                medico.atendePaciente(atual);
                try {
                    sleep(atual.getGrauDeRisco() * 1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                medico.trataPaciente(atual);
                medico.setDisponibilidade(1);
            }else{
                try {
                    System.out.println(atual.getNome() + ", o médico " + medico.getNome() + " está ocupado no momento, por favor aguarde!");
                    sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }while(!atual.isAtendido());
    }
}
