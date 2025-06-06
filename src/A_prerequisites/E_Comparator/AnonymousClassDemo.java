package A_prerequisites.E_Comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Animal {
    @Override
    public String toString() {
        return "animal";
    }
}

/*
Suppose we want to define a subclass of Animal and create only one object
of that subclass. Instead of writing a standalone class that extends
Animal and then creating an object of that class, we can instead write an
anonymous class and simultaneously create the object of the class.
*/

public class AnonymousClassDemo {
    public static void main(String[] args) {
        /*
        Here we are defining an anonymous class that inherits from Animal,
        and we are simultaneously creating an object of that anonymous class.
        An anonymous class must inherit from a class or interface.
        */
        Animal feline = new Animal() {
            @Override
            public String toString() {
                return "cat " + super.toString();
            }
        };
        System.out.println(feline); // cat animal

        String[] stringArray = {"cat", "rabbit", "bird"};

        /*
        We are defining an anonymous class that inherits from Comparator,
        and we are simultaneously creating an object of that class.
        This is an alternative to writing a standalone class like StringLengthComparator.
        */
        Comparator<String> byLength = new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };
        Arrays.sort(stringArray, byLength);
        System.out.println(Arrays.toString(stringArray)); // [cat, bird, rabbit]

        ArrayList<String> customList = new ArrayList<>() {
            @Override
            public String toString() {
                String s = super.toString(); // includes []
                return s.replace("[", "{").replace("]", "}");
            }
        };
        System.out.println(customList);
        customList.add("a");
        customList.add("b");
        customList.add("c");
        System.out.println(customList); // {a, b, c}
    }
}