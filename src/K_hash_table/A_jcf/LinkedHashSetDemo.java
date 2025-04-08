package K_hash_table.A_jcf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.SequencedCollection;
import java.util.SequencedSet;
import java.util.Set;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("bus", "train", "bus", "ferry", "car", "car", "ferry"));
        // badDeduplicate(list);
        deduplicate(list);
        System.out.println(list);
    }

    // Removes the duplicate elements in the given sequenced collection, but does not guarantee
    // that the remaining elements will be in the same order that they were originally in.
    public static <E> void badDeduplicate(SequencedCollection<E> sequencedCollection) {
        Set<E> set = new HashSet<>();

        for (E element : sequencedCollection) {
            set.add(element);
        }

        sequencedCollection.clear();
        sequencedCollection.addAll(set);
    }

    // Removes the duplicate elements in the given sequenced collection, guaranteeing that the
    // remaining elements will be in the same order that they were originally in.
    public static <E> void deduplicate(SequencedCollection<E> sequencedCollection) {
        SequencedSet<E> sequencedSet = new LinkedHashSet<>();

        for (E element : sequencedCollection) {
            sequencedSet.add(element);
        }

        sequencedCollection.clear();
        sequencedCollection.addAll(sequencedSet);
    }
}
