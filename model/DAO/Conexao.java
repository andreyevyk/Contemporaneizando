/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author aluno
 */
public class Conexao {
    
    Connection conexao;
    
    public Connection conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://localhost:3306/qualogolpe";
            String usuario = "root";
            String senha = "garrido11";
            return (Connection)DriverManager.getConnection(servidor, usuario, senha);
        }catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
         return null;   
    }
    
}
