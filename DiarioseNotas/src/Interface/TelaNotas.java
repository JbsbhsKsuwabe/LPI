/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;
import DAOs.NotaDAO;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;
import java.sql.*;
import models.Nota;
import models.Usuario;
/**
 *
 * @author Orion
 */
public class TelaNotas extends JFrame {
    private NotaDAO notaDAO;
    private Usuario usuario;
    private int categoriaId;
    private JList<String> listaNotas;

    public TelaNotas(Connection conn, Usuario usuario, int categoriaId) {
        this.usuario = usuario;
        this.categoriaId = categoriaId;
        this.notaDAO = new NotaDAO(conn);

        setTitle("Notas da Categoria");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initComponents();
        carregarNotas();
    }

    private void initComponents() {
        JPanel painel = new JPanel(new BorderLayout());

        listaNotas = new JList<>();
        painel.add(new JScrollPane(listaNotas), BorderLayout.CENTER);

        JButton btnAdicionar = new JButton("Adicionar Nota");
        btnAdicionar.addActionListener(e -> adicionarNota());
        painel.add(btnAdicionar, BorderLayout.SOUTH);
        JButton btnEditar = new JButton("Editar Nota");
        btnEditar.addActionListener(e -> editarNotaSelecionada());

        JButton btnApagar = new JButton("Apagar Nota");
        btnApagar.addActionListener(e -> apagarNotaSelecionada());
                
        JButton btnVisualizar = new JButton("Visualizar Nota");
        btnVisualizar.addActionListener(e -> visualizarNotaSelecionada());

        JPanel botoes = new JPanel();
        botoes.add(btnAdicionar);
        botoes.add(btnEditar);
        botoes.add(btnApagar);
        botoes.add(btnVisualizar);
        painel.add(botoes, BorderLayout.SOUTH);


        add(painel);
    }

    private void carregarNotas() {
        try {
            List<Nota> notas = notaDAO.listarNotas(categoriaId, usuario.getId());
            DefaultListModel<String> model = new DefaultListModel<>();
            for (Nota n : notas) {
                model.addElement(n.getTitulo() + " - " + n.getData());
            }
            listaNotas.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void adicionarNota() {
        String titulo = JOptionPane.showInputDialog("Título da nota:");
        String conteudo = JOptionPane.showInputDialog("Conteúdo da nota:");

        if (titulo != null && !titulo.isEmpty()) {
            try {
                Nota nota = new Nota(titulo, conteudo, LocalDate.now(), categoriaId, usuario.getId());
                notaDAO.criarNota(nota);
                carregarNotas();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private void editarNotaSelecionada(){
            int index = listaNotas.getSelectedIndex();
            if(index>=0){
                try{
                    List<Nota> notas = notaDAO.listarNotas(categoriaId, usuario.getId());
                    Nota n = notas.get(index);
                    String novoTitulo = JOptionPane.showInputDialog(this, "Novo título:", n.getTitulo());
                    String novoConteudo = JOptionPane.showInputDialog(this, "Novo conteúdo:", n.getConteudo());
                    if(novoTitulo!=null && !novoTitulo.isEmpty()){
                        n.setTitulo(novoTitulo); n.setConteudo(novoConteudo);
                        n.setData(LocalDate.now());
                        notaDAO.editarNota(n);
                        carregarNotas();
                    }
                } catch(Exception e){ e.printStackTrace();}
            } else JOptionPane.showMessageDialog(this,"Selecione uma nota!");
        }

        private void apagarNotaSelecionada(){
            int index = listaNotas.getSelectedIndex();
            if(index>=0){
                try{
                    List<Nota> notas = notaDAO.listarNotas(categoriaId, usuario.getId());
                    Nota n = notas.get(index);
                    int confirm = JOptionPane.showConfirmDialog(this,"Deseja apagar a nota "+n.getTitulo()+"?");
                    if(confirm==JOptionPane.YES_OPTION){
                        notaDAO.apagarNota(n.getId(), usuario.getId());
                        carregarNotas();
                    }
                } catch(Exception e){ e.printStackTrace();}
            } else JOptionPane.showMessageDialog(this,"Selecione uma nota!");
        }

        private void visualizarNotaSelecionada(){
            int index = listaNotas.getSelectedIndex();
            if(index>=0){
                try{
                    List<Nota> notas = notaDAO.listarNotas(categoriaId, usuario.getId());
                    Nota n = notas.get(index);
                    JOptionPane.showMessageDialog(this, "Título: "+n.getTitulo()+"\nData: "+n.getData()+"\n\nConteúdo:\n"+n.getConteudo());
                } catch(Exception e){ e.printStackTrace();}
            } else JOptionPane.showMessageDialog(this,"Selecione uma nota!");
        }
}


