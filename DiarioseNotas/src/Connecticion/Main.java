/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connecticion;
import DAOs.CategoriaDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import models.Categoria;

/**
 *
 * @author Orion
 */
public class Main {
    public static void main(String[] args) {
        Connection conn = (Connection) ConexaoBD.getConnection();
        
        if(conn != null) {
            System.out.println("Conectado ao banco com sucesso!");

            try {
                // Criar DAO de categorias
                CategoriaDAO categoriaDAO = new CategoriaDAO((java.sql.Connection) conn);

                // Criar nova categoria
                Categoria c = new Categoria("Projetos", "Projetos pessoais", 1);
                categoriaDAO.criarCategoria(c);

                // Listar categorias
                for(Categoria cat : categoriaDAO.listarCategoria(1)){
                    System.out.println(cat.getNome() + " - " + cat.getDescricao());
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try { conn.close(); } catch (Exception ex) {}
            }
        }
    }
}
