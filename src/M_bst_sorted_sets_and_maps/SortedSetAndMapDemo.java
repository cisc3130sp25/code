package M_bst_sorted_sets_and_maps;

import java.util.*;

public class SortedSetAndMapDemo {
    public static void main(String[] args) {
        // SortedSet by natural order (for Strings, this is alphabetical order)
        SortedSet<String> set1 = new TreeSet<>();
        set1.add("bird");
        set1.add("winter");
        set1.add("sky");
        System.out.println(set1); // [bird, sky, winter]

        // SortedSet<Scanner> scanners = new TreeSet<>();
        // scanners.add(new Scanner(System.in)); // throws ClassCastException

        // sorted set by length
        Comparator<String> byLength = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };
        SortedSet<String> set3 = new TreeSet<>(byLength);
        set3.add("bird");
        set3.add("winter");
        set3.add("sky");
        System.out.println(set3); // [sky, bird, winter]

        // sorted set by reverse of natural order
        SortedSet<String> set2 = new TreeSet<>(Comparator.reverseOrder());
        set2.add("bird");
        set2.add("winter");
        set2.add("sky");
        System.out.println(set2); // [winter, sky, bird]

        // sorted set by length in reverse order (longest to shortest)
        SortedSet<String> set4 = new TreeSet<>(byLength.reversed());
        set4.add("bird");
        set4.add("winter");
        set4.add("sky");
        System.out.println(set4); // [winter, bird, sky]

        // sorted set by length, then alphabetically to break ties
        Comparator<String> alphabetically = Comparator.naturalOrder();
        Comparator<String> byLengthThenAlphabetically = byLength.thenComparing(alphabetically);
        SortedSet<String> set5 = new TreeSet<>(byLengthThenAlphabetically);
        set5.add("bird");
        set5.add("winter");
        set5.add("sky");
        set5.add("cat");
        System.out.println(set5); // [cat, sky, bird, winter]

        SortedMap<String, Integer> map = new TreeMap<>();
        map.put("bird", 3);
        map.put("winter", 5);
        map.put("sky", 7);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        // bird 3
        // sky 7
        // winter 5
    }
}
