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
public class LP1Atividade1 {
public static void main(String args[]) {

        
        
    int n1, n2, n3, media;

n1 =Integer.parseInt(JOptionPane.showInputDialog("Entre com a primeira nota"));
n2 =Integer.parseInt(JOptionPane.showInputDialog("Entre com a segunda nota"));
n3 =Integer.parseInt(JOptionPane.showInputDialog("Entre com a terceira nota"));

media =(n1 + n2 + n3) / 3;

if(media >= 7){
JOptionPane.showMessageDialog(null, "A media é: " + media);
} else {
  int rec, nf;
  rec =Integer.parseInt(JOptionPane.showInputDialog("Entre com a nota da Recuperação"));
  
  nf =(media + rec) / 2;
  if(nf >= 5){
     JOptionPane.showMessageDialog(null, "A sua nota final foi: " + nf + " Você Passou!");   
  } else {
      JOptionPane.showMessageDialog(null, "Você foi Reprovado");
  }
}
System.exit(0);

    }
}

    
