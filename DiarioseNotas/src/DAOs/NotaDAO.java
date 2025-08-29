/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

/**
 *
 * @author Orion
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Nota;

public class NotaDAO {
    private Connection conn;

    public NotaDAO(Connection conn) {
        this.conn = conn;
    }

    // Criar nota
    public void criarNota(Nota nota) throws SQLException {
        String sql = "INSERT INTO notas (titulo, conteudo, data, categoria_id, usuario_id) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nota.getTitulo());
        stmt.setString(2, nota.getConteudo());
        stmt.setDate(3, java.sql.Date.valueOf(nota.getData()));
        stmt.setInt(4, nota.getCategoriaId());
        stmt.setInt(5, nota.getUsuarioId());
        stmt.executeUpdate();
    }

    // Listar notas de uma categoria e usuário
    public List<Nota> listarNotas(int categoriaId, int usuarioId) throws SQLException {
        List<Nota> lista = new ArrayList<>();
        String sql = "SELECT * FROM notas WHERE categoria_id = ? AND usuario_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, categoriaId);
        stmt.setInt(2, usuarioId);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Nota n = new Nota();
            n.setId(rs.getInt("id"));
            n.setTitulo(rs.getString("titulo"));
            n.setConteudo(rs.getString("conteudo"));
            n.setData(rs.getDate("data").toLocalDate());
            n.setCategoriaId(rs.getInt("categoria_id"));
            n.setUsuarioId(rs.getInt("usuario_id"));
            lista.add(n);
        }
        return lista;
    }

    // Editar nota
        public void editarNota(Nota n) throws SQLException {
    String sql = "UPDATE notas SET titulo=?, conteudo=?, data=?, categoria_id=? WHERE id=? AND usuario_id=?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, n.getTitulo());
    stmt.setString(2, n.getConteudo());
    stmt.setDate(3, java.sql.Date.valueOf(n.getData()));
    stmt.setInt(4, n.getCategoriaId());
    stmt.setInt(5, n.getId());
    stmt.setInt(6, n.getUsuarioId());
    stmt.executeUpdate();
}

    // Apagar nota
        public void apagarNota(int notaId, int usuarioId) throws SQLException {
    String sql = "DELETE FROM notas WHERE id=? AND usuario_id=?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setInt(1, notaId);
    stmt.setInt(2, usuarioId);
    stmt.executeUpdate();
}

}

