package lab11;
/*1. Create a text file for a student. You can use the student’s name as the name of the file.
2. Write the student’s full name and student ID in the file.
3. Then create an arraylist that represents the courses that the student has registered for the semester.
Before registering for OOP Lab and OOP Theory check if the student has cleared both PF Lab
and Theory. If the student has obtained 50 or above 50 in PF Lab and Theory then add OOP Lab
and OOP theory in the arraylist.
4. Each course is assumed to be of 3 credit hours so student can register for more than 15 hours in
the semester. Be careful while adding the courses in the list.
5. Write all this information to the file. Read from the file and then display all the content.*/
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

class Student {
    private String name;
    private String id;
    private ArrayList<String> courses;
    private final int MAX_CREDITS = 15;
    private final int COURSE_CREDIT = 3;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.courses = new ArrayList<>();
    }
    //Method to check eligibility and register courses
    public void registerOOP(int pfTheoryMarks, int pfLabMarks) {
        if (pfTheoryMarks >= 50 && pfLabMarks >= 50) {
            addCourse("OOP Theory");
            addCourse("OOP Lab");
        } else {
            System.out.println("Eligibility failed: PF Theory and Lab marks must be 50+");
        }
    }
    public void addCourse(String courseName) {
        //Check if adding this course exceeds 15 credit hours
        if ((courses.size() + 1) * COURSE_CREDIT <= MAX_CREDITS) {
            courses.add(courseName);
        } else {
            System.out.println("Credit limit reached! Cannot add: " + courseName);
        }
    }
    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter(name + ".txt");
            writer.write("Student Name: " + name + "\n");
            writer.write("Student ID: " + id + "\n");
            writer.write("Registered Courses:\n");
            for (String course : courses) {
                writer.write("- " + course + "\n");
            }
            writer.close();
            System.out.println("File saved successfully.");
        } catch (Exception e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    public void readFromFile() {
        try {
            File myFile = new File(name + ".txt");
            Scanner reader = new Scanner(myFile);
            System.out.println("\n--- Reading from " + name + ".txt ---");
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //sample run

        //Initialize Student
        Student s1 = new Student("Malaika Zaim", "25K-3108");
        //Add some initial courses
        s1.addCourse("MVC");
        s1.addCourse("English");
        s1.addCourse("Islamic Studies");
        //Try to register for OOP based on PF marks
        //got 75 in Theory and 60 in Lab
        s1.registerOOP(75, 60);
        //Save and Display
        s1.saveToFile();
        s1.readFromFile();
    }


}