package P_streams;

import java.util.*;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> nonEmpty = Optional.of("a");
        Optional<String> empty = Optional.empty();

        System.out.println(nonEmpty.orElse("b")); // a
        System.out.println(empty.orElse("b")); // b

        System.out.println(nonEmpty.orElseThrow()); // a
        // System.out.println(empty.orElseThrow()); // throws a NoSuchElementException

        nonEmpty.ifPresent(System.out::println); // a
        empty.ifPresent(System.out::println); // nothing is printed here

        Comparator<String> byNaturalOrder = Comparator.naturalOrder();
        Comparator<String> byLength = Comparator.comparing(String::length);
        max(Set.of("aa", "b"), byNaturalOrder).ifPresent(System.out::println); // b
        max(Set.of("aa", "b"), byLength).ifPresent(System.out::println); // aa
        max(Set.of(), byNaturalOrder).ifPresent(System.out::println); // nothing is printed here
    }

    public static <E> Optional<E> max(Collection<E> collection, Comparator<E> comparator) {
        if (collection.isEmpty()) {
            return Optional.empty();
        }

        Iterator<E> iterator = collection.iterator();
        E max = iterator.next();

        while (iterator.hasNext()) {
            E current = iterator.next();

            if (comparator.compare(current, max) > 0) {
                max = current;
            }
        }

        return Optional.of(max);
    }
}