package com.weber.cs3230.adminapp;

import com.weber.cs3230.adminapp.api.ApiClient;
import com.weber.cs3230.adminapp.dto.IntentDetail;
import com.weber.cs3230.adminapp.dto.MetricDetailList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;


public class AlexaAdminMainPanel extends JPanel {

    private JTable table;
    private DefaultTableModel model;
    private final java.util.List<IntentDetail> intentList;
    private final String[] columnNames = {"Intent Name", "Date Added"};

    AlexaAdminMainPanel(java.util.List<IntentDetail> intentList) {
        this.intentList = intentList;
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

        model = new DefaultTableModel(getTableData(), columnNames);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        scrollPane.setVisible(true);
        return scrollPane;
    }

    private Object[][] getTableData() {
        java.util.List<Object[]> rows = new ArrayList<>();
        for(IntentDetail intent: intentList){
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
            LockoutChecker.lastClick = System.currentTimeMillis();
            AddEditDialog addEditDialog = new AddEditDialog();
            addEditDialog.setVisible(true);

            intentList.add(addEditDialog.getIntent());
            updateTableData();
        });

        JButton deleteRowButton = new JButton("Delete Intent");
        deleteRowButton.addActionListener(e->{
            LockoutChecker.lastClick = System.currentTimeMillis();
            int row = table.getSelectedRow();
            if(row < 0){
                return;
            }
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            SwingWorker<Object, Object> worker = new SwingWorker<>() {
                @Override
                protected Object doInBackground(){
                    IntentDetail deleteIntent = intentList.get(row);

                   new ApiClient().deleteIntent(deleteIntent.getIntentID());
                    return true;
                }
                @Override
                protected void done(){
                    setCursor(Cursor.getDefaultCursor());

                    intentList.remove(row);
                    updateTableData();
                }
            };
            worker.execute();
        });

        JButton editRowButton = new JButton("Edit Intent");
        editRowButton.addActionListener(e->{
            LockoutChecker.lastClick = System.currentTimeMillis();
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
            LockoutChecker.lastClick = System.currentTimeMillis();
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

            SwingWorker<MetricDetailList, Object> worker = new SwingWorker<>() {
                @Override
                protected MetricDetailList doInBackground(){
                    return new ApiClient().getMetrics();
                }
                @Override
                protected void done(){
                    setCursor(Cursor.getDefaultCursor());

                    try {
                        ViewMetricDialog metricDialog = new ViewMetricDialog(get().getMetrics());
                        metricDialog.setVisible(true);
                    } catch (Exception ex) {
                        ex.getCause();
                        ex.printStackTrace();
                        System.out.println("Unable to get metrics list.");
                    }
                }
            };
            worker.execute();
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
