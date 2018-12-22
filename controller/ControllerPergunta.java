/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import model.DAO.RespostaDAO;
import model.DAO.jogadorDAO;
import model.DAO.perguntaDAO;
import model.Jogador;
import model.Pergunta;
import model.Resposta;
import model.Resposta_Selecionada;
import view.PerguntaView;
import view.RespostaView;

/**
 *
 * select resposta.texto from resposta inner join resposta_selecionada on
 * resposta.id=resposta_selecionada.resposta_id where
 * resposta_selecionada.correta=1;
 *
 */
public class ControllerPergunta implements MouseListener {

    PerguntaView pergunta;
    perguntaDAO perguntaDAO;

    jogadorDAO jogadorDAO;
    RespostaDAO respostaDAO;
    Resposta resposta;
    Resposta_Selecionada RS;

    ArrayList<Jogador> jogadores;
    ArrayList<Pergunta> perguntas;
    ArrayList<Resposta> respostas;

    int it;
    int contp;
    String select;
    int pontuacao;

    public ControllerPergunta(PerguntaView perg, int i, int j, String selected, ArrayList<Jogador> players, int pont) {

        jogadorDAO = new jogadorDAO();
        perguntaDAO = new perguntaDAO();
        respostaDAO = new RespostaDAO();
        RS = new Resposta_Selecionada();

        perguntas = new ArrayList<>();
        jogadores = new ArrayList<>();
        jogadores = new ArrayList<>();

        jogadores = players;
        pergunta = perg;
        select = selected;
        pontuacao = pont;

        jogadores = jogadorDAO.buscaJogadores(select);
        perguntas = perguntaDAO.buscarPerguntas();

        it = i;
        contp = j;

        instaciarTela();
    }
    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (this.pergunta.txtResposta1 == me.getSource()) {
            pergunta.setVisible(false);
            RS.setIdJogador(jogadores.get(contp).getId());
            RS.setIdResposta(respostas.get(0).getId());

            if (pergunta.txtResposta1.getText().equals(perguntas.get(it).getRepostaCorreta())) {
                pontuacao++;
                RS.setCorreta(1);
            } else {
                RS.setCorreta(0);
            }
            respostaDAO.inserirRespostasSelec(RS);

            if (jogadores.size() > contp) {
                if (it < perguntas.size() - 1) {

                    PerguntaView pergunta = new PerguntaView();
                    pergunta.setExtendedState(6);
                    it++;
                    ControllerPergunta CPerg = new ControllerPergunta(pergunta, it, contp, select, jogadores, pontuacao);
                } else {
                    jogadores.get(contp).setPontuacao(pontuacao);
                    jogadorDAO.inserirPontuacao(jogadores.get(contp));
                    contp++;
                    if (contp > Integer.parseInt(select) - 1) {
                        pergunta.setVisible(false);
                        RespostaView resp = new RespostaView();
                        resp.setVisible(true);
                        int nSelected = Integer.parseInt(select);

                        ControllerResposta controllerResposta = new ControllerResposta(resp,nSelected);
                    } else {
                        pontuacao = 0;
                        it = 0;
                        PerguntaView pergunta = new PerguntaView();
                        pergunta.setExtendedState(6);

                        ControllerPergunta CPerg = new ControllerPergunta(pergunta, it, contp, select, jogadores, pontuacao);
                    }
                }
            }

        } else if (this.pergunta.txtResposta2 == me.getSource()) {
            pergunta.setVisible(false);

            RS.setIdJogador(jogadores.get(contp).getId());
            RS.setIdResposta(respostas.get(1).getId());

            if (pergunta.txtResposta2.getText().equals(perguntas.get(it).getRepostaCorreta())) {
                pontuacao++;
                RS.setCorreta(1);
            } else {
                RS.setCorreta(0);
            }
            respostaDAO.inserirRespostasSelec(RS);

            if (jogadores.size() > contp) {
                if (it < perguntas.size() - 1) {
                    PerguntaView pergunta = new PerguntaView();
                    pergunta.setExtendedState(6);

                    it++;
                    ControllerPergunta CPerg = new ControllerPergunta(pergunta, it, contp, select, jogadores, pontuacao);
                } else {
                    jogadores.get(contp).setPontuacao(pontuacao);
                    jogadorDAO.inserirPontuacao(jogadores.get(contp));
                    contp++;
                    if (contp > Integer.parseInt(select) - 1) {
                        RespostaView resp = new RespostaView();
                        pergunta.setVisible(false);
                        resp.setVisible(true);
                        
                        int nSelected = Integer.parseInt(select);
                        ControllerResposta controllerResposta = new ControllerResposta(resp,nSelected);

                    } else {
                        pontuacao = 0;
                        it = 0;
                        PerguntaView pergunta = new PerguntaView();
                        pergunta.setExtendedState(6);

                        ControllerPergunta CPerg = new ControllerPergunta(pergunta, it, contp, select, jogadores, pontuacao);
                    }
                }
            }

        } else if (this.pergunta.txtResposta3 == me.getSource()) {
            pergunta.setVisible(false);
            RS.setIdJogador(jogadores.get(contp).getId());
            RS.setIdResposta(respostas.get(2).getId());

            if (pergunta.txtResposta3.getText().equals(perguntas.get(it).getRepostaCorreta())) {
                pontuacao++;
                RS.setCorreta(1);
            } else {
                RS.setCorreta(0);
            }
            respostaDAO.inserirRespostasSelec(RS);
            if (jogadores.size() > contp) {
                if (it < perguntas.size() - 1) {
                    PerguntaView pergunta = new PerguntaView();
                    pergunta.setExtendedState(6);

                    it++;
                    ControllerPergunta CPerg = new ControllerPergunta(pergunta, it, contp, select, jogadores, pontuacao);
                } else {
                    jogadores.get(contp).setPontuacao(pontuacao);
                    jogadorDAO.inserirPontuacao(jogadores.get(contp));
                    contp++;

                    if (contp > Integer.parseInt(select) - 1) {
                        RespostaView resp = new RespostaView();
                        pergunta.setVisible(false);
                        resp.setVisible(true);
                        int nSelected = Integer.parseInt(select);
                        
                        ControllerResposta controllerResposta = new ControllerResposta(resp,nSelected);

                    } else {
                        pontuacao = 0;
                        it = 0;
                        PerguntaView pergunta = new PerguntaView();
                        pergunta.setExtendedState(6);
                        ControllerPergunta CPerg = new ControllerPergunta(pergunta, it, contp, select, jogadores, pontuacao);
                    }
                }
            }
        } else if (this.pergunta.txtResposta4 == me.getSource()) {
            pergunta.setVisible(false);
            RS.setIdJogador(jogadores.get(contp).getId());
            RS.setIdResposta(respostas.get(3).getId());

            if (this.pergunta.txtResposta4.getText().equalsIgnoreCase(this.perguntas.get(it).getRepostaCorreta())) {
                pontuacao++;
                RS.setCorreta(1);
            } else {
                RS.setCorreta(0);
            }
            respostaDAO.inserirRespostasSelec(RS);

            if (jogadores.size() > contp) {
                if (it < perguntas.size() - 1) {
                    PerguntaView pergunta = new PerguntaView();
                    pergunta.setExtendedState(6);

                    it++;
                    ControllerPergunta CPerg = new ControllerPergunta(pergunta, it, contp, select, jogadores, pontuacao);
                } else {
                    jogadores.get(contp).setPontuacao(pontuacao);
                    jogadorDAO.inserirPontuacao(jogadores.get(contp));
                    contp++;

                    if (contp > Integer.parseInt(select) - 1) {
                        RespostaView resp = new RespostaView();
                        resp.setExtendedState(6);
                        pergunta.setVisible(false);                       
                        resp.setVisible(true);
                        int nSelect = Integer.parseInt(select);
                        ControllerResposta controllerResposta = new ControllerResposta(resp, nSelect);

                    } else {
                        pontuacao = 0;
                        it = 0;
                        PerguntaView pergunta = new PerguntaView();
                        pergunta.setExtendedState(6);
                        ControllerPergunta CPerg = new ControllerPergunta(pergunta, it, contp, select, jogadores, pontuacao);
                    }
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me
    ) {
    }

    @Override
    public void mouseExited(MouseEvent me
    ) {
    }

    public void salvaResposta() {

    }

    public void instaciarTela() {

        pergunta.setVisible(true);

        this.pergunta.txtResposta1.addMouseListener(this);
        this.pergunta.txtResposta2.addMouseListener(this);
        this.pergunta.txtResposta3.addMouseListener(this);
        this.pergunta.txtResposta4.addMouseListener(this);

        this.pergunta.txtNome.setText(jogadores.get(contp).getNome());
        this.pergunta.txtAreaPergunta.setText(addText(perguntas, it));
        this.pergunta.numberQuestion.setText(addNumber(it));
        addRespostas();

        this.pergunta.txtAreaPergunta.setFont(new Font("Trebuchet MS", 0, 22));
        this.pergunta.txtResposta1.setBorder(null);
        this.pergunta.txtResposta2.setBorder(null);
        this.pergunta.txtResposta3.setBorder(null);
        this.pergunta.txtResposta4.setBorder(null);
    }

    public void addRespostas() {
        respostas = respostaDAO.buscaResposta(perguntas.get(it).getNumero());
        this.pergunta.txtResposta1.setText(respostas.get(0).getTexto());
        this.pergunta.txtResposta2.setText(respostas.get(1).getTexto());
        this.pergunta.txtResposta3.setText(respostas.get(2).getTexto());
        this.pergunta.txtResposta4.setText(respostas.get(3).getTexto());
    }

    public String addText(ArrayList<Pergunta> perg, int i) {

        return perguntas.get(i).getTexto();
    }

    public String addNumber(int i) {
        int number = perguntas.get(i).getNumero();

        return String.valueOf(number);
    }
}
