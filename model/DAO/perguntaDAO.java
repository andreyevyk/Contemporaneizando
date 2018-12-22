/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Pergunta;

/**
 *
 * @author andre
 */
public class perguntaDAO {
       Conexao conexao;
       ArrayList<Pergunta> perguntas;
    
    public perguntaDAO(){
        perguntas = new ArrayList<>();
        conexao = new Conexao();
    }
       
    public ArrayList<Pergunta> buscarPerguntas() {
        try {
            String script = "select * from pergunta;";
            Connection con = conexao.conectar();
            PreparedStatement ps = con.prepareStatement(script);
            ResultSet rs = ps.executeQuery();
            Pergunta pergunta;
            while (rs.next()) {
                pergunta = new Pergunta();
                pergunta.setNumero(rs.getInt("numero"));
                pergunta.setTexto(rs.getString("texto"));
                pergunta.setRepostaCorreta(rs.getString("respCorreta"));
                perguntas.add(pergunta);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return perguntas;

    }
    
}
