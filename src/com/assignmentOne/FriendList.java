package com.assignmentOne;

import ChatExceptions.CustomExceptionHandler;
import ChatExceptions.SystemExceptionHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FriendList {
    //instance for SystemExceptionHandler and CustomExceptionHandler
    //Collaborator => Abinet Tamiru
    SystemExceptionHandler systemExceptionHandler = new SystemExceptionHandler();
    CustomExceptionHandler customExceptionHandler = new CustomExceptionHandler();

    private final ArrayList<String> friendsList;
    public FriendList() {
        friendsList = new ArrayList<>();
    }


    public void friendRead(File FriendsList){
        Scanner friendReader = null;
        try {
            friendReader = new Scanner(FriendsList);
            while(friendReader.hasNextLine()) {
                String friend_Reader = friendReader.nextLine();
                friendsList.add(friend_Reader);
                System.out.println(friendsList);
            }
            friendReader.close();
        } catch (FileNotFoundException e) {
            systemExceptionHandler.writeSystemLog(e);
            customExceptionHandler.handleException(e);
        }

    }

    public void friendWrite(String friendsName){
        File friendFile = new File("./friends.list");
        PrintWriter friendNameWriter = null;
        try {
            friendNameWriter = new PrintWriter(friendFile);
            friendNameWriter.write(friendsName);
            friendNameWriter.close();
        } catch (FileNotFoundException e) {
            systemExceptionHandler.writeSystemLog(e);
            customExceptionHandler.handleException(e);
        }

    }
}
