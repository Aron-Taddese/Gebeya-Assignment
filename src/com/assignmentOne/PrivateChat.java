package com.assignmentOne;

import ChatExceptions.CustomExceptionHandler;
import ChatExceptions.SystemExceptionHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PrivateChat {

    private final ArrayList<String> privateChatHistory;

    //instance for SystemExceptionHandler and CustomExceptionHandler
    //Collaborator => Abinet Tamiru
    SystemExceptionHandler systemExceptionHandler = new SystemExceptionHandler();
    CustomExceptionHandler customExceptionHandler = new CustomExceptionHandler();

        public PrivateChat() {
            privateChatHistory = new ArrayList<>();
        }

        public void privateRead(File privateMessage) {
            Scanner private_Read = null;
            // Try block for handling user input and performing corresponding actions
            //Collaborator => Abinet Tamiru
            try {
                private_Read = new Scanner(privateMessage);
                while(private_Read.hasNextLine()) {
                    String privateInput = private_Read.nextLine();
                    privateChatHistory.add(privateInput);
                    System.out.println(privateChatHistory);
                }
                private_Read.close();
            } catch (FileNotFoundException e) {
                // Write the exception to the system log using the systemExceptionHandler
                //Collaborator => Abinet Tamiru
                systemExceptionHandler.writeSystemLog(e);
                // Handle the exception using the customExceptionHandler
                //Collaborator => Abinet Tamiru
                customExceptionHandler.handleException(e);
            }

        }

        public void privateWrite(String privateMessage){
            File privateFile = new File("./Donut[AFK].log");
            PrintWriter private_Write = null;
            // Try block for handling user input and performing corresponding actions
            //Collaborator => Abinet Tamiru
            try {
                private_Write = new PrintWriter(privateFile);
                private_Write.write(privateMessage);
                private_Write.close();
            } catch (FileNotFoundException e) {
                // Write the exception to the system log using the systemExceptionHandler
                //Collaborator => Abinet Tamiru
                systemExceptionHandler.writeSystemLog(e);
                // Handle the exception using the customExceptionHandler
                //Collaborator => Abinet Tamiru
                customExceptionHandler.handleException(e);
            }

        }
}
