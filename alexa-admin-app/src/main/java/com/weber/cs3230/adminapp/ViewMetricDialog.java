package com.weber.cs3230.adminapp;

import com.weber.cs3230.adminapp.dto.MetricDetail;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ViewMetricDialog extends JDialog {

    private final java.util.List<MetricDetail> metricDetailList;
    private final String [] columnNames = {"Name", "Count", "Most recent date"};

    public ViewMetricDialog(java.util.List<MetricDetail> metricDetailList){
        this.metricDetailList = metricDetailList;
        setPreferredSize(new Dimension(800, 450));
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        add(getViewMetricPanel());
        pack();
        setAlwaysOnTop(true);
    }

    private JPanel getViewMetricPanel(){
        JPanel viewMetricPanel = new JPanel(new BorderLayout());

        JLabel header = new JLabel("Brandon's Alexa App - Metrics");
        header.setBorder(new EmptyBorder(10, 0,20,0));
        header.setFont(new Font("Serif", Font.BOLD, 20));
        header.setHorizontalAlignment(JLabel.CENTER);
        viewMetricPanel.add(header, BorderLayout.PAGE_START);

        viewMetricPanel.add(createTablePanel(), BorderLayout.CENTER);


        JPanel exitPanel = new JPanel(new GridLayout(1,3));
        exitPanel.setBorder(new EmptyBorder(5,5,5,5));

        JButton exitButton = new JButton("CLOSE");
        exitButton.addActionListener(e-> closeDialog());

        exitPanel.add(new JLabel());
        exitPanel.add(exitButton);
        exitPanel.add(new JLabel());

        viewMetricPanel.add(exitPanel, BorderLayout.PAGE_END);

        return viewMetricPanel;
    }

    private JComponent createTablePanel() {

        DefaultTableModel model = new DefaultTableModel(getTableData(), columnNames);
        JTable table = new JTable(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(565);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        scrollPane.setVisible(true);
        return scrollPane;
    }

    private Object[][] getTableData() {
        java.util.List<Object[]> rows = new ArrayList<>();
        for(MetricDetail metric: metricDetailList){
            Object[] newRow = new Object[3];
            newRow[0] = metric.getEventName();
            newRow[1] = metric.getCount();
            newRow[2] = metric.getMostRecentDate();
            rows.add(newRow);
        }
        return rows.toArray(new Object[0][0]);
    }
    private void closeDialog(){
        setVisible(false);
        dispose();
    }
}
