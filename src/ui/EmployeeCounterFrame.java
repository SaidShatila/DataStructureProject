package ui;

import localstorage.PreferenceHelper;
import municipality.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeCounterFrame extends JFrame {
    JPanel jPanel = new JPanel();
    JButton createJButton = new JButton("Create Application");
    JButton editJButton = new JButton("Edit Application");
    JButton backJButton = new JButton("Back");
    JButton registerCitizenJButton = new JButton("Register Citizen");
    Employee employee;
    JComboBox typeOfAppComboBox = new JComboBox(new String[]{"PassPort", "Birth Certificate", "New Id", "Personal Document"});
    JPanel createApplicationJPanel = new JPanel();
    Government governmentHelper = GovernmentHelper.getCurrentGoverment();

    public EmployeeCounterFrame(Employee employee) {
        this.employee = employee;
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.add(Box.createHorizontalGlue());
        jPanel.add(Box.createRigidArea(new Dimension(450, 0)));
        setContentPane(jPanel);


        registerCitizenJButton.setFont(new Font("Monospaced", Font.ITALIC, 20));
        registerCitizenJButton.setHorizontalAlignment(SwingConstants.LEFT);
        jPanel.add(Box.createVerticalStrut(25));
        jPanel.add(registerCitizenJButton);
        registerCitizenJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                registerCitizenButton();
            }
        });

        createApplicationJPanel.setLayout(new FlowLayout());
        createApplicationJPanel.add(typeOfAppComboBox);
        createApplicationJPanel.add(createJButton);

        createJButton.setFont(new Font("Monospaced", Font.ITALIC, 20));
        createJButton.setHorizontalAlignment(SwingConstants.LEFT);
        jPanel.add(Box.createVerticalStrut(25));
        jPanel.add(createApplicationJPanel);
        createJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                createApp();
            }
        });


        editJButton.setFont(new Font("Monospaced", Font.ITALIC, 20));
        editJButton.setHorizontalAlignment(SwingConstants.RIGHT);
        jPanel.add(Box.createVerticalStrut(25));
        jPanel.add(editJButton);
        editJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                editButton();
            }
        });

        backJButton.setFont(new Font("Monospaced", Font.ITALIC, 20));
        backJButton.setHorizontalAlignment(SwingConstants.CENTER);
        jPanel.add(Box.createVerticalStrut(25));
        jPanel.add(backJButton);
        backJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                backButton();
            }
        });


        setSize(450, 550);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

    public void createApp() {
        BaseApplicationType applicationType;

        switch (typeOfAppComboBox.getSelectedItem().toString()) {

            case "PassPort": {
                applicationType = new PassPortApplicationType();
            }
            break;
            case "Birth Certificate": {
                applicationType = new BirthCertifcateType();
            }
            break;
            case "New Id": {
                applicationType = new IdType();
            }
            break;
            case "Personal Document": {
                applicationType = new PersonalDocumentType();
            }
            break;

            default: {
                throw new IllegalArgumentException("Application type is not supported");
            }
        }
        Application application = new Application();
        application.setId(governmentHelper.getArchive().getApplicationNewId());
        application.setCitizenId(PreferenceHelper.getCurrentInstance().getSavedCitizen().getId());
        application.setType(applicationType);
        application.setState(State.WAITING);
        employee.registerApplication(governmentHelper.getArchive(), application, PreferenceHelper.getCurrentInstance().getSavedCitizen());


    }

    public void backButton() {
        LauncherFrame launcherFrame = new LauncherFrame();
        setVisible(false);
        launcherFrame.setVisible(true);


    }

    public void editButton() {
        String id = JOptionPane.showInputDialog(this, "Please enter the Id of the application");
        Application application = governmentHelper.getArchive().getApplicationById(Integer.parseInt(id));
        if ( application != null) {
            EditApplicationFrame editApplicationFrame = new EditApplicationFrame(application,employee);
            setVisible(false);
            editApplicationFrame.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(this,"Application not Found");
        }
    }

    public void registerCitizenButton() {
//         employee.registerCitizen(PreferenceHelper.getCurrentInstance().getSavedCitizen());

    }
}
