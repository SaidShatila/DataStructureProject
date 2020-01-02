package ui;

import localstorage.PreferenceHelper;
import municipality.*;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditApplicationFrame extends JFrame {
    JPanel mainPanel = new JPanel();
    JPanel idPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();
    JButton backJbutton = new JButton("Back");
    JPanel tablePanel = new JPanel();
    JLabel citizenJLabel = new JLabel();
    JLabel employeeJLabel = new JLabel();
    JLabel applicationIdJLabel = new JLabel();
    JTable stepsJtable = new JTable();
    JButton deleteJbutton = new JButton("Delete Application");
    JButton undoJbutton = new JButton("Undo Step");
    JButton nextProcessJbutton = new JButton("Process Next Step");
    Application currentApplication;
    Employee employee;
    DefaultTableModel defaultTableModel;
    String[] columnNames = {"Employee", "StepsNumber", "Status"};
    Government government = GovernmentHelper.getCurrentGoverment();

    public EditApplicationFrame(Application currentApplication, Employee employee) {
        this.currentApplication = currentApplication;
        this.employee = employee;

        add(mainPanel);
        mainPanel.add(idPanel);
        mainPanel.add(buttonsPanel);
        mainPanel.add(tablePanel);
        mainPanel.add(backJbutton);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(Box.createHorizontalGlue());
        mainPanel.add(Box.createVerticalStrut(25));

        backJbutton.setHorizontalAlignment(SwingConstants.LEFT);

        backJbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                backButton();
            }
        });

        applicationIdJLabel.setText(currentApplication.getId() + "");
        idPanel.setLayout(new GridLayout(2, 1));
        applicationIdJLabel.setFont(new Font("Serif", Font.BOLD, 25));
        idPanel.add(applicationIdJLabel);

        citizenJLabel.setText(PreferenceHelper.getCurrentInstance().getSavedCitizen().getFirstName() + " " + PreferenceHelper.getCurrentInstance().getSavedCitizen().getLastName());
        citizenJLabel.setFont(new Font("Serif", Font.BOLD, 25));
        idPanel.add(citizenJLabel);

        employeeJLabel.setText(employee.getName());
        employeeJLabel.setFont(new Font("Serif", Font.BOLD, 25));
        idPanel.add(employeeJLabel);


        tablePanel.setLayout(new GridLayout(0, 1));


        defaultTableModel = new DefaultTableModel();
        defaultTableModel.setDataVector(prepareTableData(currentApplication), columnNames);
        stepsJtable = new JTable(defaultTableModel);
        tablePanel.add(stepsJtable.getTableHeader());
        tablePanel.add(stepsJtable);
        stepsJtable.setBounds(30, 40, 200, 300);


        buttonsPanel.setLayout(new GridLayout(2, 1));

        buttonsPanel.add(nextProcessJbutton);
        nextProcessJbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                nextProcessButton();
            }
        });

        buttonsPanel.add(undoJbutton);

        undoJbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                undoButton();
            }
        });


        buttonsPanel.add(deleteJbutton);
        deleteJbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                deleteButton();
            }
        });


        setSize(200, 0);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();

    }

    public void backButton() {
        EmployeeCounterFrame employeeCounterFrame = new EmployeeCounterFrame(employee);
        setVisible(false);
        employeeCounterFrame.setVisible(true);
    }

    public void nextProcessButton() {
        if (currentApplication.listOfPendingSteps().isEmpty()) {
           employee.finishApplication(government.getArchive(),currentApplication.getId());

        } else {


            employee.processNextStep(government.getArchive(), currentApplication.getId(), currentApplication.getPendingSteps().peek());
            refreshTableData();
        }
    }

    public void deleteButton() {
        government.getArchive().applicationUnregister(currentApplication.getId());
        backButton();
    }

    public void undoButton() {
        if (currentApplication.listOfSteps().isEmpty()) {
            JOptionPane.showMessageDialog(this, "You can't undo steps , your application didn't start processing");
        } else {

            employee.undoStep(government.getArchive(), currentApplication.getId());
            refreshTableData();
        }
    }

    public String[][] prepareTableData(Application application) {

        ArrayList<Operation> listOfSteps = application.listOfSteps();
        ArrayList<Operation> listOfPendingSteps = application.listOfPendingSteps();
        String[][] data = new String[listOfSteps.size() + listOfPendingSteps.size()][3];

//                employee name | operation description | status
        for (int i = 0; i < listOfPendingSteps.size(); i++) {
            data[i][0] = "-";
            data[i][1] = listOfPendingSteps.get(i).getDescription();
            data[i][2] = "Pending";

        }
        for (int i = listOfPendingSteps.size(); i < listOfSteps.size() + listOfPendingSteps.size(); i++) {
            data[i][0] = listOfSteps.get(i - listOfPendingSteps.size()).getProcessedBy();
            data[i][1] = listOfSteps.get(i - listOfPendingSteps.size()).getDescription();
            data[i][2] = "Done";

        }
        return data;

    }

    public void refreshTableData() {
        defaultTableModel.setDataVector(prepareTableData(currentApplication), columnNames);
        defaultTableModel.fireTableChanged(new TableModelEvent(defaultTableModel, TableModelEvent.UPDATE));


    }
}
