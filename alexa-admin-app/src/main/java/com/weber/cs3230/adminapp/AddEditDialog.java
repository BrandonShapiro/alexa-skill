package com.weber.cs3230.adminapp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddEditDialog extends JDialog {

    private final Intent intent;
    private JTextField intentNameField;
    private JTable table;
    private DefaultTableModel model;
    private final java.util.List<Intent> answerList = new ArrayList<>();
    private final String[] columnNames = {"Answer", "Date Added"};

    //for ADDING NEW intent
    public AddEditDialog(){
        this(new Intent());
    }

    //for EDITING EXISTING intent
    public AddEditDialog(Intent intent) {
        this.intent = intent;
        getAnswerList();
        setPreferredSize(new Dimension(500, 350));
        setModalityType(ModalityType.APPLICATION_MODAL);
        add(getAddEditPanel());
        pack();
    }

    public Intent getIntent() {
        return intent;
    }

    void updateTableData() {
        model.setDataVector(getTableData(), columnNames);
    }
    private JComponent getAddEditPanel(){
        JPanel addEditPanel = new JPanel(new GridLayout(4,1));

        //top panel: label and text field for editing intent name
        addEditPanel.add(getTopPanel());
        //table panel: table with intent answers
        addEditPanel.add(getTablePanel());
        //action panel: add, edit, delete answer
        addEditPanel.add(getActionPanel());
        //save panel: cancel and save button
        addEditPanel.add(getSavePanel());

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
        table.getColumnModel().getColumn(0).setPreferredWidth(325);
        table.getColumnModel().getColumn(1).setPreferredWidth(25);
        scrollPane.setVisible(true);
        return scrollPane;
    }

    private JComponent getActionPanel() {
        JPanel actionPanel = new JPanel(new GridLayout(1, 3));
        actionPanel.setBorder(new EmptyBorder(10,30,10,30));
        JButton addAnswerButton = new JButton("Add New Answer");
        addAnswerButton.addActionListener(e->{
            LockoutChecker.lastClick = System.currentTimeMillis();
            EditAnswerDialog editAnswerDialog = new EditAnswerDialog();
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
            answerList.remove(row);
            updateTableData();
        });

        JButton editRowButton = new JButton("Edit Answer");
        editRowButton.addActionListener(e->{
            LockoutChecker.lastClick = System.currentTimeMillis();
            int row = table.getSelectedRow();
            if(row < 0){
                return;
            }
            EditAnswerDialog editAnswerDialog = new EditAnswerDialog(answerList.get(row));
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
        savePanel.setBorder(new EmptyBorder(10,50,20,50));

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e-> {
            LockoutChecker.lastClick = System.currentTimeMillis();
            closeDialog();
        });

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e->{
            LockoutChecker.lastClick = System.currentTimeMillis();
            intent.setName(intentNameField.getText());
            intent.setDateAdded(String.valueOf(LocalDate.now()));
            closeDialog();
        });

        savePanel.add(cancelButton);
        savePanel.add(saveButton);

        return savePanel;
    }

    public void getAnswerList() {

        switch (intent.getName()){
            case "top_scorer":
                answerList.add(new Intent("Mohammed Salah was the top scorer.", "2022-06-15"));
                answerList.add(new Intent("Mo Salah scored 22 goals.", "2022-06-15"));
                answerList.add(new Intent("Salah had the most with 22 goals.", "2022-06-15"));
                break;
            case "coach":
                answerList.add(new Intent("Jurgen Klopp is their head coach.", "2022-06-15"));
                answerList.add(new Intent("The current head coach is Jurgen Klopp.", "2022-06-15"));
                answerList.add(new Intent("Liverpool's coach is Jurgen Klopp.", "2022-06-15"));
                break;
            case "color":
                answerList.add(new Intent("Liverpool's main color is Red.", "2022-06-15"));
                answerList.add(new Intent("Their colors are Red, Green, and Gold.", "2022-06-15"));
                answerList.add(new Intent("Liverpool's home color is always Red.", "2022-06-15"));
                break;
            case "founded":
                answerList.add(new Intent("LFC was founded on June 3, 1892.", "2022-06-15"));
                answerList.add(new Intent("June 3, 1892", "2022-06-15"));
                answerList.add(new Intent("Liverpool was founded in 1892 on June 3rd", "2022-06-15"));
                break;
            case "goal_amount":
                answerList.add(new Intent("Liverpool scored 139 goals across all competitions", "2022-06-15"));
                answerList.add(new Intent("They set their new record high of 139 goals in a single season.", "2022-06-15"));
                answerList.add(new Intent("139 goals were scored by Liverpool this year", "2022-06-15"));
                break;
            case "best_team":
                answerList.add(new Intent("Liverpool FC are the top team", "2022-06-15"));
                answerList.add(new Intent("The best team is Liverpool!", "2022-06-15"));
                answerList.add(new Intent("Liverpool of course!", "2022-06-15"));
                break;
            case "motto":
                answerList.add(new Intent("YNWA - You'll Never Walk Alone","2022-06-15"));
                answerList.add(new Intent("Liverpool's motto is You'll Never Walk Alone","2022-06-15"));
                answerList.add(new Intent("You'll Never Walk Alone was adopted as their motto prior to 1982.","2022-06-15"));
                break;
            case "rival":
                answerList.add(new Intent("Everton is Liverpool's biggest rival.","2022-06-15"));
                answerList.add(new Intent("The rivalry between Liverpool and Everton is unmatched.","2022-06-15"));
                answerList.add(new Intent("Everton, who also reside in Merseyside, are Liverpool's rival.","2022-06-15"));
                break;
            case "titles":
                answerList.add(new Intent("Liverpool has won the title 19 times.","2022-06-15"));
                answerList.add(new Intent("Liverpool have achieved 19 league titles.","2022-06-15"));
                answerList.add(new Intent("With their most recent win in 2019, Liverpool have won the league 19 times.","2022-06-15"));
                break;
            case "best_player":
                answerList.add(new Intent("Mohammed Salah","2022-06-15"));
                answerList.add(new Intent("Trent Alexander Arnold","2022-06-15"));
                answerList.add(new Intent("Virgil Van Dijk","2022-06-15"));
                break;
            default:
                break;
        }
    }

    private Object[][] getTableData() {
        java.util.List<Object[]> rows = new ArrayList<>();
        for(Intent answer: answerList){
            Object[] newRow = new Object[2];
            newRow[0] = answer.getName();
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
