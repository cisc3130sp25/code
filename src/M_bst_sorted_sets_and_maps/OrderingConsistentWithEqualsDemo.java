package M_bst_sorted_sets_and_maps;

import java.util.Comparator;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

class Name implements Comparable<Name> {
    private final String first, last;

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public String toString() {
        return first + " " + last;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Name other) {
            return this.first.equals(other.first)
                && this.last.equals(other.last);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last);
    }

    // bad compareTo method - inconsistent with equals
    // @Override
    // public int compareTo(Name other) {
    //   return this.last.compareTo(other.last);
    // }

    // good compareTo method
    @Override
    public int compareTo(Name other) {
        int lastNameComparison = this.last.compareTo(other.last);

        if (lastNameComparison != 0) { // last names are not equal
            return lastNameComparison;
        }

        return this.first.compareTo(other.first);
    }
}

/*
The elements of a TreeSet and the keys of a TreeMap
must come from a class that implements Comparable,
or we must provide a Comparator when creating the set/map.

The ordering (whether natural or provided by a Comparator)
should be consistent with the equals method. Otherwise,
the set or map will behave strangely.

In order for an ordering to be consistent with the equals method,
both of the following conditions must be met:
1. If two objects are equal according to the equals method,
   then the ordering must consider them to be equal (that is,
   the compareTo method or the compare method must return 0).
2. Also, if two objects are equal according to the ordering,
   then the equals method must consider them to be equal.
*/

public class OrderingConsistentWithEqualsDemo {
    public static void main(String[] args) {
        // try running the following with the bad version of Name's compareTo method
        SortedSet<Name> set = new TreeSet<>();
        set.add(new Name("Jane", "Doe"));
        System.out.println("set contains John Doe? " + set.contains(new Name("John", "Doe"))); 
        set.add(new Name("John", "Doe"));
        System.out.println("set = " + set);
        System.out.println();

        // The following Comparator<String> is inconsistent with String's equals method:
        Comparator<String> byLength = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };

        // The following Comparator<String> is consistent with String's equals method:
        Comparator<String> byLengthThenAlphabetically = byLength.thenComparing(Comparator.naturalOrder());

        SortedSet<String> strings = new TreeSet<>(byLengthThenAlphabetically);
        strings.add("fall");
        System.out.println("strings = " + strings);
        System.out.println("strings contains snow? " + strings.contains("snow"));
        strings.add("snow");
        System.out.println("strings = " + strings);
    }
}

