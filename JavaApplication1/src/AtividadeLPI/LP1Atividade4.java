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
public class LP1Atividade4 {

    public static void main(String args[]) {

        int i, k = 0;

        i = Integer.parseInt(JOptionPane.showInputDialog("Insira o valor"));
        if(i < 0){
            JOptionPane.showMessageDialog(null, "Inválido");
        } else {
        while (i > 0) {
            i = i / 10;
            k++;
         }
        }
        JOptionPane.showMessageDialog(null, "Contem " + k + " digitos.");

    }
}
