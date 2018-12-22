/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class Resposta_Selecionada {
    private int id;
    private int idJogador;
    private int idResposta;
    private int correta;

    public int getId() {
        return id;
    }

    public int getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(int idJogador) {
        this.idJogador = idJogador;
    }

    public int getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(int idResposta) {
        this.idResposta = idResposta;
    }

    public int isCorreta() {
        return correta;
    }

    public void setCorreta(int correta) {
        if(correta==1||correta==0){
           this.correta=correta;
        }
        else{
            System.out.println("Numero inserido invalido");
        }
    }
    
    
}
