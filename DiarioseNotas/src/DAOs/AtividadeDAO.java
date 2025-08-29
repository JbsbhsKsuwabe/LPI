/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Atividade;

/**
 *
 * @author Orion
 */
public class AtividadeDAO {
    private final Connection conn;

    public AtividadeDAO(Connection conn) {
        this.conn = conn;
    }

    // Criar atividade
    public void criarAtividade(Atividade atividade) throws SQLException {
        String sql = "INSERT INTO atividades (titulo, descricao, prazo, concluida, categoria_id) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, atividade.getTitulo());
        stmt.setString(2, atividade.getDescricao());
        stmt.setDate(3, java.sql.Date.valueOf(atividade.getPrazo()));
        stmt.setBoolean(4, atividade.isConcluida());
        stmt.setInt(5, atividade.getCategoriaId());
        stmt.executeUpdate();
    }

    // Listar atividades de uma categoria
    public List<Atividade> listarAtividades(int categoriaId) throws SQLException {
        List<Atividade> lista = new ArrayList<>();
        String sql = "SELECT * FROM atividades WHERE categoria_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, categoriaId);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()) {
            Atividade a = new Atividade();
            a.setId(rs.getInt("id"));
            a.setTitulo(rs.getString("titulo"));
            a.setDescricao(rs.getString("descricao"));
            a.setPrazo(rs.getDate("prazo").toLocalDate());
            a.setConcluida(rs.getBoolean("concluida"));
            a.setCategoriaId(rs.getInt("categoria_id"));
            lista.add(a);
        }
        return lista;
    }

    // Editar atividade
    public void editarAtividade(Atividade atividade) throws SQLException {
        String sql = "UPDATE atividades SET titulo = ?, descricao = ?, prazo = ?, concluida = ?, categoria_id = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, atividade.getTitulo());
        stmt.setString(2, atividade.getDescricao());
        stmt.setDate(3, java.sql.Date.valueOf(atividade.getPrazo()));
        stmt.setBoolean(4, atividade.isConcluida());
        stmt.setInt(5, atividade.getCategoriaId());
        stmt.setInt(6, atividade.getId());
        stmt.executeUpdate();
    }

    // Apagar atividade
    public void apagarAtividade(int atividadeId) throws SQLException {
        String sql = "DELETE FROM atividades WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, atividadeId);
        stmt.executeUpdate();
    }

    // Buscar atividade pelo id
    public Atividade buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM atividades WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()) {
            Atividade a = new Atividade();
            a.setId(rs.getInt("id"));
            a.setTitulo(rs.getString("titulo"));
            a.setDescricao(rs.getString("descricao"));
            a.setPrazo(rs.getDate("prazo").toLocalDate());
            a.setConcluida(rs.getBoolean("concluida"));
            a.setCategoriaId(rs.getInt("categoria_id"));
            return a;
        }
        return null;
    }
}
