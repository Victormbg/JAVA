package br.com.adv.curso.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexao {
    private Connection con;
    
    public Connection getConexao(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager
                         .getConnection("jdbc:mysql://localhost:3306/cursojava",
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
       try{
        con.close();   
       }catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"Erro "+ex.getMessage());
       }
        
        
        
        
    }
}