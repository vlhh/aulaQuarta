/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula04;

/**
 *
 * @author vitoria.schneider
 */
public class Pessoa {
    private String nome;
    private String cidade;
    private int idade;
    private boolean aluno;

    public Pessoa() {
    }

    public Pessoa(String nome, String cidade, int idade, boolean aluno) {
        this.nome = nome;
        this.cidade = cidade;
        this.idade = idade;
        this.aluno = aluno;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isAluno() {
        return aluno;
    }

    public void setAluno(boolean aluno) {
        this.aluno = aluno;
    }
    
    @Override
    public String toString(){
        return "Pessoa{" + "nome=" + nome + ", cidade=" + cidade+ ", idade=" + idade + ", aluno=" + aluno +'}' ;
    }
    
    
    
    /*public void modificarNome(String texto){
        this.nome = texto;
    }
    
    public void modificarCidade(String textoCidade){
        this.cidade = textoCidade;
    }
    
    public void modificarIdade(int textoIdade){
        this.idade = textoIdade;
    }
    
    public void modificarAluno(boolean TextoAluno){
        aluno = TextoAluno;
    }
   
    
    
    public String retornaNome(){
        return nome;
    }
    public String retonaCidade(){
        return cidade;
    }
    
    public int retornaIdade(){
        return idade;
    }
    
    public boolean retonarAluno(){
        return aluno; 
    
    }
    public String imprimir() {
        return "Cliente:"+ nome + ", cidade:" + cidade + ", idade:" +idade ;
    }
    
    */
    
    
    
}
