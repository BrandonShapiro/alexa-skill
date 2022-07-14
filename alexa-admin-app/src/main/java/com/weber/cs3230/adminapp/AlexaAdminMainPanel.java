package com.weber.cs3230.adminapp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AlexaAdminMainPanel extends JPanel {
    AlexaAdminMainPanel(){
        super.setLayout(new BorderLayout());

        JLabel header = new JLabel("Brandon's Alexa Admin Utility");
        add(header, BorderLayout.PAGE_START);
        header.setHorizontalAlignment(JLabel.CENTER);

        add(createTablePanel(), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.PAGE_END);
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
        //addRowButton.addActionListener();

        JButton deleteRowButton = new JButton("Delete Intent");
        //deleteRowButton.addActionListener();

        JButton editRowButton = new JButton("Edit Intent");
        //editRowButton.addActionListener();

        buttonPanel.add(addRowButton);
        buttonPanel.add(editRowButton);
        buttonPanel.add(deleteRowButton);

        return buttonPanel;
    }
}
