package com.weber.cs3230.adminapp;

import com.weber.cs3230.adminapp.api.ApiClient;

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

        setPreferredSize(new Dimension(450, 200));
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

        //third row: Login/Cancel buttons
        JButton cancelButton = new JButton("Cancel");
        loginPanel.add(cancelButton);
        JButton loginButton = new JButton("Login");
        loginPanel.add(loginButton);

        cancelButton.addActionListener(e->closeDialog());

        loginButton.addActionListener(e ->{
            LockoutChecker.lastClick = System.currentTimeMillis();
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            SwingWorker<Boolean, Boolean> worker = new SwingWorker<>(){
                @Override
                protected Boolean doInBackground(){
                    return new ApiClient().validateCreds(usernameField.getText(), new String(passwordField.getPassword()));
                }
                @Override
                protected void done(){
                    setCursor(Cursor.getDefaultCursor());
                    try{
                        boolean credsValid = get();
                        if(credsValid){
                            authenticated = true;
                            closeDialog();
                        }else{
                            JOptionPane.showMessageDialog(LoginDialog.this, "Username or Password is incorrect. Please try again.", "Login Failed", JOptionPane.WARNING_MESSAGE);
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(LoginDialog.this, "Login Failed. Please try again.", "Login Error.", JOptionPane.WARNING_MESSAGE);
                    }
                }
            };
            worker.execute();
        });
        return loginPanel;
    }
}
