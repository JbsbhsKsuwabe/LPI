/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listaintrojava;
import java.util.Scanner;
/**
 *
 * @author aluno
 */
public class MediaAluno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try ( // TODO code application logic here:
                Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite a nota da Prova 1: ");
            double p1 = scanner.nextDouble();
            
            System.out.print("Digite a nota da Prova 2: ");
            double p2 = scanner.nextDouble();
            
            System.out.print("Digite a nota da Prova 3: ");
            double p3 = scanner.nextDouble();
            
            double media = (p1 + p2 + p3) / 3;
            System.out.printf("Média: %.2f\n", media);
            
            if (media >= 7.0){
                System.out.println("Aprovado!");
            } else {
                System.out.print("Digite a nota da recuperação: ");
                double rec = scanner.nextDouble();
                
                double mediafinal = (media + rec) / 2;
                System.out.printf("Media Final: %.2f\n", mediafinal);
                if (mediafinal >=5.0) {
                    System.out.println("Aprovado na recuperação!");
                } else {
                    System.out.println("Reprovado");
                }
            }
        }
    }
}
