/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Escola;
/**
 *
 * @author Orion
 */
public class Aluno {
        private final int matricula;
        private final String nome;
        private float p1, p2, trabalho;
    /**
     * @param nome
     * @param matricula
     */
    public Aluno(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;    
    }
       public float calcularmedia(){
       float media = (float) ((p1*2.5 + p2*2.5 + trabalho*2)/7);
       return media;
       }
       public boolean aprovacao(float media){
       if (media >= 6) {
       return true;
       } else {
       return false;
       }
    }
        public void setP1(float p1) {
        this.p1 = p1;
    }

    public void setP2(float p2) {
        this.p2 = p2;
    }

    public void setTrabalho(float trabalho) {
        this.trabalho = trabalho;
    }

    // Getters para os dados do aluno
    public String getNome() {
        return nome;
    }

    public int getMatricula() {
        return matricula;
    }
}

           
