/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaintrojava;

import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class ReajustedeSalario {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            double[] salarios = new double[5];

            for (int i = 0; i < 5; i++) {
                System.out.print("Digite o salário " + (i + 1) + "; ");
                salarios[i] = scanner.nextDouble();
            }

            System.out.print("Digite o percentual de reajuste (ex: 10 para 10%): ");
            double reajuste = scanner.nextDouble() / 100;

            for (int i = 0; i < 5; i++) {
                salarios[i] += salarios[i] * reajuste;
            }
            System.out.println("Salários reajustados:");
            for (double salario : salarios) {
                System.out.printf("R$ %.2f\n", salario);
            }
        }
    }
}
