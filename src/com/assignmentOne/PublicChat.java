package com.assignmentOne;

import ChatExceptions.CustomExceptionHandler;
import ChatExceptions.SystemExceptionHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PublicChat {

    //instance for SystemExceptionHandler and CustomExceptionHandler
    //Collaborator => Abinet Tamiru
    SystemExceptionHandler systemExceptionHandler = new SystemExceptionHandler();
    CustomExceptionHandler customExceptionHandler = new CustomExceptionHandler();
    private final ArrayList<String> publicChatHistory;

    public PublicChat() {

        publicChatHistory = new ArrayList<>();
    }


    public void publicRead(File privateMessage){
        Scanner public_Read = null;
        try {
            public_Read = new Scanner(privateMessage);
            while(public_Read.hasNextLine()) {
                String publicInput = public_Read.nextLine();
                publicChatHistory.add(publicInput);
                System.out.println(publicChatHistory);
            }
            public_Read.close();
        } catch (FileNotFoundException e) {
            systemExceptionHandler.writeSystemLog(e);
            customExceptionHandler.handleException(e);
        }

    }

    public void publicWrite(String privateMessage){
        File publicFile = new File("./Eurakarte.log");
        PrintWriter public_Write = null;
        try {
            public_Write = new PrintWriter(publicFile);
            public_Write.write(privateMessage);
            public_Write.close();
        } catch (FileNotFoundException e) {
            systemExceptionHandler.writeSystemLog(e);
            customExceptionHandler.handleException(e);
        }

    }
}
