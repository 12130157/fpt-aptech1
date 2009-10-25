/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demolist2;

import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author tunn
 */
public class StudentListModel extends AbstractListModel{
    private ArrayList<Student> array;

    public StudentListModel(ArrayList<Student> array) {
        this.array = array;
    }

    public StudentListModel() {
    }

    public ArrayList<Student> getArray() {
        return array;
    }

    public void setArray(ArrayList<Student> array) {
        this.array = array;
    }

    public int getSize() {
        return array.size();
    }

    public Object getElementAt(int index) {
        return array.get(index);
    }

    public void addStudent(Student std) {
        array.add(std);
        fireIntervalAdded(this, 0, 0);
    }

    public void removeStudent(Student std) {
        array.remove(std);
        fireIntervalRemoved(this, 0, 0);
    }

    public void updateStudent(Student std,int index) {
        array.set(index, std);
        fireContentsChanged(this, 0, 0);
    }
}
