/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listaintrojava;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Questão7 {

public class ConsultaTelefone {
    public static void main(String[] args) {
        // Criando o HashMap para armazenar os nomes e telefones
        try (Scanner scanner = new Scanner(System.in)) {
            // Criando o HashMap para armazenar os nomes e telefones
            HashMap<String, String> telefoneMap = new HashMap<>();
            
            // Perguntando a quantidade de contatos a ser registrada
            System.out.print("Quantos contatos você deseja registrar? ");
            int quantidade = scanner.nextInt();
            scanner.nextLine();  // Consumir o '\n' após o nextInt
            
            // Leitura dos nomes e telefones
            for (int i = 0; i < quantidade; i++) {
                System.out.print("Digite o nome da pessoa: ");
                String nome = scanner.nextLine();
                System.out.print("Digite o telefone de " + nome + ": ");
                String telefone = scanner.nextLine();
                
                // Armazenando no mapa
                telefoneMap.put(nome, telefone);
            }
            
            // Perguntando o nome para consulta
            System.out.print("Digite o nome que você deseja consultar o telefone: ");
            String nomeConsulta = scanner.nextLine();
            
            // Verificando e mostrando o telefone ou se não encontrado
            if (telefoneMap.containsKey(nomeConsulta)) {
                System.out.println("O telefone de " + nomeConsulta + " é: " + telefoneMap.get(nomeConsulta));
            } else {
                System.out.println("Nome não encontrado no banco de dados.");
            }
        }
    }
}

    
}
