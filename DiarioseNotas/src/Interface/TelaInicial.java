/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;
import DAOs.CategoriaDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.util.List;
import models.Categoria;
import models.Usuario;
/**
 *
 * @author Orion
 */

public class TelaInicial extends JFrame{
    private Connection conn;
    private Usuario usuario;
    private CategoriaDAO categoriaDAO;
    private JList<String> listaCategoria;

    public TelaInicial(Connection conn, Usuario usuario){
        this.conn=conn; this.usuario=usuario; this.categoriaDAO=new CategoriaDAO(conn);
        setTitle("Diário - "+usuario.getNome()); setSize(500,400); setLocationRelativeTo(null); setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents(); carregarCategoria();
    }

    private void initComponents(){
        JPanel painel = new JPanel(new BorderLayout());
        listaCategoria = new JList<>();
        painel.add(new JScrollPane(listaCategoria),BorderLayout.CENTER);

        JButton btnAdicionar = new JButton("Adicionar Categoria");
        btnAdicionar.addActionListener(e -> adicionarCategoria());
        JButton btnAbrirNotas = new JButton("Abrir Notas");
        btnAbrirNotas.addActionListener(e -> abrirNotas());
        JPanel botoes = new JPanel();
        botoes.add(btnAdicionar); botoes.add(btnAbrirNotas);
        painel.add(botoes,BorderLayout.SOUTH);
        JButton btnEditar = new JButton("Editar Categoria");
        btnEditar.addActionListener(e -> editarCategoriaSelecionada());

        JButton btnApagar = new JButton("Apagar Categoria");
        btnApagar.addActionListener(e -> apagarCategoriaSelecionada());
        botoes.add(btnAdicionar);
        botoes.add(btnAbrirNotas);
        botoes.add(btnEditar);
        botoes.add(btnApagar);
        painel.add(botoes, BorderLayout.SOUTH);


        add(painel);
    }

    private void carregarCategoria(){
        try{
            List<Categoria> categoria = categoriaDAO.listarCategoria(usuario.getId());
            DefaultListModel<String> model = new DefaultListModel<>();
            for(Categoria c : categoria) model.addElement(c.getNome());
            listaCategoria.setModel(model);
        } catch(Exception e){ e.printStackTrace();}
    }

    private void adicionarCategoria(){
        String nome = JOptionPane.showInputDialog("Nome da Categoria:");
        if(nome!=null && !nome.isEmpty()){
            try{ categoriaDAO.criarCategoria(new Categoria(nome,"",usuario.getId())); carregarCategoria(); }
            catch(Exception e){ e.printStackTrace();}
        }
    }

            private void abrirNotas(){
                int index = listaCategoria.getSelectedIndex();
                if(index>=0){
                    try{
                        List<Categoria> categoria = categoriaDAO.listarCategoria(usuario.getId());
                        Categoria c = categoria.get(index);
                        new TelaNotas(conn,usuario,c.getId()).setVisible(true);
                    } catch(Exception e){ e.printStackTrace();}
                } else JOptionPane.showMessageDialog(this,"Selecione uma categoria!");
            }
                        private void editarCategoriaSelecionada(){
            int index = listaCategoria.getSelectedIndex();
            if(index>=0){
                try{
                    List<Categoria> categoria = categoriaDAO.listarCategoria(usuario.getId());
                    Categoria c = categoria.get(index);
                    String novoNome = JOptionPane.showInputDialog(this, "Novo nome:", c.getNome());
                    if(novoNome!=null && !novoNome.isEmpty()){
                        c.setNome(novoNome);
                        categoriaDAO.editarCategoria(c);
                        carregarCategoria();
                    }
                } catch(Exception e){ e.printStackTrace();}
            } else JOptionPane.showMessageDialog(this,"Selecione uma categoria!");
        }

        private void apagarCategoriaSelecionada(){
            int index = listaCategoria.getSelectedIndex();
            if(index>=0){
                try{
                    List<Categoria> categoria = categoriaDAO.listarCategoria(usuario.getId());
                    Categoria c = categoria.get(index);
                    int confirm = JOptionPane.showConfirmDialog(this,"Deseja apagar a categoria "+c.getNome()+"?");
                    if(confirm==JOptionPane.YES_OPTION){
                        categoriaDAO.apagarCategoria(c.getId(), usuario.getId());
                        carregarCategoria();
                    }
                } catch(Exception e){ e.printStackTrace();}
            } else JOptionPane.showMessageDialog(this,"Selecione uma categoria!");
        }

}

