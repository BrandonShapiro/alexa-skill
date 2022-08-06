package com.weber.cs3230;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.slu.Slot;
import com.weber.cs3230.dto.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Component
public class AlexaIntentHandler {
    private final DBAnswerGenerator dbAnswerGenerator;
    @Value("${mail.username}") private String mailUser;
    @Value("${mail.password}") private String mailPass;
    @Autowired
    AlexaIntentHandler(DBAnswerGenerator dbAnswerGenerator){
        this.dbAnswerGenerator = dbAnswerGenerator;
    }
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    public Answer handleIntent(Intent intent) throws NoAvailableAnswerException {
        AlexaIntent intentType = AlexaIntent.getIntentFromString(intent.getName());

        if(intentType != null) {
            //email intent has special handling
            if(AlexaIntent.SEND_EMAIL.equals(intentType)){
                log.info("generated new intent: " + intentType.getIntentName());
                //get slot values
                Map<String, Slot> slots = intent.getSlots();
                final String recipient = slots.get("Name").getValue();
                final String emailContent = slots.get("Content").getValue();
                //send email
                sendEmail(recipient, emailContent);
                //return confirmation text to user (answer)
                return new Answer("I sent your email.");
            }
            //all other intents return an answer from database
            else {
                log.info("generated new intent: " + intentType.getIntentName());
                return new Answer(dbAnswerGenerator.findAnswer(intentType));
            }
        }
        else{
            log.info("unable to find a matching intent - returning null");
            return null;
        }
    }

    void sendEmail(String name, String content){

        String recipient;
        switch (name.toLowerCase()) {
            case "brandon":
            case "me":
            case "myself":
                recipient = "brandonshapiro9@gmail.com";
                break;
            case "cameron":
            case "my fiance":
                recipient = "soccerkam99@gmail.com";
                break;
            default:
                recipient = "brandonshapiro@mail.weber.edu";
                break;
        }

        //implement JAVAMAIL
        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(mailUser, mailPass);

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(mailUser));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }


    }

}


