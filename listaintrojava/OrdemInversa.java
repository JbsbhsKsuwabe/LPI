/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaintrojava;
import java.util.Scanner;

public class OrdemInversa {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[] numeros = new int[10];
            
            // Leitura dos números
            for (int i = 0; i < 10; i++) {
                System.out.print("Digite o número " + (i + 1) + ": ");
                numeros[i] = scanner.nextInt();
            }
            
            // Exibição na ordem inversa
            System.out.println("Números na ordem inversa:");
            for (int i = 9; i >= 0; i--) {
                System.out.println(numeros[i]);
            }
        }
    }
}
