package com.weber.cs3230.adminapp;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class AddEditDialog extends JDialog {

    private final Intent intent;

    //for ADDING NEW intent
    public AddEditDialog(){
        this(new Intent());
    }

    //for EDITING EXISTING intent
    public AddEditDialog(Intent intent) {
        this.intent = intent;
        setPreferredSize(new Dimension(300, 150));
        setModalityType(ModalityType.APPLICATION_MODAL);
        add(getAddEditPanel());
        pack();
    }

    public Intent getIntent() {
        return intent;
    }

    private JComponent getAddEditPanel(){
        JPanel addEditPanel = new JPanel(new GridLayout(2,2));

        //first row: Label and text field for intent name
        addEditPanel.add(new JLabel("Intent name: "));
        JTextField intentNameField = new JTextField();
        intentNameField.setText(intent.getName());
        addEditPanel.add(intentNameField);

        //second row: cancel and save button
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e-> closeDialog());

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e->{
            intent.setName(intentNameField.getText());
            intent.setDateAdded(String.valueOf(LocalDate.now()));
            closeDialog();
        });

        addEditPanel.add(cancelButton);
        addEditPanel.add(saveButton);

        return addEditPanel;
    }

    public void closeDialog(){
        setVisible(false);
        dispose();
    }
}
