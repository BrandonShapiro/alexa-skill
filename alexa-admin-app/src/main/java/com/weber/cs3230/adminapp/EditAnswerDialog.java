package com.weber.cs3230.adminapp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDate;

public class EditAnswerDialog extends JDialog {
    private final Intent answer;
    private JTextField answerField;

    //for adding new answer
    public EditAnswerDialog(){
        this(new Intent());
    }

    //for editing existing answer
    public EditAnswerDialog(Intent answer){
        this.answer = answer;
        setPreferredSize(new Dimension(650, 150));
        setModalityType(ModalityType.APPLICATION_MODAL);
        add(getEditAnswerPanel());
        pack();
        setAlwaysOnTop(true);
    }

    private JComponent getEditAnswerPanel(){
        JPanel editAnswerPanel = new JPanel(new GridLayout(2,1));

        JPanel upperHalf = new JPanel(new GridLayout(2,1));
        upperHalf.setBorder(new EmptyBorder(10,20,0,20));

        JLabel answerLabel = new JLabel("Answer: ");
        answerLabel.setHorizontalAlignment(JLabel.CENTER);
        upperHalf.add(answerLabel);

        answerField = new JTextField(answer.getName());
        answerField.setPreferredSize(new Dimension(550, 25));
        upperHalf.add(answerField);

        JPanel lowerHalf = new JPanel(new GridLayout(1,2));
        lowerHalf.setBorder(new EmptyBorder(10,50,10,50));

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e-> closeDialog());
        lowerHalf.add(cancelButton);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e->{
            answer.setName(answerField.getText());
            answer.setDateAdded(String.valueOf(LocalDate.now()));
            closeDialog();
        });
        lowerHalf.add(saveButton);

        editAnswerPanel.add(upperHalf);
        editAnswerPanel.add(lowerHalf);

        return editAnswerPanel;
    }

    public Intent getAnswer() {return answer;}

    private void closeDialog(){
        setVisible(false);
        dispose();
    }
}
