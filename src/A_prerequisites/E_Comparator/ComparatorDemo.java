package A_prerequisites.E_Comparator;

/*
Suppose s1 and s2 are Strings.

To call the compareTo method of Comparable: s1.compareTo(s2)
This gives us the "natural order" of objects,
which is alphabetical order in the case of Strings.
The compareTo method is built into objects that have the Comparable property.
The compareTo method takes one parameter.

Suppose we would like to compare Strings in some other way, such as by length.
To do this, we create an object that inherits from the Comparator interface.
This interface has a method named compare that takes two objects as input,
and returns an int (negative, positive, or 0, like the compareTo method).
Suppose c refers to an object that inherits from Comparator.
We can say: c.compare(s1, s2)
The compare method is not built into the objects that we are trying to compare;
rather, it is part of an external Comparator.
The compare method has two parameters: the two objects that the Comparator is
being asked to compare.
 */

import java.util.Arrays;
import java.util.Comparator;

class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        /*
        // long way:
        if (s1.length() < s2.length()) {
            return -55;
        } else if (s1.length() > s2.length()) {
            return 92;
        } else {
            return 0;
        }
         */

        // concise way:
        return Integer.compare(s1.length(), s2.length());
    }
}

class StudentAgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getAge(), s2.getAge());
    }
}

public class ComparatorDemo {
    public static void main(String[] args) {
        // using natural order
        System.out.println("bird".compareTo("cat")); // negative int
        System.out.println("dog".compareTo("cat")); // positive int

        Comparator<String> byLength = new StringLengthComparator();
        System.out.println(byLength.compare("bird", "cat")); // positive int
        System.out.println(byLength.compare("dog", "cat")); // 0

        String[] stringArray = {"rabbit", "cat", "bird"};
        // Arrays.sort(stringArray); // sorts the array using natural order
        Arrays.sort(stringArray, byLength);
        // sorts the array based on the provided Comparator, byLength
        System.out.println(Arrays.toString(stringArray)); // [cat, bird, rabbit]


        Student[] students = {
                new Student(56789, 19),
                new Student(12345, 21),
                new Student(11111, 20)
        };

        Arrays.sort(students);
        // sorts the students by natural order, here meaning by id

        System.out.println("sorted by id: " + Arrays.toString(students));

        Comparator<Student> byAge = new StudentAgeComparator();

        // sort students based on their ages, from lowest age to highest age
        Arrays.sort(students, byAge);
        System.out.println("sorted ascending by age: " + Arrays.toString(students));

        Comparator<Student> byAgeReversed = byAge.reversed();

        // reversed is a default method of Comparator

        Student a = new Student(11111, 21);
        Student b = new Student(22222, 20);
        System.out.println(byAge.compare(a, b)); // positive int
        System.out.println(byAgeReversed.compare(a, b)); // negative int

        // sorts the students by age, from highest age to lowest age
        Arrays.sort(students, byAgeReversed);
        System.out.println("sorted descending by age: " + Arrays.toString(students));

        // create a comparator that compares students by
        // the reverse of their natural order
        // one way:
        //     create a comparator that uses natural order:
        //     Comparator<Student> byId = Comparator.naturalOrder();
        //     then get the reverse comparator:
        //     Comparator<Student> byIdReversed = byId.reversed();

        // better way:
        // get a Comparator that compares Students by the reverse of their natural order
        Comparator<Student> byIdReversed = Comparator.reverseOrder();

        // reverseOrder is a static method of the Comparator interface.

        // reverseOrder is an example of a static factory method:
        // a static method (whether in a class or in an interface)
        // that returns an object of the type of the class/interface.
        // Some interfaces and classes in the Java library use static
        // factory methods heavily; e.g., java.time.LocalDate.
        // (JShell demo if there's time.)

        // sort students by id in reverse order (highest to lowest)
        Arrays.sort(students, byIdReversed);
        System.out.println("sorted descending by ID: " + Arrays.toString(students));

        // for an ArrayList<Student>, two ways to sort using a Comparator:
        // - using Collections.sort(list, comparator)
        // - or using list.sort(comparator)

        /*
        Comparable vs Comparator:
        - A Comparable can compare itself to another object, e.g., "e".compareTo("y")
        - A Comparator can compare two objects, e.g., byLength.compare("e", "y")

        When should you implement Comparable? When you're writing a class whose
        objects should be comparable with each other.

        When should you implement Comparator? When you want to compare objects of
        a class that doesn't implement Comparable, or if you want to compare objects
        in a different way than their compareTo method.
         */
    }
}