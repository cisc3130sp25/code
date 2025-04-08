package K_hash_table.A_jcf;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class Name {
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
            return this.first.equals(other.first) && this.last.equals(other.last);
        } else {
            return false;
        }
    }

    /*
    Recall that a hashCode() method must return equal results for equal objects.
    If this rule is violated, and objects of the class are used as elements of a
    (Linked)HashSet or as the keys of a (Linked)HashMap,
    the HashSet and HashMap will not work correctly.

    Additionally, a good hashCode() method endeavors to return unequal results
    for unequal objects. If this isn't followed, HashSet and HashMap will work
    correctly, but slowly (O(n) instead of O(1)).
     */

//    @Override
//    public int hashCode() { // satisfies the contract, but causes hash tables to work slowly
//        return 33;
//    }

    @Override
    public int hashCode() { // a good hashCode method
        return Objects.hash(first, last);
    }
}

// Try running this program with Name's hashCode method commented out.
// If hashCode is commented out, we just inherit Object's hashCode method,
// which returns distinct integers for distinct objects. This is a problem,
// since the Name class overrides the equals method such that two distinct
// Names can be equal:
//      Name n1 = new Name("A", "B"), n2 = new Name("A", "B");
// Now n1.equals(n2) is true, but they don't have the same hash code.
// As a result, a HashSet that uses Names as elements, or a HashMap that
// uses Names as keys, will not work correctly.
public class HashCodeEffectDemo {
    public static void main(String[] args) {
        Set<Name> set = new HashSet<>();
        set.add(new Name("Jane", "Doe"));
        System.out.println("set = " + set);
        System.out.println("set contains Jane Doe? " +
                           set.contains(new Name("Jane", "Doe")));
        set.add(new Name("Jane", "Doe"));
        System.out.println("set = " + set);
        System.out.println();

        Map<Name, Integer> map = new HashMap<>();
        map.put(new Name("Jane", "Doe"), 4);
        System.out.println("map = " + map);
        System.out.println("map contains key Jane Doe? " +
                           map.containsKey(new Name("Jane", "Doe")));
        map.put(new Name("Jane", "Doe"), 10);
        System.out.println("map = " + map);
    }
}