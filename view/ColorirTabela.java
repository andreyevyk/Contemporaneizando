/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author andre
 */
public class ColorirTabela extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus,int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        String str = (String) value;
        if ("1".equals(str)) {  // ou outro teste qq  
            setBackground(Color.green);
            setForeground(Color.green);
        } else if("0".equals(str)) {
            setBackground(Color.RED);
            setForeground(Color.RED);
        }
        else{
            setBackground(null);
            setForeground(null);
        }
        return this;
    }
}
