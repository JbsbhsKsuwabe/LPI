/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Categoria;
/**
 *
 * @author Orion
 */
public class CategoriaDAO {
    private Connection conn;

    public CategoriaDAO(Connection conn) {
        this.conn = conn;
    }

    // Criar categoria
    public void criarCategoria(Categoria categoria) throws SQLException {
        String sql = "INSERT INTO categoria (nome, descricao, usuario_id) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, categoria.getNome());
        stmt.setString(2, categoria.getDescricao());
        stmt.setInt(3, categoria.getUsuarioId());
        stmt.executeUpdate();
    }

    // Listar categoria de um usuário
    public List<Categoria> listarCategoria(int usuarioId) throws SQLException {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categoria WHERE usuario_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, usuarioId);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Categoria c = new Categoria();
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setDescricao(rs.getString("descricao"));
            c.setUsuarioId(rs.getInt("usuario_id"));
            lista.add(c);
        }
        return lista;
    }

    // Editar categoria
        public void editarCategoria(Categoria c) throws SQLException {
    String sql = "UPDATE categoria SET nome=?, descricao=? WHERE id=? AND usuario_id=?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, c.getNome());
    stmt.setString(2, c.getDescricao());
    stmt.setInt(3, c.getId());
    stmt.setInt(4, c.getUsuarioId());
    stmt.executeUpdate();
}

    // Apagar categoria
        public void apagarCategoria(int categoriaId, int usuarioId) throws SQLException {
    String sql = "DELETE FROM categoria WHERE id=? AND usuario_id=?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setInt(1, categoriaId);
    stmt.setInt(2, usuarioId);
    stmt.executeUpdate();
}


    // Buscar categoria pelo id
    public Categoria buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM categoria WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()) {
            Categoria c = new Categoria();
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setDescricao(rs.getString("descricao"));
            c.setUsuarioId(rs.getInt("usuario_id"));
            return c;
        }
        return null; // se não encontrar
    }
}
