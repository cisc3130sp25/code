package O_lambdas;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        Function<String, String> secondHalf = s -> s.substring(s.length() / 2);
        System.out.println(secondHalf.apply("goodbye!"));

        Function<String, Integer> lengthGetter = String::length;
        System.out.println(lengthGetter.apply("bye!")); // 4

        Function<Integer, Double> squareRooter = Math::sqrt;
        System.out.println(squareRooter.apply(4)); // 2.0

        Function<String, Double> sqrtHalfLength = secondHalf.andThen(lengthGetter).andThen(squareRooter);
        System.out.println(sqrtHalfLength.apply("goodbye!")); // 2.0

        Integer[] integers = {4, 16, 9};
        mapAndPrint(integers, i -> Math.sqrt(i));
        mapAndPrint(integers, i -> i * i);

        String[] strings = {"a", "few", "strings"};
        mapAndPrint(strings, String::length);
        mapAndPrint(strings, s -> s.charAt(0));
        mapAndPrint(strings, String::toUpperCase);
        mapAndPrint(strings, s -> s + "!");
    }

    public static <T, R> void mapAndPrint(T[] arr, Function<T, R> mapper) {
        for (T element : arr) {
            R mapped = mapper.apply(element);
            System.out.print(mapped + " ");
        }

        System.out.println();
    }
}
