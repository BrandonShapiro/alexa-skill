package com.weber.cs3230;

import java.util.Scanner;

public class ChatBotMain {

    public static void main(String[] args) {
        WelcomeMessage w = new WelcomeMessage();
        w.printWelcome();
        ChatBotRunner cb = new ChatBotRunner();
        cb.StartChatting();

    }
}
