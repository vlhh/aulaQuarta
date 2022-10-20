/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade_dia28_09;

/**
 *
 * @author vitoria.schneider
 */
public class CadastroUsuarios {
    
    private String nome;
    private String sobrenome;
    private String email;
    private String cidade;

    public CadastroUsuarios(String nome, String sobrenome, String email, String cidade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.cidade = cidade;
    }

    public CadastroUsuarios() {
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "CadastroUsuarios{" + "nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", cidade=" + cidade + '}';
    }
    
}
