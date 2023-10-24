package com.assignmentOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PrivateChat {

    private final ArrayList<String> privateChatHistory;
        public PrivateChat() {
            privateChatHistory = new ArrayList<>();
        }

        public void privateRead(File privateMessage) throws FileNotFoundException {
            Scanner private_Read = new Scanner(privateMessage);
            while(private_Read.hasNextLine()) {
                String privateInput = private_Read.nextLine();
                privateChatHistory.add(privateInput);
                System.out.println(privateChatHistory);
            }
            private_Read.close();
        }

        public void privateWrite(String privateMessage) throws IOException {
            File privateFile = new File("./Donut[AFK].log");
            PrintWriter private_Write = new PrintWriter(privateFile);
            private_Write.write(privateMessage);
            private_Write.close();
        }
}
