/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import ferramentas.Conexao;
import java.sql.ResultSet;
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
import models.Tenis;

/**
 *
 * @author vitoria.schneider
 */
public class TenisController {
    
    public Tenis buscar(int id) {
        try {
            Tenis objTenis = null;

            Conexao.abreConexao();
            ResultSet rs = null;
            PreparedStatement stmt;

            String wSql = "";
            wSql = " SELECT * ";
            wSql += " FROM tenis ";
            wSql += " WHERE id = ? ";

            try {
                System.out.println("Vai Executar Conexão em buscar Veiculos");
                stmt = Conexao.con.prepareStatement(wSql);
                stmt.setInt(1, id);

                rs = stmt.executeQuery();

                if (rs.next()) {
                    objTenis = new Tenis();
                    objTenis.setId(rs.getInt("id"));
                    objTenis.setModelo(rs.getString("modelo"));
                    objTenis.setTamanho(rs.getString("tamanho"));
                    objTenis.setAno_lancamento(rs.getString("ano_lancamento"));
                    objTenis.setCor(rs.getString("cor"));


                    return objTenis;
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

    public boolean verificaExistencia(Tenis objTenis) {
        try {
            Conexao.abreConexao();
            ResultSet rs = null;
            PreparedStatement stmt;

            String wSql = " SELECT * ";
            wSql += " FROM tenis ";
            wSql += " WHERE modelo = ? ";
            if(objTenis.getId() > 0){
                wSql += " AND id <> ? ";
            }

            System.out.println("Vai Executar Conexão em verificaExistencia Veiculo");
            stmt = Conexao.con.prepareStatement(wSql);
            stmt.setString(1, objTenis.getModelo());   
            if(objTenis.getId() > 0){
                stmt.setInt(2, objTenis.getId());   
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

    public boolean incluir(Tenis objTenis) {

        try {

            Conexao.abreConexao();
            PreparedStatement stmt = null;

            stmt = Conexao.con.prepareStatement("INSERT INTO tenis (modelo, tamanho, ano_lancamento,cor) VALUES(?,?,?,?)");
            stmt.setString(1, objTenis.getModelo());
            stmt.setString(2, objTenis.getTamanho());
            stmt.setString(3, objTenis.getAno_lancamento());
            stmt.setString(4, objTenis.getCor());
            

            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(Conexao.con);
        }

    }

    public void preencherLista(JTable jtbTenis) {

        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector();
        cabecalhos.add("Id");
        cabecalhos.add("Modelo");        
        cabecalhos.add("Tamanho");


        Conexao.abreConexao();
        ResultSet result = null;

        try {

            String sql = "";
            sql = "SELECT id, modelo, tamanho";
            sql += " FROM tenis ";
            sql += " ORDER BY modelo ";

            result = Conexao.stmt.executeQuery(sql);

            while (result.next()) {
                Vector<Object> linha = new Vector<Object>();
                linha.add(result.getInt("id"));
                linha.add(result.getString("modelo"));                
                linha.add(result.getString("tamanho"));

                dadosTabela.add(linha);
            }

        } catch (SQLException e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        jtbTenis.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        });

        // permite seleção de apenas uma linha da tabela
        jtbTenis.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < 3; i++) {
            column = jtbTenis.getColumnModel().getColumn(i);
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
        jtbTenis.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

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

    public boolean alterar(Tenis objTenis){
        
        Conexao.abreConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = Conexao.con.prepareStatement("UPDATE tenis SET modelo=?, tamanho=?, ano_lancamento=?, cor=? WHERE id=? ");
            stmt.setString(1, objTenis.getModelo());
            stmt.setString(2, objTenis.getTamanho());
            stmt.setString(3, objTenis.getAno_lancamento());
            stmt.setString(4, objTenis.getCor());
            stmt.setInt(5, objTenis.getId());
            
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
            stmt = con.prepareStatement("DELETE FROM tenis WHERE id=?");
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
