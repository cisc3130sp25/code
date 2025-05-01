package O_lambdas;

import java.util.*;
import java.util.function.Predicate;

public class LambdasWithCollectionsDemo {
    public static void main(String[] args) {
        forEachDemoIterable();
        forEachDemoMap();
        removeIfDemo();
        replaceAllDemo();
    }

    // demonstrates Iterable's forEach(Consumer action) method
    public static void forEachDemoIterable() {
        List<String> list = List.of("a", "b", "c");
        list.forEach(System.out::println);
    }

    // demonstrates Map's forEach(BiConsumer action) method
    public static void forEachDemoMap() {
        Map<Integer, String> map = Map.of(4, "a", 6, "b", 2, "c");
        map.forEach((i, s) -> System.out.println(i + " ---- " + s));
    }

    // demonstrates Collection's removeIf(Predicate filter) method
    public static void removeIfDemo() {
        Set<String> set = new HashSet<>(Set.of("alpha", "bravo", "charlie"));
        set.removeIf(s -> s.length() == 5);
        System.out.println(set); // [charlie]

        List<Integer> list = new ArrayList<>(List.of(-3, -2, -1, 0, 1, 2, 3));
        Predicate<Integer> isPositive = x -> x > 0;
        Predicate<Integer> isEven = x -> x % 2 == 0;
        Predicate<Integer> isPositiveOrEven = isPositive.or(isEven);
        list.removeIf(isPositiveOrEven);
        System.out.println(list); // [-3, -1]
    }

    // demonstrates List's replaceAll(UnaryOperator operator)
    public static void replaceAllDemo() {
        List<String> list = new ArrayList<>(List.of("one", "two"));
        list.replaceAll(s -> s + " more");
        System.out.println(list); // [one more, two more]

        list.replaceAll(String::toUpperCase);
        System.out.println(list); // [ONE MORE, TWO MORE]

        list.replaceAll(s -> "a");
        System.out.println(list); // [a, a]
    }
}