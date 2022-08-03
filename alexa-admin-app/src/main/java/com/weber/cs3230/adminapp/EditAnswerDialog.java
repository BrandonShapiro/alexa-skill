package com.weber.cs3230.adminapp;

import com.weber.cs3230.adminapp.api.ApiClient;
import com.weber.cs3230.adminapp.dto.IntentAnswer;
import com.weber.cs3230.adminapp.dto.IntentDetail;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDate;
import java.util.concurrent.ExecutionException;

public class EditAnswerDialog extends JDialog {
    private final IntentAnswer answer;
    private final IntentDetail intent;
    private JTextField answerField;
    private final boolean isEditing;

    //for adding new answer
    public EditAnswerDialog(IntentDetail intent){
        this(intent, new IntentAnswer(),false);
    }
    //for editing existing answer
    public EditAnswerDialog(IntentDetail intent, IntentAnswer answer){this(intent, answer, true);}


    public EditAnswerDialog(IntentDetail intent, IntentAnswer answer, boolean isEditing){
        this.answer = answer;
        this.intent = intent;
        this.isEditing = isEditing;
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

        answerField = new JTextField(answer.getText());
        answerField.setPreferredSize(new Dimension(550, 25));
        upperHalf.add(answerField);

        JPanel lowerHalf = new JPanel(new GridLayout(1,2));
        lowerHalf.setBorder(new EmptyBorder(10,50,10,50));

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e-> {
            LockoutChecker.lastClick = System.currentTimeMillis();
            closeDialog();
        });
        lowerHalf.add(cancelButton);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e->{
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            final String newAnswer = answerField.getText();
            SwingWorker<IntentAnswer, Object> worker = new SwingWorker<>() {
                @Override
                protected IntentAnswer doInBackground(){
                    ApiClient apiClient = new ApiClient();
                    if(isEditing){
                        return apiClient.updateAnswer(intent.getIntentID(), answer.getAnswerID(), newAnswer);
                    }else {
                        return apiClient.saveNewAnswer(intent.getIntentID(), newAnswer);
                    }
                }
                @Override
                protected void done(){
                    setCursor(Cursor.getDefaultCursor());
                    LockoutChecker.lastClick = System.currentTimeMillis();
                    answer.setText(newAnswer);
                    answer.setDateAdded(String.valueOf(LocalDate.now()));
                    try {
                        answer.setAnswerID(get().getAnswerID());
                        //System.out.println("New answer ID:" + get().getAnswerID());
                    } catch (Exception ex) {
                        System.out.println("Unable to get new answer ID");
                    }
                    closeDialog();
                }
            };
            worker.execute();
        });

        lowerHalf.add(saveButton);

        editAnswerPanel.add(upperHalf);
        editAnswerPanel.add(lowerHalf);

        return editAnswerPanel;
    }

    public IntentAnswer getAnswer() {return answer;}

    private void closeDialog(){
        setVisible(false);
        dispose();
    }
}
