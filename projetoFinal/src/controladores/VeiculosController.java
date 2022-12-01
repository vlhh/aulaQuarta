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
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import models.Usuario;
import models.Veiculo;

/**
 *
 * @author vitoria.schneider
 */
public class VeiculosController {


    public Veiculo buscar(int id) {
        try {
            Veiculo objVeiculo = null;

            Conexao.abreConexao();
            ResultSet rs = null;
            PreparedStatement stmt;

            String wSql = "";
            wSql = " SELECT * ";
            wSql += " FROM usuarios ";
            wSql += " WHERE id = ? ";

            try {
                System.out.println("Vai Executar Conexão em buscar Usuario");
                stmt = Conexao.con.prepareStatement(wSql);
                stmt.setInt(1, id);

                rs = stmt.executeQuery();

                if (rs.next()) {
                    objVeiculo = new Veiculo();
                    objVeiculo.setId(rs.getInt("id"));
                    objVeiculo.setAno(rs.getString("ano"));
                    objVeiculo.setModelo(rs.getString("modelo"));
                    objVeiculo.setPlaca(rs.getString("placa"));


                    return objVeiculo;
                }

            } catch (SQLException ex) {
                System.out.println("ERRO de SQL: " + ex.getMessage().toString());
                return null;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage().toString());
            return null;
        }

        return null;

    }

    public boolean verificaExistencia(Veiculo objVeiculo) {
        try {
            Conexao.abreConexao();
            ResultSet rs = null;
            PreparedStatement stmt;

            String wSql = " SELECT * ";
            wSql += " FROM objVeiculo ";
            wSql += " WHERE modelo = ? ";
            if(objVeiculo.getId() > 0){
                wSql += " AND id <> ? ";
            }

            System.out.println("Vai Executar Conexão em verificaExistencia Usuario");
            stmt = Conexao.con.prepareStatement(wSql);
            stmt.setString(1, objVeiculo.getModelo());   
            if(objVeiculo.getId() > 0){
                stmt.setInt(2, objVeiculo.getId());   
            }

            rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println("ERRO de SQL: " + ex.getMessage());
            return false;
        } catch (Exception ex) {
            System.out.println("ERRO: " + ex.getMessage());
            return false;
        }

        return false;

    }

    public boolean incluir(Veiculo objVeiculo) {

        try {

            Conexao.abreConexao();
            PreparedStatement stmt = null;

            stmt = Conexao.con.prepareStatement("INSERT INTO veiculos (modelo, placa, ano, ) VALUES(?,?,?)");
            stmt.setString(1, objVeiculo.getModelo());
            stmt.setString(2, objVeiculo.getPlaca());
            stmt.setString(3, objVeiculo.getAno());

            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(Conexao.con);
        }

    }

    public void preencherLista(JTable jtbVeiculos) {

        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector();
        cabecalhos.add("Id");
        cabecalhos.add("Modelo");        
        cabecalhos.add("Placa");


        Conexao.abreConexao();
        ResultSet result = null;

        try {

            String sql = "";
            sql = "SELECT id, modelo, placa ";
            sql += " FROM veiculos ";
            sql += " ORDER BY modelo ";

            result = Conexao.stmt.executeQuery(sql);

            while (result.next()) {
                Vector<Object> linha = new Vector<Object>();
                linha.add(result.getInt("id"));
                linha.add(result.getString("modelo"));                
                linha.add(result.getString("placa"));

                dadosTabela.add(linha);
            }

        } catch (SQLException e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        jtbVeiculos.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        });

        // permite seleção de apenas uma linha da tabela
        jtbVeiculos.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < 3; i++) {
            column = jtbVeiculos.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(80);
                    break;
                case 1:
                    column.setPreferredWidth(180);
                    break;
                case 2:
                    column.setPreferredWidth(150);
                    break;
            }
        }
        jtbVeiculos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
                if (row % 2 == 0) {
                    setBackground(Color.LIGHT_GRAY);
                } else {
                    setBackground(Color.WHITE);
                }
                return this;
            }
        });
        //return (true);
    }

    public boolean alterar(Usuario objUsuario){
        
        Conexao.abreConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = Conexao.con.prepareStatement("UPDATE usuarios SET nome=?, usuario=?, senha=md5(?), telefone=?, email=? WHERE id=? ");
            stmt.setString(1, objUsuario.getNome());
            stmt.setString(2, objUsuario.getUsuario());
            stmt.setString(3, objUsuario.getSenha());
            stmt.setString(4, objUsuario.getTelefone());
            stmt.setString(5, objUsuario.getEmail());
            stmt.setInt(6, objUsuario.getId());
            
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.closeConnection(Conexao.con);
        }
        
    }
    
    public boolean excluir(int id){
        
        Conexao.abreConexao();
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM usuarios WHERE id=?");
            stmt.setInt(1, id);//1º?
                        
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.closeConnection(con, stmt);
        }
        
    }
    
}
