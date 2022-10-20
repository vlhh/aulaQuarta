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
public class LoginUsuario {
    
    private String usuario;
    private String senha;

    public LoginUsuario() {
    }
    
    public LoginUsuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "loginUsuario{" + "usuario=" + usuario + ", senha=" + senha + '}';
    }
    
    
    
    
    
}
