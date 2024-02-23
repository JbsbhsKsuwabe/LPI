/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AtividadeLPI;

import javax.swing.JOptionPane;

/**
 *
 * @author joabe
 */
public class LP1Atividade2 {
public static void main(String args[]) {
    
    int book;
    float a, b;
    
    book = Integer.parseInt(JOptionPane.showInputDialog("Quantos Livros Comprara? "));
    a = (book * 0.25F) + 7.50F;
    b = (book * 0.50F) + 2.50F;
    
    if(a <= b){
        JOptionPane.showMessageDialog(null, "A opção A tem melhor desconto " + a);
    } else {
        JOptionPane.showMessageDialog(null, "A opção B tem melhor desconto " + b);
    
    }
    System.exit(0);
    }
}

    
