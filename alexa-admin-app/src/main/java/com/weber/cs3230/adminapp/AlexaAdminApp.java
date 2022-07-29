package com.weber.cs3230.adminapp;

import com.weber.cs3230.adminapp.api.ApiClient;
import com.weber.cs3230.adminapp.dto.IntentDetailList;
import javax.swing.*;
import java.awt.*;

public class AlexaAdminApp {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            LockoutChecker lockoutChecker = new LockoutChecker();
            lockoutChecker.startLockoutThread();

            LoginDialog loginDialog = new LoginDialog();
            loginDialog.setVisible(true);

            if(loginDialog.isAuthenticated()) {
                loginDialog.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                SwingWorker<IntentDetailList, Object> worker = new SwingWorker<>() {
                    @Override
                    protected IntentDetailList doInBackground(){
                        return new ApiClient().getIntents();
                    }
                    @Override
                    protected void done(){
                        loginDialog.setCursor(Cursor.getDefaultCursor());
                        try {
                            AlexaAdminFrame mainFrame = new AlexaAdminFrame(get().getIntents());
                            mainFrame.setVisible(true);;
                        } catch (Exception e) {
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error fetching data.", "ERROR", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                };
                worker.execute();
            }
        });
    }
}
