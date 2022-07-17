package com.weber.cs3230.adminapp;

import javax.swing.*;
import java.awt.*;

public class AlexaAdminFrame extends JFrame{
    AlexaAdminFrame(){
        setPreferredSize(new Dimension(500, 350));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new AlexaAdminMainPanel());
        pack();
    }
}
