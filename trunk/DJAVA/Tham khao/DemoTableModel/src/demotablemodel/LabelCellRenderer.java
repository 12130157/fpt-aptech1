/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demotablemodel;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author tunn
 */
public class LabelCellRenderer extends JLabel implements TableCellRenderer{

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label=new JLabel();
        if(row%2==0) {
            label.setBackground(Color.red);
            label.setForeground(Color.YELLOW);
        }else{
            
        }
        label.setText(value.toString());
        return label;
    }

}
