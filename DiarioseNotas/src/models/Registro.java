/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.time.LocalDate;
/**
 *
 * @author Orion
 */
public class Registro {
    private int id;
    private String titulo;
    private String descricao;
    private LocalDate dataRegistro;
    private int categoriaId;

    public Registro() {}

    public Registro(String titulo, String descricao, LocalDate dataRegistro, int categoriaId) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataRegistro = dataRegistro;
        this.categoriaId = categoriaId;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public LocalDate getDataRegistro() { return dataRegistro; }
    public void setDataRegistro(LocalDate dataRegistro) { this.dataRegistro = dataRegistro; }

    public int getCategoriaId() { return categoriaId; }
    public void setCategoriaId(int categoriaId) { this.categoriaId = categoriaId; }
}

