package com.weber.cs3230.adminapp;

import com.weber.cs3230.adminapp.api.ApiClient;
import com.weber.cs3230.adminapp.dto.IntentAnswerList;
import com.weber.cs3230.adminapp.dto.IntentDetail;
import com.weber.cs3230.adminapp.dto.IntentAnswer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class AddEditDialog extends JDialog {

    private final IntentDetail intent;
    private JTextField intentNameField;
    private JTable table;
    private DefaultTableModel model;
    private java.util.List<IntentAnswer> answerList = new ArrayList<>();
    private final String[] columnNames = {"Answer", "Date Added"};
    private final boolean isEditing;

    //for ADDING NEW intent
    public AddEditDialog(){
        this(new IntentDetail(), false);
    }

    //for EDITING EXISTING intent
    public AddEditDialog(IntentDetail intent){this(intent, true);}
    public AddEditDialog(IntentDetail intent, Boolean isEditing) {
        this.intent = intent;
        this.isEditing = isEditing;
        setPreferredSize(new Dimension(800, 450));
        setModalityType(ModalityType.APPLICATION_MODAL);
        add(getAddEditPanel());
        pack();
        getAnswerList();
    }

    public IntentDetail getIntent() {
        return intent;
    }

    void updateTableData() {
        model.setDataVector(getTableData(), columnNames);
    }
    private JComponent getAddEditPanel(){
        JPanel addEditPanel = new JPanel(new BorderLayout());

        //top panel: label and text field for editing intent name
        addEditPanel.add(getTopPanel(), BorderLayout.PAGE_START);
        //table panel: table with intent answers
        addEditPanel.add(getTablePanel(), BorderLayout.CENTER);
        //Button Panel, contains all 5 buttons
        JPanel buttonPanel = new JPanel(new GridLayout(2,1));
        buttonPanel.add(getActionPanel());
        buttonPanel.add(getSavePanel());
        addEditPanel.add(buttonPanel, BorderLayout.PAGE_END);


        return addEditPanel;
    }

    private JPanel getTopPanel(){

        JPanel topPanel = new JPanel(new GridLayout(1,2));
        JLabel intentLabel = new JLabel("Intent name: ");
        topPanel.add(intentLabel);
        intentNameField = new JTextField();
        intentNameField.setText(intent.getName());
        topPanel.add(intentNameField);

        topPanel.setBorder(new EmptyBorder(10,50,10,50));

        return topPanel;
    }

    private JComponent getTablePanel(){

        model = new DefaultTableModel(getTableData(), columnNames);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        table.getColumnModel().getColumn(0).setPreferredWidth(650);
        table.getColumnModel().getColumn(1).setPreferredWidth(50);
        scrollPane.setVisible(true);
        return scrollPane;
    }

    private JComponent getActionPanel() {
        JPanel actionPanel = new JPanel(new GridLayout(1, 3));
        actionPanel.setBorder(new EmptyBorder(10,30,10,30));
        JButton addAnswerButton = new JButton("Add New Answer");
        addAnswerButton.addActionListener(e->{
            LockoutChecker.lastClick = System.currentTimeMillis();
            EditAnswerDialog editAnswerDialog = new EditAnswerDialog(intent);
            editAnswerDialog.setVisible(true);

            answerList.add(editAnswerDialog.getAnswer());
            updateTableData();
        });

        JButton deleteAnswerButton = new JButton("Delete Answer");
        deleteAnswerButton.addActionListener(e->{
            LockoutChecker.lastClick = System.currentTimeMillis();
            int row = table.getSelectedRow();
            if(row < 0){
                return;
            }
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            SwingWorker<Object, Object> worker = new SwingWorker<>() {
                @Override
                protected Object doInBackground(){
                    int row = table.getSelectedRow();
                    IntentAnswer deleteAnswer = answerList.get(row);

                    new ApiClient().deleteAnswer(intent.getIntentID(), deleteAnswer.getAnswerID());
                    return true;
                }
                @Override
                protected void done(){
                    setCursor(Cursor.getDefaultCursor());

                    answerList.remove(row);
                    updateTableData();
                }
            };
            worker.execute();
        });

        JButton editRowButton = new JButton("Edit Answer");
        editRowButton.addActionListener(e->{
            LockoutChecker.lastClick = System.currentTimeMillis();
            int row = table.getSelectedRow();
            if(row < 0){
                return;
            }
            EditAnswerDialog editAnswerDialog = new EditAnswerDialog(intent, answerList.get(row));
            editAnswerDialog.setVisible(true);

            updateTableData();
        });

        actionPanel.add(addAnswerButton);
        actionPanel.add(editRowButton);
        actionPanel.add(deleteAnswerButton);

        return actionPanel;
    }
    private JPanel getSavePanel(){
        JPanel savePanel = new JPanel(new GridLayout(1,2));
        savePanel.setBorder(new EmptyBorder(10,30,10,30));

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e-> {
            LockoutChecker.lastClick = System.currentTimeMillis();
            closeDialog();
        });

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e->{
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            final String newIntentName = intentNameField.getText();
            SwingWorker<IntentDetail, Object> worker = new SwingWorker<>() {
                @Override
                protected IntentDetail doInBackground(){
                    ApiClient apiClient = new ApiClient();
                    if(isEditing){
                        return apiClient.updateIntent(intent.getIntentID(), newIntentName);
                    }else{
                        return apiClient.saveNewIntent(newIntentName);
                    }
                }
                @Override
                protected void done(){
                    setCursor(Cursor.getDefaultCursor());
                    LockoutChecker.lastClick = System.currentTimeMillis();
                    intent.setName(newIntentName);
                    intent.setDateAdded(String.valueOf(LocalDate.now()));
                    try {
                        intent.setIntentID(get().getIntentID());
                        //System.out.println("intent ID:" + get().getIntentID());
                    } catch (Exception ex) {
                        System.out.println("Unable to get new Intent ID.");
                    }
                    closeDialog();
                }
            };
            worker.execute();
        });

        savePanel.add(cancelButton);
        savePanel.add(saveButton);

        return savePanel;
    }

    public void getAnswerList() {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        SwingWorker<IntentAnswerList, Object> worker = new SwingWorker<>() {
            @Override
            protected IntentAnswerList doInBackground(){
                return new ApiClient().getAnswers(intent.getIntentID());
            }
            @Override
            protected void done(){
                setCursor(Cursor.getDefaultCursor());
                try {
                    answerList = get().getAnswers();
                    updateTableData();
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error getting answers for Intent", "ERROR", JOptionPane.WARNING_MESSAGE);
                }
            }
        };
        worker.execute();
    }

    private Object[][] getTableData() {
        java.util.List<Object[]> rows = new ArrayList<>();
        for(IntentAnswer answer: answerList){
            Object[] newRow = new Object[2];
            newRow[0] = answer.getText();
            newRow[1] = answer.getDateAdded();
            rows.add(newRow);
        }
        return rows.toArray(new Object[0][0]);
    }

    private void closeDialog(){
        setVisible(false);
        dispose();
    }
}
