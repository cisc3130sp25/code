package G_complexity;

public class Range {
    // returns the range of values in the given array:
    // the difference between elements furthest apart.
    // example: range({17, 29, 11, 4, 20, 8}) is 25
    public static int rangeSlow(int[] numbers) {
        int maxDiff = 0;

        // look at each pair of values
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                int diff = Math.abs(numbers[j] - numbers[i]);

                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }

        return maxDiff;
    }
    // running time:

    public static int rangeFaster(int[] numbers) {
        int maxDiff = 0;

        // look at each pair of values exactly once
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) { // note: j = i + 1 instead of j = 0
                int diff = Math.abs(numbers[j] - numbers[i]);

                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }

        return maxDiff;
    }

    public static int rangeFast(int[] numbers) {
        int max = numbers[0], min = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }

            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        return max - min;
    }
}
