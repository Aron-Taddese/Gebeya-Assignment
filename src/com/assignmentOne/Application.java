package com.assignmentOne;

import java.io.File;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws Exception {

        PrivateChat privateChat = new PrivateChat();
        PublicChat publicChat = new PublicChat();
        FriendList friendList = new FriendList();
        int flag = -1;
        do {
            System.out.println("""
                   ****Assignment One Chat Simulation\n
                    What do you want to do? Please enter the number****
                    """);
            System.out.println("""
                    1: Read from private chat
                    2: Write into the private chat.
                    3: Read from public chat.
                    4: Write into public chat.
                    5: View my friend's list.
                    6: Add a new friend.
                    7: Quit""");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter the file from which you want to read?");
                    System.out.println("1: Donut[AFK].log");
                    System.out.println("2: Eurakarte.log");
                    int choice1 = scanner.nextInt();
                    switch (choice1) {
                        case 1 -> {
                            File privatePath = new File("Donut[AFK].log");
                            privateChat.privateRead(privatePath);
                        }
                        case 2 -> {
                            File privatePath1 = new File("Eurakarte.log");
                            privateChat.privateRead(privatePath1);
                        }
                        default -> System.out.println("Wrong Number Please enter the correct number.");

                    }

                case 2:
                    System.out.println("Type your message: ");
                    String privateMessage = scanner.nextLine();
                    privateChat.privateWrite(privateMessage);
                    break;
                case 3:
                    System.out.println("Enter the file from which you want to read?");
                    System.out.println("1: Donut[AFK].log");
                    System.out.println("2: Eurakarte.log");
                    int choice2 = scanner.nextInt();
                    switch (choice2) {
                        case 1 -> {
                            File publicPath = new File("Donut[AFK].log");
                            publicChat.publicRead(publicPath);
                        }
                        case 2 -> {
                            File publicPath1 = new File("Eurakarte.log");
                            publicChat.publicRead(publicPath1);
                        }
                        default -> System.out.println("Wrong Number Please enter the correct number.");
                    }
                case 4:
                    System.out.println("Type your message: ");
                    String publicMessage = scanner.nextLine();
                    publicChat.publicWrite(publicMessage);
                    break;
                case 5:
                    System.out.println("Enter the path to your friend's list: ");
                    String fp = scanner.nextLine();
                    File friendPath = new File(fp);
                    friendList.friendRead(friendPath);
                    break;
                case 6:
                    System.out.println("Write new friend's name: ");
                    String friendName = scanner.nextLine();
                    friendList.friendWrite(friendName);
                    break;
                case 7:
                    System.out.println("""
                            The application is Closed!
                            """);
                    flag = 7;
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error! Pick the correct choice.");
            }

        } while (7 == flag);
    }
}