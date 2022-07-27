package com.weber.cs3230.adminapp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;


public class AlexaAdminMainPanel extends JPanel {

    private JTable table;
    private DefaultTableModel model;
    private final java.util.List<Intent> intentList = new ArrayList<>();
    private final String[] columnNames = {"Intent Name", "Date Added"};

    AlexaAdminMainPanel() {
        super.setLayout(new BorderLayout());
        super.setBorder(new EmptyBorder(10,30,10,30));

        add(createHeaderPanel(), BorderLayout.PAGE_START);
        add(createTablePanel(), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.PAGE_END);
    }

    private JComponent createHeaderPanel(){

        JPanel headerPanel = new JPanel(new BorderLayout());
        JLabel header = new JLabel("Brandon's Alexa Admin Utility");
        header.setBorder(new EmptyBorder(0, 0,20,0));
        header.setFont(new Font("Serif", Font.BOLD, 20));
        header.setHorizontalAlignment(JLabel.CENTER);
        headerPanel.add(header, BorderLayout.PAGE_START);

        return headerPanel;
    }
    private JComponent createTablePanel() {

        intentList.add(new Intent("top_scorer", "2022-06-15"));
        intentList.add(new Intent("coach", "2022-06-15"));
        intentList.add(new Intent("color", "2022-06-15"));
        intentList.add(new Intent("founded", "2022-06-15"));
        intentList.add(new Intent("goal_amount", "2022-06-15"));
        intentList.add(new Intent("best_team", "2022-06-15"));
        intentList.add(new Intent("motto", "2022-06-15"));
        intentList.add(new Intent("rival", "2022-06-15"));
        intentList.add(new Intent("titles", "2022-06-15"));
        intentList.add(new Intent("best_player", "2022-06-15"));

        model = new DefaultTableModel(getTableData(), columnNames);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        scrollPane.setVisible(true);
        return scrollPane;
    }

    private Object[][] getTableData() {
        java.util.List<Object[]> rows = new ArrayList<>();
        for(Intent intent: intentList){
            Object[] newRow = new Object[2];
            newRow[0] = intent.getName();
            newRow[1] = intent.getDateAdded();
            rows.add(newRow);
        }
        return rows.toArray(new Object[0][0]);
    }

    void updateTableData() {
        model.setDataVector(getTableData(), columnNames);
    }

    private JComponent createButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3));

        JButton addRowButton = new JButton("Add New Intent");
        addRowButton.addActionListener(e->{
            AddEditDialog addEditDialog = new AddEditDialog();
            addEditDialog.setVisible(true);

            intentList.add(addEditDialog.getIntent());
            updateTableData();
        });

        JButton deleteRowButton = new JButton("Delete Intent");
        deleteRowButton.addActionListener(e->{
            int row = table.getSelectedRow();
            if(row < 0){
                return;
            }
            intentList.remove(row);
            updateTableData();
        });

        JButton editRowButton = new JButton("Edit Intent");
        editRowButton.addActionListener(e->{
            int row = table.getSelectedRow();
            if(row < 0){
                return;
            }
            AddEditDialog addEditDialog = new AddEditDialog(intentList.get(row));
            addEditDialog.setVisible(true);

            updateTableData();
        });

        JButton viewMetricButton = new JButton("View Metrics");
        viewMetricButton.addActionListener(e->{
            ViewMetricDialog viewMetricDialog = new ViewMetricDialog();
            viewMetricDialog.setVisible(true);
        });

        buttonPanel.add(addRowButton);
        buttonPanel.add(editRowButton);
        buttonPanel.add(deleteRowButton);

        buttonPanel.add(new JLabel());
        buttonPanel.add(viewMetricButton);
        buttonPanel.add(new JLabel());

        return buttonPanel;
    }
}
