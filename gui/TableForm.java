package gui;

import model.Employee;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TableForm {
    private JTable stuffTable;
    private JPanel tablePanel;
    StaffTableModel tableModel;

    TableForm(){}

    public JPanel getTablePanel(){ return tablePanel;}

    public void setData(List<Employee> db){ tableModel.setData(db); }

    public void refresh() { tableModel.fireTableDataChanged(); }


}