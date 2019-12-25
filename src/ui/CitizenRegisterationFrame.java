package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

public class CitizenRegisterationFrame extends JFrame {
    JPanel labelJPanel = new JPanel();
    JPanel boxJPanel = new JPanel();
    JTextField firstNameTextField = new JTextField(10);
    JLabel firstNameJLabel = new JLabel();
    JTextField lastNameTextField = new JTextField(10);
    JLabel lastNameJLabel = new JLabel();
    JTextField emailTextField = new JTextField(10);
    JLabel emailJLabel = new JLabel();
    JTextField phoneNumberTextField = new JTextField(10);
    JLabel phoneNumberJLabel = new JLabel();
    JButton saveJButton = new JButton("Save");
    FlowLayout flowLayout = new FlowLayout();
    Container content = new Container();

    public CitizenRegisterationFrame() {
        boxJPanel.setLayout(new BoxLayout(boxJPanel, BoxLayout.Y_AXIS));
        setBounds(100, 100, 600, 600);
        labelJPanel.setLayout(flowLayout);
        flowLayout.setHgap(25);
        content = getContentPane();
        content.setLayout(flowLayout);

        firstNameJLabel.setText("First Name: ");
        lastNameJLabel.setText("Last Name: ");
        emailJLabel.setText("Email: ");
        phoneNumberJLabel.setText("Phone Number: ");

        firstNameJLabel.setFont(new Font("Serif", Font.PLAIN, 22));
        labelJPanel.add(firstNameJLabel);
        labelJPanel.add(firstNameTextField);


        lastNameJLabel.setFont(new Font("Serif", Font.PLAIN, 22));
        labelJPanel.add(lastNameJLabel);
        labelJPanel.add(lastNameTextField);

        emailJLabel.setFont(new Font("Serif", Font.PLAIN, 22));
        labelJPanel.add(emailJLabel);
        labelJPanel.add(emailTextField);

        phoneNumberJLabel.setFont(new Font("Serif", Font.PLAIN, 22));
        labelJPanel.add(phoneNumberJLabel);
        labelJPanel.add(phoneNumberTextField);


        firstNameJLabel.setDisplayedMnemonic(KeyEvent.VK_N);
        firstNameTextField.setHorizontalAlignment(JTextField.LEFT);
        firstNameJLabel.setLabelFor(firstNameTextField);

        lastNameJLabel.setDisplayedMnemonic(KeyEvent.VK_N);
        lastNameTextField.setHorizontalAlignment(JTextField.LEFT);
        lastNameJLabel.setLabelFor(lastNameTextField);

        emailJLabel.setDisplayedMnemonic(KeyEvent.VK_N);
        emailTextField.setHorizontalAlignment(JTextField.LEFT);
        emailJLabel.setLabelFor(emailTextField);

        phoneNumberJLabel.setDisplayedMnemonic(KeyEvent.VK_N);
        phoneNumberTextField.setHorizontalAlignment(JTextField.LEFT);
        phoneNumberJLabel.setLabelFor(phoneNumberTextField);


        labelJPanel.add(saveJButton, BorderLayout.PAGE_END);
        saveJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                saveButtonConfig();
            }
        });


        add(labelJPanel, BorderLayout.NORTH);
        setSize(250, 75);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    public void saveButtonConfig() {

        toastMessage();

        LauncherFrame launcherFrame = new LauncherFrame();
        setVisible(false);
        launcherFrame.setVisible(true);
    }



    public JFrame toastMessage() {
        JFrame jFrame = new JFrame();
        JPanel jPanel = new JPanel();
        JLabel jLabel = new JLabel();

        jFrame.setContentPane(jPanel);
        jFrame.add(jPanel);
        jPanel.setLayout(new BorderLayout());
        jPanel.add(jLabel, BorderLayout.CENTER);
         jFrame.setVisible(false);
        if (firstNameTextField.getText()=="") {
            jFrame.setVisible(true);
            jLabel.setText("Please enter your first name correctly");
        } else if (lastNameTextField.getText() == "") {
            jFrame.setVisible(true);
            jLabel.setText("Please enter your last name correctly");
        } else if (emailTextField.getText() == "") {
            jFrame.setVisible(true);
            jLabel.setText("Please enter your email correctly");
        } else if (firstNameTextField.getText() == "") {
            jFrame.setVisible(true);
            jLabel.setText("Please enter your phone number correctly");
        }
        return jFrame;
    }
}










