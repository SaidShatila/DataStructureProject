package ui;

import municipality.WaitTurnManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LauncherFrame extends JFrame {
    JPanel jPanel = new JPanel();
    JPanel waitTurnPanel = new JPanel();
    JLabel titleJLabel = new JLabel("Welcome To Harriri Municipality");
    JLabel waitingNumberJlabel = new JLabel();
    JLabel dateJlabel = new JLabel();
    JLabel waitMessageJlabel = new JLabel("Thank you for your patience.");
    JButton requestJButton = new JButton("Request Employee");
    WaitTurnManager waitTurnManager = new WaitTurnManager();


    public LauncherFrame() {
        titleJLabel.setFont(new Font("Serif", Font.BOLD, 25));
        titleJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.add(Box.createHorizontalGlue());
        jPanel.add(Box.createRigidArea(new Dimension(450, 0)));
        jPanel.add(titleJLabel);
        setContentPane(jPanel);


        requestJButton.setFont(new Font("Serif", Font.ITALIC, 20));
        requestJButton.setHorizontalAlignment(SwingConstants.CENTER);
        jPanel.add(Box.createVerticalStrut(25));
        jPanel.add(requestJButton);

        createWaitNumberPanel();

        requestJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                requestEmployee();
            }
        });


        setSize(450, 550);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void requestEmployee() {
        waitTurnPanel.setVisible(true);
        SimpleDateFormat simpleDate = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        Date date = new Date();
        String formattedDate = simpleDate.format(date);
        dateJlabel.setText("Date: " + formattedDate);
        waitingNumberJlabel.setText(" " + waitTurnManager.getNextTurn());
        if (waitTurnManager.getCurrentNum() == 100) {
            waitTurnManager.reset();
        }

    }

    private void createWaitNumberPanel() {
        waitTurnPanel.setLayout(new BoxLayout(waitTurnPanel, BoxLayout.Y_AXIS));
        waitTurnPanel.add(Box.createHorizontalGlue());
        add(waitTurnPanel);

        dateJlabel.setFont(new Font("Serif", Font.PLAIN, 15));
        dateJlabel.setHorizontalAlignment(SwingConstants.CENTER);
        waitTurnPanel.add(Box.createRigidArea(new Dimension(450, 0)));
        waitTurnPanel.add(dateJlabel);


        waitingNumberJlabel.setFont(new Font("Serif", Font.PLAIN, 30));
        waitingNumberJlabel.setHorizontalAlignment(SwingConstants.CENTER);
        waitTurnPanel.add(Box.createRigidArea(new Dimension(450, 0)));
        waitTurnPanel.add(waitingNumberJlabel);


        waitMessageJlabel.setFont(new Font("Serif", Font.PLAIN, 22));
        waitMessageJlabel.setHorizontalAlignment(SwingConstants.CENTER);
        waitTurnPanel.add(Box.createRigidArea(new Dimension(450, 0)));
        waitTurnPanel.add(waitMessageJlabel);
        waitTurnPanel.setVisible(false);
    }

}
