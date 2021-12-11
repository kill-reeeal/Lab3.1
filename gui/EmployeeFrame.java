package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Controller;

public class EmployeeFrame extends JFrame{

    private Controller controller;
    private JButton addButton;

    public EmployeeFrame() {
        super ("Staff Manager");

        controller = new Controller();
        setLayout(new BorderLayout());

        EmployeeAddForm empAddForm = new EmployeeAddForm();

        TableForm tableForm = new TableForm();
        tableForm.setData(controller.getEmployees()); //получили данные из БД и заполнили таблицу

        addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                empAddForm.addDataToDB();
                controller.updateEmployees();
                tableForm.setData(controller.getEmployees());
                tableForm.refresh();
            }
        });

        add(empAddForm.getEmployeeAddPanel(), BorderLayout.WEST); // получили панель с форм добавления сотрудников и
        // разместили на форме главного окна
        add(tableForm.getTablePanel(), BorderLayout.CENTER);      //получили панель с формы добавления сотрудников и
        // разместили на форме главного окна
        add(addButton,BorderLayout.SOUTH);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}