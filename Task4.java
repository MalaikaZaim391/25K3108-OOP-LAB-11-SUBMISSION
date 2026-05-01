package lab11;
/*Assuming you have a List of objects of different types such as Integer and Double, write a program in
Java using generics that:
1. Sorts the list in ascending order based on the values of the objects.
2. Calculates the sum of all the objects in the list.
3. Finds the maximum value of all the objects in the list.
4. Prints out the sorted list, sum of all the objects, and maximum value of all the objects.
You'll need to use Java&#39;s Comparable and Wildcard generics to accomplish this.*/
import java.util.*;

public class Task4 {

    public static void processList(List<? extends Number> list) {
        //Sort using Comparator
        List<Number> sortedList = new ArrayList<>(list);
        sortedList.sort(Comparator.comparingDouble(Number::doubleValue));
        double sum = 0;
        double max = Double.MIN_VALUE;
        for (Number n : sortedList) {
            sum += n.doubleValue();
            if (n.doubleValue() > max) {
                max = n.doubleValue();
            }
        }
        System.out.println("Sorted List: " + sortedList);
        System.out.println("Sum = " + sum);
        System.out.println("Max = " + max);
    }


    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(5.5);
        numbers.add(2);
        numbers.add(99.9);
        numbers.add(45);
        processList(numbers);
    }


}
