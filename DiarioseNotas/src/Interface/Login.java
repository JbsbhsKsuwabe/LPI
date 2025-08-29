/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;
import DAOs.UsuarioDAO;
import javax.swing.*;
import java.sql.Connection;
import models.Usuario;

/**
 *
 * @author Orion
 */
public class Login {
    private Connection conn;
    private UsuarioDAO usuarioDAO;

    public Login(Connection conn) {
        this.conn = conn;
        this.usuarioDAO = new UsuarioDAO(conn);
        mostrarTelaLogin();
    }

    private void mostrarTelaLogin() {
        String[] opcoes = {"Login", "Criar Conta"};
        int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Diário Pessoal",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha == 0) {
            // Login
            String email = JOptionPane.showInputDialog("Email:");
            String senha = JOptionPane.showInputDialog("Senha:");
            try {
                Usuario usuario = usuarioDAO.login(email, senha);
                if (usuario != null) {
                    JOptionPane.showMessageDialog(null, "Bem-vindo, " + usuario.getNome() + "!");
                    new TelaInicial(conn, usuario).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Login inválido!");
                    mostrarTelaLogin();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Criar Conta
            String nome = JOptionPane.showInputDialog("Nome:");
            String email = JOptionPane.showInputDialog("Email:");
            String senha = JOptionPane.showInputDialog("Senha:");
            try {
                usuarioDAO.criarUsuario(nome, email, senha);
                JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");
                mostrarTelaLogin();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

