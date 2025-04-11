/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aula0404;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
/**
 *
 * @author aluno
 */
public class principal {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
         System.out.print("Quantos funcionários deseja cadastrar? ");
         int quantidade = scanner.nextInt();
         scanner.nextLine();
         
        for (int i = 0; i < quantidade; i++){
            System.out.println("\nFuncionário " + (i + 1) + ":");
            System.out.print("CPF: ");
            String cpf = scanner.next();
            System.out.print("Nome: ");
            String nome = scanner.next();
            System.out.print("Salário: ");
            Double salario = scanner.nextDouble();
            System.out.print("Data de Admissão (dd/MM/yyyy): ");
            String dataString = scanner.next();
            Date dataadm = null;
            
            try {
                dataadm = dateFormat.parse(dataString);
            } catch (ParseException e) {
                System.out.println("Formato de data inválido!");
                return;
            }
            
            Funcionario funcionario = new Funcionario(cpf, nome, salario, dataadm);
            funcionarios.add(funcionario);
        }
        
        System.out.println("\nLista de Funcionários: ");
        for (Funcionario f : funcionarios){
            System.out.println(f.getCpf() + "\n" + f.getNome() + "\n" + f.getSalario() + "\n" + dateFormat.format(f.getDataadm()) + "\n");
        }
        
        double somaSalarios = 0;
        for (Funcionario f : funcionarios){
            somaSalarios += f.getSalario();
        }
        
        double mediaSalarial = somaSalarios / funcionarios.size();
        System.out.println("\nMédia Salarial: R$ " + mediaSalarial);
        
        System.out.println("Quantidade de funcionários cadastrados: " + funcionarios.size());
        
        scanner.close();
        
    }
}
