package lab11;
import java.io.*;
import java.util.*;
/*Create a generic class having two parameters username and password. If the username and password
entered by the user matches with the pre-stored username and password then print a logon message
otherwise terminate the program.*/

import java.util.Scanner;

class Credentials <T, U> {
    T userName;
    U password;
    public Credentials(T userName, U password) {
        this.userName = userName;
        this.password = password;
    }
    public boolean Login (T userName, T password) {
        if (userName.equals(this.userName)) {
            if (password.equals(this.password)) {
                return true;
            }
            return  false;
        }
        return false;
    }
}

public class Task3 {
    public static void main(String[] args) {
        Credentials <String, Integer> user1 = new Credentials("Ali Ahmed", 12345678);
        Credentials <String, String> user2 = new Credentials("lola", "1234123##");

        Scanner sc = new Scanner(System.in);
        boolean success;

        System.out.println("User1 Username: ");
        String user1Name = sc.nextLine();
        System.out.println("User1 Password: ");
        String user1Password = sc.nextLine();
        success = user1.Login(user1Name, user1Password);
        if (success) {
            System.out.println("User Logged In Successfully!");
        }
        else {
            System.out.println("Invalid Credentials, User Log In Failed!");
            System.out.println("Terminating Program...");
            System.exit(0);
        }

        System.out.println("User2 Username: ");
        String user2Name = sc.nextLine();
        System.out.println("User1 Password: ");
        String user2Password = sc.nextLine();
        success = user2.Login(user2Name, user2Password);
        if (success) {
            System.out.println("User Logged In Successfully");
        }
        else {
            System.out.println("Invalid Credentials, User Log In Failed");
            System.out.println("Terminating Program...");
            System.exit(0);
        }


    }
}
