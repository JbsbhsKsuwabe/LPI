/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Atividade1;

/**
 *
 * @author joabe
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Atividade1A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Passo 1: Solicitar quantidade de nomes a serem cadastrados
        System.out.print("Digite a quantidade de nomes que deseja cadastrar: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();  // Consumir a nova linha após nextInt()

        // Passo 2: Entrada dos nomes
        ArrayList<String> nomes = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            System.out.print("Digite o nome " + (i + 1) + ": ");
            nomes.add(scanner.nextLine());
        }

        // Passo 3: Perguntar ao usuário o número do nome que deseja consultar
        System.out.print("Digite o número da posição do nome que deseja consultar: ");
        int posicao = scanner.nextInt();

        // Passo 4: Validação da posição
        if (posicao > 0 && posicao <= nomes.size()) {
            // Passo 5: Exibir o nome correspondente
            System.out.println("O nome na posição " + posicao + " é: " + nomes.get(posicao - 1));
        } else {
            // Caso de posição inválida
            System.out.println("Posição inválida! Deve ser um número entre 1 e " + nomes.size() + ".");
        }

        scanner.close();
    }
}
