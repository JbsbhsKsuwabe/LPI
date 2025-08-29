/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;
import Connecticion.ConexaoBD;
import java.sql.Connection;
/**
 *
 * @author Orion
 */
public class Main {
    public static void main(String[] args) {
        Connection conn = ConexaoBD.getConnection();
        if (conn != null) {
            new Login(conn); // abre tela de login/criação de conta
        } else {
            System.out.println("Falha na conexão com o banco!");
        }
    }
}

