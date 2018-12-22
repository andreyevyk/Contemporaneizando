/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.plaf.basic.BasicInternalFrameUI;
import model.DAO.jogadorDAO;
import view.SelectNomeJogadores2;
import view.SelectNomeJogadores3;
import view.SelectNomeJogadores4;

/**
 *
 * @author andre
 */
public class ControllerNJSelect {
    
    SelectNomeJogadores2 selectNJ2;
    SelectNomeJogadores3 selectNJ3;
    SelectNomeJogadores4 selectNJ4;

    
    public ControllerNJSelect(SelectNomeJogadores2 SNJ2){
    
        selectNJ2 = SNJ2;
        selectNJ2.setSize(830, 447);
        selectNJ2.setVisible(true);
        ((BasicInternalFrameUI) selectNJ2.getUI()).setNorthPane(null);
        selectNJ2.setBorder(null);
        
    }
    public ControllerNJSelect(SelectNomeJogadores3 SNJ3) {
        
        selectNJ3 = SNJ3;
        selectNJ3.setSize(830, 447);
        selectNJ3.setVisible(true);
        ((BasicInternalFrameUI) selectNJ3.getUI()).setNorthPane(null);
        selectNJ3.setBorder(null);
    }
    public ControllerNJSelect(SelectNomeJogadores4 SNJ4) {
       
        selectNJ4 = SNJ4;
        selectNJ4.setSize(830, 447);
        selectNJ4.setVisible(true);
        ((BasicInternalFrameUI) selectNJ4.getUI()).setNorthPane(null);
        selectNJ4.setBorder(null);
    }
}
