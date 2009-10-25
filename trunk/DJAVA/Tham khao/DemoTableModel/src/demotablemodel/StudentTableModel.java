/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demotablemodel;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author tunn
 */
public class StudentTableModel extends AbstractTableModel{
    private ArrayList<Student> array;

    public static final ColumnData columns[]={
        new ColumnData("No",10,JLabel.LEFT),
        new ColumnData("Name",100,JLabel.LEFT),
        new ColumnData("Age",100,JLabel.LEFT)
    };

    public StudentTableModel(ArrayList<Student> array) {
        this.array = array;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }



    public int getRowCount() {
        return array.size();
    }

    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column].getTitle();
    }



    public Object getValueAt(int rowIndex, int columnIndex) {
        Student std=array.get(rowIndex);

        switch(columnIndex) {
            case 0:
                return rowIndex;
            case 1:
                return std.getName();
            case 2:
                return std.getAge();
        }
        return null;
    }

    @Override
    public void setValueAt(Object value, int nRow, int nCol) {
        Student std=array.get(nRow);
        switch(nCol) {
            case 0:
                return;
            case 1:
                std.setName((String) value);
                break;
            case 2:
                std.setAge(Integer.parseInt(value.toString()));
                break;
        }
    }

    public Student getStudentAt(int rowIndex) {
        return array.get(rowIndex);
    }

    public void updateStudent() {
        fireTableDataChanged();
    }

    //insert
    //delete

}
