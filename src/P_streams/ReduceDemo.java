package P_streams;

import java.util.List;

public class ReduceDemo {
    public static void main(String[] args) {
        List<Integer> list = List.of(5, 3, 2, 4, 1, 7, 9);

        int sum = list.stream()              // 5, 3, 2, 4, 1, 7, 9
                .filter(i -> i % 2 != 0)     // 5, 3, 1, 7, 9
                .reduce(0, (a, b) -> a + b); // 25
        // ((((0 + 5) + 3) + 1) + 7) + 9 = 25
        // or maybe:
        // ((((0 + 3) + 5) + 9) + 1) + 4 = 25
        // or may in some other order.
        // So the binary operator must be associative (the order cannot matter)
        System.out.println("sum of odds: " + sum);

        int product = list.stream()
                .filter(i -> i % 2 != 0) // 5, 3, 1, 7, 9
                .reduce(1, (a, b) -> a * b);
        // (((((1 * 5) * 3) * 1) * 7) * 9)
        // or maybe:
        // ((((((1 * 7) * 3) * 1) * 5) * 9)
        System.out.println("product of odds: " + product);

        int result = list.stream()
                .filter(i -> i % 2 != 0) // 5, 3, 1, 7, 9
                .reduce(4, (a, b) -> a + b + 2);
        // ((((4 + 5 + 2) + 3 + 2) + 1 + 2) + 7 + 2) + 9 + 2
        // or some other order; result is the same
        System.out.println(result);
    }
}

