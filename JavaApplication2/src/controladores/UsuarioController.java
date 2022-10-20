/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import ferramentas.Conexao;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
//import model.Usuario;

/**
 *
 * @author jonas
 */
public class UsuarioController {
    
    //Usuario objUsuario;
    //JTable jtbUsuarios = null;
    
    //public UsuarioDAO(Usuario objUsuario, JTable jtbUsuarios) {
    //    this.objUsuario = objUsuario;
    //    this.jtbUsuarios = jtbUsuarios;
    //}
    
    public boolean login(String user, String pass)
    {
        try {
            Conexao.abreConexao();
            ResultSet rs;
            PreparedStatement stmt;

            String wSql = "SELECT id FROM usuarios WHERE login = ? AND senha = md5(?)";
            
            wSql = " SELECT nome ";
            wSql += " FROM usuarios ";
            wSql += " WHERE login = ?";
            wSql += " AND senha = md5(?)";
            //stm.executeQuery(wSql);

            try{
                System.out.println("Vai Executar Conexão em buscar Usuario");
                stmt = Conexao.con.prepareStatement(wSql);
                stmt.setString(1, user);
                stmt.setString(2, pass);
                System.out.println("Executou Conexão em buscar Usuario");

                //objUsuario = new Usuario();
                /*
                if(rs.next() == true) //caso exista pelo menos um registro
                {
                    return true;
                }else{
					return false;
				}
                */
                rs = stmt.executeQuery();
                return rs.next();
                
            }

            catch (SQLException ex )
            {
                System.out.println("ERRO de SQL: " + ex.getMessage().toString());
                return false;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage().toString());
            return false;
        }
		
    }
}
