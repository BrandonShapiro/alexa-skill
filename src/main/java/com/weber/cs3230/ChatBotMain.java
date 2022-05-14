package com.weber.cs3230;

import java.util.Scanner;

public class ChatBotMain {

    public static void main(String[] args) {

        System.out.println("Welcome to ChatBot!");
        System.out.println();
        System.out.println("Please ask a question or type 'q' to quit: ");

        Scanner input = new Scanner(System.in);
        String question = input.nextLine();

        while(!question.equalsIgnoreCase("q")){
            switch (question){
                case "what does a dog say?":
                    System.out.println("Woof!");
                    break;
                case "what does a cat say?":
                    System.out.println("Meowwww");
                    break;
                case "what does a pig say?":
                    System.out.println("Oink Oink!");
                    break;
                case "what does a horse say?":
                    System.out.println("Neighhhh");
                    break;
                case "what does a cow say?":
                    System.out.println("Moooooo");
                    break;
                case "what does a chicken say?":
                    System.out.println("cluck cluck");
                    break;
                case "what does a duck say?":
                    System.out.println("Quack quack!");
                    break;
                case "what does a fish say?":
                    System.out.println("glub glub glub");
                    break;
                case "what does a rooster say?":
                    System.out.println("Cockadoodledoo!");
                    break;
                case "what does a sheep say?":
                    System.out.println("Baaahhhh");
                    break;
            }

            System.out.println("Ask another question or type 'q' to quit: ");
            question = input.nextLine();
        }


    }
}
