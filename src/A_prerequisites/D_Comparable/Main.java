package A_prerequisites.D_Comparable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        System.out.println("a".compareTo("r")); // negative int
        System.out.println("r".compareTo("a")); // positive int
        System.out.println("a".compareTo("a")); // 0
        System.out.println();

        String[] stringArray = {"car", "train", "bus"};
        Arrays.sort(stringArray); // uses String's compareTo method to compare the elements with each other
        System.out.println(Arrays.toString(stringArray));
        System.out.println();

        // Arrays.sort(arr) works only if the elements of arr
        // come from a class that implements Comparable.
        // It's not enough for the class to simply have a compareTo method;
        // the class must explicitly state that it implements Comparable.

        // similarly with an ArrayList
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("car");
        stringArrayList.add("train");
        stringArrayList.add("bus");
        System.out.println(stringArrayList);
        Collections.sort(stringArrayList); // uses String's compareTo
        System.out.println(stringArrayList);

        // we can make our own classes implement the Comparable interface

        System.out.println(new Student("John", 1111).compareTo(new Student("Jane", 2222))); // a negative int

        Student[] students = {
                new Student("Jane", 56789),
                new Student("John", 12345),
                new Student("Joe", 11111)
        };
        System.out.println(Arrays.toString(students));
        Arrays.sort(students); // uses Student's compareTo method
        System.out.println(Arrays.toString(students));

        Product[] products = {
                new Product(666, "apple", 1.25),
                new Product(555, "apple", 1.05),
                new Product(444, "bread", 2.25),
                new Product(333, "bread", 2.25),
                new Product(222, "milk", 1.75),
                new Product(111, "almonds", 1.25)
        };

        Arrays.sort(products); // uses Product's compareTo method

        for (Product product : products) {
            System.out.println(product);
        }
    }
}
