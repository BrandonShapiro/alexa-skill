package com.weber.cs3230.adminapp;

import com.weber.cs3230.adminapp.dto.IntentDetail;

import javax.swing.*;
import java.awt.*;

public class AlexaAdminFrame extends JFrame{
    AlexaAdminFrame(java.util.List<IntentDetail> intentList){
        setPreferredSize(new Dimension(500, 350));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new AlexaAdminMainPanel(intentList));
        pack();
    }
}
