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
import model.Resposta;
import model.Resposta_Selecionada;

/**
 *
 * @author andre
 */
public class RespostaDAO {
    Conexao conexao;
    ArrayList<Resposta> respostas;
    ArrayList<Resposta_Selecionada> respostasSelecionadas;

    
    public RespostaDAO(){
        conexao = new Conexao();
        respostas = new ArrayList<>();
        respostasSelecionadas = new ArrayList<>();
    }
    public boolean inserirRespostasSelec(Resposta_Selecionada RS){
        boolean deuCerto;
        try{
            String script="Insert into resposta_selecionada(jogador_id,resposta_id,correta) values(?,?,?)";
            Connection con = conexao.conectar();
            PreparedStatement ps = con.prepareStatement(script);
            ps.setInt(1, RS.getIdJogador());
            ps.setInt(2, RS.getIdResposta());
            ps.setInt(3, RS.isCorreta());
            ps.execute();
            deuCerto = true;
            ps.close();
        }catch(Exception e){
            System.out.println("Error: "+ e.getMessage());
            deuCerto = false;
        }
        return deuCerto;
    }
    
    public ArrayList<Resposta_Selecionada> buscaRespostaSelec(int selected){
        try{
                String script="Select * from resposta_selecionada order by id DESC limit "+selected;
                Connection con = conexao.conectar();
                PreparedStatement ps = con.prepareStatement(script);
                ResultSet rs = ps.executeQuery();
                Resposta_Selecionada respostaSelec;
                while(rs.next()){
                    respostaSelec = new Resposta_Selecionada();
                    respostaSelec.setIdJogador(rs.getInt("jogador_id"));
                    respostaSelec.setIdResposta(rs.getInt("resposta_id"));
                    respostaSelec.setCorreta(rs.getInt("correta"));
                    respostasSelecionadas.add(respostaSelec);
                }
                ps.close();
                }catch(Exception e){
                System.out.println("Error: "+e.getMessage());
                }
        return respostasSelecionadas;
    }
    
    public ArrayList<Resposta> buscaResposta(){
        try{
            String script="Select * from resposta";
            Connection con = conexao.conectar();
            PreparedStatement ps = con.prepareStatement(script);
            ResultSet rs = ps.executeQuery();
            Resposta resposta;
            while(rs.next()){
                resposta = new Resposta();
                resposta.setId(rs.getInt("id"));
                resposta.setTexto(rs.getString("texto"));
                resposta.setIdPergunta(rs.getInt("pergunta_id"));
                respostas.add(resposta);
            }
            ps.close();
            }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
            }
        return respostas;
    }
    public ArrayList<Resposta> buscaResposta(int idPergunta){
        try{
            String script="SELECT * FROM resposta where pergunta_id="+idPergunta;
            Connection con = conexao.conectar();
            PreparedStatement ps = con.prepareStatement(script);
            ResultSet rs = ps.executeQuery();
            Resposta resposta;
            while(rs.next()){
                resposta = new Resposta();
                resposta.setId(rs.getInt("id"));
                resposta.setTexto(rs.getString("texto"));
                resposta.setIdPergunta(rs.getInt("pergunta_id"));
                respostas.add(resposta);
            }
            ps.close();
            }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
            }
        return respostas;
    }
  
    
   
}
