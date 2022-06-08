package main;

import objetos.Hospital;
import objetos.Medico;
import objetos.Paciente;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        LinkedList<Paciente> ordemPacientes = new LinkedList<Paciente>();
        Medico medico = new Medico("Renato");
        Hospital hospital = new Hospital(medico);
        int op;
        do{
            System.out.println("Informe o nome do paciente: ");
            String nome = inputString.nextLine();
            System.out.println("Informe a doença do paciente: ");
            String doenca = inputString.nextLine();
            System.out.println("Informe o grau de risco (1 a 5)");
            int grauDeRisco = input.nextInt();
            while(grauDeRisco < 1 || grauDeRisco > 5){
                System.out.println("Valor inválido, informe um grau de risco entre 1 e 5!");
                grauDeRisco = input.nextInt();
            }
            Paciente paciente = new Paciente(nome, doenca, grauDeRisco);
            hospital.addPacientes(paciente);
            menu();
            op = input.nextInt();
            while(op < 0 || op > 1){
                System.out.println("Valor inválido, digite 0 para não e 1 para sim.");
                op = input.nextInt();
            }
        }while(op != 0);

        for(int i = 0; i < hospital.tamanhoFila(); i++){
            hospital.run();
        }
    }


    public static void menu(){
        System.out.println("Deseja criar mais um paciente?");
        System.out.println("1 - Sim.");
        System.out.println("0 - Não.");
    }
}