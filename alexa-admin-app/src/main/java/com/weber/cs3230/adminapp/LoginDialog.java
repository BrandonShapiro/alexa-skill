package com.weber.cs3230.adminapp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginDialog extends JDialog {
    private boolean authenticated = false;

    public boolean isAuthenticated() {
        return authenticated;
    }

    private void closeDialog(){
        setVisible(false);
        dispose();
    }

    LoginDialog(){
        super.setLayout(new BorderLayout());

        setPreferredSize(new Dimension(300, 150));
        setModalityType(ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JLabel header = new JLabel("Brandon's Alexa Admin Utility Login");
        header.setFont(new Font("Serif", Font.BOLD,15));
        header.setBorder(new EmptyBorder(10,0,0,0));

        add(header, BorderLayout.PAGE_START);
        header.setHorizontalAlignment(JLabel.CENTER);

        add(getLoginPanel(), JLabel.CENTER);
        pack();
    }

    JPanel getLoginPanel(){
        JPanel loginPanel = new JPanel(new GridLayout(3,2));
        loginPanel.setBorder(new EmptyBorder(10,10,10,10));

        //first row: Username label and text field
        loginPanel.add(new JLabel("Username: "));
        JTextField usernameField = new JTextField();
        loginPanel.add(usernameField);

        //second row: Password label and text field
        loginPanel.add(new JLabel("Password: "));
        JPasswordField passwordField = new JPasswordField();
        loginPanel.add(passwordField);

        //third row: Login button
        JLabel blankLabel = new JLabel("");
        loginPanel.add(blankLabel);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e ->{
            LockoutChecker.lastClick = System.currentTimeMillis();
            if("user".equals(usernameField.getText()) && "pass".equals(new String(passwordField.getPassword()))){
                authenticated = true;
                closeDialog();
            }
            else{
                JOptionPane.showMessageDialog(this, "Username or Password is incorrect, please try again.", "Login Failed", JOptionPane.WARNING_MESSAGE);
            }
        });
        loginPanel.add(loginButton);

        return loginPanel;
    }
}
