package ui;

import localstorage.PreferenceHelper;
import municipality.Application;
import municipality.Employee;
import municipality.Government;
import municipality.GovernmentHelper;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditApplicationFrame extends JFrame {
    JPanel mainPanel = new JPanel();
    JPanel idPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();
    JPanel tablePanel = new JPanel();
    JLabel citizenJLabel = new JLabel();
    JLabel employeeJLabel = new JLabel();
    JLabel applicationIdJLabel = new JLabel();
    JTable stepsJtable= new JTable();
    JButton deleteJbutton = new JButton("Delete Application");
    JButton undoJbutton = new JButton("Undo Step");
    JButton nextProcessJbutton = new JButton("Process Next Step");
    Application currentApplication = new Application();
    Government governmentHelper= GovernmentHelper.getCurrentGoverment();
    public EditApplicationFrame(Application currentApplication , Employee employee){
        this.currentApplication=currentApplication;

        add(mainPanel);
        mainPanel.add(idPanel);
        mainPanel.add(buttonsPanel);
        mainPanel.add(tablePanel);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(Box.createHorizontalGlue());
        mainPanel.add(Box.createVerticalStrut(25));

        applicationIdJLabel.setText(currentApplication.getId()+"");
        idPanel.setLayout(new GridLayout(2,1));
        applicationIdJLabel.setFont(new Font("Serif", Font.BOLD, 25));
        idPanel.add(applicationIdJLabel);

        citizenJLabel.setText(PreferenceHelper.getCurrentInstance().getSavedCitizen().getFirstName()+" "+PreferenceHelper.getCurrentInstance().getSavedCitizen().getLastName());
        citizenJLabel.setFont(new Font("Serif", Font.BOLD, 25));
        idPanel.add(citizenJLabel);

        employeeJLabel.setText(employee.getName());
        employeeJLabel.setFont(new Font("Serif", Font.BOLD, 25));
        idPanel.add(employeeJLabel);


                tablePanel.setLayout(new GridLayout(0,1));
                String [][] data = new String[3][3];
                String [] columnNames = {"Applications","StepsNumber", "Status"};

                stepsJtable= new JTable(data,columnNames);
                tablePanel.add(stepsJtable.getTableHeader());
                tablePanel.add(stepsJtable);
                stepsJtable.setBounds(30,40,200,300);




        buttonsPanel.setLayout(new GridLayout(2,1));

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
        public void nextProcessButton(){

        }

        public void deleteButton(){

        }
        public void undoButton(){

        }
}
