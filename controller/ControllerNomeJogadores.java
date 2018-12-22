/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.DAO.jogadorDAO;
import model.DAO.perguntaDAO;
import model.Jogador;
import model.Pergunta;
import view.NomeJogadores;
import view.PerguntaView;
import view.SelectNomeJogadores2;
import view.SelectNomeJogadores3;
import view.SelectNomeJogadores4;

/**
 *
 * @author andre
 */
public class ControllerNomeJogadores implements ActionListener {

    NomeJogadores NJ;
    jogadorDAO jogadorDAO;
    Pergunta pergunta = new Pergunta();
    perguntaDAO perguntaDAO = new perguntaDAO(); 
    SelectNomeJogadores2 selectNJ2;
    SelectNomeJogadores3 selectNJ3;
    SelectNomeJogadores4 selectNJ4;
    String selected = "";
    ArrayList<Pergunta> perguntas;
    ArrayList<Jogador> jogadores;

    public ControllerNomeJogadores(NomeJogadores nomeJ) {
        jogadorDAO = new jogadorDAO();
        perguntas = new ArrayList<>();
        jogadores = new ArrayList<>();
        this.NJ = nomeJ;
        this.NJ.btnAvanc.addActionListener(al2);
        this.NJ.CbQTDJog.addActionListener(al1);
        
    }

    ActionListener al1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (NJ.CbQTDJog == (JComboBox) ae.getSource()) {

                selected = NJ.CbQTDJog.getSelectedItem().toString();

                if (selected.equals("2")) {
                    selectNJ2 = new SelectNomeJogadores2();
                    NJ.DeskNJ.removeAll();
                    NJ.DeskNJ.add(selectNJ2);

                    ControllerNJSelect CNJSelect = new ControllerNJSelect(selectNJ2);
                } else if (selected.equals("3")) {
                    selectNJ3 = new SelectNomeJogadores3();
                    NJ.DeskNJ.removeAll();
                    NJ.DeskNJ.add(selectNJ3);

                    ControllerNJSelect CNJSelect = new ControllerNJSelect(selectNJ3);
                } else if (selected.equals("4")) {
                    selectNJ4 = new SelectNomeJogadores4();
                    NJ.DeskNJ.removeAll();
                    NJ.DeskNJ.add(selectNJ4);

                    ControllerNJSelect CNJSelect = new ControllerNJSelect(selectNJ4);
                }
            }
        }
    };
    ActionListener al2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (NJ.btnAvanc == ae.getSource()) {
                if (addJogador(selected)) {
                    NJ.setVisible(false);
                    
                    jogadores = jogadorDAO.buscaJogadores(selected);
                    int i=0;
                    int cont=0;
                    int pont=0;
                    PerguntaView pergunta = new PerguntaView();
                    pergunta.setExtendedState(6);
                    ControllerPergunta CPerg = new ControllerPergunta(pergunta,i,cont,selected,jogadores,pont);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Jogador não pode ser inserido");
                }
            }
        }

    };

    @Override
    public void actionPerformed(ActionEvent ae) {

    }
    

    
    public boolean addJogador(String selected) {
        boolean deuCerto = false;
        ArrayList<Jogador> jogadores = new ArrayList<>();

        switch (selected) {
            case "2": {
                Jogador jogador = new Jogador();
                jogador.setNome(this.selectNJ2.txtJogador2.getText());
                if (jogador.getNome().equals("")) {
                    return deuCerto = false;
                }

                jogadores.add(jogador);

                Jogador jogador2 = new Jogador();
                jogador2.setNome(this.selectNJ2.txtJogador1.getText());
                if (jogador2.getNome().equals("")) {
                    return deuCerto = false;
                }
                jogadores.add(jogador2);
                break;
            }
            case "3": {
                Jogador jogador = new Jogador();
                jogador.setNome(this.selectNJ3.txtJogador1.getText());
                if (jogador.getNome().equals("")) {
                    return deuCerto = false;
                }
                jogadores.add(jogador);

                Jogador jogador2 = new Jogador();
                jogador2.setNome(this.selectNJ3.txtJogador2.getText());
                if (jogador2.getNome().equals("")) {
                    return deuCerto = false;
                }
                jogadores.add(jogador2);

                Jogador jogador3 = new Jogador();
                jogador3.setNome(this.selectNJ3.txtJogador3.getText());
                if (jogador3.getNome().equals("")) {
                    return deuCerto = false;
                }
                jogadores.add(jogador3);
                break;
            }
            case "4": {
                Jogador jogador = new Jogador();
                jogador.setNome(this.selectNJ4.txtJogador1.getText());
                if (jogador.getNome().equals("")) {
                    return deuCerto = false;
                }
                jogadores.add(jogador);

                Jogador jogador2 = new Jogador();
                jogador2.setNome(this.selectNJ4.txtJogador2.getText());
                if (jogador2.getNome().equals("")) {
                    return deuCerto = false;
                }
                jogadores.add(jogador2);
                Jogador jogador3 = new Jogador();
                jogador3.setNome(this.selectNJ4.txtJogador4.getText());
                if (jogador3.getNome().equals("")) {
                    return deuCerto = false;
                }
                jogadores.add(jogador3);

                Jogador jogador4 = new Jogador();
                jogador4.setNome(this.selectNJ4.txtJogador3.getText());
                if (jogador4.getNome().equals("")) {
                    return deuCerto = false;
                }
                jogadores.add(jogador4);
                break;
            }
            default:
                break;
        }

        for (int i = 0; i < jogadores.size(); i++) {
            if (jogadorDAO.inserirJogador(jogadores.get(i))) {
                deuCerto = true;
            } else {
                deuCerto = false;
            }
        }
        return deuCerto;
    }
}
