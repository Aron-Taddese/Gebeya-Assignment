package com.assignmentOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PublicChat {

    private final ArrayList<String> publicChatHistory;

    public PublicChat() {

        publicChatHistory = new ArrayList<>();
    }


    public void publicRead(File privateMessage) throws FileNotFoundException {
        Scanner public_Read = new Scanner(privateMessage);
        while(public_Read.hasNextLine()) {
            String publicInput = public_Read.nextLine();
            publicChatHistory.add(publicInput);
            System.out.println(publicChatHistory);
        }
        public_Read.close();
    }

    public void publicWrite(String privateMessage) throws IOException {
        File publicFile = new File("./Eurakarte.log");
        PrintWriter public_Write = new PrintWriter(publicFile);
        public_Write.write(privateMessage);
        public_Write.close();
    }
}
