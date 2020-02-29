/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adv.curso.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author 391151520171
 */
public class Conexao {
    private Connection con;
    
    public Connection getConexao(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager
                         .getConnection("jdbc:mysql://localhost:3306/boletim",
                                        "root",
                                        "");
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro Cmdo SQL " +
                        ex.getMessage()
                         );
        } catch (ClassNotFoundException ex) {
                 JOptionPane.showMessageDialog(null, "Driver não Encontrado " 
                         + ex.getMessage() );
        }
        
        return con;
    }
    
    public void fecharConexao(){
       // con.close();
    }
}
