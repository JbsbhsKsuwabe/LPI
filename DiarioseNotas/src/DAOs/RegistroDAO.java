/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Registro;
/**
 *
 * @author Orion
 */
public class RegistroDAO {
    private Connection conn;

    public RegistroDAO(Connection conn) {
        this.conn = conn;
    }

    // Criar registro
    public void criarRegistro(Registro registro) throws SQLException {
        String sql = "INSERT INTO registros (titulo, descricao, data_registro, categoria_id) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, registro.getTitulo());
        stmt.setString(2, registro.getDescricao());
        stmt.setDate(3, java.sql.Date.valueOf(registro.getDataRegistro()));
        stmt.setInt(4, registro.getCategoriaId());
        stmt.executeUpdate();
    }

    // Listar registros de uma categoria
    public List<Registro> listarRegistros(int categoriaId) throws SQLException {
        List<Registro> lista = new ArrayList<>();
        String sql = "SELECT * FROM registros WHERE categoria_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, categoriaId);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Registro r = new Registro();
            r.setId(rs.getInt("id"));
            r.setTitulo(rs.getString("titulo"));
            r.setDescricao(rs.getString("descricao"));
            r.setDataRegistro(rs.getDate("data_registro").toLocalDate());
            r.setCategoriaId(rs.getInt("categoria_id"));
            lista.add(r);
        }
        return lista;
    }

    // Editar registro
    public void editarRegistro(Registro registro) throws SQLException {
        String sql = "UPDATE registros SET titulo = ?, descricao = ?, data_registro = ?, categoria_id = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, registro.getTitulo());
        stmt.setString(2, registro.getDescricao());
        stmt.setDate(3, java.sql.Date.valueOf(registro.getDataRegistro()));
        stmt.setInt(4, registro.getCategoriaId());
        stmt.setInt(5, registro.getId());
        stmt.executeUpdate();
    }

    // Apagar registro
    public void apagarRegistro(int registroId) throws SQLException {
        String sql = "DELETE FROM registros WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, registroId);
        stmt.executeUpdate();
    }

    // Buscar registro pelo id
    public Registro buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM registros WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()) {
            Registro r = new Registro();
            r.setId(rs.getInt("id"));
            r.setTitulo(rs.getString("titulo"));
            r.setDescricao(rs.getString("descricao"));
            r.setDataRegistro(rs.getDate("data_registro").toLocalDate());
            r.setCategoriaId(rs.getInt("categoria_id"));
            return r;
        }
        return null;
    }
}

