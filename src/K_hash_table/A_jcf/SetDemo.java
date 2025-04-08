package K_hash_table.A_jcf;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.SequencedSet;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        System.out.println("demoing HashSet");
        Set<Integer> set1 = new HashSet<>();
        demo(set1);

        System.out.println("demoing LinkedHashSet");
        SequencedSet<Integer> set2 = new LinkedHashSet<>();
        demo(set2);
    }

    private static void demo(Set<Integer> set) {
        set.add(5);
        set.add(19);
        set.add(7);
        System.out.println("set = " + set);
        System.out.println(set.add(19)); // false
        System.out.println("set = " + set);
    }
}