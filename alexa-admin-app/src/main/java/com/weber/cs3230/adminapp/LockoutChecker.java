package com.weber.cs3230.adminapp;

import javax.swing.*;

public class LockoutChecker {
    public static volatile long lastClick = 0L;     //time in milliseconds since last button click

    public void startLockoutThread(){
        new Thread(()-> {
            try {
                watchForInactivity();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    private void watchForInactivity() throws Exception {
        boolean inactive = false;
        while(!inactive){
            Thread.sleep(30000); // wait 30 seconds
            long nowTime = System.currentTimeMillis();
            long timeDiff = nowTime - lastClick;
            if(timeDiff > 600000){ // if inactivity is longer than 10 minutes - lockout
                inactive = true;
            }
        }

        SwingUtilities.invokeLater(()->{
            JOptionPane.showMessageDialog(null, "Logged out due to inactivity. Please sign back in to continue.", "Account inactive", JOptionPane.WARNING_MESSAGE);

            LoginDialog loginDialog = new LoginDialog();
            loginDialog.setVisible(true);

            LockoutChecker newLockoutChecker = new LockoutChecker();
            newLockoutChecker.startLockoutThread();
        });
    }
}
