/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Dimension;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import model.DAO.RespostaDAO;
import model.DAO.jogadorDAO;    
import model.DAO.perguntaDAO;
import model.Jogador;
import model.Pergunta;
import model.Resposta_Selecionada;
import view.ColorirTabela;
import view.RespostaView;

/**
 *
 * @author andre
 */
public class ControllerResposta {
    RespostaView respostaView;
    ColorirTabela colTabela;
    
    
    int selected;
    jogadorDAO jogadorDAO;
    
    RespostaDAO respDAO;
    perguntaDAO pergDAO;
    
    ArrayList<Jogador> jogadores;
    ArrayList<Resposta_Selecionada> respSelect;
    ArrayList<Pergunta> perguntas;
    
    public ControllerResposta(RespostaView resp,int select){
        respostaView = resp;
        selected=select;
        colTabela = new ColorirTabela();
        
        pergDAO = new perguntaDAO();

        respDAO = new RespostaDAO();
        jogadorDAO = new jogadorDAO();
        
        perguntas = new ArrayList<>();
        jogadores = new ArrayList<>();
        respSelect = new ArrayList<>();
        
        preencheTabela();
        respostaView.tabela.setDefaultRenderer(Object.class, colTabela);
        mudarCaracTabela();
        
        setPontuacao();
       
   
        
    }
   
    public void preencheTabela(){
        
        DefaultTableModel tabela = new DefaultTableModel();
        jogadores = jogadorDAO.buscaJogadores(String.valueOf(selected));        
        tabela.addColumn("");
        for(int i=jogadores.size();i>0;i--){
            tabela.addColumn(jogadores.get(i-1).getNome());
        }
        
        perguntas = pergDAO.buscarPerguntas();
        
        Object[] colunas = new Object[selected+1];
      
        respSelect = respDAO.buscaRespostaSelec(selected*perguntas.size());
        

        int cont=0;        
        
        for(int i=perguntas.size();i>0;i--){
            colunas [0] = "Pergunta "+perguntas.get(i-1).getNumero();
                
            if(selected==2){
                colunas [1] = String.valueOf(respSelect.get(cont).isCorreta());
                colunas [2] = String.valueOf(respSelect.get(cont+8).isCorreta());
                
            }
            else if(selected==3){
                colunas [1] = String.valueOf(respSelect.get(cont).isCorreta());
                colunas [2] = String.valueOf(respSelect.get(cont+8).isCorreta());
                colunas [3] = String.valueOf(respSelect.get(cont+16).isCorreta());

                
            }
            else if(selected==4){
                colunas [1] = String.valueOf(respSelect.get(cont).isCorreta());
                colunas [2] = String.valueOf(respSelect.get(cont+8).isCorreta());
                colunas [3] = String.valueOf(respSelect.get(cont+16).isCorreta());
                colunas [4] = String.valueOf(respSelect.get(cont+24).isCorreta());

                
            }
            cont++;
            tabela.addRow(colunas);
        }
        
        respostaView.tabela.setModel(tabela);
        
        
    }   
    public void mudarCaracTabela(){        
        respostaView.tabela.setBorder(null);
        
        respostaView.tabela.setEnabled(false);
        
        
        DefaultTableCellRenderer rendererEsquerda = new DefaultTableCellRenderer();
        rendererEsquerda.setHorizontalAlignment(SwingConstants.LEFT);

        

        JTableHeader header = respostaView.tabela.getTableHeader();
        header.setPreferredSize(new Dimension(0, 25));   // define a largura do cabeçalho
        TableColumnModel modeloDaColuna = respostaView.tabela.getColumnModel();

        modeloDaColuna.getColumn(0).setCellRenderer(rendererEsquerda);
        
        modeloDaColuna.getColumn(0).setPreferredWidth(100);
        modeloDaColuna.getColumn(0).setMaxWidth(110);      
        respostaView.tabela.setRowHeight(50);
       
    }
    public void setPontuacao(){
        List<Jogador> list = jogadores;
      
        Collections.sort(list);
        
        DefaultTableModel tabela = new DefaultTableModel();
                       
            tabela.addColumn("Posição");
            tabela.addColumn("Nome");
            tabela.addColumn("Pontuação");
            
            Object[] colunas = new Object[selected+1];

            int cont=0;        

            for(int i=0;i<list.size();i++){                
                
                    colunas [0] = i+1;
                    colunas [1] = list.get(i).getNome();
                    colunas [2] = list.get(i).getPontuacao();

                tabela.addRow(colunas);
            }
            respostaView.tabelaPont.setModel(tabela); 
            respostaView.tabelaPont.getTableHeader().setFont(new java.awt.Font("Trebuchet MS", 0, 22));
    }
    
    
//    
//    public void setPontuacao(){
//        List<Jogador> list = jogadores;
//      
//        Collections.sort(list);
//        
//        if(selected==2){
//            respostaView.umColocado.setText("1- "+list.get(0).getNome());
//            respostaView.pontum.setText(" - "+ list.get(0).getPontuacao());
//            respostaView.doisColocado.setText("2- "+list.get(1).getNome());
//            respostaView.pontdois.setText(" - "+ list.get(1).getPontuacao());
//            respostaView.tresColocado.setVisible(false);
//            respostaView.ponttres.setVisible(false);
//            respostaView.quatColocado.setVisible(false);
//            respostaView.pontquatro.setVisible(false);
//        }
//        if(selected==3){
//            respostaView.umColocado.setText("1- "+list.get(0).getNome());
//            respostaView.pontum.setText(" - "+ list.get(0).getPontuacao());
//            respostaView.doisColocado.setText("2- "+list.get(1).getNome());
//            respostaView.pontdois.setText(" - "+ list.get(1).getPontuacao());
//            respostaView.tresColocado.setText("3- "+list.get(2).getNome());
//            respostaView.ponttres.setText(" - "+ list.get(2).getPontuacao());
//            respostaView.quatColocado.setVisible(false);
//            respostaView.pontquatro.setVisible(false);
//        }
//        if(selected==4){
//            respostaView.umColocado.setText("1- "+list.get(0).getNome());
//            respostaView.pontum.setText(" - "+ list.get(0).getPontuacao());
//            respostaView.doisColocado.setText("2- "+list.get(1).getNome());
//            respostaView.pontdois.setText(" - "+ list.get(1).getPontuacao());
//            respostaView.tresColocado.setText("3- "+list.get(2).getNome());
//            respostaView.ponttres.setText(" - "+ list.get(2).getPontuacao());
//            respostaView.quatColocado.setText("4- "+list.get(3).getNome());
//            respostaView.pontquatro.setText(" - "+ list.get(3).getPontuacao());
//        }
//    }
    
//    public void adicionarVencEmpate(){
//        if(selected==2){            
//            if(jogadores.get(0).getPontuacao()<jogadores.get(1).getPontuacao()){
//                ganhador = new Ganhador();
//                ganhador.nomeJogador.setText(jogadores.get(1).getNome());
//                ganhador.pontuacao.setText("Pontuação: "+ String.valueOf(jogadores.get(1).getPontuacao()));
//                respostaView.areaTrabalho.removeAll();
//                respostaView.areaTrabalho.add(ganhador);
//                this.ganhador.setVisible(true);
//                ((BasicInternalFrameUI) this.ganhador.getUI()).setNorthPane(null);
//                this.ganhador.setBorder(null);
//                
//            }
//            else if(jogadores.get(0).getPontuacao()>jogadores.get(1).getPontuacao()){
//                ganhador = new Ganhador();                
//                ganhador.nomeJogador.setText(jogadores.get(0).getNome());
//                ganhador.pontuacao.setText("Pontuação: "+ String.valueOf(jogadores.get(0).getPontuacao()));                                
//                this.respostaView.areaTrabalho.removeAll();
//                this.respostaView.areaTrabalho.add(ganhador);
//                this.ganhador.setVisible(true);
//                ((BasicInternalFrameUI) this.ganhador.getUI()).setNorthPane(null);
//                this.ganhador.setBorder(null);
//            }
//            else{
//                empate2p = new Empate2p();              
//                empate2p.nomeJogador.setText(jogadores.get(0).getNome());
//                empate2p.pontuacao.setText("Pontuação: "+String.valueOf(jogadores.get(0).getPontuacao()));
//                empate2p.nomeJogador1.setText(jogadores.get(1).getNome());
//                empate2p.pontuacao1.setText("Pontuação: "+String.valueOf(jogadores.get(1).getPontuacao()));
//                this.respostaView.areaTrabalho.removeAll();
//                this.respostaView.areaTrabalho.add(empate2p);
//                this.empate2p.setVisible(true);
//                ((BasicInternalFrameUI) this.empate2p.getUI()).setNorthPane(null);
//                this.empate2p.setBorder(null);
//               
//                
//            }
//        }
//        
//    
//        else if(selected==3){
//            if(jogadores.get(0).getPontuacao()>jogadores.get(1).getPontuacao()){
//                if(jogadores.get(2).getPontuacao()<jogadores.get(0).getPontuacao()){
//                    ganhador = new Ganhador();
//                    ganhador.nomeJogador.setText(jogadores.get(0).getNome());
//                    ganhador.pontuacao.setText(String.valueOf(jogadores.get(0).getPontuacao()));
//                    this.respostaView.areaTrabalho.removeAll();
//                    this.respostaView.areaTrabalho.add(ganhador);
//                    this.ganhador.setVisible(true);
//                    ((BasicInternalFrameUI) this.ganhador.getUI()).setNorthPane(null);
//                    this.ganhador.setBorder(null);                
//                }                
//            }
//            if(jogadores.get(0).getPontuacao()>jogadores.get(1).getPontuacao()){
//                if(jogadores.get(2).getPontuacao()<jogadores.get(0).getPontuacao()){
//                    ganhador = new Ganhador();
//                    ganhador.nomeJogador.setText(jogadores.get(0).getNome());
//                    ganhador.pontuacao.setText(String.valueOf(jogadores.get(0).getPontuacao()));
//                    this.respostaView.areaTrabalho.removeAll();
//                    this.respostaView.areaTrabalho.add(ganhador);
//                    this.ganhador.setVisible(true);
//                    ((BasicInternalFrameUI) this.ganhador.getUI()).setNorthPane(null);
//                    this.ganhador.setBorder(null);                
//                }                
//            }
//            else if(jogadores.get(1).getPontuacao()>jogadores.get(0).getPontuacao()){
//                if(jogadores.get(2).getPontuacao()<jogadores.get(1).getPontuacao()){
//                    ganhador = new Ganhador();
//                    ganhador.nomeJogador.setText(jogadores.get(1).getNome());
//                    ganhador.pontuacao.setText(String.valueOf(jogadores.get(1).getPontuacao()));
//                    this.respostaView.areaTrabalho.removeAll();
//                    this.respostaView.areaTrabalho.add(ganhador);  
//                    this.ganhador.setVisible(true);
//                    ((BasicInternalFrameUI) this.ganhador.getUI()).setNorthPane(null);
//                    this.ganhador.setBorder(null);
//                }
//            }
//            else if(jogadores.get(2).getPontuacao()>jogadores.get(1).getPontuacao()){
//                if(jogadores.get(0).getPontuacao()<jogadores.get(2).getPontuacao()){
//                    ganhador = new Ganhador();
//                    ganhador.nomeJogador.setText(jogadores.get(2).getNome());
//                    ganhador.pontuacao.setText(String.valueOf(jogadores.get(2).getPontuacao()));
//                    this.respostaView.areaTrabalho.removeAll();
//                    this.respostaView.areaTrabalho.add(ganhador);  
//                    this.ganhador.setVisible(true);
//                    ((BasicInternalFrameUI) this.ganhador.getUI()).setNorthPane(null);
//                    this.ganhador.setBorder(null);
//                }
//            }
//
//            else{
//                empate3p = new Empate3p();
//                empate3p.nomeJogador.setText(jogadores.get(0).getNome());
//                empate3p.pontuacao.setText(String.valueOf(jogadores.get(0).getPontuacao()));
//                empate3p.nomeJogador1.setText(jogadores.get(1).getNome());
//                empate3p.pontuacao1.setText(String.valueOf(jogadores.get(1).getPontuacao()));
//                empate3p.nomeJogador2.setText(jogadores.get(1).getNome());
//                empate3p.pontuacao2.setText(String.valueOf(jogadores.get(2).getPontuacao()));
//                this.respostaView.areaTrabalho.removeAll();
//                this.respostaView.areaTrabalho.add(empate3p);
//                this.empate3p.setVisible(true);
//                ((BasicInternalFrameUI) this.empate3p.getUI()).setNorthPane(null);
//                this.empate3p.setBorder(null);
//            }
//        }
//        
//        
//        else if(selected==4){
//            if(jogadores.get(0).getPontuacao()>jogadores.get(1).getPontuacao()){
//                if(jogadores.get(2).getPontuacao()<jogadores.get(0).getPontuacao());
//                    if(jogadores.get(0).getPontuacao()>jogadores.get(3).getPontuacao()){
//                        ganhador = new Ganhador();
//                        ganhador.nomeJogador.setText(jogadores.get(0).getNome());
//                        ganhador.pontuacao.setText(String.valueOf(jogadores.get(0).getPontuacao()));
//                        this.respostaView.areaTrabalho.removeAll();
//                        this.respostaView.areaTrabalho.add(ganhador);  
//                        this.ganhador.setVisible(true);
//                ((BasicInternalFrameUI) this.ganhador.getUI()).setNorthPane(null);
//                this.ganhador.setBorder(null);
//                    }
//            }
//            else if(jogadores.get(1).getPontuacao()>jogadores.get(0).getPontuacao()){
//                if(jogadores.get(2).getPontuacao()<jogadores.get(1).getPontuacao());
//                    if(jogadores.get(1).getPontuacao()>jogadores.get(3).getPontuacao()){
//                        ganhador = new Ganhador();
//                        ganhador.nomeJogador.setText(jogadores.get(1).getNome());
//                        ganhador.pontuacao.setText(String.valueOf(jogadores.get(1).getPontuacao()));
//                        this.respostaView.areaTrabalho.removeAll();
//                        this.respostaView.areaTrabalho.add(ganhador);  
//                        this.ganhador.setVisible(true);
//                ((BasicInternalFrameUI) this.ganhador.getUI()).setNorthPane(null);
//                this.ganhador.setBorder(null);
//                    }
//            }
//            else if(jogadores.get(2).getPontuacao()>jogadores.get(0).getPontuacao()){
//                if(jogadores.get(2).getPontuacao()<jogadores.get(1).getPontuacao());
//                    if(jogadores.get(2).getPontuacao()>jogadores.get(3).getPontuacao()){
//                        ganhador = new Ganhador();
//                        ganhador.nomeJogador.setText(jogadores.get(2).getNome());
//                        ganhador.pontuacao.setText(String.valueOf(jogadores.get(2).getPontuacao()));
//                        this.respostaView.areaTrabalho.removeAll();
//                        this.respostaView.areaTrabalho.add(ganhador);  
//                        this.ganhador.setVisible(true);
//                ((BasicInternalFrameUI) this.ganhador.getUI()).setNorthPane(null);
//                this.ganhador.setBorder(null);
//                    }
//            }
//            else if(jogadores.get(3).getPontuacao()>jogadores.get(0).getPontuacao()){
//                if(jogadores.get(3).getPontuacao()<jogadores.get(1).getPontuacao());
//                    if(jogadores.get(3).getPontuacao()>jogadores.get(2).getPontuacao()){
//                        ganhador = new Ganhador();
//                        ganhador.nomeJogador.setText(jogadores.get(3).getNome());
//                        ganhador.pontuacao.setText(String.valueOf(jogadores.get(3).getPontuacao()));
//                        this.respostaView.areaTrabalho.removeAll();
//                        this.respostaView.areaTrabalho.add(ganhador);  
//                        this.ganhador.setVisible(true);
//                ((BasicInternalFrameUI) this.ganhador.getUI()).setNorthPane(null);
//                this.ganhador.setBorder(null);
//                    }
//            }
//            
//            else{
//                empate4p = new Empate4p();
//                empate4p.nomeJogador.setText(jogadores.get(0).getNome());
//                empate4p.pontuacao.setText(String.valueOf(jogadores.get(0).getPontuacao()));
//                empate4p.nomeJogador1.setText(jogadores.get(1).getNome());
//                empate4p.pontuacao1.setText(String.valueOf(jogadores.get(1).getPontuacao()));
//                empate4p.nomeJogador2.setText(jogadores.get(2).getNome());
//                empate4p.pontuacao2.setText(String.valueOf(jogadores.get(2).getPontuacao()));
//                empate4p.nomeJogador3.setText(jogadores.get(3).getNome());
//                empate4p.pontuacao3.setText(String.valueOf(jogadores.get(3).getPontuacao()));
//                this.respostaView.areaTrabalho.removeAll();
//                this.respostaView.areaTrabalho.add(empate4p);
//                this.empate4p.setVisible(true);
//                ((BasicInternalFrameUI) this.empate4p.getUI()).setNorthPane(null);
//                this.empate4p.setBorder(null);
//            }
//        }
//        
//    }
    
}
