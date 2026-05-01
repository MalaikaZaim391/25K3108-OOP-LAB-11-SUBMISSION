package lab11;
/*Create an arraylist of 5 elements added by user (The user should input the elements). Then write this list
to the text file present on the Desktop of your PC using BufferedWriter. After writing, read from the file
and show the items in the list. Then,delete the file.*/

import java.io.*;
import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Enter 5 elements:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            list.add(sc.nextLine());
        }

        //User enters full absolute path
        /*System.out.print("\nEnter FULL file path (Example: C:\\Users\\HP\\Desktop\\MyList.txt): ");
        String path = sc.nextLine();*/

        //or desktop path for my own pc
        String path = "C:\\Users\\LENOVO\\Desktop\\task1.txt";

        File file = new File(path);

        try {
            //Writing
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (String item : list) {
                bw.write(item);
                bw.newLine();
            }
            bw.close();
            System.out.println("\nList written successfully at: " + file.getAbsolutePath());
            //Reading
            System.out.println("\n--- Reading File Contents ---");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
            // Deleting file
            if (file.delete()) {
                System.out.println("\nFile deleted successfully.");
            } else {
                System.out.println("\nFile could not be deleted.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }


}




