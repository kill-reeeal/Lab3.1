package gui;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;

import controller.Controller;
import model.Employee;

public class EmployeeAddForm extends Container {
    private JPanel EmployeeAddPanel;
    private JTextField nameTextField;
    private JLabel NameLabel;
    private JTextField depTextField;
    private JFormattedTextField ageTextField;
    private JFormattedTextField phoneTextField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JRadioButton otherRadioButton;
    private JLabel depLabel;
    private JLabel ageLabel;
    private JLabel phoneLabel;
    private JLabel positionLabel;
    private JLabel genderLabel;
    //private JButton addButton;
    private JComboBox positionComboBox;
    private ButtonGroup genderGroup;

    private Controller controller;

    public EmployeeAddForm() {

        controller = new Controller();

    }

    public void addDataToDB() {
        boolean validInput = true;
        String errMessage = "Incorrect values in input fields: \n";

        String nameText = nameTextField.getText();
        if (nameText.isEmpty()) {
            errMessage = errMessage + "\"Name\" field is empty \n";

            validInput = false;
        }

        String depText = depTextField.getText();
        if (depText.isEmpty()) {
            errMessage = errMessage + "\"Department\" field is empty \n";

            validInput = false;
        }

        int age = 0;
        try {
            age = Integer.parseInt(ageTextField.getText());
        } catch (NumberFormatException ne) {
            errMessage = errMessage + "\"Age\" field has incorrect value \n" + ne.getMessage();
            validInput = false;
        }

        String phone = phoneTextField.getText();
        if (phone.isEmpty()) {
            errMessage = errMessage + "\"Phone\" field is empty \n";

            validInput = false;
        }

        String position = (String) positionComboBox.getSelectedItem();

        String gender = genderGroup.getSelection().getActionCommand();
        errMessage = errMessage + "Gender: " + gender;

        if (!validInput) {
            JOptionPane.showMessageDialog(new JFrame(), errMessage, "Input Information Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Employee employee = new Employee(nameText, depText, age, phone, position, gender);
        Controller controller = new Controller();
        controller.addEmployee(employee);

        JOptionPane.showMessageDialog(new JFrame(), employee.toString(), "Input information OK",
                JOptionPane.INFORMATION_MESSAGE);
    }

    JPanel getEmployeeAddPanel() {
        return EmployeeAddPanel;
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        EmployeeAddPanel = new JPanel();
        EmployeeAddPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(10, 4, new Insets(0, 0, 0, 0), -1, -1));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        EmployeeAddPanel.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        NameTextField = new JLabel();
        NameTextField.setText("Name:");
        EmployeeAddPanel.add(NameTextField, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nameTextField = new JTextField();
        nameTextField.setText("");
        EmployeeAddPanel.add(nameTextField, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        depLabel = new JLabel();
        depLabel.setText("Department:");
        EmployeeAddPanel.add(depLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        depTextField = new JTextField();
        EmployeeAddPanel.add(depTextField, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        ageLabel = new JLabel();
        ageLabel.setText("Age:");
        EmployeeAddPanel.add(ageLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        phoneLabel = new JLabel();
        phoneLabel.setText("Phone");
        EmployeeAddPanel.add(phoneLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        positionLabel = new JLabel();
        positionLabel.setText("Position");
        EmployeeAddPanel.add(positionLabel, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        genderLabel = new JLabel();
        genderLabel.setText("Gender:");
        EmployeeAddPanel.add(genderLabel, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        EmployeeAddPanel.add(ageTextField, new com.intellij.uiDesigner.core.GridConstraints(2, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        EmployeeAddPanel.add(phoneTextField, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setSelected(true);
        maleRadioButton.setActionCommand("Male");
        EmployeeAddPanel.add(maleRadioButton, new com.intellij.uiDesigner.core.GridConstraints(5, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setActionCommand("Female");
        EmployeeAddPanel.add(femaleRadioButton, new com.intellij.uiDesigner.core.GridConstraints(6, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        otherRadioButton = new JRadioButton("Other");
        otherRadioButton.setActionCommand("Other");
        EmployeeAddPanel.add(otherRadioButton, new com.intellij.uiDesigner.core.GridConstraints(7, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        addButton = new JButton();
        addButton.setText("Add");
        EmployeeAddPanel.add(addButton, new com.intellij.uiDesigner.core.GridConstraints(9, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        positionComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Trainee");
        defaultComboBoxModel1.addElement("Junior");
        defaultComboBoxModel1.addElement("Middle");
        defaultComboBoxModel1.addElement("Senior");
        defaultComboBoxModel1.addElement("Lead");
        defaultComboBoxModel1.addElement("Head");
        defaultComboBoxModel1.addElement("PM");
        positionComboBox.setModel(defaultComboBoxModel1);
        EmployeeAddPanel.add(positionComboBox, new com.intellij.uiDesigner.core.GridConstraints(4, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        genderGroup.add(otherRadioButton);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return EmployeeAddPanel;
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here

        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(0);
        nf.setMaximumIntegerDigits(10);

        ageTextField = new JFormattedTextField(nf);

        MaskFormatter phoneMask = null;
        try {
            // create a MaskFormatter for accepting phone number, the # symbol accept
            // only a number. We can also set the empty value with a place holder
            // character.
            phoneMask = new MaskFormatter("+7 (###) ###-####");
            phoneMask.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            e.printStackTrace();
        }
        phoneTextField = new JFormattedTextField(phoneMask);
    }
}