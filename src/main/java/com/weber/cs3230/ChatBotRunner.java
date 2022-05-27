package com.weber.cs3230;

import java.util.*;

public class ChatBotRunner {

    public void startChatting(){
        Scanner input = new Scanner(System.in);
        Map<String, String> responseCache = new HashMap<>();
        Set<String> questionCache = new HashSet<>();



        String question = input.nextLine();
        while(!question.equalsIgnoreCase("q")) {

            questionCache.add(question);
            String response = generateResponse(question, responseCache);
            System.out.println(response);

            System.out.println("Ask another question or type 'q' to quit: ");
            question = input.nextLine();
        }
        System.out.println("Here are the questions you asked: ");
        System.out.println(questionCache);
    }

    private String generateResponse(String question, Map<String, String> responseCache){

        Map<String, List<String>> questionsAndAnswers = new HashMap<>();

        String response;

        List<String> answers1 = new ArrayList<>();
        answers1.add("Liverpool FC are the top team.");
        answers1.add("The best team is Liverpool!");
        answers1.add("Liverpool of course!");
        questionsAndAnswers.put("Who is the best soccer team in England?", answers1);

        List<String> answers2 = new ArrayList<>();
        answers2.add("Liverpool scored 139 goals across all competitions.");
        answers2.add("They set their new record high of 139 goals in a single season.");
        answers2.add("139 goals were scored by Liverpool this year.");
        questionsAndAnswers.put("How many goals did Liverpool score this year?", answers2);

        List<String> answers3 = new ArrayList<>();
        answers3.add("Mohammed Salah was the top scorer.");
        answers3.add("Mo Salah scored 22 goals.");
        answers3.add("Salah had the most with 22 goals.");
        questionsAndAnswers.put("Who was the top scorer?", answers3);

        List<String> answers4 = new ArrayList<>();
        answers4.add("Jurgen Klopp is their head coach.");
        answers4.add("The current head coach is Jurgen Klopp.");
        answers4.add("Liverpool's coach is a german named Jurgen Klopp.");
        questionsAndAnswers.put("Who is Liverpool's coach?", answers4);

        List<String> answers5 = new ArrayList<>();
        answers5.add("Liverpool has won the title 19 times.");
        answers5.add("Liverpool have achieved 19 league titles.");
        answers5.add("With their most recent win in 2019, Liverpool have won the league 19 times.");
        questionsAndAnswers.put("How many times has Liverpool won the English title?", answers5);

        List<String> answers6 = new ArrayList<>();
        answers6.add("Everton is Liverpool's biggest rival.");
        answers6.add("The rivalry between Liverpool and Everton is unmatched.");
        answers6.add("Everton, who also reside in Merseyside, are Liverpool's rival.");
        questionsAndAnswers.put("Who is Liverpool's rival?", answers6);

        List<String> answers7 = new ArrayList<>();
        answers7.add("Mohammed Salah");
        answers7.add("Trent Alexander Arnold");
        answers7.add("Sadio Mane");
        questionsAndAnswers.put("Who is Liverpool's best player?", answers7);

        List<String> answers8 = new ArrayList<>();
        answers8.add("YNWA - You'll Never Walk Alone");
        answers8.add("Liverpool's motto is \"You'll Never Walk Alone\" ");
        answers8.add("You'll Never Walk Alone was adopted as their motto prior to 1982.");
        questionsAndAnswers.put("What is Liverpool's motto?", answers8);

        List<String> answers9 = new ArrayList<>();
        answers9.add("Liverpool's main color is Red.");
        answers9.add("Their colors are Red, Green, and Gold.");
        answers9.add("Liverpool's home color is always Red.");
        questionsAndAnswers.put("What color does Liverpool wear?", answers9);

        List<String> answers10 = new ArrayList<>();
        answers10.add("LFC was founded on June 3, 1892.");
        answers10.add("June 3, 1892");
        answers10.add("Liverpool was founded in 1892 on June 3rd.");
        questionsAndAnswers.put("When was Liverpool FC founded?", answers10);


        List<String> possibleAnswers;
        if(questionsAndAnswers.containsKey(question)) {
            possibleAnswers = findPossibleAnswers(questionsAndAnswers.get(question), responseCache.get(question));
            Collections.shuffle(possibleAnswers);
            response = possibleAnswers.get(0);
            responseCache.put(question, response);
        }
        else{
            response = "I don't know.";
        }
        return response;
    }

    private static List<String> findPossibleAnswers(List<String> allAnswers, String lastAnswer){
        List<String> possibleAnswers = new ArrayList<>();
        for(String answer : allAnswers){
            if(!answer.equals(lastAnswer)){
                possibleAnswers.add(answer);
            }
        }
        return possibleAnswers;
    }
}
