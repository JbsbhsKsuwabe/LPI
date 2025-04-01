/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Escola;

import java.util.Scanner;

/**
 *
 * @author Orion
 */
public class principal {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a matrícula do aluno: ");
        int matricula = scanner.nextInt();

        // Criar o objeto Aluno
        Aluno aluno = new Aluno(nome, matricula);

        System.out.print("Digite a nota da P1: ");
        float p1 = scanner.nextFloat();

        System.out.print("Digite a nota da P2: ");
        float p2 = scanner.nextFloat();

        System.out.print("Digite a nota do trabalho: ");
        float trabalho = scanner.nextFloat();

        // Atribuir as notas ao aluno
        aluno.setP1(p1);
        aluno.setP2(p2);
        aluno.setTrabalho(trabalho);

        // Calcular a média e verificar aprovação
        float media = aluno.calcularmedia();
        boolean aprovado = aluno.aprovacao(media);

        // Exibir resultados
        System.out.println("\nDados do Aluno:");
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Matrícula: " + aluno.getMatricula());
        System.out.println("Média: " + media);
        System.out.println("Aprovado: " + (aprovado ? "Sim" : "Não"));

        // Fechar o scanner
        scanner.close();
    }
}