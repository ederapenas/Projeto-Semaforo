package objetos;

public class Paciente{
    private String nome;
    private String doenca;
    private int grauDeRisco;

    private boolean atendido;

    public Paciente(String nome, String doenca, int grauDeRisco){
        this.nome = nome;
        this.doenca = doenca;
        this.grauDeRisco = grauDeRisco;
        this.atendido = false;
    }

    public String getNome() {
        return nome;
    }

    public String getDoenca() {
        return doenca;
    }

    public int getGrauDeRisco() {
        return grauDeRisco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    public void setGrauDeRisco(int grauDeRisco) {
        this.grauDeRisco = grauDeRisco;
    }

    public boolean isAtendido() {
        return atendido;
    }

    public void setAtendido(boolean atendido) {
        this.atendido = atendido;
    }
}
