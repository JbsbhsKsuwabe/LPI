/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connecticion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Orion
 */
public class ConexaoBD {
    private static final String URL = "jdbc:mysql://localhost:3306/diario_pessoal?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root"; // seu usuário do MySQL
    private static final String PASS = "4301"; // sua senha do MySQL

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
            return null;
        }
    }
}
