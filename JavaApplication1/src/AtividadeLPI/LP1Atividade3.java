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
public class LP1Atividade3 {

    public static void main(String args[]) {

        int h, m, s, H, M, S;
        int hs, ms, HS, MS, hourF, hourD;
        int hf = 0, mf = 0, sf = 0;
        int hd = 0, md = 0, sd = 0;

        h = Integer.parseInt(JOptionPane.showInputDialog("Insira as horas iniciais"));
        m = Integer.parseInt(JOptionPane.showInputDialog("Insira os minutos iniciais"));
        while (m > 59) {
            m = Integer.parseInt(JOptionPane.showInputDialog("Insira os minutos iniciais novamente"));
        }
        s = Integer.parseInt(JOptionPane.showInputDialog("Insira os segundos iniciais"));
        while (s > 59) {
            s = Integer.parseInt(JOptionPane.showInputDialog("Insira os segundos iniciais novamente"));
        }
        H = Integer.parseInt(JOptionPane.showInputDialog("Insira as horas finais"));
        M = Integer.parseInt(JOptionPane.showInputDialog("Insira os minutos finais"));
        while (M > 59) {
            M = Integer.parseInt(JOptionPane.showInputDialog("Insira os minutos iniciais novamente"));
        }
        S = Integer.parseInt(JOptionPane.showInputDialog("Insira os segundos finais"));
        while (S > 59) {
            S = Integer.parseInt(JOptionPane.showInputDialog("Insira os segundos iniciais novamente"));
        }

        hs = h * 3600;
        ms = m * 60;
        HS = H * 3600;
        MS = M * 60;

        hourF = (hs + ms + s) + (HS + MS + S);
        hourD = (hs + ms + s) - (HS + MS + S);
        hf = hourF / 3600;
        mf = hourF % 3600 / 60;
        sf = hourF % 3600 % 60;
        hd = hourD / 3600;
        md = hourD % 3600 / 60;
        sd = hourD % 3600 % 60;

        JOptionPane.showMessageDialog(null, "A soma dos intervalos é: " + hf + ":" + mf + ":" + sf);
        JOptionPane.showMessageDialog(null, "A diferença dos intervalos é: " + hd + ":" + md + ":" + sd);

    }
}
