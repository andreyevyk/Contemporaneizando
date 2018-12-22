/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author andre
 */
public class Jogador implements Comparable<Jogador> {
    private int id;
    private String nome;
    private int pontuacao;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
   
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int compareTo(Jogador o) {
        if(this.pontuacao>o.getPontuacao()){
            return -1;
        }
        if(this.pontuacao<o.getPontuacao()){
            return 1;
        }
        return 0;
    }

    
    

    
    
    
}
