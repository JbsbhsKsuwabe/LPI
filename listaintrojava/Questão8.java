/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package questão8;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author usuario
 */
public class Questão8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite a quantidade de números nos conjuntos:");
        int n = scanner.nextInt();
        
        Set<Integer> conjunto1 = new HashSet<>();
        Set<Integer> conjunto2 = new HashSet<>();
        
        System.out.println("Digite os números do segundo conjunto:");
        for (int i = 0; i < n; i++) {
            conjunto2.add(scanner.nextInt());
        }
         
        conjunto1.retainAll(conjunto2);
        
        System.out.println("Interseção dos conjuntos:"+ conjunto1);
        
        scanner.close();
    }
    
}
