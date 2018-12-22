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
public class Pergunta {
    private int numero;
    private String texto;
    private String repostaCorreta;
    
    public String getRepostaCorreta() {
        return repostaCorreta;
    }

    public void setRepostaCorreta(String repostaCorreta) {
        this.repostaCorreta = repostaCorreta;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
}
