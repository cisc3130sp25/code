package O_lambdas;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        // Predicate<String> emptinessTester = s -> s.isEmpty();
        Predicate<String> emptinessTester = String::isEmpty;
        System.out.println(emptinessTester.test("a")); // false
        System.out.println(emptinessTester.test("")); // true

        Predicate<Integer> isPositive = x -> x > 0;

        System.out.println(isPositive.test(-4)); // false
        System.out.println(isPositive.test(4)); // true

        Predicate<Integer> isEven = x -> x % 2 == 0;

        // Predicate<Integer> isPositiveOrEven = x -> x > 0 || x % 2 == 0;
        Predicate<Integer> isPositiveOrEven = isPositive.or(isEven);

        Predicate<Integer> isPositiveAndEven = isPositive.and(isEven);

        Predicate<Integer> alwaysTrue = x -> true;

        // Predicate<Integer> alwaysFalse = x -> false;
        Predicate<Integer> alwaysFalse = alwaysTrue.negate();

        Predicate<Integer> isOdd = Predicate.not(isEven);
        // alternatively: Predicate<Integer> isOdd = isEven.negate();
        // alternatively: Predicate<Integer> isOdd = x -> x % 2 == 1;

        int[] arr = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};

        System.out.print("positive: ");
        printIf(arr, isPositive); // 1 2 3 4 5

        System.out.print("even: ");
        printIf(arr, isEven); // -4 -2 0 2 4

        System.out.print("positive or even: ");
        printIf(arr, isPositiveOrEven); // -4 -2 0 1 2 3 4 5

        System.out.print("positive and even: ");
        printIf(arr, isPositiveAndEven); // 2 4

        System.out.print("all: ");
        printIf(arr, alwaysTrue); // -5 -4 -3 -2 -1 0 1 2 3 4 5

        System.out.print("none: ");
        printIf(arr, alwaysFalse); //

        System.out.print("odd: ");
        printIf(arr, isOdd); // -5 -3 -1 1 3 5

        printIf(arr, x -> x == 0); // 0
    }

    public static void printIf(int[] arr, Predicate<Integer> condition) {
        for (int element : arr) {
            if (condition.test(element)) {
                System.out.print(element + " ");
            }
        }

        System.out.println();
    }
}