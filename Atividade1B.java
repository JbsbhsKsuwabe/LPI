/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Atividade1;

/**
 *
 * @author joabe
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Atividade1B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Passo 1: Solicitar quantidade de registros
        System.out.print("Digite a quantidade de registros (nome e telefone) que deseja cadastrar: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();  // Consumir a nova linha após nextInt()

        // Passo 2: Entrada dos nomes e telefones
        Map<String, String> agenda = new HashMap<>();
        for (int i = 0; i < quantidade; i++) {
            System.out.print("Digite o nome " + (i + 1) + ": ");
            String nome = scanner.nextLine();
            System.out.print("Digite o telefone de " + nome + ": ");
            String telefone = scanner.nextLine();
            agenda.put(nome, telefone);
        }

        // Passo 3: Perguntar ao usuário o nome que deseja consultar
        System.out.print("Digite o nome da pessoa cujo telefone deseja consultar: ");
        String nomeConsulta = scanner.nextLine();

        // Passo 4: Validação e busca
        if (agenda.containsKey(nomeConsulta)) {
            // Passo 5: Exibir o telefone correspondente
            System.out.println("O telefone de " + nomeConsulta + " é: " + agenda.get(nomeConsulta));
        } else {
            // Caso o nome não exista na base de dados
            System.out.println("Nome inexistente na base de dados.");
        }

        scanner.close();
    }
}
