package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeCounterFrame extends JFrame {
    JPanel jPanel = new JPanel();
     JButton createJButton= new JButton("Create Application");
     JButton editJButton = new JButton("Edit Application");
     JButton backJButton = new JButton("Back");


     public EmployeeCounterFrame(){
         jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
         jPanel.add(Box.createHorizontalGlue());
         jPanel.add(Box.createRigidArea(new Dimension(450, 0)));
         setContentPane(jPanel);

         createJButton.setFont(new Font("Monospaced", Font.ITALIC, 20));
         createJButton.setHorizontalAlignment(SwingConstants.LEFT);
         jPanel.add(Box.createVerticalStrut(25));
         jPanel.add(createJButton);
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
     }

     public void createApp(){

     }
     public void backButton(){
         LauncherFrame launcherFrame= new LauncherFrame();
         setVisible(false);
         launcherFrame.setVisible(true);


     }

     public void editButton(){

     }
}
