package com.weber.cs3230.adminapp;

import javax.swing.*;

public class AlexaAdminApp {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            LockoutChecker lockoutChecker = new LockoutChecker();
            lockoutChecker.startLockoutThread();

            LoginDialog loginDialog = new LoginDialog();
            loginDialog.setVisible(true);

            if(loginDialog.isAuthenticated()) {
                AlexaAdminFrame mainFrame = new AlexaAdminFrame();
                mainFrame.setVisible(true);
            }
        });
    }
}
