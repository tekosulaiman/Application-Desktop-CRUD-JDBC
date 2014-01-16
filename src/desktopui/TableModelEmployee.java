package desktopui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Employee;

/**
 * @author tombisnis@yahoo.com
 */
public class TableModelEmployee extends AbstractTableModel{
    public List<Employee> list = new ArrayList<Employee>();

    public Employee getList(int i) {
        return list.get(i);
    }

    public void setList(List<Employee> list) {
        this.list = list;
        fireTableDataChanged();
    }
 
    public void save(Employee e){
        list.add(e);
        fireTableDataChanged();
    }
    
    public void update(int i,Employee e){
        list.set(i, e);
        fireTableDataChanged();
    }
    
    public void delete(int i){
        list.remove(i);
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
           case 0 : return list.get(rowIndex).getId();
           case 1 : return list.get(rowIndex).getName();
           case 2 : return list.get(rowIndex).getAddress();
           default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
           case 0 : return "Id";
           case 1 : return "Nama";
           case 2 : return "Address";
           default: return null;
       }
    }
}