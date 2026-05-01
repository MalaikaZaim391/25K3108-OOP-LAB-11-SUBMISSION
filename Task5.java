package lab11;
/*Create a text file named as “Confidential.txt”. Now, take input of designation from user. If the entered
input is “Faculty”, then give the RWX permissions to user. If the designation is student then give only
the read permissions.
After assigning the permissions, show the Access Rights’ status.*/

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String desktopPath = "C:\\Users\\LENOVO\\Desktop\\Confidential.txt";
        File file = new File(desktopPath);
        try {
            if (file.createNewFile()) {
                System.out.println("Confidential.txt created successfully.");
            } else {
                System.out.println("Confidential.txt already exists.");
            }
            System.out.print("Enter Designation (Faculty/Student): ");
            String designation = sc.nextLine();
            boolean r, w, x;
            if (designation.equalsIgnoreCase("Faculty")) {
                r = file.setReadable(true);
                w = file.setWritable(true);
                x = file.setExecutable(true);
                System.out.println("Faculty Permissions Applied (RWX).");
            }
            else if (designation.equalsIgnoreCase("Student")) {
                r = file.setReadable(true);
                w = file.setWritable(false);
                x = file.setExecutable(false);
                System.out.println("Student Permissions Applied (R only).");
            }
            else {
                System.out.println("Invalid designation. No changes applied.");
                return;
            }
            //show if set functions succeeded
            System.out.println("\n--- Permission Setting Result ---");
            System.out.println("Readable set success? " + file.setReadable(file.canRead()));
            System.out.println("Writable set success? " + file.setWritable(file.canWrite()));
            System.out.println("Executable set success? " + file.setExecutable(file.canExecute()));
            //Display final permissions
            System.out.println("\n--- Access Rights Status ---");
            System.out.println("Readable: " + file.canRead());
            System.out.println("Writable: " + file.canWrite());
            System.out.println("Executable: " + file.canExecute());

            //windows doesn't view txt file as executable that's why it always shows true

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }

}