package com.weber.cs3230.adminapp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ViewMetricDialog extends JDialog {

    public ViewMetricDialog(){
        setPreferredSize(new Dimension(500, 300));
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        add(getViewMetricPanel());
        pack();
        setAlwaysOnTop(true);
    }

    private JPanel getViewMetricPanel(){
        JPanel viewMetricPanel = new JPanel(new GridLayout(2,1));
        JLabel placeHolder = new JLabel("THIS IS A PLACEHOLDER!");
        placeHolder.setHorizontalAlignment(JLabel.CENTER);
        placeHolder.setBorder(new EmptyBorder(10,10,10,10));
        viewMetricPanel.add(placeHolder);

        JButton exitButton = new JButton("CLOSE");
        exitButton.addActionListener(e-> closeDialog());
        viewMetricPanel.add(exitButton);

        return viewMetricPanel;
    }

    private void closeDialog(){
        setVisible(false);
        dispose();
    }
}
