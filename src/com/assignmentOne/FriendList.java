package com.assignmentOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FriendList {

    private final ArrayList<String> friendsList;
    public FriendList() {
        friendsList = new ArrayList<>();
    }


    public void friendRead(File FriendsList) throws FileNotFoundException {
        Scanner friendReader = new Scanner(FriendsList);
        while(friendReader.hasNextLine()) {
            String friend_Reader = friendReader.nextLine();
            friendsList.add(friend_Reader);
            System.out.println(friendsList);
        }
        friendReader.close();
    }

    public void friendWrite(String friendsName) throws IOException {
        File friendFile = new File("./friends.list");
        PrintWriter friendNameWriter = new PrintWriter(friendFile);
        friendNameWriter.write(friendsName);
        friendNameWriter.close();
    }
}
