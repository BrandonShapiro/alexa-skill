package com.weber.cs3230.adminapp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AlexaAdminApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AlexaAdminApp().startApp());
    }

    public void startApp(){
            JFrame mainFrame = new JFrame();
            mainFrame.setPreferredSize(new Dimension(500, 300));
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.add(createMainPanel());
            mainFrame.pack();
            mainFrame.setVisible(true); //hangs here
    }

    private JComponent createMainPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(new JLabel("Alexa Admin Utility"), BorderLayout.NORTH);
        mainPanel.add(createTablePanel(), BorderLayout.CENTER);
        mainPanel.add(createButtonPanel(), BorderLayout.SOUTH);
        return mainPanel;
    }


    private JComponent createTablePanel() {
        String[] columnNames = {"Intent", "Date Added"};
        Object[][] data = {
                {"top_scorer", "06/15/2022"},
                {"coach", "06/15/2022"},
                {"color", "06/15/2022"},
                {"founded", "06/15/2022"},
                {"goal_amount", "06/15/2022"},
                {"best_team", "06/15/2022"},
                {"motto", "06/15/2022"},
                {"rival", "06/15/2022"},
                {"titles", "06/15/2022"},
                {"best_player", "06/15/2022"}
        };
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        scrollPane.setVisible(true);
        return scrollPane;
    }

    private JComponent createButtonPanel(){
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));

        JButton addRowButton = new JButton("Add New Intent");
        JButton deleteRowButton = new JButton("Delete Intent");
        JButton editRowButton = new JButton("Edit Intent");

        buttonPanel.add(addRowButton);
        buttonPanel.add(editRowButton);
        buttonPanel.add(deleteRowButton);

        return buttonPanel;
    }

}
