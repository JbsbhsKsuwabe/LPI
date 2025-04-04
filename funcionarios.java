/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aula0404;
import java.util.Date;
/**
 *
 * @author aluno
 */
public class funcionarios {
    private String cpf;
    private String nome;
    private double salario;
    private Date dataadm;
    
    public funcionarios(String cpf, String nome, double,Date dataadm){
        this.cpf = cpf;
        this.nome = nome;
        this.salario = salario;
        this.dataadm = dataadm;
    }
    
    public String getCpf(){
        return cpf;
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public double getSalario(){
        return salario;
    }
    
    public void setSalario(double salario){
        this.salario = salario;
    }
    
    public Date getDataadm(){
        return dataadm;
    }
    
    public void setDataadm(double dataadm){
        this.dataadm = dataadm;
    }
    
    
}
