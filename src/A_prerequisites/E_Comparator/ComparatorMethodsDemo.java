package A_prerequisites.E_Comparator;

/*
The following are some important methods of the Comparator interface. We will learn some more near the end of the course.

abstract method:
- if c is a Comparator, then c.compare(a, b) returns positive (if a > b), negative (if a < b), or 0 (if a = b)

static methods:
- Comparator.naturalOrder(): returns a Comparator<T> that uses T's compareTo method.
- Comparator.reverseOrder(): returns a Comparator<T> that uses the reverse of T's compareTo method.

- default methods:
- if c is a Comparator, then c.reversed() returns a Comparator that does the reverse of c.
- if c1 and c2 are Comparators, then c1.thenComparing(c2) returns a Comparator that
  first compares objects using c1 and then (if there's a tie) compares them using c2.
 */

import java.util.Comparator;

public class ComparatorMethodsDemo {
    public static void main(String[] args) {
        Comparator<String> alphabetically = Comparator.naturalOrder();
        System.out.println(alphabetically.compare("bird", "cat")); // negative int
        System.out.println(alphabetically.compare("dog", "cat"));  // positive int

        Comparator<String> alphabeticallyReversed = Comparator.reverseOrder();
        System.out.println(alphabetically.compare("bird", "cat")); // positive int
        System.out.println(alphabetically.compare("dog", "cat"));  // negative int

        Comparator<String> byLength = new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };
        System.out.println(byLength.compare("bird", "cat")); // positive int
        System.out.println(byLength.compare("dog", "cat"));  // 0

        Comparator<String> byLengthReversed = byLength.reversed();
        System.out.println(byLength.compare("bird", "cat")); // negative int
        System.out.println(byLength.compare("dog", "cat"));  // 0

        Comparator<String> byLengthThenAlphabetically = byLength.thenComparing(alphabetically);
        System.out.println(byLength.compare("bird", "cat")); // positive int
        System.out.println(byLength.compare("dog", "cat"));  // positive int
    }
}
