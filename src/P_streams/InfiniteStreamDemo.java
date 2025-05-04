package P_streams;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class InfiniteStreamDemo {
    public static void main(String[] args) {
        Random rand = new Random();

        // rand.ints(0, 100) // infinite IntStream of random ints between 0 and 100
        //         .forEach(System.out::println); // runs forever

        rand.ints(); // nothing happens here, no terminal operation

        // array of ten random even ints between 0 and 100
        // with no duplicates
        int[] arr = rand.ints(0, 100)
                .distinct()
                .filter(i -> i % 2 == 0)
                .limit(10)
                .toArray();
        System.out.println(Arrays.toString(arr));

        List<Integer> list =
                Stream.iterate(1, i -> i + 1)
                        .limit(5)
                        .toList();
        System.out.println(list);

        System.out.println("5! = " + factorial(5));
        System.out.println("21! = " + factorial(21));
    }

    // returns n! = 1 * 2 * 3 * 4 * ... * (n - 1) * n
    public static BigInteger factorial(int n) {
        return Stream.iterate(BigInteger.ONE, bi -> bi.add(BigInteger.ONE))
                .limit(n)
                .reduce(BigInteger.ONE, BigInteger::multiply);
    }
}





