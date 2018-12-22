/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qualogolpe;

import controller.ControllerInicio;
import java.util.ArrayList;
import model.DAO.Conexao;
import model.DAO.jogadorDAO;
import model.DAO.perguntaDAO;
import model.Jogador;
import model.Pergunta;
import view.Inicio;

/**
 *
 * @author andre
 */
public class QualoGolpe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Inicio inicio = new Inicio();
        inicio.setExtendedState(6);
        inicio.setVisible(true);
        
        ControllerInicio ci = new ControllerInicio(inicio);
        
        
        

    }
    
}
