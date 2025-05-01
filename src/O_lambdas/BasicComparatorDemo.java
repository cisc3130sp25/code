package O_lambdas;

import java.util.Arrays;
import java.util.Comparator;

/*
The Comparator interface is a functional interface. It has
many non-abstract methods, but only two abstract methods,
one of which is the equals method (which doesn't count,
since it's found in the Object class). A lambda expression
that is an instance of Comparator is a function that has
the ability to compare two objects and determine their order.
*/
public class BasicComparatorDemo {
    public static void main(String[] args) {
        String[] arr = {"rabbit", "dog", "baboon", "eagle", "hamster", "bat", "cat"};
        System.out.println("original array: " + Arrays.toString(arr));

        // Here's how we created a Comparator previously, using an anonymous class:
        // Comparator<String> byLength = new Comparator<>() {
        //     @Override
        //     public int compare(String s1, String s2) {
        //         return Integer.compare(s1.length(), s2.length());
        //     }
        // };

        // Now we can do it much more concisely, using a lambda expression:
        // Comparator<String> byLength = (s1, s2) -> Integer.compare(s1.length(), s2.length());

        // Using the Comparator.comparing(Function keyExtractor) method:
        // Comparator<String> byLength = Comparator.comparing(s -> s.length());

        // Now with a method reference instead of a lambda expression:
        // Comparator<String> byLength = Comparator.comparing(String::length);

        // Arrays.sort(arr, byLength);
        // System.out.println("sorted by length: " + Arrays.toString(arr));

        // Using the thenComparing(Comparator other) method
        Comparator<String> byLengthThenAlphabetically =
                Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder());
        Arrays.sort(arr, byLengthThenAlphabetically);
        System.out.println("sorted by length then alphabetically: " + Arrays.toString(arr));
    }
}