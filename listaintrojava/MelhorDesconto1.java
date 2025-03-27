/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package listaintrojava;

import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class MelhorDesconto1 {

   public static double calcularCriterioA(int quantidadeLivros) {
        return 0.25* quantidadeLivros + 7.50;
}
 public static double calcularCriterioB(int quantidadeLivros){
        return 0.50* quantidadeLivros + 2.50;
    }
    public static void main(String[]args){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite a quantidade de livros que deseja comprar:");
            int quantidadeLivros = scanner.nextInt();
            
            double descontoA = calcularCriterioA(quantidadeLivros);
            double descontoB = calcularCriterioB(quantidadeLivros);
            
            if(descontoA<descontoB){
                System.out.printf("O Criterio A e mais vantajoso! Desconto total: R$ %.2f\n", descontoA);
            }else if (descontoB<descontoA){
                System.out.printf("O Criterio B e mais vantajoso! Desconto total: R$ %.2f\n", descontoB);
            } else { System.out.printf("Ambos os criterios oferecem o mesmo desconto total: R$ %.2f\n", descontoA);
            }
        }
        }
    }