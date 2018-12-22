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
import model.Jogador;

/**
 *
 * @author andre
 */
public class jogadorDAO {
    Conexao conexao;
    ArrayList<Jogador> jogadores; 
    
    public jogadorDAO(){
        conexao = new Conexao();
        jogadores = new ArrayList<>();
    }
    public boolean inserirPontuacao(Jogador jogador){
        boolean deuCerto;
        try{
           String script = "update jogador set pontuacao=? where id=?";
           Connection con = conexao.conectar();
           PreparedStatement ps = con.prepareStatement(script);
           ps.setInt(1,jogador.getPontuacao());
           ps.setInt(2, jogador.getId());
           ps.execute();
           deuCerto = true;
           ps.close();
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            deuCerto = false;
        }
        return deuCerto;
    }
    public boolean inserirJogador(Jogador jogador) {
        boolean deuCerto;
        try {
            String script = "insert into jogador(nome,pontuacao) values (?,?);";
            Connection con = conexao.conectar();
            PreparedStatement ps = con.prepareStatement(script);
            ps.setString(1, jogador.getNome());
            ps.setInt(2, jogador.getPontuacao());
            ps.execute();
            deuCerto = true;
            ps.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            deuCerto = false;
        }
        return deuCerto;
    }
    public ArrayList<Jogador> buscaJogadores(String qtdJogadores){
        try{
            String qtdjogadores = String.valueOf(qtdJogadores);            
            String script = "select * from jogador order by id desc limit "+qtdjogadores+";";
            Connection con = conexao.conectar();

            PreparedStatement ps =con.prepareStatement(script);
            ResultSet rs= ps.executeQuery();
            Jogador jogador;
            while(rs.next()){
                jogador = new Jogador();
                jogador.setId(rs.getInt("id"));
                jogador.setNome(rs.getString("nome"));
                jogador.setPontuacao(rs.getInt("pontuacao"));
                
                jogadores.add(jogador);
            }
            ps.close();
        }catch(Exception e){
            System.out.println("error: "+e.getMessage());
        }
        return jogadores;
    }
 
       
    
}
