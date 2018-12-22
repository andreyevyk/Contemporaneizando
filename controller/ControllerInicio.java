/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Inicio;
kko,o,
import view.NomeJogadores;

/**
 *
 * @author andre
 */
public class ControllerInicio implements ActionListener {
    Inicio inicio;
    
    public ControllerInicio(Inicio ini){
        inicio=ini;
        inicio.btnComecar.addActionListener(this);
        inicio.setExtendedState(6);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(this.inicio.btnComecar==ae.getSource()){
            NomeJogadores nomeJ = new NomeJogadores();    
           if(this.inicio.getExtendedState() == 6){
               nomeJ.setExtendedState(6);
               nomeJ.setVisible(true);
           }else{
               nomeJ.setVisible(true);
           }
           ControllerNomeJogadores CNJ = new ControllerNomeJogadores(nomeJ);
           inicio.setVisible(false);
        }
    }
}
