package main;

import java.util.concurrent.Semaphore;
import java.util.Scanner;

public class Main {

    static Semaphore semaforo = new Semaphore(3);

    static class Paciente extends Thread{
        String nome;
        Paciente(String nome){
            this.nome = nome;
        }

        public void run(){
            try{
                System.out.println("O numero de atendimentos disponiveis para " + nome + " é de: " + semaforo.availablePermits());
                System.out.println(nome + " está esperando para ser atendido");
                semaforo.acquire();
                System.out.println(nome + " irá ser atendido!");

                try{
                    System.out.println(nome + " está sendo atendido nesse exato momento! Numero de atendimentos disponiveis: " + semaforo.availablePermits());
                    Thread.sleep(3000);
                }finally {
                    System.out.println(nome + " foi atendido com sucesso!");
                    semaforo.release();
                    System.out.println("Numero de atendimentos disponiveis :" + semaforo.availablePermits());
                }
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Informe o numero de pacientes que você deseja ter: ");
        int numeroPacientes = input.nextInt();
        while(numeroPacientes <= 0){
            System.out.println("Por favor, informe um numero maior que 0: ");
            numeroPacientes = input.nextInt();
        }

        for(int i = 0; i < numeroPacientes; i++){
            String nome = "Paciente " + i;
            Paciente paciente = new Paciente(nome);
            paciente.start();
        }
    }
        
}